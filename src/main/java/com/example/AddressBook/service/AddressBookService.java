package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressBookDTO;
import com.example.AddressBook.model.AddressBook;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBook> addressBookList = new ArrayList<>();
    private long idCounter = 1;  // Simulates auto-increment ID

    @Override
    public List<AddressBook> getAllContacts() {
        return addressBookList;
    }

    @Override
    public AddressBook getContactById(Long id) {
        for (AddressBook contact : addressBookList) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null; // Not found
    }

    @Override
    public AddressBook createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(idCounter++, addressBookDTO.getName(), addressBookDTO.getAddress(), addressBookDTO.getPhoneNumber());
        addressBookList.add(addressBook);
        return addressBook;
    }

    @Override
    public AddressBook updateContact(Long id, AddressBookDTO addressBookDTO) {
        for (AddressBook contact : addressBookList) {
            if (contact.getId().equals(id)) {
                contact.setName(addressBookDTO.getName());
                contact.setAddress(addressBookDTO.getAddress());
                contact.setPhoneNumber(addressBookDTO.getPhoneNumber());
                return contact;
            }
        }
        return null; // Not found
    }

    @Override
    public void deleteContact(Long id) {
        for (int i = 0; i < addressBookList.size(); i++) {
            if (addressBookList.get(i).getId().equals(id)) {
                addressBookList.remove(i);
                return;
            }
        }
    }
}

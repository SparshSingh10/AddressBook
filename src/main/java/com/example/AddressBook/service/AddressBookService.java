package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressBookDTO;
import com.example.AddressBook.model.AddressBook;
import com.example.AddressBook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBook> getAllContacts() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook getContactById(Long id) {
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with ID: " + id));
    }

    @Override
    public AddressBook createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public AddressBook updateContact(Long id, AddressBookDTO addressBookDTO) {
        AddressBook existingContact = addressBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with ID: " + id));

        existingContact.setName(addressBookDTO.getName());
        existingContact.setPhoneNumber(addressBookDTO.getPhoneNumber());
        existingContact.setAddress(addressBookDTO.getAddress());

        return addressBookRepository.save(existingContact);
    }

    @Override
    public void deleteContact(Long id) {
        if (!addressBookRepository.existsById(id)) {
            throw new RuntimeException("Contact not found with ID: " + id);
        }
        addressBookRepository.deleteById(id);
    }
}

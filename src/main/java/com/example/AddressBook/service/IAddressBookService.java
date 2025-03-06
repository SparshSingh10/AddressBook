package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressBookDTO;
import com.example.AddressBook.model.AddressBook;
import java.util.List;

public interface IAddressBookService {
    List<AddressBook> getAllContacts();
    AddressBook getContactById(Long id);
    AddressBook createAddressBookData(AddressBookDTO addressBookDTO);
    AddressBook updateContact(Long id, AddressBookDTO addressBookDTO);
    void deleteContact(Long id);
}

package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressBookDTO;

public interface IAddressBookService {
    String getAllContacts();
    String getContactById(Long id);
    String addContact(AddressBookDTO addressBookDTO);
    String updateContact(Long id, AddressBookDTO addressBookDTO);
    String deleteContact(Long id);
}

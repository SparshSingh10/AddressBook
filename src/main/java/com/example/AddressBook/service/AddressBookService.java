package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressBookDTO;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public String getAllContacts() {
        return "Returning all contacts (but not actually storing any)";
    }

    @Override
    public String getContactById(Long id) {
        return "Returning contact with ID: " + id + " (but not actually stored)";
    }

    @Override
    public String addContact(AddressBookDTO addressBookDTO) {
        return "Adding new contact: " + addressBookDTO.getName() + " (but not actually stored)";
    }

    @Override
    public String updateContact(Long id, AddressBookDTO addressBookDTO) {
        return "Updating contact with ID: " + id + " (but not actually stored)";
    }

    @Override
    public String deleteContact(Long id) {
        return "Deleting contact with ID: " + id + " (but not actually stored)";
    }
}

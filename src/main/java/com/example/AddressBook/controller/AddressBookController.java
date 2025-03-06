package com.example.AddressBook.controller;

import com.example.AddressBook.dto.AddressBookDTO;
import com.example.AddressBook.model.AddressBook;
import com.example.AddressBook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping("/get")
    public ResponseEntity<List<AddressBook>> getAll() {
        return new ResponseEntity<>(addressBookService.getAllContacts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBook> find(@PathVariable Long id) {
        AddressBook contact = addressBookService.getContactById(id);
        if (contact != null) {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<AddressBook> add(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<>(addressBookService.createAddressBookData(addressBookDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBook> update(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook updatedContact = addressBookService.updateContact(id, addressBookDTO);
        if (updatedContact != null) {
            return new ResponseEntity<>(updatedContact, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressBookService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

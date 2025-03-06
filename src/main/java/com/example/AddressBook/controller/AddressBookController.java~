package com.example.AddressBook.controller;

import com.example.AddressBook.dto.AddressBookDTO;
import com.example.AddressBook.dto.ResponseDTO;
import com.example.AddressBook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAll() {
        String message = addressBookService.getAllContacts();
        return new ResponseEntity<>(new ResponseDTO("Get Contacts", message), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> find(@PathVariable Long id) {
        String message = addressBookService.getContactById(id);
        return new ResponseEntity<>(new ResponseDTO("Get Contact", message), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> add(@RequestBody AddressBookDTO addressBookDTO) {
        String message = addressBookService.addContact(addressBookDTO);
        return new ResponseEntity<>(new ResponseDTO("Add New Contact", message), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        String message = addressBookService.updateContact(id, addressBookDTO);
        return new ResponseEntity<>(new ResponseDTO("Update the Contact", message), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
        String message = addressBookService.deleteContact(id);
        return new ResponseEntity<>(new ResponseDTO("Deleted the contact with id: " + id, message), HttpStatus.OK);
    }
}

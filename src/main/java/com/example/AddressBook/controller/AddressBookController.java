package com.example.AddressBook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @GetMapping("/api/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello from Address Book Controller");
    }

    @GetMapping({"", "/", "/get"})
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("All contacts displayed");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> find(@PathVariable Long id) {
        return ResponseEntity.ok("Contact with ID " + id + " displayed");
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody String contactDetails) {
        return ResponseEntity.ok("Contact added: " + contactDetails);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody String updatedDetails) {
        return ResponseEntity.ok("Contact with ID " + id + " updated: " + updatedDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok("Contact with ID " + id + " deleted");
    }
}

/*
-------------------------------------------
   📌 cURL COMMANDS TO TEST API ENDPOINTS
-------------------------------------------

✅ Test API Connectivity
curl -X GET http://localhost:8080/address/api/test

✅ Get All Contacts
curl -X GET http://localhost:8080/address/get

✅ Get Contact by ID (Example: ID = 1)
curl -X GET http://localhost:8080/address/get/1

✅ Add a New Contact
curl -X POST http://localhost:8080/address/add \
     -H "Content-Type: application/json" \
     -d '{"name": "John Doe", "phone": "1234567890"}'

✅ Update Contact by ID (Example: ID = 1)
curl -X PUT http://localhost:8080/address/update/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "John Doe Updated", "phone": "0987654321"}'

✅ Delete Contact by ID (Example: ID = 1)
curl -X DELETE http://localhost:8080/address/delete/1
*/

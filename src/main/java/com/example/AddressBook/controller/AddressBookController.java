package com.example.AddressBook.controller;

import com.example.AddressBook.dto.AddressBookDTO;
import com.example.AddressBook.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ResponseDTO> getAll() {
        AddressBookDTO addressBook = new AddressBookDTO();
        return new ResponseEntity<>(new ResponseDTO("Get Contacts", addressBook), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> find(@PathVariable Long id) {
        AddressBookDTO addressBook = new AddressBookDTO();
        return new ResponseEntity<>(new ResponseDTO("Get Contact", addressBook), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> add(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<>(new ResponseDTO("Add New Contact", addressBookDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<>(new ResponseDTO("Update the Contact", addressBookDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
        return new ResponseEntity<>(new ResponseDTO("Deleted the contact with id: " + id, null), HttpStatus.OK);
    }
}

/*
-----------------------------------------------------
   📌 cURL COMMANDS TO TEST API ENDPOINTS
-----------------------------------------------------

✅ Test API Connectivity
curl -X GET http://localhost:8080/address/api/test

✅ Get All Contacts
curl -X GET http://localhost:8080/address/get

✅ Get Contact by ID (Example: ID = 1)
curl -X GET http://localhost:8080/address/get/1

✅ Add a New Contact
curl -X POST http://localhost:8080/address/add \
     -H "Content-Type: application/json" \
     -d '{"name": "John Doe", "phoneNumber": "1234567890"}'

✅ Update Contact by ID (Example: ID = 1)
curl -X PUT http://localhost:8080/address/update/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "John Doe Updated", "phoneNumber": "0987654321"}'

✅ Delete Contact by ID (Example: ID = 1)
curl -X DELETE http://localhost:8080/address/delete/1


-----------------------------------------------------
   📌 POSTMAN REQUEST DETAILS
-----------------------------------------------------

✅ **1. Test API**
   - **Method:** `GET`
   - **URL:** `http://localhost:8080/address/api/test`

✅ **2. Get All Contacts**
   - **Method:** `GET`
   - **URL:** `http://localhost:8080/address/get`

✅ **3. Get Contact by ID**
   - **Method:** `GET`
   - **URL:** `http://localhost:8080/address/get/{id}`

✅ **4. Add a New Contact**
   - **Method:** `POST`
   - **URL:** `http://localhost:8080/address/add`
   - **Headers:** `Content-Type: application/json`
   - **Body (JSON):**
     ```json
     {
       "name": "John Doe",
       "phoneNumber": "1234567890"
     }
     ```

✅ **5. Update Contact by ID**
   - **Method:** `PUT`
   - **URL:** `http://localhost:8080/address/update/{id}`
   - **Headers:** `Content-Type: application/json`
   - **Body (JSON):**
     ```json
     {
       "name": "John Doe Updated",
       "phoneNumber": "0987654321"
     }
     ```

✅ **6. Delete Contact by ID**
   - **Method:** `DELETE`
   - **URL:** `http://localhost:8080/address/delete/{id}`
*/


package com.example.marian.controller;

import com.example.marian.model.Customer;
import com.example.marian.model.TypeCustomer;
import com.example.marian.service.ICustomerService;
import com.example.marian.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping()
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ITypeService iTypeService;

    @GetMapping("customer")
    public ResponseEntity<Page<Customer>> showCustomerList(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_limit", defaultValue = "10") int pageSize,
            @RequestParam(name = "name_like", defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(page -1, pageSize);
        Page<Customer> customers = iCustomerService.findAll(pageable, name);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        iCustomerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer with ID " + id + " has been deleted.");
    }


//    @GetMapping("/customer/{id}")
//    public ResponseEntity<Customer> showProduct(@PathVariable int id) {
//        Customer customer = iCustomerService.findAllById(id);
//
//        return new ResponseEntity<>(customer, HttpStatus.OK);
//    }
//
//    @PutMapping("/customer/{id}")
//    public ResponseEntity<String> updateCustomer(@PathVariable int id, @RequestBody Customer customerData) {
//        iCustomerService.editCustomer(id, customerData);
//        return ResponseEntity.ok("Customer with ID " + id + " has been updated.");
//    }
//
    @GetMapping("/type")
    public ResponseEntity<List<TypeCustomer>> getType(){
        List<TypeCustomer> typeCustomerList = iTypeService.findAllType();
        if (typeCustomerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeCustomerList,HttpStatus.OK);
    }
    @PostMapping("customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerData)  {
        iCustomerService.createCustomer(customerData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

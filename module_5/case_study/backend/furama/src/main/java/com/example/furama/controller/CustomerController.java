package com.example.furama.controller;

import com.example.furama.model.Customer;
import com.example.furama.model.Type;
import com.example.furama.repository.ITypeRepository;
import com.example.furama.service.ICustomerService;
import com.example.furama.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ITypeService iTypeService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAll()
    {
        List<Customer> customerPage = iCustomerService.findAll();
        if(customerPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable int id){
        Customer customer = iCustomerService.findById(id);
        if (customer== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        iCustomerService.delete(id);
        return new ResponseEntity<>("xoa thanh cong", HttpStatus.OK);
    }
    @GetMapping("/type")
    public ResponseEntity<?> showAdd(Model model) {
        List<Type> typeList = iTypeService.findAllType();
        if (typeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }
    @PostMapping("/customer")
        public ResponseEntity<?> add (@RequestBody Customer customer){
        iCustomerService.add(customer);
        return new ResponseEntity<>("Them moi thanh cong",HttpStatus.OK);
    }
}

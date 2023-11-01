package com.example.backend.controller;

import com.example.backend.model.Product;
import com.example.backend.model.TypeProduct;
import com.example.backend.service.IProductService;
import com.example.backend.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping()
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ITypeService iTypeService;

    @GetMapping("product")
    public ResponseEntity<List<Product>> display(@RequestParam(name = "name_like", defaultValue = "") String name) {

        List<Product> productList = iProductService.findAll(name);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @GetMapping("type")
    public ResponseEntity<List<TypeProduct>> getType(){
        List<TypeProduct> typeProductList = iTypeService.findAllType();
        if (typeProductList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeProductList,HttpStatus.OK);
    }
    @PostMapping("product")
    public ResponseEntity<Product> createProduct (@RequestBody Product product){
        iProductService.create(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

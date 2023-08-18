package com.igc.productapp.controller;


import com.igc.productapp.entity.ProductEntity;
import com.igc.productapp.model.ProductModel;
import com.igc.productapp.responses.Response;
import com.igc.productapp.service.IProductService;
import com.igc.productapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/product/api")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/getproducts")
    public ResponseEntity<?> getAllProduct()
    {
        return new ResponseEntity<>(new Response("Product List",HttpStatus.FOUND,productService.getAllProduct()), HttpStatus.FOUND);
    }

    @PostMapping("/addproduct")
      public ResponseEntity<?> addAllProduct(@RequestBody @Valid ProductModel productmodel)
      {
          return new ResponseEntity<>(new Response("Product Added Successsfully",HttpStatus.CREATED,productService.addAllProduct(productmodel)),HttpStatus.CREATED) ;
      }

      @GetMapping("/getproductbyid/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(new Response("Product Found",HttpStatus.FOUND,productService.getProductById(id)),HttpStatus.FOUND);
    }

}

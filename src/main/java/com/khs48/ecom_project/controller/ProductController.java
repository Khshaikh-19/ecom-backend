package com.khs48.ecom_project.controller;

import com.khs48.ecom_project.model.Product;
import com.khs48.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>( service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable int id) {
       Product product=service.getProductById(id);
       if(product != null)
        return new ResponseEntity<>(product,HttpStatus.OK);
       else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(
            @ModelAttribute Product product,       // binds form fields to Product object
            @RequestParam("image") MultipartFile imageFile) {

        try {
            // set image bytes and type
            product.setImageData(imageFile.getBytes());
            product.setImageType(imageFile.getContentType());
            product.setImagename(imageFile.getOriginalFilename());

            Product savedProduct = service.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/{productId}/image")
        public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
Product product=service.getProductById(productId);
byte[] imageFile = product.getImageData();
return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
        }
    }


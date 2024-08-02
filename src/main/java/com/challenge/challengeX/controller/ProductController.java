package com.challenge.challengeX.controller;

import com.challenge.challengeX.model.request.ProductDetailsRequest;
import com.challenge.challengeX.model.response.ProductDetailsResponse;
import com.challenge.challengeX.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/product")
    public ResponseEntity<ProductDetailsResponse> create(@RequestBody ProductDetailsRequest productDetailsRequest) {

        ProductDetailsResponse productDetailsResponse = productService.create(productDetailsRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(productDetailsResponse);
    }

    @GetMapping(value = "/product2", params = "id")
    public ResponseEntity<ProductDetailsResponse> getProduct(@RequestParam(value = "id") long id) {

        ProductDetailsResponse productDetailsResponse = productService.getProduct(id);

        return ResponseEntity.ok().body(productDetailsResponse);
    }


    @GetMapping(value = "/allProducts")
    public ResponseEntity<List<ProductDetailsResponse>> getAll() {

        List<ProductDetailsResponse> productDetailsResponse = productService.getAllOrderByPrice();

        return ResponseEntity.ok().body(productDetailsResponse);
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }

    @PutMapping(value = "/updateProduct/{id}")
    public ResponseEntity<ProductDetailsResponse> update(@PathVariable long id, @RequestBody  ProductDetailsRequest productDetailsRequest){

        ProductDetailsResponse productDetailsResponse = productService.update(id, productDetailsRequest);

        return ResponseEntity.ok().body(productDetailsResponse);
    }


}

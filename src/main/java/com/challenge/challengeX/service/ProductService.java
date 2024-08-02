package com.challenge.challengeX.service;

import com.challenge.challengeX.mapper.ProductMapper;
import com.challenge.challengeX.model.entity.Product;
import com.challenge.challengeX.model.request.ProductDetailsRequest;
import com.challenge.challengeX.model.response.ProductDetailsResponse;
import com.challenge.challengeX.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public ProductDetailsResponse create(ProductDetailsRequest productDetailsRequest){

        Product product = productMapper.productRequestToProduct(productDetailsRequest);

       Product productCreated = productRepository.save(product);

        return productMapper.ToProductResponse(productCreated);
    }

    public ProductDetailsResponse getProduct(long id){

        return productMapper.ToProductResponse(productRepository.findById(id));
    }

    public List<ProductDetailsResponse> getAllOrderByPrice(){

        List<Product > products = productRepository.findAllOrderByPrice();

        return productMapper.toProductResponseList(products);
    }

    public void delete(long id){
        //Product product = productRepository.findById(id);
        productRepository.deleteById(id);
    }

    public ProductDetailsResponse update (long id , ProductDetailsRequest productDetailsRequest){

        Product product = productRepository.findById(id);

        product.setName(productDetailsRequest.getName());
        product.setDescription(productDetailsRequest.getDescription());
        product.setPrice(productDetailsRequest.getPrice());
        product.setQty(productDetailsRequest.getQty());

        productRepository.save(product);


        ProductDetailsResponse productDetailsResponse = productMapper.ToProductResponse(product);

        return productDetailsResponse;

    }
}

package com.challenge.challengeX.mapper;

import com.challenge.challengeX.model.entity.Product;
import com.challenge.challengeX.model.request.ProductDetailsRequest;
import com.challenge.challengeX.model.response.ProductDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "qty", target = "qty")
    Product productRequestToProduct(ProductDetailsRequest productDetailsRequest);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "qty", target = "qty")
    ProductDetailsResponse ToProductResponse(Product product);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "qty", target = "qty")
    List<ProductDetailsResponse> toProductResponseList (List<Product> product);
}

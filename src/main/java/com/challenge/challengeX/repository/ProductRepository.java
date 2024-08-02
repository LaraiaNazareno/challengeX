package com.challenge.challengeX.repository;

import com.challenge.challengeX.model.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository <Product, Long> {

    Product findById(long id);

    @Query(value = "SELECT * FROM products ORDER BY price DESC", nativeQuery = true)
    List<Product> findAllOrderByPrice();

}

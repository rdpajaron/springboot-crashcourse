package com.example.demo.myfirstapi.repository;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository productRepository;

    @BeforeEach
    void setUp(){
        productRepository = new ProductRepository();
    }

    @Test
    void testInitializedProductsAndFindAllMethod(){
        List<Product> products = Collections.synchronizedList(new ArrayList<>());
        AtomicLong nextId = new AtomicLong(1);
        products.add(new Product(nextId.getAndIncrement(), "Laptop", 1200.00));
        products.add(new Product(nextId.getAndIncrement(), "Mouse", 25.50));
        products.add(new Product(nextId.getAndIncrement(), "Keyboard", 75.00));
        assertEquals(products, productRepository.findAll());
    }

    @Test
    void testFindById(){
        Optional<Product> product = productRepository.findById(1L);
        List<Product> actual = new ArrayList<>(productRepository.findAll());
        assertEquals(product.stream().toList().get(0), actual.get(0));
    }

    @Test
    void testSaveProduct(){
        List<Product> list = new ArrayList<>(productRepository.findAll());
        AtomicLong nextId = new AtomicLong(list.size() + 1);
        AtomicLong test = new AtomicLong(4);
        list.add(productRepository.save(new Product(nextId.getAndIncrement(), "Light", 70.00)));
        Product dummy = new Product(4L, "Light", 70.00);
        assertEquals(dummy, list.get(list.size() - 1));
    }

}
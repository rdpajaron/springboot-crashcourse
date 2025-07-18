package com.example.demo.myfirstapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;
    @BeforeEach
    void setUp(){
        product = new Product(123456L,"Cheese", 120.50);
    }

    @Test
    void testProductConstructorTwoArgs(){
        Product product = new Product("Cheese", 120.50);
        assertEquals("Cheese", product.getName());
        assertEquals(120.50, product.getPrice());
    }

    @Test
    void testProductConstructorThreeArgs(){
        assertEquals("Cheese", product.getName());
        assertEquals(120.50, product.getPrice());
        assertEquals(123456L, product.getId());
    }

    @Test
    void testToStringMethod(){
        String expected = "Product{id=123456, name='Cheese', price=120.5}";
        assertEquals(expected, product.toString());
    }

    @Test
    void testEqualsMethod(){
        String expected = "Product{id=123456, name='Cheese', price=120.5}";
        boolean equalsMethodResult = product.toString().equals(expected);
        assertTrue(equalsMethodResult);
    }

    @Test
    void testHashCode(){
        Product productX = new Product(123456L,"Cheese", 120.50);
        int product1 = product.hashCode();
        int product2 = productX.hashCode();
        assertEquals(product1, product2);
    }

}
package com.simplilearn.kitchenStoryFoods.service;

import com.simplilearn.kitchenStoryFoods.models.Products;
import com.simplilearn.kitchenStoryFoods.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductsRepository productsRepository;

    public void saveProduct(Products products) {
        productsRepository.save(products);
    }

    public List<Products> getAllProducts() {

        return productsRepository.findAll();
    }

    public List<Products> getSortedHighToLow() {
        return productsRepository.findAllProductsOrderedByPriceHighToLow();
    }

    public List<Products> getSortedLowToHigh() {
        return productsRepository.findAllProductsOrderedByPriceLowToHigh();
    }

    public Products findProductById(Long id) {

        return productsRepository.findById(id).orElse(new Products());
    }
}

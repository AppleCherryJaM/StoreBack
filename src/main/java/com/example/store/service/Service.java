package com.example.store.service;

import com.example.store.entity.Category;
import com.example.store.entity.Product;
import com.example.store.repository.CategoryRepository;
import com.example.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void addProduct(Product product, Integer id) {
        Category category = categoryRepository.getById(id);
        product.setCategory(category);
        productRepository.save(product);
    }

    public Product[] getCategoryProducts(Integer id) {
        return productRepository.getCategoryProducts(id);
    }

    public String getImagePath(Integer id) {
        return productRepository.getImgPath(id);
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.getById(id);
    }
/*    private void deleteAllInCategory(String category) { productRepository.deleteAllInCategory(category); }

    public void deleteCategory(Integer id) {
        productRepository.deleteAllInCategory(id);
        categoryRepository.deleteById(id);
    }*/

/*    public void deleteCategory(String name) {
        productRepository.deleteAllInCategory(name);
        categoryRepository.delete(categoryRepository.getCategoryByName(name));
    }*/
}
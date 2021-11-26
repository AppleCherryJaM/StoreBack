package com.example.store.repository;

import com.example.store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select c from Category c where c.name = :name")
    public Category getCategoryByName(String name);
}

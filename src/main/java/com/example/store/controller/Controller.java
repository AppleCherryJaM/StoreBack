package com.example.store.controller;

import com.example.store.entity.Category;
import com.example.store.entity.Product;
import com.example.store.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired
    private Service service;

    @PostMapping("/product/{category_id}")
    public void addProduct(@RequestBody Product product, @PathVariable(name = "category_id") Integer id) {
        service.addProduct(product, id);
    }

    @PostMapping("/category")
    public void addCategory(@RequestBody Category category) {
        service.addCategory(category);
    }

    @GetMapping("/category")
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/category/{category_id}")
    public Category getCategoryById(@PathVariable(value = "category_id") Integer id) {
        return service.getCategoryById(id);
    }

    @GetMapping("/category/{name}")
    public Category getCategoryByName(@PathVariable(value = "name") String name) {
        return service.getCategoryByName(name);
    }

/*    @DeleteMapping("/category")
    public void deleteCategory(@RequestParam(value = "id") Integer id) {
        service.deleteCategory(id);
    }

    @DeleteMapping("/category")
    public void deleteCategory(@RequestParam(value = "name") String name) {
        service.deleteCategory(name);
    }*/

/*    @Autowired
    private TestService service;
    @PostMapping("/student/{group_id}")
    public void addStudent(@RequestBody Student student, @PathVariable(name = "group_id") int group_id) {
        service.addStudent(student, group_id);
    }
    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
    @PostMapping("/group")
    public void addGroup(@RequestBody Group group) {
        service.addGroup(group);
    }
    @GetMapping("/group")
    public List<Group> getAllGroups() {
        return service.getAllGroups();
    }*/
}
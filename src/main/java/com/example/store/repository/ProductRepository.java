package com.example.store.repository;

import com.example.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("delete from Product p where p.category = :category")
    public void deleteAllInCategory(@Param("category") Integer id);

    @Query("delete from Product p where p.category = (select c from Category c where c.name = :name)")
    public void deleteAllInCategory(@Param("name") String name);

    @Query("select p.imgPath from Product p where p.id = :id")
    public String getImgPath(@Param("id") Integer id);

    @Query("select products from Category where id = :id")
    public Product[] getCategoryProducts(Integer id);
}

package com.bymyself.SteelFabricatedOrderManage.repository;

import com.bymyself.SteelFabricatedOrderManage.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll();
    Category save(Category category);
    Category findByName(String name);
    void deleteById(int id);
}

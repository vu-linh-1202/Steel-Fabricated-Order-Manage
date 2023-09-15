package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);
    Category findById(int id);
    List<Category> findAll();
    Category saveCategory(Category category);
    Category findByName(String name);
    void delete(Category category);
    void deleteById(int id);

}

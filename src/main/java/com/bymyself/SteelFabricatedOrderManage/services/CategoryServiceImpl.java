package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Category;
import com.bymyself.SteelFabricatedOrderManage.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        Category cat = categoryRepository.save(category);
        System.out.println(cat);
        return cat;
    }

    @Override
    public Category findById(int id) {
        Optional<Category> id1 = categoryRepository.findById(id);
        return id1.orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findByName(String name) {
        Category nameCategory = categoryRepository.findByName(name);
        if(nameCategory != null) return nameCategory;
        return null;
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}

package com.bymyself.SteelFabricatedOrderManage.controller;

import com.bymyself.SteelFabricatedOrderManage.entities.Category;
import com.bymyself.SteelFabricatedOrderManage.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getCategories()
    {
        List<Category> listCategories = categoryService.findAll();
        if (listCategories == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(listCategories);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Category category)
    {
        Category c = categoryService.saveCategory(category);
        System.out.println(c.toString());
        return ResponseEntity.ok(c);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id)
    {
        Category category = categoryService.findById(id);
        System.out.println(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/nameof/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable("name") String name)
    {
        Category category  = categoryService.findByName(name);
        categoryService.delete(category);
        return ResponseEntity.ok("Data deleted successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id)
    {
        categoryService.deleteById(id);
        return ResponseEntity.ok("Data deleted successfully!");
    }
}

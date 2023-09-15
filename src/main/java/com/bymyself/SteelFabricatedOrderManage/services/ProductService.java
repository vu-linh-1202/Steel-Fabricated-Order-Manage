package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Product findById(int id);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    Product saveProduct(Product product, MultipartFile thumbnail);
    Double getAverageStar(int pid);
    void  delete(Product product);
}

package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.CustomisedProduct;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CustomisedProductService {
    CustomisedProduct save(CustomisedProduct customisedProduct);
    List<CustomisedProduct> findAll();
    CustomisedProduct saveProduct(CustomisedProduct customisedProduct, MultipartFile thumbnail);
    CustomisedProduct findById(int id);
}

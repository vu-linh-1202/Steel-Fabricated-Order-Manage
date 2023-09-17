package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.CustomisedProduct;
import com.bymyself.SteelFabricatedOrderManage.repository.CustomisedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomisedProductServiceImpl implements CustomisedProductService{

    @Autowired
    private CustomisedProductRepository customisedProductRepository;

    private StorageService storageService;
    @Override
    public CustomisedProduct save(CustomisedProduct customisedProduct) {
        return customisedProductRepository.save(customisedProduct);
    }

    @Override
    public List<CustomisedProduct> findAll() {
        return customisedProductRepository.findAll();
    }

    @Override
    public CustomisedProduct saveProduct(CustomisedProduct customisedProduct, MultipartFile thumbnail) {
        String fileName= storageService.store(thumbnail);
        customisedProduct.setThumbnail(fileName);
        return customisedProductRepository.save(customisedProduct);
    }

    @Override
    public CustomisedProduct findById(int id) {
        Optional<CustomisedProduct> p = customisedProductRepository.findById(id);
        CustomisedProduct product = p.orElse(null);
        return product;
    }
}

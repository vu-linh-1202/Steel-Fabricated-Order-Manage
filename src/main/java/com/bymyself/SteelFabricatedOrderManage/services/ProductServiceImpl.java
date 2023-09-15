package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Product;
import com.bymyself.SteelFabricatedOrderManage.repository.ProductRepository;
import com.bymyself.SteelFabricatedOrderManage.repository.ReviewRepository;
import com.bymyself.SteelFabricatedOrderManage.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StorageService storageService;
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> product = productRepository.findById(id);
        Product product1 = product.orElse(null);
        return product1;
    }

    @Override
    public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public Product saveProduct(Product product, MultipartFile thumbnail) {
        String filename = storageService.store(thumbnail);
        product.setThumbnail(filename);
        return productRepository.save(product);
    }

    @Override
    public Double getAverageStar(int pid) {
        return reviewRepository.getAverageStar(pid);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}

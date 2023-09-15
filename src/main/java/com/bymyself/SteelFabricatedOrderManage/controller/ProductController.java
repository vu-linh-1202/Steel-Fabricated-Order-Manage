package com.bymyself.SteelFabricatedOrderManage.controller;

import com.bymyself.SteelFabricatedOrderManage.dto.ProductInputDto;
import com.bymyself.SteelFabricatedOrderManage.dto.ProductUpdateDto;
import com.bymyself.SteelFabricatedOrderManage.entities.Category;
import com.bymyself.SteelFabricatedOrderManage.entities.Product;
import com.bymyself.SteelFabricatedOrderManage.entities.Review;
import com.bymyself.SteelFabricatedOrderManage.services.CategoryService;
import com.bymyself.SteelFabricatedOrderManage.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Product>> findAll()
    {
        List<Product> products = productService.findAll();
        if (products == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") int id)
    {
        Product product= productService.findById(id);
        if (product == null) throw new RuntimeException("Product not found");
        return ResponseEntity.ok(product);
    }

    @GetMapping("/bycategory/{id}")
    public ResponseEntity<List<Product>> findByCategory(@PathVariable("id") int id)
    {
        Category category = categoryService.findById(id);
        List<Product> productList = category.getProductList();
        System.out.println(Arrays.toString(productList.toArray()));
        if(productList == null) throw  new RuntimeException("No product not found");
        System.out.println(productList);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/price/{min}/{max}")
    public ResponseEntity<List<Product>> findByPriceRange(@PathVariable("min") double minPrice,@PathVariable("max") double maxPrice)
    {
        List<Product> listProduct = productService.findByPriceBetween(minPrice, maxPrice);
        if (listProduct == null) throw  new RuntimeException("Product not found");
        return ResponseEntity.ok(listProduct);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<List<Review>> getReviews(@PathVariable("id") int pid)
    {
        Product product = productService.findById(pid);
        List<Review> reviewList= product.getReviews();
        if (reviewList == null) throw new RuntimeException("No reviews found");
        return ResponseEntity.ok(reviewList);
    }

    @PostMapping("/addreview")
    public ResponseEntity<Product> addReview(@RequestBody Review review)
    {
        System.out.println(review);
        Product product = productService.findById(review.getpId());
        product.addReview(review);
        return ResponseEntity.ok(product);
    }

//    @PostMapping("")
//    public ResponseEntity<?> save(ProductInputDto productInputDto)
//    {
//        System.out.println(productInputDto);
//        Product product = ProductInputDto.toEntity(productInputDto);
//        System.out.println(product);
//        product = productService.saveProduct(product, productInputDto.getThumbnail());
//        return ResponseEntity.ok(product);
//    }

    @GetMapping("/averagestar/{pid}")
    public Double getAverageStar(@PathVariable("pid") int pid)
    {
        return productService.getAverageStar(pid);
    }

    @DeleteMapping("/delete/{p_id}")
    public ResponseEntity<?> deleteById(@PathVariable("p_id") int p_id)
    {
        Product product = productService.findById(p_id);
        productService.delete(product);
        return ResponseEntity.ok("Product deleted successfully!");
    }

    @PutMapping("/update/{pid}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductUpdateDto updateDto, @PathVariable("pid") int pid)
    {
        Product product = productService.findById(pid);
        product.setQty(updateDto.getQty());
        product.setPrice(updateDto.getPrice());
        productService.save(product);
        return ResponseEntity.ok(product);
    }
}

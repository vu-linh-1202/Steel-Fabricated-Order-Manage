package com.bymyself.SteelFabricatedOrderManage.controller;

import com.bymyself.SteelFabricatedOrderManage.dto.CustomisedProductInputDto;
import com.bymyself.SteelFabricatedOrderManage.entities.CustomisedProduct;
import com.bymyself.SteelFabricatedOrderManage.services.CustomerService;
import com.bymyself.SteelFabricatedOrderManage.services.CustomisedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/custproducts")
public class CustomiseProductController {

    @Autowired
    CustomisedProductService customisedProductService;

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<CustomisedProduct>> findAll()
    {
        List<CustomisedProduct> productList = customisedProductService.findAll();
        if (productList == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomisedProduct> findById(@PathVariable("id") int id)
    {
        CustomisedProduct customisedProduct = customisedProductService.findById(id);
        if (customisedProduct == null) throw new RuntimeException("Customer not found");
        return ResponseEntity.ok(customisedProduct);
    }

    @PostMapping("")
    public ResponseEntity<?> save(CustomisedProductInputDto customisedProductInputDto)
    {
        System.out.println(customisedProductInputDto);
        CustomisedProduct product = CustomisedProductInputDto.toEntity(customisedProductInputDto);
        product.setCust(customerService.findById(customisedProductInputDto.getCid()));
        System.out.println(product);
        product = customisedProductService.saveProduct(product, customisedProductInputDto.getThumbnail());
        return ResponseEntity.ok(product);
    }
}

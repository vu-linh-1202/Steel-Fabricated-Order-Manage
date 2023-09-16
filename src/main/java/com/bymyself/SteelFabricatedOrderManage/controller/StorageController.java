package com.bymyself.SteelFabricatedOrderManage.controller;

import com.bymyself.SteelFabricatedOrderManage.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> loadFile(@PathVariable("filename") String filename)
    {
        System.out.println("Request recieves");
        Resource file = storageService.load(filename);
        return ResponseEntity.ok(file);
    }
}

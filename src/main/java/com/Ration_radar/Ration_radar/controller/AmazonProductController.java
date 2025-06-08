package com.Ration_radar.Ration_radar.controller;

import com.Ration_radar.Ration_radar.entities.AmazonProduct;
import com.Ration_radar.Ration_radar.service.AmazonProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/Amazon")
public class AmazonProductController {

    @Autowired
    private AmazonProductService amazonProductService;

    @PostMapping
    public AmazonProduct addProduct(@RequestBody AmazonProduct amazonProduct){
        return amazonProductService.addProduct(amazonProduct);
    }

    @GetMapping
    public List<AmazonProduct> getAllProducts(){
        return amazonProductService.getALlProducts();
    }

    @GetMapping("/{sku}")
    public AmazonProduct getProductySku(@PathVariable String sku){
        return amazonProductService.getProductBySku(sku);
    }
    public void deletePost(@PathVariable Long id){
        amazonProductService.deleteProduct(id);
    }




}

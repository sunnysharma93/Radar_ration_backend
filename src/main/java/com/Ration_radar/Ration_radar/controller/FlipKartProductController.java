package com.Ration_radar.Ration_radar.controller;

import com.Ration_radar.Ration_radar.entities.FlipkartProduct;
import com.Ration_radar.Ration_radar.service.FlipKartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/flipkart")
public class FlipKartProductController {

    @Autowired
    private FlipKartProductService flipKartProductService;

    @PostMapping
    public FlipkartProduct addProduct(@RequestBody FlipkartProduct flipkartProduct){
        return flipKartProductService.addProduct(flipkartProduct);
    }

    @PostMapping("/bulk")
    public List<FlipkartProduct> addMultipleProduct(@RequestBody List<FlipkartProduct> products){
        return flipKartProductService.addAllProducts(products);
    }

    @GetMapping
    public List<FlipkartProduct> getALlProducts(){
        return flipKartProductService.getAllProducts();
    }
    @GetMapping("/{sku}")
    public FlipkartProduct getProductBySku(@PathVariable String sku){
        return flipKartProductService.getProductBySku(sku);
    }
    public void deleteProduct(@PathVariable Long id){
        flipKartProductService.deleteProduct(id);
    }


}

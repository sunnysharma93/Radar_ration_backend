package com.Ration_radar.Ration_radar.service;

import com.Ration_radar.Ration_radar.entities.FlipkartProduct;
import com.Ration_radar.Ration_radar.repository.FlipKartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlipKartProductService {

    @Autowired
    private FlipKartRepository flipKartRepository;

    public FlipkartProduct addProduct(FlipkartProduct flipkartProduct){
        return flipKartRepository.save(flipkartProduct);
    }

    public List<FlipkartProduct> getAllProducts(){
        return flipKartRepository.findAll();
    }
    public FlipkartProduct getProductBySku(String sku){
        return flipKartRepository.findBySku(sku);
    }
    public void deleteProduct(Long id){
        flipKartRepository.deleteById(id);
    }
    public List<FlipkartProduct> addAllProducts(List<FlipkartProduct> products){
        return flipKartRepository.saveAll(products);
    }
}

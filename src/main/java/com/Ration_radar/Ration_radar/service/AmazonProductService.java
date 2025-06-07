package com.Ration_radar.Ration_radar.service;

import com.Ration_radar.Ration_radar.entities.AmazonProduct;
import com.Ration_radar.Ration_radar.repository.AmazonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmazonProductService {

    @Autowired
    private AmazonRepository amazonRepository;

    public AmazonProduct addProduct (AmazonProduct product){
        return amazonRepository.save(product);

    }

    public List<AmazonProduct> getALlProducts(){
        return amazonRepository.findAll();
    }
    public AmazonProduct getProductBySku(String sku){
        return amazonRepository.findBySku(sku);
    }

    public void deleteProduct(Long id){
        amazonRepository.deleteById(id);
    }
}

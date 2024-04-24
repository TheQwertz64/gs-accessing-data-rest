package com.example.storeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tvService")
public class tvService implements serviceInterface{

    @Autowired
    recTVRepository tvInventory;

    public void saveTv(RecTV newTv){
        tvInventory.save(newTv);
    }

    public RecTV getTV(long sid){
        return tvInventory.findBysid(sid);
    }

    public List<RecTV> getData(){
        List<RecTV> data = tvInventory.findAll();
        return data;
    }

    public RecTV cheapestTv(){
        float price = 0.0f;
        RecTV sel = new RecTV();
        List<RecTV> data = tvInventory.findAll();
        for(RecTV a: data){
            if (a.getPrice() < price){
                price = a.getPrice();
                sel = a;
            }
        }
        return sel;
    }
    
}

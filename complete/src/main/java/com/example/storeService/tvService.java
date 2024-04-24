package com.example.storeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tvService")
public class tvService implements serviceInterface{

    @Autowired
    recTVRepository tvInventory;

    //saves a tv item, (used after one is updated)
    public void saveTv(RecTV newTv){
        tvInventory.save(newTv);
    }

    //gets a tv based on sid
    public RecTV getTV(long sid){
        return tvInventory.findBysid(sid);
    }

    //used for getting a list of all the tvs
    public List<RecTV> getData(){
        List<RecTV> data = tvInventory.findAll();
        return data;
    }

    //returns the cheapest tv
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

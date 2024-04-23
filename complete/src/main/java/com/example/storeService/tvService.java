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

    public RecTV getTV(Long id){
        return tvInventory.findBysid(id);
    }

    public List<RecTV> getData(){
        List<RecTV> data = tvInventory.findAll();
        return data;
    }
    
}

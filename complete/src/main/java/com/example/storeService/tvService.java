package com.example.storeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tvService")
public class tvService implements serviceInterface{

    @Autowired
    recTVRepository tvInventory;

    public void saveTv(RecTV newTv){
        tvInventory.save(newTv);
    }

    public List<RecTV> getData(Long id){
        return tvInventory.findBysid(id);
    }
    
}
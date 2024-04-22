package com.example.accessingdatarest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tvService")
public class tvService {

    @Autowired
    recTVRepository tvInventory;

    public void saveTv(RecTV newTv){
        tvInventory.save(newTv);
    }

    public Optional<RecTV> getData(Long id){
        return tvInventory.findById(id);
    }
    
}

package com.example.storeService;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class restClientController implements restClientInterface {

    @Autowired
    tvService service;

    @PostMapping("/dummy")
    public void dummy(@RequestBody String info) {

        String[] dummy = info.split(",");

        RecTV myTv = new RecTV();
        //parse input here

        service.saveTv(myTv);

    }

    @PostMapping("/silly")
    public String silly(@RequestBody String info) {
        String[] silly = info.split(",");
    

        RecTV alsoMyTv = new RecTV();

        service.saveTv(alsoMyTv);
        return alsoMyTv.toString();
    }

    @GetMapping("/nextPage/{sid}")
    public Object[] nextPage(@PathVariable Long sid) {

        List<String> result = new ArrayList<String>();
        List<RecTV> sample = service.getData(sid);
        for(RecTV test : sample){
            result.add("hi");
        }
        return result.toArray();
    }
}
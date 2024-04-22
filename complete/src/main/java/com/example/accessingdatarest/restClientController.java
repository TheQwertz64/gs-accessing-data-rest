package com.example.accessingdatarest;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface restClientController {
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
        return alsoMyTv.toString;
    }
}
package com.example.storeService;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class restClientController implements restClientInterface {

    @Autowired
    tvService service;

    /*
     * 0 int sales
     * 1 long sid
     */

    @PostMapping("/updateSalesInfo")
        public String updateSalesInfo(@PathVariable String info){
        String[] change = info.split(",");
        service.getTV((long)Integer.parseInt(change[1])).reduceStock(Integer.parseInt(change[0]));
        service.saveTv(service.getTV((long)Integer.parseInt(change[1])));
        return service.getTV((long)Integer.parseInt(change[1])).toString();
    }


    /*
     * 0 Long sid
     * 1 String model
     * 2 String size
     * 3 String resolution
     * 4 String Manufacturer
     * 5 int stock
     * 6 float price
     */


    @PostMapping("/makeStoreOrder")
    public String makeStoreOrder(@RequestBody String oosTv) {
        String[] orderString = oosTv.split(",");
        return ("-1,"+Integer.parseInt(orderString[0])+",1,"+orderString[4]+",0");
    }

    @GetMapping("/getTvInfo/{sid}")
    public String getTvInfo(@PathVariable Long sid) {
        RecTV selTv = service.getTV(sid);
        
        return selTv.toString();
    }


}
package com.example.storeService;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class restClientController implements restClientInterface {

    @Autowired
    tvService service;

    /*
     * 0 int sales
     * 1 long sid
     */

    //for update the repo 
    @PostMapping("/updateSalesInfo/{info}")
        public String updateSalesInfo(@PathVariable String info){
        String[] change = info.split(",");
        service.getTV((long)Integer.parseInt(change[1])).reduceStock(Integer.parseInt(change[0]));
        service.saveTv(service.getTV((long)Integer.parseInt(change[1])));
        return service.getTV((long)Integer.parseInt(change[1])).toString();
    }

    //for sales to get a list of all the tvs
    @GetMapping("/findAllTvs")
        public List<String> findAllTvs(){
            List<RecTV> inventory = service.getData();
            List<String> stringInv = new ArrayList<String>();
            for(RecTV next : inventory){
                stringInv.add(next.toString());
            }
            return stringInv;
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
    
    //for member accounts to find the cheapest tv for their promotion
    @GetMapping("/cheapestTv")
    public String cheapestTv(){
        return service.cheapestTv().toString();
    }

    //for the store to make a special order when oos of a tv
    @PostMapping("/makeStoreOrder")
    public String makeStoreOrder(@RequestBody String oosTv) {
        String[] orderString = oosTv.split(",");
        return ("-1,"+Integer.parseInt(orderString[0])+",1,"+orderString[4]+",0");
    }

    //for special order and store to get info on a specific tv
    @GetMapping("/getTvInfo/{sid}")
    public String getTvInfo(@PathVariable Long sid) {
        RecTV selTv = service.getTV(sid);
        return selTv.toString();
    }

    //if there are at least 10 levelTwoMembers discounts the cheapest tv by 10%
    @PostMapping("/levelTwoMembers")
    public void levelTwoMembers(@RequestParam List<Integer> lvTwoMembers) {
        int members = lvTwoMembers.size();
        if (members > 9){
            float curPrice = service.cheapestTv().getPrice();
            curPrice *= .9;
            service.cheapestTv().setPrice(curPrice);
        }
        service.saveTv(service.cheapestTv());
    }
    


}
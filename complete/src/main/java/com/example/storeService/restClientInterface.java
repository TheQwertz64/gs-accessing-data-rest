package com.example.storeService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface restClientInterface {

    @PostMapping("/updateSalesInfo{info}")
    public String updateSalesInfo(@PathVariable String info);

    @PostMapping("/makeStoreOrder")
    public String makeStoreOrder(@RequestBody String oosTv);

    @GetMapping("/getTvInfo/{sid}")
    public String getTvInfo(@PathVariable Long sid);
    
    @GetMapping("/findAllTvs")
    public List<String> findAllTvs();

    @GetMapping("/cheapestTv")
    public String cheapestTv();

    @PostMapping("/levelTwoMembers")
    public void levelTwoMembers(@RequestParam List<Integer> lvTwoMembers);
}

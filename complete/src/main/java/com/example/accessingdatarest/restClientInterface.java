package com.example.accessingdatarest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface restClientInterface {

    @PostMapping("/dummy")
    public void dummy(@RequestBody String info);

    @PostMapping("/silly")
    public String silly(@RequestBody String info);

    @GetMapping("/nextPage/{sid}")
    public List<RecTV> getInfo(@PathVariable Long sid);
    
}

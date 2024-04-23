package com.example.storeService;

import java.util.*;

public interface serviceInterface {
    public void saveTv(RecTV recTV);

    public List<RecTV> getData();

    public RecTV getTV(Long sid);


    
}

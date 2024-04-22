package com.example.accessingdatarest;

import java.util.*;

public interface serviceInterface {
    public void saveTV(RecTV recTV);

    public List<RecTV> getInfo(Long sid);
}

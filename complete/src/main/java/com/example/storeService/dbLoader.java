package com.example.storeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class dbLoader {
    
    @Bean
    CommandLineRunner initDatabase(recTVRepository tvInventory) {
        return args -> {
            tvInventory.save(new RecTV(1L, "HJ1234", "42\"","1920x1080","LG", 42, 394.99f));
            tvInventory.save(new RecTV(2L, "KL4231","55\"","1280x720", "TCL", 12, 349.99f));
            tvInventory.save(new RecTV(3L, "MN8777", "60\"", "3840x2160", "Sony", 21, 849.99f));
            tvInventory.save(new RecTV(4L, "JB3212", "32\"", "1920x1080", "Toshiba", 33, 274.99f));
            tvInventory.save(new RecTV(5L, "OP1282", "70\"", "4096x2160", "Samsung", 5, 1699.99f));
            tvInventory.save(new RecTV(6L, "NE6423", "55\"", "4096x2160", "Samsung", 0, 999.99f));
        };
    }
}

package com.example.accessingdatarest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class dbLoader {
    
    @Bean
    CommandLineRunner initDatabase(recTVRepository tvInventory) {
        return args -> {
            tvInventory.save(new RecTV());
            tvInventory.save(new RecTV());
            tvInventory.save(new RecTV());
            tvInventory.save(new RecTV());
            tvInventory.save(new RecTV());
        };
    }
}

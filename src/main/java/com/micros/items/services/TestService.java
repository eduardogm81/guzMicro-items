package com.micros.items.services;

import com.micros.items.models.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

//@Component
@Slf4j
@RequiredArgsConstructor
public class TestService implements CommandLineRunner {
    private final ItemServiceFeignImpl itemService;
    @Override
    public void run(String... args) throws Exception {
        log.info("Hello from TestService");
        List<Item> items = itemService.fidnAll();
        log.info("items: {}", items);

    }
}

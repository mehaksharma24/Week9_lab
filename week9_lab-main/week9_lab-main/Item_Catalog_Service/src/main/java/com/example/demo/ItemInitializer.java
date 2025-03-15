package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
class ItemInitializer implements CommandLineRunner {
    private final ItemRepository itemRepository;

    ItemInitializer(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Lining", "PUMA", "Bad Boy", "Air Jordan", "Nike", "Adidas", "Reebok")
                .forEach(brand -> itemRepository.save(new Item(brand)));

        itemRepository.findAll().forEach(System.out::println);
    }
}

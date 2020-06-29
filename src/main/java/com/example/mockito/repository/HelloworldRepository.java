package com.example.mockito.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloworldRepository {

    public String retrieve() {
        return "helloworld";
    }
}

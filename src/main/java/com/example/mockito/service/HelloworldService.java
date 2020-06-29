package com.example.mockito.service;


import com.example.mockito.repository.HelloworldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloworldService {

    @Autowired
    private HelloworldRepository helloworldRepository;

    public String helloworld() {
        return helloworldRepository.retrieve();
    }
}

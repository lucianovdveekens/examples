package com.lvdveekens.springmvc.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String getMsg() {
        return getClass().getSimpleName() + " says hello!";
    }
}

package com.lvdveekens.aspectj;

import java.util.concurrent.Executors;

public class AppImpl implements App {

    @Override
    public void sayHello() {
        System.out.println("Hello World!");
        Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("The pointcut should not match this joinpoint!");
            }
        });
    }
}
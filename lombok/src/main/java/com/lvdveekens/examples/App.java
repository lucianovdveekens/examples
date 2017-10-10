package com.lvdveekens.examples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Person person = new Person("Luciano", 24);
        System.out.println(person);
    }
}

@Data
@ToString
@AllArgsConstructor
class Person {
    private String name;
    private int age;
}

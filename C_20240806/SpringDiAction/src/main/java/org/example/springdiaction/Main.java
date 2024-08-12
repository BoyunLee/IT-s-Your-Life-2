package org.example.springdiaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        context.getBean("person2", Person.class).setName("수민이");
        System.out.println(context.getBean("person2", Person.class).getName());


    }
}

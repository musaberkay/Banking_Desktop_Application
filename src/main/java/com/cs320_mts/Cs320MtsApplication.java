package com.cs320_mts;

import com.cs320_mts.GUI.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
public class Cs320MtsApplication implements CommandLineRunner {

    @Autowired
    Application application;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Cs320MtsApplication.class).headless(false).run(args);

    }

    @Override
    public void run(String... args) {
        application.init();
    }


}
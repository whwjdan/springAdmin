package com.jeongmu.springstudy1;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class Springstudy1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springstudy1Application.class, args);
    }


}

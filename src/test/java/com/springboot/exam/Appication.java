package com.springboot.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Appication {
    public static void main(String[] args) {
        SpringApplication.run(Appication.class,args);

        //SpringApplication 내장 WAS( 내장 톰캣, 내장서버) 를 실행시켜줌
    }
}

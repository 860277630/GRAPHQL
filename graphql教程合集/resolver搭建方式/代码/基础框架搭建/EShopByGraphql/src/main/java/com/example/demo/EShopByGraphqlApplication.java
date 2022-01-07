package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EShopByGraphqlApplication {

    public static void main(String[] args) {
        int port = 8099;
        String playGround = "/playground";
        String voyager = "/voyager";
        String portPrefix = "--server.port=";
        for (String arg : args) {
            if (arg.startsWith(portPrefix)) {
                port = Integer.parseInt(arg.substring(portPrefix.length()));
            }
        }
        SpringApplication.run(EShopByGraphqlApplication.class, args);
        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:" + port+playGround);
            Runtime.getRuntime().exec("cmd /c start http://localhost:" + port+voyager);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

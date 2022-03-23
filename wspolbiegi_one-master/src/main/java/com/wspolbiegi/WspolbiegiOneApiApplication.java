package com.wspolbiegi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WspolbiegiOneApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WspolbiegiOneApiApplication.class, args);
//        RequestThreadPool requestThreadPool = new RequestThreadPool();
//        requestThreadPool.requestHandler();
    }
}

@RestController
class HelloController {
    @GetMapping("/")
    String hello() {
        return "Tu kiedyś powstanie coś wspaniałego!";
    }

    @GetMapping("/download/{threadNumber}/")
    String download() {
        RequestThreadPool requestThreadPool = new RequestThreadPool();
        requestThreadPool.requestHandler();
        // tutaj pewnie odpalamy threadpool albo kolejkę runnable, sterowanie albo zmieniając kod albo jakąś flagą przy uruchmieniu serwera
        return "";
    }
}

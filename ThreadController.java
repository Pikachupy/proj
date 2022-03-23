package com.wspolbiegi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@CrossOrigin
@RequestMapping
public class ThreadController {
    private AtomicInteger counter;

    public void ThreadController(AtomicInteger counter) {
        this.counter = counter;
    }

    // GET zwracający id
//    @GetMapping("/download")
//    public
}

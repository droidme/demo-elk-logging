package io.droidme.elk.controller;

import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    private final Logger logger;

    public HelloController(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("/hello")
    public String Hello(@RequestParam("name") String name) {
        String howdy = Optional.ofNullable(name).orElse("Reinhard");
        MDC.put("Howdy", howdy);
        logger.info(String.format("Hello %s", howdy));
        MDC.remove("Howdy");
        return String.format("Hello %s", howdy);
    }
}

package com.subhadipmitra.code.consentbase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Controller
public class RootController {

    @GetMapping("/")
    @ResponseBody
    public Flux<String> getRoot() {
        return Flux.just("Consent Service Alive");
    }
}
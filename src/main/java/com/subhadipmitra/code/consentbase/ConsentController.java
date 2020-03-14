package com.subhadipmitra.code.consentbase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "/consents")
public class ConsentController {

    private final ConsentRepository consentRepository;

    public ConsentController(ConsentRepository consentRepository) {
        this.consentRepository = consentRepository;
    }

    @PostMapping()
    public @ResponseBody
    Mono<Consent> addConsent(@RequestBody Consent consent) {
        return consentRepository.save(consent);
    }

    @GetMapping()
    public @ResponseBody
    Flux<Consent> getAllConsents() {
        Flux<Consent> result = consentRepository.findAll();
        return result;
    }}
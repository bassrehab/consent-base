package com.subhadipmitra.code.consentbase;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ConsentRepository extends ReactiveMongoRepository<Consent, Long> {
}

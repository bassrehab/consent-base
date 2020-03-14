package com.subhadipmitra.code.consentbase;

import com.subhadipmitra.code.consentbase.utils.RandomUserAgent;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

import static com.subhadipmitra.code.consentbase.Seed.*;
import static com.subhadipmitra.code.consentbase.utils.GenericUtils.*;

@SpringBootApplication
public class ConsentbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsentbaseApplication.class, args);
	}

	/**
	 * Initialize with some demo values.
	 * Placeholder for Calling Service from Channels/Apps
	 * @param repository
	 * @return
	 */
	@Bean
	ApplicationRunner init(ConsentRepository repository) {

		Object[][] data = IntStream.range(0, 1000).mapToObj(i -> new Object[]{
				getRandomUUID(),
				id_prefix + getDuplicatbleId(),
				getRandomItemFromList(customerType),
				getRandomDtTime(false),
				nist_prefix + getRandomUUID(),
				getRandomItemFromList(channel),
				getRandomDtTime(false),
				getRandomDtTime(true),
				getRandomItemFromList(scope),
				RandomUserAgent.getRandomUserAgent()
		}).toArray(Object[][]::new);


		return args -> {
			repository
					.deleteAll()
					.thenMany(
							Flux
									.just(data)
									.map(array -> {
										return new Consent((String) array[0], (String) array[1], (String) array[2],
												(String) array[3], (String) array[4], (String) array[5], (String) array[6],
												(String) array[7], (String) array[8], (String) array[9]);
									})
									.flatMap(repository::save)
					)
					.thenMany(repository.findAll())
					.subscribe(consent -> System.out.println("saving " + consent.toString()));

		};
	}


}

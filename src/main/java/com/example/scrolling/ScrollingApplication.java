package com.example.scrolling;

import com.example.scrolling.model.Person;
import com.example.scrolling.repository.PersonRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

@SpringBootApplication
public class ScrollingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrollingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PersonRepo personRepo) {
        return  args -> {
            LongStream.range(0, 200).
                    forEach(x ->
                            personRepo.save(new Person()
                                    .setName("person").setToken(ThreadLocalRandom.current().nextLong(1000L))));
        };
    }
}

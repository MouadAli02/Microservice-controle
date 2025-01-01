package org.example.customerservice;

import org.example.customerservice.entities.Customer;
import org.example.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("Mouad").email("mouad@gmail.com").build(),
                            Customer.builder().name("Hassan").email("hassan@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(System.out::println);


        };
    }
}

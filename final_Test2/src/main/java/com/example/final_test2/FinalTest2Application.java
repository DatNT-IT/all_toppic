package com.example.final_test2;

import com.example.final_test2.repository.IUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = IUserRepository.class)
public class FinalTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(FinalTest2Application.class, args);
    }

}

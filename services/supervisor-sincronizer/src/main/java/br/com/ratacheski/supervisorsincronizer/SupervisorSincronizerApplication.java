package br.com.ratacheski.supervisorsincronizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SupervisorSincronizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupervisorSincronizerApplication.class, args);
    }

}

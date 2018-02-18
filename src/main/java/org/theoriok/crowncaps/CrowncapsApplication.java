package org.theoriok.crowncaps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan("org.theoriok")
public class CrowncapsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrowncapsApplication.class, args);
    }
}

package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "controllers","models"}) // define packages for scan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

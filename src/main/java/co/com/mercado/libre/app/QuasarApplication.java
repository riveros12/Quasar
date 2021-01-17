package co.com.mercado.libre.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "co.com.mercado.libre.controller",
        "co.com.mercado.libre.business",
        "co.com.mercado.libre.app",
        "co.com.mercado.libre.domain.servicies",
        "co.com.mercado.libre.domain.exception"
})
public class QuasarApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuasarApplication.class, args);
    }
}

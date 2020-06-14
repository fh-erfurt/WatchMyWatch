package de.watchmywatch.model.Helper;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.repository.core.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class WatchMyWatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(WatchMyWatchApplication.class, args);
    }

}

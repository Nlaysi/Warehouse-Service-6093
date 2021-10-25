package itmo.softwaredesign.warehouse;

import itmo.softwaredesign.warehouse.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
public class SoftwareDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareDesignApplication.class, args);
    }

}

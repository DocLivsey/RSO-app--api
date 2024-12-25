package dclvs.rso_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RsoAppApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsoAppApiApplication.class, args);
    }

}

package hexlet.code.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WelcomeController {

    @GetMapping(path = "/welcome")
    public String welcome() {
        return "Welcome to Spring!";
    }
}
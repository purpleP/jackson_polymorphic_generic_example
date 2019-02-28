package hello;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    @PreAuthorize("allowed()")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}

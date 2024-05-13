package ke.natujenge.cloud.gateway.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {
    @GetMapping("/userServiceFallBack")
public  String userServiceFallBackMethod(){
    return  "User Service is taking longer than expected" +"Please try again later";
}
    @GetMapping("/shortnerServiceFallBack")
    public  String shortnerServiceFallBackMethod(){
        return  "Shortner Service is taking longer than expected" +"Please try again later";
    }
}

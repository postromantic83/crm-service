package ru.gazpromneft_at;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return new String("Hello world! Welcome to ESB-DMZ!");
    }
}

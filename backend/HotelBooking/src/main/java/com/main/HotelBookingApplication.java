package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HotelBookingApplication {

	public static void main(String[] args) 
	{

		SpringApplication.run(HotelBookingApplication.class, args);
	}

}

@RestController
class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
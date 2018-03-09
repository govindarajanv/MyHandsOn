package in.govindarajanv.SpringBootApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringBootController {
	
		@RequestMapping("/")
	    public String home() {
	        return "Hello World!";
	    }
	
}

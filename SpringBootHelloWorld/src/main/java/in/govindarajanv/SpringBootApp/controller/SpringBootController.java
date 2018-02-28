package in.govindarajanv.SpringBootApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringBootController {
	public class SpringBootApp 
	{
		@RequestMapping("/hello")
	    String home() {
	        return "Hello World!";
	    }
	}

}

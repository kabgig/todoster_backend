package com.in28minutes.rest.webservices.restfulwebservices.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/basicauth")
	public String basicAthCheck() {
		return "Success";
	}

	@GetMapping(path = "/")
	public String returnSomethingOnRootUrl() {
		return "Congratulations!";
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World v3";
	}

}

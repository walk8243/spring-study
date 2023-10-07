package xyz.walk8243.springstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.walk8243.springstudy.model.Hello;

@RestController()
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping({""})
	public Hello get() {
		return new Hello("Hello World!");
	}
}

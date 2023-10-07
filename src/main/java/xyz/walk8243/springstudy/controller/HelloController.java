package xyz.walk8243.springstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import xyz.walk8243.springstudy.model.Hello;

@RestController
@RequestMapping("/hello")
@Tag(name = "Hello", description = "Getting Started")
public class HelloController {
	
	@GetMapping({""})
	@Operation(summary = "hello", description = "Hello World")
	public Hello get() {
		return new Hello("Hello World!");
	}
}

package xyz.walk8243.springstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import xyz.walk8243.springstudy.model.Hello;
import xyz.walk8243.springstudy.model.constant.Environment;

@RestController
@RequestMapping("/hello")
@Tag(name = "Hello", description = "Getting Started")
@RequiredArgsConstructor
public class HelloController {
	private final Environment env;
	
	@GetMapping({""})
	@Operation(summary = "hello", description = "Hello World")
	public Hello get() {
		return new Hello("Hello World!", env);
	}
}

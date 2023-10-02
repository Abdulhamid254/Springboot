package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


//	@GetMapping
//	//here it returns a normal string
////	public String hello(){
////		return "Hello World";
////	}


	//this one return a json obj
//	@GetMapping
////	public List<String> hello() {
////		return List.of("Hello", "World!");
////	}




}

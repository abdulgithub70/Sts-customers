package com.jamia.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.jamia.*")
public class SpringPracticeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPracticeProjectApplication.class, args);
		System.out.println("this is my first spring project");
		
	}

}

package com.nutrahall.nutrahallrest;


import com.nutrahall.nutrahallrest.web.userController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScans(value = {@ComponentScan("com.myapp.repository"),
		@ComponentScan(basePackageClasses = userController.class) })
public class NutrahallrestApplication {



	public static void main(String[] args) {
		SpringApplication.run(NutrahallrestApplication.class, args);
	}

}

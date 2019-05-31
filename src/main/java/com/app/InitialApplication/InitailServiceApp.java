package com.app.InitialApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.app")
public class InitailServiceApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SpringApplication.run(InitailServiceApp.class,args);
	}

}

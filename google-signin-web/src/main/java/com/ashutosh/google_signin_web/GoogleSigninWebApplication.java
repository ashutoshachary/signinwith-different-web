package com.ashutosh.google_signin_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ashutosh.google_signin_web.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class GoogleSigninWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleSigninWebApplication.class, args);
	}

}

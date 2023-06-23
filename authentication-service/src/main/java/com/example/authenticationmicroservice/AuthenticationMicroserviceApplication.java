package com.example.authenticationmicroservice;

import com.example.authenticationmicroservice.Entity.Role;
import com.example.authenticationmicroservice.Entity.User;
import com.example.authenticationmicroservice.Service.RoleService;
import com.example.authenticationmicroservice.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;

@SpringBootApplication
@EnableEurekaClient
public class AuthenticationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationMicroserviceApplication.class, args);
	}


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(RoleService roleService , UserService userService){
		return args -> {
			// init roles list
			roleService.saveRole(Role.builder().name("ADMIN").build());
			roleService.saveRole(Role.builder().name("USER").build());

			// init users list
			userService.saveUser( User.builder().email("faiez.abid@esprit.tn").password("fabid").username("fabid").roles(new  ArrayList<>()).build()) ;
			userService.saveUser( User.builder().email("nazih.jlassi1@esprit.tn ").password("njlassi").username("njlassi").roles(new  ArrayList<>()).build()) ;
			userService.saveUser( User.builder().email("marwen.fraj1@esprit.tn ").password("mfraj").username("mfraj").roles(new  ArrayList<>()).build()) ;
			userService.saveUser( User.builder().email("marwa.mahdoui1@esprit.tn").password("mmahdoui").username("mmahdoui").roles(new  ArrayList<>()).build()) ;
			userService.saveUser( User.builder().email("hamza mohamedhamza.ajlani@esprit.tn ").password("mhajlani").username("mhajlani").roles(new  ArrayList<>()).build()) ;
			userService.saveUser( User.builder().email("yassin.thabti1@esprit.tn").password("ythabti").username("ythabti").roles(new  ArrayList<>()).build()) ;


		} ;
	}




}

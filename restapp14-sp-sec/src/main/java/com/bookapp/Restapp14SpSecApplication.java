package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.entity.AppUser;
import com.bookapp.service.AppUserService;

@SpringBootApplication
public class Restapp14SpSecApplication implements CommandLineRunner {

	@Autowired
	private AppUserService appUserService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Restapp14SpSecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		AppUser user1=new AppUser("raj", "raj123", new String[] {"ROLE_ADMIN","ROLE_MGR","ROLE_EMP"});
//		AppUser user2=new AppUser("ekta", "ekta123", new String[] {"ROLE_MGR","ROLE_EMP"});
//		AppUser user3=new AppUser("gunika", "gunika123", new String[] {"ROLE_EMP"});
//		
//		appUserService.addAppUser(user1); 
//		appUserService.addAppUser(user2); 
//		appUserService.addAppUser(user3); 
		
		System.out.println("user is added...");
	}

}

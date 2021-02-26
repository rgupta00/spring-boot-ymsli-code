package com.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.dao.AppUserRepo;
import com.bookapp.entity.AppUser;
@Service
@Transactional
public class AppUserServiceImpl implements AppUserService{

	private AppUserRepo appUserRepo;
	
	@Autowired
	public AppUserServiceImpl(AppUserRepo appUserRepo) {
		this.appUserRepo = appUserRepo;
	}

	@Override
	public AppUser findByName(String name) {
		return appUserRepo.findByName(name);
	}

	@Override
	public void addAppUser(AppUser appUser) {
		appUserRepo.save(appUser);
	}

}

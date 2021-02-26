package com.bookapp.service;

import com.bookapp.entity.AppUser;

public interface AppUserService {
	public AppUser findByName(String name);
	public void addAppUser(AppUser appUser);
}

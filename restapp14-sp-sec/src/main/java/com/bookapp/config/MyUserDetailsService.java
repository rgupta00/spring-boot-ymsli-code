package com.bookapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookapp.entity.AppUser;
import com.bookapp.service.AppUserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private AppUserService appUserService;

	@Autowired
	public MyUserDetailsService(AppUserService appUserService) {
		this.appUserService = appUserService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// i need to do something so that i can convert my appuser --> to spring sec
		// user
		AppUser appUser = appUserService.findByName(username);
		if (appUser == null)
			throw new UsernameNotFoundException("user not found");

		User user = new User(appUser.getName(), appUser.getPassword(),
				AuthorityUtils.createAuthorityList(appUser.getRoles()));

		return user;
	}

}

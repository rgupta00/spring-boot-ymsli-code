package com.bookapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.entity.AppUser;
@Repository
public interface AppUserRepo extends CrudRepository<AppUser, Long>{
	public AppUser findByName(String name);
}

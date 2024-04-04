package com.jfs.backend.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jfs.backend.entity.UserData;

@Repository
public interface UserRepository extends CrudRepository<UserData, Integer> {

	// find the User which is belongs to India
	public List<UserData> findByCountry(String cName);
	
	// find the User whose age is 30
	public List<UserData> findByUserage(Integer age);
	
	// find the User whose age is greater than 30
	public List<UserData> findByUserageGreaterThanEqual(Integer age);
	
	// find the User which is belongs to India and USA
	public List<UserData> findByCountryIn(List<String> countries);
	
	// User is belongs to india and its age is 30
	public List<UserData> findByCountryAndUserage(String cName, Integer age);
	
	// User is belongs to india and its age is 30 and gender is Male
	
	public List<UserData> findByCountryAndUserageAndGender(String cName,Integer age,String gender);
	
}

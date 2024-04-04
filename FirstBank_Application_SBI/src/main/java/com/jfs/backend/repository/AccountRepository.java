package com.jfs.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jfs.backend.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	public List<Account> findByUsernameAndPassword(String uname, String pass);

	// public List<Account> findByUsername(String uname);

	public Account findByUsername(String uname);

	public Account findByAccountnumber(String accNum);

}

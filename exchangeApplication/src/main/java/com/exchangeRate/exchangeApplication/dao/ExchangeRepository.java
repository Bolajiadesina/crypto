package com.exchangeRate.exchangeApplication.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.exchangeRate.exchangeApplication.model.Users;






@Repository
public interface ExchangeRepository extends JpaRepository<Users, Integer> {

	
	@Query(value = "SELECT a.userName,a.password FROM Users a where a.userName = :userName")
	Users getUser();
	

}

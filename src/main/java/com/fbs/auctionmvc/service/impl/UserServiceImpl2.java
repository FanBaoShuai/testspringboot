package com.fbs.auctionmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fbs.auctionmvc.entity.User;
import com.fbs.auctionmvc.service.UserService;
@Service
public class UserServiceImpl2 implements UserService{
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
	

	public void register(User user){
		
	}


	public boolean register1(User user) {
		try {
			userServiceImpl.register(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public User login(String userName, String passWord) {
		// TODO Auto-generated method stub
		return null;
	}
}

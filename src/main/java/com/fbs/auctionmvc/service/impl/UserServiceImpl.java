package com.fbs.auctionmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.auctionmvc.dao.UserDao;
import com.fbs.auctionmvc.entity.User;
import com.fbs.auctionmvc.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;



	public void register(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);
	}


	public User login(String userName, String passWord) {
		// TODO Auto-generated method stub
		return userDao.selectOne(userName, passWord);
	}


	public boolean register1(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}

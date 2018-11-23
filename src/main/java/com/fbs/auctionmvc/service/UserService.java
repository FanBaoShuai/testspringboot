package com.fbs.auctionmvc.service;

import com.fbs.auctionmvc.entity.User;

public interface UserService {
	public void register(User user);
	public boolean register1(User user);
	public User login(String userName, String passWord);
}

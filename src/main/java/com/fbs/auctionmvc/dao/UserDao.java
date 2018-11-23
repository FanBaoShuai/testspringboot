package com.fbs.auctionmvc.dao;

import com.fbs.auctionmvc.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
	public User selectOne(@Param("userName") String userName, @Param("passWord") String passWord);
	public void add(User user);
}

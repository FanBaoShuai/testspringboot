package com.fbs.auctionmvc.controller;

import com.fbs.auctionmvc.entity.User;
import com.fbs.auctionmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	@Autowired
	@Qualifier("userServiceImpl2")
	private UserService userService2;

	@RequestMapping("/login")
	public String login(User user,HttpSession session,String kaptcha,Map map){
		User userlogin = userService.login(user.getUser_name(), user.getUser_password());
		String a = (String)session.getAttribute("kaptcha");
		if(userlogin != null){
			if(a.equalsIgnoreCase(kaptcha)){
				session.setAttribute("user", userlogin);
				return "redirect:/selectAll.do";
			}else{
				map.put("images", "验证码输入错误");
				return "login";
			}
		}else{
			map.put("images", "账号密码输入错误");
			return "login";
		}
	}

	@RequestMapping("/register")
	public String register(User user,String kaptcha,HttpSession session){
		boolean a = userService2.register1(user);
		if(a){
			return "login";
		}else{
			return "index";
		}
	}
}

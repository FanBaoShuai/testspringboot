package com.fbs.auctionmvc.controller;

import com.fbs.auctionmvc.entity.Record;
import com.fbs.auctionmvc.entity.User;
import com.fbs.auctionmvc.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RecordController {
	@Autowired
	private RecordService recordService;
	
	@RequestMapping("recordAdd")
	public String recordAdd(Record record,HttpSession session){
		User user = (User)session.getAttribute("user");
		record.setUser_id(user.getUser_id());
		recordService.add(record);
		return "redirect:/selectOne1.do?id="+record.getAuction_id();
	}
	
}

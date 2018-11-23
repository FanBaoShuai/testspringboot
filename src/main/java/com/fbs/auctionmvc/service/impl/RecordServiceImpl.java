package com.fbs.auctionmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.auctionmvc.dao.RecordDao;
import com.fbs.auctionmvc.entity.Record;
import com.fbs.auctionmvc.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDao recordDao;
	

	public void add(Record record) {
		// TODO Auto-generated method stub
		recordDao.add(record);
	}


	public List<Record> selectAll(int id) {
		// TODO Auto-generated method stub
		return recordDao.selectAll(id);
	}

}

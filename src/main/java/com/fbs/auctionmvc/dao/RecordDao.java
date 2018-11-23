package com.fbs.auctionmvc.dao;

import com.fbs.auctionmvc.entity.Record;

import java.util.List;

public interface RecordDao {
	public List<Record> selectAll(int id);
	public void add(Record record);
}	

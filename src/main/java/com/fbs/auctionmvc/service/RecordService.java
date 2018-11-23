package com.fbs.auctionmvc.service;

import com.fbs.auctionmvc.entity.Record;

import java.util.List;

public interface RecordService {
	public void add(Record record);
	public List<Record> selectAll(int id);
}

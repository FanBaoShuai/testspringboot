package com.fbs.auctionmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.auctionmvc.dao.AuctionDao;
import com.fbs.auctionmvc.entity.Auction;
import com.fbs.auctionmvc.service.AuctionService;
@Service
public class AuctionServiceImpl implements AuctionService{
	@Autowired
	private AuctionDao auctionDao;

	public List<Auction> selectAll(Auction auction) {
		// TODO Auto-generated method stub
		return auctionDao.selectAll(auction);
	}


	public void update(Auction auction) {
		// TODO Auto-generated method stub
		auctionDao.update(auction);
	}


	public Auction selectOne(int id) {
		// TODO Auto-generated method stub
		return auctionDao.selectOne(id);
	}


	public void add(Auction auction) {
		// TODO Auto-generated method stub
		auctionDao.add(auction);
	}


	public void delete(int id) {
		// TODO Auto-generated method stub
		auctionDao.delete(id);
	}

}

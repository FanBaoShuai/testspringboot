package com.fbs.auctionmvc.dao;

import com.fbs.auctionmvc.entity.Auction;

import java.util.List;

public interface AuctionDao {
	public void add(Auction auction);
	public void delete(int id);
	public void update(Auction auction);
	public List<Auction> selectAll(Auction auction);
	public Auction selectOne(int id);
}

package com.fbs.auctionmvc.service;

import com.fbs.auctionmvc.entity.Auction;

import java.util.List;

public interface AuctionService {
	public List<Auction> selectAll(Auction auction);
	public void update(Auction auction);
	public Auction selectOne(int id);
	public void add(Auction auction);
	public void delete(int id);
}

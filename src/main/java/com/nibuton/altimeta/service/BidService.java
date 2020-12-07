package com.nibuton.altimeta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nibuton.altimeta.entities.Bid;
import com.nibuton.altimeta.entities.BidItem;
import com.nibuton.altimeta.entities.TradeItem;
import com.nibuton.altimeta.exception.BidValidationException;
import com.nibuton.altimeta.repo.BidItemRepo;
import com.nibuton.altimeta.repo.BidRepo;
import com.nibuton.altimeta.repo.TradeItemRepo;

@org.springframework.stereotype.Service
public class BidService implements Service<Bid> {
	
	private BidRepo bidRepo;
	private TradeItemRepo tradeItemRepo;
	private BidItemRepo bidItemRepo;
	
	
	@Autowired
	public BidService(BidRepo bidRepo, TradeItemRepo tradeItemRepo, BidItemRepo bidItemRepo){
		this.bidRepo = bidRepo;
		this.tradeItemRepo = tradeItemRepo;
		this.bidItemRepo = bidItemRepo;
	}
	
	
	/*public BidItem returnBestBid(int trade_item_id) {
		
		List<BidItem> bidItems = bidItemRepo.getBestBid(trade_item_id);
		
		if (Optional.ofNullable(bidItems).isPresent()) {
			return bidItems.get(0);
		}
		else {
			throw new 
		}
		
	}*/

	@Override
	public Bid save(Bid bid) {
		
		for (BidItem bidItem : bid.getBidItems()) {
			TradeItem tradeItem = tradeItemRepo.getOne(bidItem.getTrade_item_id());
			bidItem.setTradeItem(tradeItem);
			
			Integer minPrice = bidItemRepo.getMinPrice(tradeItem.getId());
			
			if(bidItem.getPrice() > tradeItemRepo.getInitialPrice(tradeItem.getId())){
				throw new BidValidationException(1,tradeItem.getId());
			}
			
			if (Optional.ofNullable(minPrice).isPresent()) {
				
				if(bidItem.getPrice() >= minPrice){
					throw new BidValidationException(2,tradeItem.getId());
				}
			}
			
			bidItem.setBid(bid);
		}
		
		
		Bid returnedBid = bidRepo.save(bid);
		return returnedBid;
	}
	

	
}

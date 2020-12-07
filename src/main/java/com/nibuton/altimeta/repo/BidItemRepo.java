package com.nibuton.altimeta.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nibuton.altimeta.entities.BidItem;

public interface BidItemRepo extends JpaRepository<BidItem, Integer> {
	
	@Query(value = "SELECT MIN(price) FROM bid_item WHERE trade_item_id = ?1", nativeQuery = true)
	Integer getMinPrice(int trade_item_id);
	
	@Query(value = "SELECT * FROM bid_item WHERE trade_item_id = ?1 limit 1", nativeQuery = true)
	List<BidItem> getBestBid(int trade_item_id);

}

package com.nibuton.altimeta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nibuton.altimeta.entities.BidItem;

public interface BidItemRepo extends JpaRepository<BidItem, Integer> {
	
	@Query(value = "SELECT MIN(price) FROM bid_item WHERE trade_item_id = ?1", nativeQuery = true)
	int getMinPrice(int trade_item_id);

}

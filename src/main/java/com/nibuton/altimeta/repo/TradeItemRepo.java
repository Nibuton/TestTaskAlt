package com.nibuton.altimeta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nibuton.altimeta.entities.TradeItem;

public interface TradeItemRepo extends JpaRepository<TradeItem, Integer> {
	
	@Query(value = "SELECT initial_price FROM trade_item WHERE id = ?1", nativeQuery = true)
	int getInitialPrice(int trade_item_id);
	
}

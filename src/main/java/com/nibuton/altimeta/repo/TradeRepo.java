package com.nibuton.altimeta.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibuton.altimeta.entities.Trade;

public interface TradeRepo extends JpaRepository<Trade, Integer> {

}

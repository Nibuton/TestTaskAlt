package com.nibuton.altimeta.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibuton.altimeta.entities.Bid;

public interface BidRepo extends JpaRepository<Bid, Integer> {

}

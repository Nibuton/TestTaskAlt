package com.nibuton.altimeta.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bid")
public class Bid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToMany(mappedBy = "bid",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<BidItem> bidItems = new HashSet<BidItem>();

	public Bid() {
		// TODO Auto-generated constructor stub
	}

	public Bid(int id, Set<BidItem> bidItems) {
		super();
		this.id = id;
		this.bidItems = bidItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<BidItem> getBidItems() {
		return bidItems;
	}

	public void setBidItems(Set<BidItem> bidItems) {
		this.bidItems = bidItems;
	}
	
	

}

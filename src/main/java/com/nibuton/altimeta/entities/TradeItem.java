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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trade_item")
public class TradeItem{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "initial_price")
	private double intitial_price;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "trade_id")
	private Trade trade;
	
	@OneToMany(mappedBy = "tradeItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<BidItem> bidItems = new HashSet<>();
	
	public TradeItem() {
		
	}

	public TradeItem(double intitial_price, Trade trade, Set<BidItem> bidItems) {
		super();
		this.intitial_price = intitial_price;
		this.trade = trade;
		this.bidItems = bidItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getIntitial_price() {
		return intitial_price;
	}

	public void setIntitial_price(double intitial_price) {
		this.intitial_price = intitial_price;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public Set<BidItem> getBidItems() {
		return bidItems;
	}

	public void setBidItems(Set<BidItem> bidItems) {
		this.bidItems = bidItems;
	}

	

}

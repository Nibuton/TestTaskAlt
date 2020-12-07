package com.nibuton.altimeta.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "bid_item")
public class BidItem{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "price")
	private int price;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "bid_id")
	private Bid bid;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "trade_item_id")
	private TradeItem tradeItem;
	
	@Transient
	private int trade_item_id;

	public BidItem() {
		// TODO Auto-generated constructor stub
	}

	public BidItem(Bid bid, TradeItem tradeItem, int price, int trade_item_id) {
		super();
		this.bid = bid;
		this.tradeItem = tradeItem;
		this.price = price;
		this.trade_item_id = trade_item_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public TradeItem getTradeItem() {
		return tradeItem;
	}

	public void setTradeItem(TradeItem tradeItem) {
		this.tradeItem = tradeItem;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTrade_item_id() {
		return trade_item_id;
	}

	public void setTrade_item_id(int trade_item_id) {
		this.trade_item_id = trade_item_id;
	}

}

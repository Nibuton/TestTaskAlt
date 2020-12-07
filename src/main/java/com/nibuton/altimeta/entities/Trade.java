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
@Table(name = "trade")
public class Trade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "organization")
	private String organization;
	
	@OneToMany(mappedBy = "trade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TradeItem> tradeItems = new HashSet<TradeItem>();

	public Trade() {
		// TODO Auto-generated constructor stub
	}

	public Trade(String organization, Set<TradeItem> tradeItems) {
		super();
		this.organization = organization;
		this.tradeItems = tradeItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Set<TradeItem> getTradeItems() {
		return tradeItems;
	}

	public void setTradeItems(Set<TradeItem> tradeItems) {
		this.tradeItems = tradeItems;
	}
	

}

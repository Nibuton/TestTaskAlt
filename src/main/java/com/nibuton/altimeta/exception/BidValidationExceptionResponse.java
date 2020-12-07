package com.nibuton.altimeta.exception;

public class BidValidationExceptionResponse {
	
	private int status_code;
	private int trade_item_id;

	public BidValidationExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

	public BidValidationExceptionResponse(int status_code, int trade_item_id) {
		super();
		this.status_code = status_code;
		this.trade_item_id = trade_item_id;
	}

	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

	public int getTrade_item_id() {
		return trade_item_id;
	}

	public void setTrade_item_id(int trade_item_id) {
		this.trade_item_id = trade_item_id;
	}
	
	

}

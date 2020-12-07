package com.nibuton.altimeta.exception;

public class BidValidationException extends RuntimeException {
	
	private int code;
	private int trade_item_id;
	
	public BidValidationException(int code, int trade_item_id) {
		super();
		this.code = code;
		this.trade_item_id = trade_item_id;
		
	}

	public BidValidationException() {
		// TODO Auto-generated constructor stub
	}

	public BidValidationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BidValidationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BidValidationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BidValidationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getTrade_item_id() {
		return trade_item_id;
	}

	public void setTrade_item_id(int trade_item_id) {
		this.trade_item_id = trade_item_id;
	}
	
	

}

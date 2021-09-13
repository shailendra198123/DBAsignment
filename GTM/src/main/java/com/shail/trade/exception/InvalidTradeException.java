package com.shail.trade.exception;

public class InvalidTradeException extends RuntimeException {

	private String tradeId;
//private String msg;
	public InvalidTradeException(String tradeId,String message) {
		super("Invalid Trade "+ tradeId +" cause " + message);
		this.tradeId = tradeId;
	
		
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	
	
	
}

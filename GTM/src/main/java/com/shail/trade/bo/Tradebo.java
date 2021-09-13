package com.shail.trade.bo;
import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.shail.trade.exception.InvalidTradeException;




public class Tradebo {

	
	

private String id;
private int version;
private String counterPartyId;
private String bookId;
private LocalDate maturityDate;
private LocalDate createdDate;
private char isExpired;


public Tradebo(String id, int version, String counterPartyId, String bookId, LocalDate maturityDate,
		 char isExpired) {
	super();
	if(StringUtils.isBlank(id) || version <1 ||StringUtils.isBlank(counterPartyId) || null==maturityDate) {
		throw new InvalidTradeException(id, " Blank field ");
	}
	this.id = id;
	this.version = version;
	this.counterPartyId = counterPartyId;
	this.bookId = bookId;
	this.maturityDate = maturityDate;
	this.createdDate = LocalDate.now();
	this.isExpired = isExpired;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}
public String getCounterPartyId() {
	return counterPartyId;
}
public void setCounterPartyId(String counterPartyId) {
	this.counterPartyId = counterPartyId;
}
public String getBookId() {
	return bookId;
}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public LocalDate getMaturityDate() {
	return maturityDate;
}
public void setMaturityDate(LocalDate maturityDate) {
	this.maturityDate = maturityDate;
}
public LocalDate getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}
public char isExpired() {
	return isExpired;
}
public void setExpired(char isExpired) {
	this.isExpired = isExpired;
}


}

package com.yorku.group111.dto;

public class BiddingDto {
	private String itemname;
	private String itemdesc;
	private String itemshippingprice;
	private Integer currentprice;
	private String highestbidder;
	
	public BiddingDto(String itemname, String itemdesc, String itemshippingprice, Integer currentprice,String highestbidder) {
		this.itemname = itemname;
		this.itemdesc = itemdesc;
		this.itemshippingprice = itemshippingprice;
		this.currentprice = currentprice;
		this.highestbidder = highestbidder;
	}
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	public String getItemshippingprice() {
		return itemshippingprice;
	}
	public void setItemshippingprice(String itemshippingprice) {
		this.itemshippingprice = itemshippingprice;
	}
	public Integer getCurrentprice() {
		return currentprice;
	}
	public void setCurrentprice(Integer currentprice) {
		this.currentprice = currentprice;
	}
	public String getHighestbidder() {
		return highestbidder;
	}
	public void setHighestbidder(String highestbidder) {
		this.highestbidder = highestbidder;
	}
}

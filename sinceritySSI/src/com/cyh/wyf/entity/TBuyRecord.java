package com.cyh.wyf.entity;

import java.util.Date;

public class TBuyRecord {
	private int buyid;
	private String uname;
	private Date buytime;
	private double allmoney;
	
	
	public int getBuyid() {
		return buyid;
	}
	public void setBuyid(int buyid) {
		this.buyid = buyid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getBuytime() {
		return buytime;
	}
	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}
	public double getAllmoney() {
		return allmoney;
	}
	public void setAllmoney(double allmoney) {
		this.allmoney = allmoney;
	}

}

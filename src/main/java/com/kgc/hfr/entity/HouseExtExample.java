package com.kgc.hfr.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 梦霄
 * \* Date: 2019/7/2
 * \* Time: 14:47
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class HouseExtExample {
	private String price;
	private String floorage;
	private Date pubdate;
	private Long startPrice;
	private Long endPrice;
	private Integer districtID;
	private Integer type_id;
	private Integer startFloorage;
	private Integer endFloorage;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startPubdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endPubdate;
	private String contact;
	private String title;

	@Override
	public String toString() {
		return "HouseExtExample{" +
				"price=" + price +
				", floorage=" + floorage +
				", pubdate=" + pubdate +
				", startPrice=" + startPrice +
				", endPrice=" + endPrice +
				", districtID=" + districtID +
				", type_id=" + type_id +
				", startFloorage=" + startFloorage +
				", endFloorage=" + endFloorage +
				", startPubdate=" + startPubdate +
				", endPubdate=" + endPubdate +
				", contact='" + contact + '\'' +
				", title='" + title + '\'' +
				'}';
	}

	public Long getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Long startPrice) {
		this.startPrice = startPrice;
	}

	public Long getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Long endPrice) {
		this.endPrice = endPrice;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public Integer getStartFloorage() {
		return startFloorage;
	}

	public void setStartFloorage(Integer startFloorage) {
		this.startFloorage = startFloorage;
	}

	public Integer getEndFloorage() {
		return endFloorage;
	}

	public void setEndFloorage(Integer endFloorage) {
		this.endFloorage = endFloorage;
	}

	public Date getStartPubdate() {
		return startPubdate;
	}

	public void setStartPubdate(Date startPubdate) {
		this.startPubdate = startPubdate;
	}

	public Date getEndPubdate() {
		return endPubdate;
	}

	public void setEndPubdate(Date endPubdate) {
		this.endPubdate = endPubdate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFloorage() {
		return floorage;
	}

	public void setFloorage(String floorage) {
		this.floorage = floorage;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
}

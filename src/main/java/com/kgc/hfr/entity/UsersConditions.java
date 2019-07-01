package com.kgc.hfr.entity;
//Users查询条件
public class UsersConditions {
	Integer page;
	Integer rows;
	String name;
	Integer startId;
	Integer endId;
	String telephone;

	public UsersConditions() {
	}

	public UsersConditions(String name, Integer startId, Integer endId, String telephone, Integer rows, Integer page) {
		this.name = name;
		this.startId = startId;
		this.endId = endId;
		this.telephone = telephone;
		this.rows = rows;
		this.page = page;
	}

	public String getName() {
		return name;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStartId() {
		return startId;
	}

	public void setStartId(Integer startId) {
		this.startId = startId;
	}

	public Integer getEndId() {
		return endId;
	}

	public void setEndId(Integer endId) {
		this.endId = endId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "UsersConditions{" +
				"page=" + page +
				", rows=" + rows +
				", name='" + name + '\'' +
				", startId=" + startId +
				", endId=" + endId +
				", telephone='" + telephone + '\'' +
				'}';
	}
}

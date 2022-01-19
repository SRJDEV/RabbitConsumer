package com.zensar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SourceTable")
public class SourceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sourceId")
	private int sourceId;

	@Column(name = "clientID")
	private String clientID;

	@Column(name = "subClientID")
	private String subClientID;

	@Column(name = "sellingChannelCode")
	private String sellingChannelCode;

	@Column(name = "seperatorSource0")
	private int separatorSource0;

	@Column(name = "separatorSource1")
	private int separatorSource1;

	public SourceEntity() {
	}

	public SourceEntity(int sourceId, String clientID, String subClientID, String sellingChannelCode,
			int separatorSource0, int separatorSource1) {
		super();
		this.sourceId = sourceId;
		this.clientID = clientID;
		this.subClientID = subClientID;
		this.sellingChannelCode = sellingChannelCode;
		this.separatorSource0 = separatorSource0;
		this.separatorSource1 = separatorSource1;
	}
	
	

	public SourceEntity(String clientID, String subClientID, String sellingChannelCode, int separatorSource0,
			int separatorSource1) {
		super();
		this.clientID = clientID;
		this.subClientID = subClientID;
		this.sellingChannelCode = sellingChannelCode;
		this.separatorSource0 = separatorSource0;
		this.separatorSource1 = separatorSource1;
	}

	public String getClientID() {
		return clientID;
	}

	

	public int getSourceId() {
		return sourceId;
	}

	

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getSubClientID() {
		return subClientID;
	}

	public void setSubClientID(String subClientID) {
		this.subClientID = subClientID;
	}

	public String getSellingChannelCode() {
		return sellingChannelCode;
	}

	public void setSellingChannelCode(String sellingChannelCode) {
		this.sellingChannelCode = sellingChannelCode;
	}

	public int getSeparatorSource0() {
		return separatorSource0;
	}

	public void setSeparatorSource0(int separatorSource0) {
		this.separatorSource0 = separatorSource0;
	}

	public int getSeparatorSource1() {
		return separatorSource1;
	}

	public void setSeparatorSource1(int separatorSource1) {
		this.separatorSource1 = separatorSource1;
	}

}

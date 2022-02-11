package com.zensar.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zensar.dto.Address;
import com.zensar.dto.Name;
import com.zensar.dto.OrderStatus;

@Entity
@Table(name = "Xml_MasterTable")
public class FulfilmentOrderEntity {

	@Id
	@Column(name = "orderID")
	private int orderID;

	@Column(name = "sourceId")
	private int sourceId;

	
	@Column(name = "custID")
	private BigInteger custID;

	@Column(name = "orderTypeCode")
	private String orderTypeCode;
	@Column(name = "partnerOrderID")
	private String partnerOrderID;

	@Column(name = "messageCreateTimeStamp")
	private String messageCreateTimeStamp;

	@Column(name = "fulfillmentChannelCode")
	private String fulfillmentChannelCode;

	@Column(name = "orderStatusCode")
	private int orderStatusCode;

	@Column(name = "orderStatusDescription")
	private String orderStatusDescription;

	@Column(name = "sellZLDivisionNbr")
	private int sellZLDivisionNbr;

	@Column(name = "sellZLLocationNbr")
	private int sellZLLocationNbr;


	@Enumerated(value = EnumType.STRING)
	@Column(name = "OrderStatus")
	private OrderStatus orderStatus = OrderStatus.CREATED;
	

	// source
	@Column(name = "clientID")
	private String clientID;


	// Order Totals
	@Column(name = "totalPurchaseAmount")
	private double totalPurchaseAmount;

	@Column(name = "seperatorOrderTotals0")
	private int separatorOrderTotals0;







	public FulfilmentOrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}








	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}


	public int getorderStatusCode() {
		return orderStatusCode;
	}

	public void setorderStatusCode(int orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	public String getorderStatusDescription() {
		return orderStatusDescription;
	}

	public void setorderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
	}



	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderTypeCode() {
		return orderTypeCode;
	}

	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}

	public String getPartnerOrderID() {
		return partnerOrderID;
	}

	public void setPartnerOrderID(String partnerOrderID) {
		this.partnerOrderID = partnerOrderID;
	}

	public String getMessageCreateTimeStamp() {
		return messageCreateTimeStamp;
	}

	public void setMessageCreateTimeStamp(String messageCreateTimeStamp) {
		this.messageCreateTimeStamp = messageCreateTimeStamp;
	}

	public String getFulfillmentChannelCode() {
		return fulfillmentChannelCode;
	}

	public void setFulfillmentChannelCode(String fulfillmentChannelCode) {
		this.fulfillmentChannelCode = fulfillmentChannelCode;
	}





	public int getSellZLDivisionNbr() {
		return sellZLDivisionNbr;
	}

	public void setSellZLDivisionNbr(int sellZLDivisionNbr) {
		this.sellZLDivisionNbr = sellZLDivisionNbr;
	}

	public int getSellZLLocationNbr() {
		return sellZLLocationNbr;
	}

	public void setSellZLLocationNbr(int sellZLLocationNbr) {
		this.sellZLLocationNbr = sellZLLocationNbr;
	}



	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}




	public double getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}

	public void setTotalPurchaseAmount(double totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}

	public int getSeparatorOrderTotals0() {
		return separatorOrderTotals0;
	}

	public void setSeparatorOrderTotals0(int separatorOrderTotals0) {
		this.separatorOrderTotals0 = separatorOrderTotals0;
	}

	public BigInteger getCustID() {
		return custID;
	}

	public void setCustID(BigInteger custID) {
		this.custID = custID;
	}








	public FulfilmentOrderEntity(int orderID, int sourceId, BigInteger custID, String orderTypeCode,
			String partnerOrderID, String messageCreateTimeStamp, String fulfillmentChannelCode, int orderStatusCode,
			String orderStatusDescription, int sellZLDivisionNbr, int sellZLLocationNbr, OrderStatus orderStatus,
			String clientID, double totalPurchaseAmount, int separatorOrderTotals0) {
		super();
		this.orderID = orderID;
		this.sourceId = sourceId;
		this.custID = custID;
		this.orderTypeCode = orderTypeCode;
		this.partnerOrderID = partnerOrderID;
		this.messageCreateTimeStamp = messageCreateTimeStamp;
		this.fulfillmentChannelCode = fulfillmentChannelCode;
		this.orderStatusCode = orderStatusCode;
		this.orderStatusDescription = orderStatusDescription;
		this.sellZLDivisionNbr = sellZLDivisionNbr;
		this.sellZLLocationNbr = sellZLLocationNbr;
		this.orderStatus = orderStatus;
		this.clientID = clientID;
		this.totalPurchaseAmount = totalPurchaseAmount;
		this.separatorOrderTotals0 = separatorOrderTotals0;
	}








	public FulfilmentOrderEntity(int sourceId, BigInteger custID, String orderTypeCode, String partnerOrderID,
			String messageCreateTimeStamp, String fulfillmentChannelCode, int orderStatusCode,
			String orderStatusDescription, int sellZLDivisionNbr, int sellZLLocationNbr, OrderStatus orderStatus,
			String clientID, double totalPurchaseAmount, int separatorOrderTotals0) {
		super();
		this.sourceId = sourceId;
		this.custID = custID;
		this.orderTypeCode = orderTypeCode;
		this.partnerOrderID = partnerOrderID;
		this.messageCreateTimeStamp = messageCreateTimeStamp;
		this.fulfillmentChannelCode = fulfillmentChannelCode;
		this.orderStatusCode = orderStatusCode;
		this.orderStatusDescription = orderStatusDescription;
		this.sellZLDivisionNbr = sellZLDivisionNbr;
		this.sellZLLocationNbr = sellZLLocationNbr;
		this.orderStatus = orderStatus;
		this.clientID = clientID;
		this.totalPurchaseAmount = totalPurchaseAmount;
		this.separatorOrderTotals0 = separatorOrderTotals0;
	}





















	

}

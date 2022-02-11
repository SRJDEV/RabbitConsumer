package com.zensar.dto;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import java.io.Serializable;

@JacksonXmlRootElement(namespace = "ns0:http://www.mst.macys.com/main/eos/fulfillmentOrder/orderDetails.v1.1")
public class FulfillmentOrder implements Serializable {

    @JacksonXmlProperty(isAttribute = true, localName = "orderID")
    private int orderID;

    private int sourceId;
    
   
  
   private double totalPurchaseAmount;
   
   private int separatorOrderTotals0;
    
    @JacksonXmlProperty(namespace = "ns0", localName = "orderTypeCode")
    private String orderTypeCode;

    @JacksonXmlProperty(namespace = "ns0",localName = "partnerOrderID")
    private String partnerOrderID;

    @JacksonXmlProperty(namespace = "ns0",localName = "orderStatus")
    private OrderStatus orderStatus ;//= OrderStatus.CREATED;

    @JacksonXmlProperty(namespace = "ns0",localName = "messageCreateTimeStamp")
    private String messageCreateTimeStamp;

    @JacksonXmlProperty(namespace = "ns0",localName = "fulfillmentChannelCode")
    private String fulfillmentChannelCode;

    @JacksonXmlProperty(namespace = "ns0",localName = "orderStatusCode")
    private int orderStatusCode;

    @JacksonXmlProperty(namespace = "ns0",localName = "orderStatusDescription")
    private String orderStatusDescription;

    @JacksonXmlProperty(namespace = "ns0",localName = "sellZLDivisionNbr")
    private int sellZLDivisionNbr;

    @JacksonXmlProperty(namespace = "ns0",localName = "sellZLLocationNbr")
    private int sellZLLocationNbr;

    @JacksonXmlProperty(namespace = "ns0",localName = "source")
    private Source source;

    @JacksonXmlProperty(namespace = "ns0",localName = "orderTotals")
    private OrderTotals orderTotals;

    @JacksonXmlProperty(namespace = "ns0",localName = "billingAddress")
    private BillingAddress billingAddress;

    public FulfillmentOrder() {
    }







	public FulfillmentOrder(int orderID, int sourceId, double totalPurchaseAmount,
			int separatorOrderTotals0, String orderTypeCode, String partnerOrderID, OrderStatus orderStatus,
			String messageCreateTimeStamp, String fulfillmentChannelCode, int orderStatusCode,
			String orderStatusDescription, int sellZLDivisionNbr, int sellZLLocationNbr, Source source,
			OrderTotals orderTotals, BillingAddress billingAddress) {
		super();
		this.orderID = orderID;
		this.sourceId = sourceId;
		this.totalPurchaseAmount = totalPurchaseAmount;
		this.separatorOrderTotals0 = separatorOrderTotals0;
		this.orderTypeCode = orderTypeCode;
		this.partnerOrderID = partnerOrderID;
		this.orderStatus = orderStatus;
		this.messageCreateTimeStamp = messageCreateTimeStamp;
		this.fulfillmentChannelCode = fulfillmentChannelCode;
		this.orderStatusCode = orderStatusCode;
		this.orderStatusDescription = orderStatusDescription;
		this.sellZLDivisionNbr = sellZLDivisionNbr;
		this.sellZLLocationNbr = sellZLLocationNbr;
		this.source = source;
		this.orderTotals = orderTotals;
		this.billingAddress = billingAddress;
	}



	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
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


    public void setOrderTypeCode(String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    public String getPartnerOrderID() {
        return partnerOrderID;
    }

    public void setPartnerOrderID(String partnerOrderID) {
        this.partnerOrderID = partnerOrderID;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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

    public int getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(int orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    public void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public OrderTotals getOrderTotals() {
        return orderTotals;
    }

    public void setOrderTotals(OrderTotals orderTotals) {
        this.orderTotals = orderTotals;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }



	@Override
	public String toString() {
		return "FulfillmentOrder [orderID=" + orderID + ", sourceId=" + sourceId + ","
				+ ", orderTypeCode=" + orderTypeCode + ", partnerOrderID=" + partnerOrderID + ", orderStatus="
				+ orderStatus + ", messageCreateTimeStamp=" + messageCreateTimeStamp + ", fulfillmentChannelCode="
				+ fulfillmentChannelCode + ", orderStatusCode=" + orderStatusCode + ", orderStatusDescription="
				+ orderStatusDescription + ", sellZLDivisionNbr=" + sellZLDivisionNbr + ", sellZLLocationNbr="
				+ sellZLLocationNbr + ", source=" + source + ", orderTotals=" + orderTotals + ", billingAddress="
				+ billingAddress + "]";
	}

 
}
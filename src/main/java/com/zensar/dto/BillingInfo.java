package com.zensar.dto;

import java.math.BigInteger;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BillingInfo {


	
		//Name class
		private String firstName;
		private String lastName;
		private int seperatorName0;
		private int seperatorName1;
		

		@JacksonXmlProperty(localName = "custID")
	    private BigInteger custID;

	

	

	    @JacksonXmlProperty(localName = "daytimePhoneNbr")
	    private String daytimePhoneNbr;

	    @JacksonXmlProperty(localName = "homePhoneNbr")
	    private String homePhoneNbr;

	    @JacksonXmlProperty(localName = "alternatePhoneNbr")
	    private String alternatePhoneNbr;

	    @JacksonXmlProperty(localName = "sendSMSMessage")
	    private boolean sendSMSMessage;

	    public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

	

		@JacksonXmlProperty(localName = "emailAddress")
	    private String emailAddress;

	    @JacksonXmlProperty(localName = "seperatorContact0")
	    private int separatorContact0;


	

	    public BigInteger getCustID() {
	        return custID;
	    }

	    public void setCustID(BigInteger custID) {
	        this.custID = custID;
	    }



	    public String getDaytimePhoneNbr() {
	        return daytimePhoneNbr;
	    }

	    public void setDaytimePhoneNbr(String daytimePhoneNbr) {
	        this.daytimePhoneNbr = daytimePhoneNbr;
	    }

	    public String getHomePhoneNbr() {
	        return homePhoneNbr;
	    }

	    public void setHomePhoneNbr(String homePhoneNbr) {
	        this.homePhoneNbr = homePhoneNbr;
	    }

	    public String getAlternatePhoneNbr() {
	        return alternatePhoneNbr;
	    }

	    public void setAlternatePhoneNbr(String alternatePhoneNbr) {
	        this.alternatePhoneNbr = alternatePhoneNbr;
	    }

	    public boolean isSendSMSMessage() {
	        return sendSMSMessage;
	    }

	    public void setSendSMSMessage(boolean sendSMSMessage) {
	        this.sendSMSMessage = sendSMSMessage;
	    }

	    public String getEmailAddress() {
	        return emailAddress;
	    }

	    public void setEmailAddress(String emailAddress) {
	        this.emailAddress = emailAddress;
	    }

	    public int getSeparatorContact0() {
	        return separatorContact0;
	    }

	    public void setSeparatorContact0(int separatorContact0) {
	        this.separatorContact0 = separatorContact0;
	    }
	    
	    
	    

		@Override
		public String toString() {
			return "BillingInfo [ firstName=" + firstName + ", lastName=" + lastName
					+ ", seperatorName0=" + seperatorName0 + ", seperatorName1=" + seperatorName1 + ", custID=" + custID
					+ ", daytimePhoneNbr=" + daytimePhoneNbr + ", homePhoneNbr=" + homePhoneNbr
					+ ", alternatePhoneNbr=" + alternatePhoneNbr + ", sendSMSMessage=" + sendSMSMessage
					+ ", emailAddress=" + emailAddress + ", separatorContact0=" + separatorContact0 + "]";
		}



		public int getSeperatorName0() {
			return seperatorName0;
		}

		public void setSeperatorName0(int seperatorName0) {
			this.seperatorName0 = seperatorName0;
		}

		public int getSeperatorName1() {
			return seperatorName1;
		}

		public void setSeperatorName1(int seperatorName1) {
			this.seperatorName1 = seperatorName1;
		}

		public BillingInfo(String firstName, String lastName, int seperatorName0, int seperatorName1, BigInteger custID,
				 String daytimePhoneNbr, String homePhoneNbr, String alternatePhoneNbr,
				boolean sendSMSMessage, String emailAddress, int separatorContact0) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.seperatorName0 = seperatorName0;
			this.seperatorName1 = seperatorName1;
			this.custID = custID;
			this.daytimePhoneNbr = daytimePhoneNbr;
			this.homePhoneNbr = homePhoneNbr;
			this.alternatePhoneNbr = alternatePhoneNbr;
			this.sendSMSMessage = sendSMSMessage;
			this.emailAddress = emailAddress;
			this.separatorContact0 = separatorContact0;
		}

		public BillingInfo() {
			super();
			// TODO Auto-generated constructor stub
		}

	
	
	
	
}

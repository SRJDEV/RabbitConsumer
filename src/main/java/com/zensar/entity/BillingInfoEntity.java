package com.zensar.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zensar.dto.Address;

@Entity
@Table(name = "BillingInfo")
public class BillingInfoEntity {

	

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

	public String getSeperatorName0() {
		return seperatorName0;
	}

	public void setSeperatorName0(String seperatorName0) {
		this.seperatorName0 = seperatorName0;
	}

	public String getSeperatorName1() {
		return seperatorName1;
	}

	public void setSeperatorName1(String seperatorName1) {
		this.seperatorName1 = seperatorName1;
	}

	@Id
	@Column(name = "custID")
    private BigInteger custID;

	//Name class
	@Column(name ="firstName")
	private String firstName;
	@Column(name ="lastName")
	private String lastName;
	@Column(name ="seperatorName0")
	private String seperatorName0;
	@Column(name ="seperatorName1")
	private String seperatorName1;
	

    @Column(name = "address")
    private Address address;

    @Column(name = "daytimePhoneNbr")
    private String daytimePhoneNbr;

    @Column(name = "homePhoneNbr")
    private String homePhoneNbr;

    @Column(name = "alternatePhoneNbr")
    private String alternatePhoneNbr;

    @Column(name = "sendSMSMessage")
    private boolean sendSMSMessage;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "seperatorContact0")
    private int separatorContact0;




    public BigInteger getCustID() {
        return custID;
    }

    public void setCustID(BigInteger custID) {
        this.custID = custID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
				+ ", address=" + address + ", daytimePhoneNbr=" + daytimePhoneNbr + ", homePhoneNbr=" + homePhoneNbr
				+ ", alternatePhoneNbr=" + alternatePhoneNbr + ", sendSMSMessage=" + sendSMSMessage
				+ ", emailAddress=" + emailAddress + ", separatorContact0=" + separatorContact0 + "]";
	}

	public BillingInfoEntity(String firstName, String lastName, String seperatorName0, String seperatorName1,
			BigInteger custID, Address address, String daytimePhoneNbr, String homePhoneNbr, String alternatePhoneNbr,
			boolean sendSMSMessage, String emailAddress, int separatorContact0) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.seperatorName0 = seperatorName0;
		this.seperatorName1 = seperatorName1;
		this.custID = custID;
		this.address = address;
		this.daytimePhoneNbr = daytimePhoneNbr;
		this.homePhoneNbr = homePhoneNbr;
		this.alternatePhoneNbr = alternatePhoneNbr;
		this.sendSMSMessage = sendSMSMessage;
		this.emailAddress = emailAddress;
		this.separatorContact0 = separatorContact0;
	}

	public BillingInfoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


}

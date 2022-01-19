package com.zensar.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class AddressEntity {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id;
	
	@Column(name = "custId")
	private BigInteger custId;

	@Column(name = "line1")
	private String line1;

	@Column(name = "line2")
	private String line2;

	@Column(name = "line3")
	private String line3;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zipCode")
	private int zipCode;

	@Column(name = "countryCode")
	private String countryCode;

	@Column(name = "seperatorAddress0")
	private int separatorAddress0;

	public AddressEntity() {

	}
	
	
	
	

	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public AddressEntity(int id, BigInteger custId, String line1, String line2, String line3, String city, String state,
			int zipCode, String countryCode, int separatorAddress0) {
		super();
		this.id = id;
		this.custId = custId;
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.countryCode = countryCode;
		this.separatorAddress0 = separatorAddress0;
	}





	public AddressEntity(BigInteger custId, String line1, String line2, String line3, String city, String state,
			int zipCode, String countryCode, int separatorAddress0) {
		super();
		this.custId = custId;
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.countryCode = countryCode;
		this.separatorAddress0 = separatorAddress0;
	}

	public BigInteger getCustId() {
		return custId;
	}

	public void setCustId(BigInteger custId) {
		this.custId = custId;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getSeparatorAddress0() {
		return separatorAddress0;
	}

	public void setSeparatorAddress0(int separatorAddress0) {
		this.separatorAddress0 = separatorAddress0;
	}

	@Override
	public String toString() {
		return "Address [custId=" + custId + ", line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", countryCode=" + countryCode
				+ ", separatorAddress0=" + separatorAddress0 + "]";
	}

}

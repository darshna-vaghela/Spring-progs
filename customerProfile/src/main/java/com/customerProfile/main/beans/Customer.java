package com.customerProfile.main.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tbl_customers")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "dob", nullable = false)
	private Date dob;

	@Column(name = "house_no", nullable = false)
	private String houseNo;

	@Column(name = "street_name", nullable = false)
	private String streetName;

	@Column(name = "area", nullable = false)
	private String area;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "pincode", nullable = false)
	private int pincode;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	public Customer() {
		super();
	}

	public Customer(long customerId, String firstName, String lastName, String gender, Date dob, String houseNo,
			String streetName, String area, String city, int pincode, Date createdAt, Date updatedAt) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Customer [Customer Id=" + getCustomerId() + ", Cutomer First Name=" + getFirstName()
				+ ", Customer Last Name=" + getLastName() + ", Gender=" + getGender() + ", Date Of Birth=" + getDob()
				+ ",  House No=" + getHouseNo() + ", Street Name=" + getStreetName() + ", Area=" + getArea() + ", City="
				+ getCity() + ", Pincode=" + getPincode() + ", Created At=" + getCreatedAt() + ", Updated At="
				+ getUpdatedAt() + "]";
	}

}

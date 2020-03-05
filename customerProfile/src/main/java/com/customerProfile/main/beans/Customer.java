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

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "Phone_no1", nullable = false)
	private long phoneNo1;

	@Column(name = "Phone_no2", nullable = false)
	private long phoneNo2;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "date_of_birth", nullable = false)
	private Date dateOfBirth;

	@Column(name = "door_no", nullable = false)
	private String doorNo;

	@Column(name = "house_no", nullable = false)
	private String houseNo;

	@Column(name = "street_address", nullable = false)
	private String streetAddress;

	@Column(name = "landmark", nullable = false)
	private String landmark;

	@Column(name = "area", nullable = false)
	private String area;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "state", nullable = false)
	private String state;

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

	public Customer(long customerId, String email, long phoneNo1, long phoneNo2, String firstName, String lastName,
			String gender, Date dateOfBirth, String doorNo, String houseNo, String streetAddress, String landmark,
			String area, String city, String state, int pincode, Date createdAt, Date updatedAt) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.phoneNo1 = phoneNo1;
		this.phoneNo2 = phoneNo2;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.doorNo = doorNo;
		this.houseNo = houseNo;
		this.streetAddress = streetAddress;
		this.landmark = landmark;
		this.area = area;
		this.city = city;
		this.state = state;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(long phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public long getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(long phoneNo2) {
		this.phoneNo2 = phoneNo2;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth=dateOfBirth;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
		return "Customer [Customer Id=" + customerId + ", Email=" + email + ", Phone No=" + phoneNo1
				+ ", PhoneNo (optional)=" + phoneNo2 + ", First Name=" + firstName + ", Last Name=" + lastName
				+ ", Gender=" + gender + ", Date of Birth=" + dateOfBirth + ", Door No=" + doorNo + ", House No="
				+ houseNo + ", Street Address=" + streetAddress + ", Landmark=" + landmark + ", Area=" + area
				+ ", City=" + city + ", State=" + state + ", Pincode=" + pincode + ", Created At=" + createdAt
				+ ", Updated At=" + updatedAt + "]";
	}

	public Customer orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}

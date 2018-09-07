package com.ideas2it.employeeinformation.address.model;

import java.util.Date;
import java.util.List;

/**
 * Address class is the Entity class is having the getters and setter methods
 * which is used to get the values from the user. This class acts as an Model
 * for the Address Details.
 *
 * @author  Arul Murugan
 * @version 1.0
 */
public class Address {

    public Address() {
    }

    private Integer id;
    private Integer doorNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private Long pincode;
    private String addressType;
    private Integer clientId;
    private Integer employeeId;

    public Address (Address address) {

        this.doorNumber = address.doorNumber; 
        this.streetName = address.streetName;
        this.city = address.city;
        this.state = address.state;
        this.country = address.country;
        this.pincode = address.pincode;
    }

    // Getters and Setters for Address Model.
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoorNumber() {
        return this.doorNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPincode() {
        return this.pincode = pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getAddressType() {
        return this.addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Integer getClientId() {
        return this.clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}

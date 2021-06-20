package com.challenge.longlife.resource;

import com.challenge.longlife.domain.model.AuditModel;


public class UserResource extends AuditModel {

    private Long id;
    private String firstname;
    private String lastname;
    private Long postalCode;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public UserResource setId(Long id) {
        this.id = id;
        return this;
    }


    public String getFirstname() {
        return firstname;
    }

    public UserResource setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public UserResource setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public UserResource setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserResource setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserResource setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}

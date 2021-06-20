package com.challenge.longlife.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveUserResource {

    @NotNull
    @Lob
    private String firstname;

    @NotNull
    @Lob
    private String lastname;

    @NotNull
    private Long postalCode;

    @NotNull
    private String dateOfBirth;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String address;

    @NotNull
    private String phoneNumber;

    public String getFirstname() {
        return firstname;
    }

    public SaveUserResource setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveUserResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public SaveUserResource setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public SaveUserResource setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SaveUserResource setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SaveUserResource setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}

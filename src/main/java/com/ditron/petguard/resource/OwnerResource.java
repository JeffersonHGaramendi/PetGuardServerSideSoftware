package com.ditron.petguard.resource;

import com.ditron.petguard.domain.model.AuditModel;


public class OwnerResource extends AuditModel {

    private Long id;

    private String name;

    private String lastname;

    private String age;

    private String phoneNumber;

    private String email;

    private String creditCard;

    public Long getId() {
        return id;
    }

    public OwnerResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OwnerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public OwnerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAge() {
        return age;
    }

    public OwnerResource setAge(String age) {
        this.age = age;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OwnerResource setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OwnerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public OwnerResource setCreditCard(String creditCard) {
        this.creditCard = creditCard;
        return this;
    }
}

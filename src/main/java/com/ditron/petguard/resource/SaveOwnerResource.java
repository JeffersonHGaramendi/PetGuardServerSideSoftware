package com.ditron.petguard.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SaveOwnerResource {

    @NotNull
    @Lob
    private String name;

    @NotNull
    @Lob
    private String lastname;

    @NotNull
    private String age;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private String creditCard;

    public String getName() {
        return name;
    }

    public SaveOwnerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveOwnerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAge() {
        return age;
    }

    public SaveOwnerResource setAge(String age) {
        this.age = age;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SaveOwnerResource setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveOwnerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public SaveOwnerResource setCreditCard(String creditCard) {
        this.creditCard = creditCard;
        return this;
    }
}

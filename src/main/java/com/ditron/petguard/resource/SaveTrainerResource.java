package com.ditron.petguard.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SaveTrainerResource {
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

    public SaveTrainerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveTrainerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAge() {
        return age;
    }

    public SaveTrainerResource setAge(String age) {
        this.age = age;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SaveTrainerResource setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveTrainerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public SaveTrainerResource setCreditCard(String creditCard) {
        this.creditCard = creditCard;
        return this;
    }
}

package com.ditron.petguard.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "owners")
public class Owner extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private String age;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private String creditCard;

    public Owner() {    }

    public Owner(Long id, String name, String lastname, String age, String phoneNumber, String email, String creditCard) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creditCard = creditCard;
    }


    public Long getId() {
        return id;
    }

    public Owner setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Owner setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Owner setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Owner setAge(String age) {
        this.age = age;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Owner setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Owner setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public Owner setCreditCard(String creditCard) {
        this.creditCard = creditCard;
        return this;
    }
}

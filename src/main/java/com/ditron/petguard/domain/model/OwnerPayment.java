package com.ditron.petguard.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "owner_payment")
public class OwnerPayment extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cardNumber;

    @NotNull
    private String ownerName;

    @NotNull
    private String dueDate;

    @NotNull
    private String cv;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "owner_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Owner owner;

    public Long getId() {
        return id;
    }

    public OwnerPayment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public OwnerPayment setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public OwnerPayment setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public OwnerPayment setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getCv() {
        return cv;
    }

    public OwnerPayment setCv(String cv) {
        this.cv = cv;
        return this;
    }
}

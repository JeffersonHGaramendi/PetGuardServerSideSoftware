package com.ditron.petguard.resource;


import com.ditron.petguard.domain.model.AuditModel;

public class OwnerPaymentResource extends AuditModel {
    private Long id;

    private String cardNumber;

    private String ownerName;

    private String dueDate;

    private String cv;

    public Long getId() {
        return id;
    }

    public OwnerPaymentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public OwnerPaymentResource setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public OwnerPaymentResource setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public OwnerPaymentResource setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getCv() {
        return cv;
    }

    public OwnerPaymentResource setCv(String cv) {
        this.cv = cv;
        return this;
    }
}

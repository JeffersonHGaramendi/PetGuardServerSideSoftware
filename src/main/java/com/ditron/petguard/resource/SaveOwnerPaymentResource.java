package com.ditron.petguard.resource;

import javax.validation.constraints.NotNull;

public class SaveOwnerPaymentResource {

    @NotNull
    private String cardNumber;

    @NotNull
    private String ownerName;

    @NotNull
    private String dueDate;

    @NotNull
    private String cv;

    public String getCardNumber() {
        return cardNumber;
    }

    public SaveOwnerPaymentResource setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public SaveOwnerPaymentResource setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public SaveOwnerPaymentResource setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getCv() {
        return cv;
    }

    public SaveOwnerPaymentResource setCv(String cv) {
        this.cv = cv;
        return this;
    }
}

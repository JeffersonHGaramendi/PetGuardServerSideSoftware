package com.ditron.petguard.resource;

import com.ditron.petguard.domain.model.AuditModel;



public class OrderResource extends AuditModel {

    private Long id;

    private  String startedAt;

    private String finishedAt;

    private String address;

    public Long getId() {
        return id;
    }

    public OrderResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public OrderResource setStartedAt(String startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public OrderResource setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderResource setAddress(String address) {
        this.address = address;
        return this;
    }
}

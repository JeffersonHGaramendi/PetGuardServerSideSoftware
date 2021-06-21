package com.ditron.petguard.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="orders")
public class Order extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private  String startedAt;

    @NotNull
    private String finishedAt;

    @NotNull
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public Order setStartedAt(String startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public Order setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public Owner getOwner() {
        return owner;
    }

    public Order setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }
}

package com.ditron.petguard.resource;

import javax.validation.constraints.NotNull;

public class SaveOrderResource {
    @NotNull
    private  String startedAt;

    @NotNull
    private String finishedAt;

    @NotNull
    private String address;

    public String getStartedAt() {
        return startedAt;
    }

    public SaveOrderResource setStartedAt(String startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public SaveOrderResource setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SaveOrderResource setAddress(String address) {
        this.address = address;
        return this;
    }
}

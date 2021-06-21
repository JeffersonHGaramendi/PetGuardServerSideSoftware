package com.ditron.petguard.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SaveCommentResource {
    @NotNull
    @Lob
    private String description;

    public String getDescription() {
        return description;
    }

    public SaveCommentResource setDescription(String description) {
        this.description = description;
        return this;
    }
}

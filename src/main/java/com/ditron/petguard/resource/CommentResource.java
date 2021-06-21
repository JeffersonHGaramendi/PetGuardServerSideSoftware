package com.ditron.petguard.resource;

import com.ditron.petguard.domain.model.AuditModel;

public class CommentResource extends AuditModel {
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public CommentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CommentResource setDescription(String description) {
        this.description = description;
        return this;
    }
}

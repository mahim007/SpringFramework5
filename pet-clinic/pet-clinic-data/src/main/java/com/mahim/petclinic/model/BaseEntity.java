package com.mahim.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private Long id;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

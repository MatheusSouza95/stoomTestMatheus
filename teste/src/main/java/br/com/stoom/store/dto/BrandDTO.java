package br.com.stoom.store.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

public class BrandDTO {

    private Long id;
    @NotBlank(message = "Field name is required")
    private String name;
    private String description;
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
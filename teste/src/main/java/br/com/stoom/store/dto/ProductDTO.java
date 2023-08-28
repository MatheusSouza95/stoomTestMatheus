package br.com.stoom.store.dto;

import br.com.stoom.store.model.Brand;
import br.com.stoom.store.model.Category;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;


public class ProductDTO {
    private Long id;
    private String sku;
    @NotBlank(message = "Field name is required")
    private String name;
    private String description;
    @NotBlank(message = "Field stock is required")
    private String stock;
    private boolean active;
    private Category category;
    private Brand brand;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }


}
package com.igc.productapp.entity;

import com.igc.productapp.model.ProductModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "productinfo")
public class ProductEntity {
    @Id
    private int id;

    private String name;
    private String description;
    private String price;
    private String qty;
    private String status;
    public ProductEntity() {

    }
    public ProductEntity(ProductModel productModel) {
        this.id = productModel.getId();
        this.name = productModel.getName();
        this.description = productModel.getDescription();
        this.price = productModel.getPrice();
        this.qty = productModel.getQty();
        this.status = productModel.getStatus();
    }


}

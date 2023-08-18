package com.igc.productapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductModel {
    private int id;
    @NotBlank(message = "Please Enter the Name")
    private String name;
    @NotBlank(message = "Please Enter the Description")
    private String description;
    @Email(message = "Enter the Valid EMail")
    private String price;
    private String qty;
    private String status;

}

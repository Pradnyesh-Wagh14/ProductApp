package com.igc.productapp.service;

import com.igc.productapp.entity.ProductEntity;
import com.igc.productapp.model.ProductModel;

import java.util.List;

public interface IProductService {

    public List<ProductModel> getAllProduct();

    public ProductModel addAllProduct(ProductModel productmodel);

    public ProductModel getProductById(Integer id);

}

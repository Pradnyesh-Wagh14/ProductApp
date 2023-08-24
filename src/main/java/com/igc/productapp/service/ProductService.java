package com.igc.productapp.service;

import com.igc.productapp.entity.ProductEntity;
import com.igc.productapp.exception.ProductNotFoundException;
import com.igc.productapp.model.ProductModel;
import com.igc.productapp.repository.productRepo;
import com.igc.productapp.util.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    productRepo productRepo;

    @Autowired
    ModelMapper modelMapper;

    List<ProductEntity>productentities = new ArrayList<>();

    @Override
    public  List<ProductModel> getAllProduct()
    {
        List<ProductModel> productModelList = new ArrayList(productRepo.findAll());
        return  productModelList;
    }

    @Override
    public ProductModel addAllProduct( ProductModel productmodel)
    {
        ProductEntity productEntity = new ProductEntity(productmodel);

        ProductEntity productEntity1 = productRepo.save(productEntity);

        ProductModel productModel = modelMapper.map(productEntity1 , ProductModel.class);

        return productModel;

        //return modelMapper.map(productRepo.save(new ProductEntity(productmodel)),ProductModel.class);
    }

    @Override
    public ProductModel getProductById(Integer id) {
        Optional<ProductEntity> productEntity = productRepo.findById(id);
        if(productEntity.isPresent())
        {
            return modelMapper.map(productEntity,ProductModel.class);
        }
        else
        {
            throw new ProductNotFoundException(Constants.PRODUCT_ID_NOT_FOUND);
        }
    }

}

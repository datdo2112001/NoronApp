package com.example.noronapp.service;


import com.example.noronapp.data.request.ProductRequest;
import com.example.noronapp.data.response.ProductResponse;
import com.example.noronapp.data.mappers.ProductMapper;
import com.example.noronapp.repository.ProductRepository;
import noronapp.jooq.data.tables.pojos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductResponse> getAllProducts()
    {
        return productMapper.productsToProductResponses(productRepository.findAll());
    }
//
    public ProductResponse getProductById(int id) {
        Product product =  productRepository.findById(id);
        return productMapper.productToProductResponse(product);
    }

    public void saveProduct(ProductRequest productRequest) {
        Product product = ProductMapper.INSTANCE.productRequestToProduct(productRequest);
        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
//
    public ResponseEntity<ProductRequest> updateProduct(ProductRequest productRequest, int id) {
        Product temp = productRepository.findById(id);
        if (temp == null) {
            return ResponseEntity.noContent().build();
        }
        Product product = productMapper.productRequestToProduct(productRequest);
        productRepository.update(id, product);
        return ResponseEntity.ok(productRequest);
    }

}

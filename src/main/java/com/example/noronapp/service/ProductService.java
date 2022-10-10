package com.example.noronapp.service;


import com.example.noronapp.data.dto.ActionLogDTO;
import com.example.noronapp.data.mappers.ProductMapper;
import com.example.noronapp.data.request.ProductRequest;
import com.example.noronapp.data.response.ProductResponse;
import com.example.noronapp.repository.ProductRepository;
import com.example.noronapp.repository.VendorRepository;
import noronapp.jooq.data.tables.pojos.Product;
import noronapp.jooq.data.tables.pojos.Vendor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.example.noronapp.utils.CollectionUtils.extractFieldToSet;
import static com.example.noronapp.utils.TimeUtils.getCurrentTimeLong;

@Service
public class ProductService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ProductRepository productRepository;

    private final VendorRepository vendorRepository;

    private final ProductMapper productMapper;

    public ProductService(KafkaTemplate<String, String> kafkaTemplate,
                          ProductRepository productRepository,
                          VendorRepository vendorRepository,
                          ProductMapper productMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.productRepository = productRepository;
        this.vendorRepository = vendorRepository;
        this.productMapper = productMapper;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        Set<Integer> vendorIds = extractFieldToSet(products, Product::getVendorId);
        Map<Integer, Vendor> vendorMap = vendorRepository.getVendors(vendorIds);
        return productMapper.toResponses(products, vendorMap);
    }

    public ProductResponse getProductById(int id) {
        Product product = productRepository.findById(id);
        Vendor vendor = vendorRepository.findById(product.getVendorId());
        return productMapper.toResponse(product, vendor);
    }

    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product product = productRepository.insert(productMapper.toPojo(productRequest));
        Vendor vendor = vendorRepository.findById(product.getVendorId());
        return productMapper.toResponse(product, vendor);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    //
    public ResponseEntity<ProductRequest> updateProduct(ProductRequest productRequest, int id) {
        Product temp = productRepository.findById(id);
        if (temp == null) return ResponseEntity.noContent().build();

        Product product = productMapper.toPojo(productRequest);
        productRepository.update(id, product);
        return ResponseEntity.ok(productRequest);
    }

    public void upView(int id) {
        ActionLogDTO productDto = new ActionLogDTO()
                .setObjectType("product")
                .setObjectId(id + "")
                .setCreatedAt(getCurrentTimeLong());
        String message = "upview" + id;

        // json -> productDto -> string, jackson:
        kafkaTemplate.send("first_topic", message);
    }

}

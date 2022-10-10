package com.example.noronapp.data.mappers;

import com.example.noronapp.data.request.ProductRequest;
import com.example.noronapp.data.response.ProductResponse;
import noronapp.jooq.data.tables.pojos.Product;
import noronapp.jooq.data.tables.pojos.Vendor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    @Autowired
    protected VendorMapper vendorMapper;

    @Mapping(source = "product.title", target = "product_title")
    @Mapping(source = "product.type", target = "product_type")
    @Mapping(source = "product.description", target = "product_description")
    public abstract ProductResponse toResponse(Product product);

    @Mapping(source = "product.title", target = "product_title")
    @Mapping(source = "product.type", target = "product_type")
    @Mapping(source = "product.description", target = "product_description")
    public abstract ProductResponse toResponse(Product product, @Context Vendor vendor);

    @Mapping(source = "product_title", target = "title")
    @Mapping(source = "product_type", target = "type")
    @Mapping(source = "product_description", target = "description")
    public abstract Product toPojo(ProductRequest productRequest);

    public List<ProductResponse> toResponses(List<Product> products, @Context Map<Integer, Vendor> vendorMap) {
        return products.stream()
                .map(product -> {
                    ProductResponse productResponse = toResponse(product);
                    Vendor vendor = vendorMap.getOrDefault(product.getVendorId(), null);
                    productResponse.setVendor(vendorMapper.vendorToResponse(vendor));
                    return productResponse;
                })
                .collect(Collectors.toList());
    }

    @AfterMapping
    protected void afterToResponse(@MappingTarget ProductResponse response, Product product, @Context Vendor vendor) {
        //
        response.setVendor(vendorMapper.vendorToResponse(vendor));
    }

}

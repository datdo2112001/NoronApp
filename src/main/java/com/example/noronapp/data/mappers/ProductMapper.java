package com.example.noronapp.data.mappers;

import com.example.noronapp.data.request.ProductRequest;
import com.example.noronapp.data.response.ProductResponse;
import noronapp.jooq.data.tables.pojos.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    @Mapping(source = "product.title", target = "product_title")
    @Mapping(source = "product.type", target = "product_type")
    @Mapping(source = "product.description", target = "product_description")
    ProductResponse productToProductResponse(Product product);

    @Mapping(source = "product_title", target = "title")
    @Mapping(source = "product_type", target = "type")
    @Mapping(source = "product_description", target = "description")
    Product productRequestToProduct(ProductRequest productRequest);

    List<ProductResponse> productsToProductResponses(List<Product> products);

}

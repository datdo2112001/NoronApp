package com.example.noronapp.repository;

import com.example.noronapp.repository.abstract_repo.AbstractCRUDRepository;
import noronapp.jooq.data.tables.pojos.Product;
import noronapp.jooq.data.tables.records.ProductRecord;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import static noronapp.jooq.data.Tables.PRODUCT;

@Component
public class ProductRepository extends AbstractCRUDRepository<ProductRecord, Integer, Product> {
    @Override
    protected Table<ProductRecord> table() {
        return PRODUCT;
    }

}

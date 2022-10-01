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

    @Override
    protected ProductRecord getRecord() {
        return new ProductRecord();
    }


//    @Override
//    public void update(Integer id, Product pojo) {
//        dslContext.update(table())
//                .set(toUpdateQuery(pojo))
//                .where(idField.eq(id))
//                .execute();
//    }
//
//    protected Map<?, ?> toUpdateQuery(Product pojo) {
//        ProductRecord productRecord = new ProductRecord();
//        productRecord.from(pojo);
//        HashMap map = new HashMap<>();
//        for (Field<?> field : productRecord.fields()) {
//            if (productRecord.getValue(field) != null) {
//                map.put(field, productRecord.getValue(field));
//            }
//        }
//        return map;
//    }

}

package com.example.noronapp.repository.abstract_repo;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.UpdatableRecord;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCRUDRepository<R extends UpdatableRecord<R>, ID, P> {

    @Autowired
    protected DSLContext dslContext;

    protected abstract Table<R> table();
    protected abstract R getRecord();

    protected Field<ID> idField;
//    protected R record;

    protected Class<P> pojoClass;

    @PostConstruct
    public void init() {
        this.pojoClass = (Class<P>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[2];
//        (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]).
//        this.r = (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
        this.idField = (Field<ID>) Arrays.stream(table().fields())
                .filter(field -> field.getName().equals("id"))
                .findFirst()
                .orElse(null);
    }

    public P findById(ID id) {
        return dslContext.selectFrom(table())
                .where(idField.eq(id))
                .fetchOneInto(pojoClass);
    }

    public void save(P p) {
        dslContext.insertInto(table())
                .set(dslContext.newRecord(table(), p))
                .execute();
    }

    public List<P> findAll() {
        return dslContext.selectFrom(table())
                .fetchInto(pojoClass);
    }

    public void deleteById(ID id) {
        dslContext.delete(table()).where(idField.eq(id)).execute();
    }

    public void update(ID id, P pojo) {
        dslContext.update(table())
                .set(toUpdateQuery(pojo))
                .where(idField.eq(id))
                .execute();
    }

    protected Map<?, ?> toUpdateQuery(P pojo) {
        R record = getRecord();
        record.from(pojo);
        HashMap map = new HashMap<>();
        for (Field<?> field : record.fields()) {
            if (record.getValue(field) != null) {
                map.put(field, record.getValue(field));
            }
        }
        return map;
    }

}
package com.example.noronapp.repository;

import com.example.noronapp.repository.abstract_repo.AbstractCRUDRepository;
import noronapp.jooq.data.tables.pojos.Users;
import noronapp.jooq.data.tables.records.UsersRecord;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import static noronapp.jooq.data.Tables.USERS;


@Component
public class UserRepository extends AbstractCRUDRepository<UsersRecord, Integer, Users> {

    @Override
    protected Table<UsersRecord> table() {
        return USERS;
    }

    @Override
    protected UsersRecord getRecord() {
        return null;
    }

}

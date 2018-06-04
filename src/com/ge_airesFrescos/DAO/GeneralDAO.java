package com.ge_airesFrescos.DAO;

import com.ge_airesFrescos.Exceptions.MySQLException;

import java.util.List;

public interface GeneralDAO<T> {

    void insert(T p) throws MySQLException;

    void update(T p) throws MySQLException;

    void delete(T p) throws MySQLException;

    List<T> getAll() throws MySQLException;

    T  getOne(int id) throws MySQLException;
}

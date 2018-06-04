package com.ge_airesFrescos.DAO;

import java.util.List;

public interface GeneralDAO<T> {

    void insert(T p);

    void update(T p);

    void delete(T p);

    List<T> getAll();

    T  getOne(int id);
}

package com.ge_airesFrescos.DAO;

public interface GeneralDAO<T> {

    void insert(T p);

    void update(T p);

    void delete(T p);

    public T  getAll(T p);

    public T  getOne(T p);
}

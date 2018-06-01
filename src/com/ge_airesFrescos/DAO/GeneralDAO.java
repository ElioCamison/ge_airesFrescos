package com.ge_airesFrescos.DAO;

public interface GeneralDAO<T> {

    void insert(T p);

    void update(T p);

    void delete(T p);

    public T  getAllPressupost(T p);

    public T  getOnePressupost(T p);
}

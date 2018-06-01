package com.ge_airesFrescos.DAO;

public interface GeneralDAO {
    void insert(Object p);

    void update(Object p);

    void delete(Object p);

    public Object  getAllPressupost(Object p);

    public Object  getOnePressupost(Object p);
}

package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.CustomerDAO;
import com.ge_airesFrescos.Model.Customer;
import com.ge_airesFrescos.dbb.Conexio;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpDAO implements CustomerDAO {

    private Conexio connection;
    private List<Customer> customerList = new ArrayList();


    @Override
    public void insert(Customer p) {

    }

    @Override
    public void update(Customer p) {

    }

    @Override
    public void delete(Customer p) {

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getOne(int id) {
        return null;
    }


}

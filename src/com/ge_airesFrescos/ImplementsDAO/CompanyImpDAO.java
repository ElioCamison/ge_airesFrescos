package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.CompanyDAO;
import com.ge_airesFrescos.ObjectClass.Company;
import com.ge_airesFrescos.dbb.Conexio;

import java.util.ArrayList;
import java.util.List;

public class CompanyImpDAO implements CompanyDAO {

    private Conexio connection;
    private List<Company> companyList = new ArrayList();


    @Override
    public void insert(Company p) {

    }

    @Override
    public void update(Company p) {

    }

    @Override
    public void delete(Company p) {

    }

    @Override
    public Company getAll(Company p) {
        return null;
    }

    @Override
    public Company getOne(Company p) {
        return null;
    }
}

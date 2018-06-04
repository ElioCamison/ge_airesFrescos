package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.CompanyDAO;
import com.ge_airesFrescos.Model.Company;
import com.ge_airesFrescos.dbb.Conexio;

import java.util.ArrayList;
import java.util.List;

public class CompanyImpDAO implements CompanyDAO {

    final String INSERT = "INSERT INTO pressupost(id_producte, id_treballador, id_empresa, id_client, total, data, observacions) VALUES(?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE pressupost SET id_producte = ?, id_treballador = ?, id_empresa = ?, id_client = ?, total = ?, data = ?, observacions = ? WHERE id = ?";
    final String DELETE = "DELETE FROM pressupost WHERE id = ?";
    final String GETALL = "SELECT * FROM pressupost";
    final String GETONE = "SELECT * FROM pressupost WHERE id = ?";

    private Conexio conn;
    private List<Company> companyList = new ArrayList();

    CompanyImpDAO(Conexio conn) {
        this.conn = conn;
    }


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
    public List<Company> getAll() {
        return null;
    }

    @Override
    public Company getOne(int id) {
        return null;
    }

}

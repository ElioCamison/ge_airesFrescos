package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.BudgetHasProductDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.Model.BudgetHasProduct;
import com.ge_airesFrescos.dbb.Conexio;

import java.util.ArrayList;
import java.util.List;

public class BudgetHasProductImpDAO implements BudgetHasProductDAO {


    final String INSERT = "INSERT INTO pressupost_inclou_producte(id_producte, id_pressupost) VALUES(?, ?)";
    final String UPDATE = "UPDATE pressupost_inclou_producte SET id_producte = ?, id_pressupost = ? WHERE id = ?";
    final String DELETE = "DELETE FROM pressupost_inclou_producte WHERE id = ?";
    final String GETALL = "SELECT * FROM pressupost_inclou_producte";
    final String GETONE = "SELECT * FROM pressupost_inclou_producte WHERE id = ?";


    public Conexio conn;
    private List<BudgetHasProduct> budgetHasProductList = new ArrayList();

    BudgetHasProductImpDAO(Conexio conn){
        this.conn = conn;
    }

    @Override
    public void insert(com.ge_airesFrescos.Model.BudgetHasProduct p) throws MySQLException {

    }

    @Override
    public void update(com.ge_airesFrescos.Model.BudgetHasProduct p) throws MySQLException {

    }

    @Override
    public void delete(com.ge_airesFrescos.Model.BudgetHasProduct p) throws MySQLException {

    }

    @Override
    public List<com.ge_airesFrescos.Model.BudgetHasProduct> getAll() throws MySQLException {
        return null;
    }

    @Override
    public com.ge_airesFrescos.Model.BudgetHasProduct getOne(int id) throws MySQLException {
        return null;
    }
}

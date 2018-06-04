package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.BudgetDAO;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.dbb.Conexio;

import java.util.ArrayList;
import java.util.List;

public class BudgetImpDAO implements BudgetDAO{

    private Conexio connection;
    private List<Budget> budgetList = new ArrayList();


    @Override
    public void insert(Budget p) {

    }

    @Override
    public void update(Budget p) {

    }

    @Override
    public void delete(Budget p) {

    }

    @Override
    public Budget getAll(Budget p) {
        return null;
    }

    @Override
    public Budget getOne(Budget p) {
        return null;
    }
}

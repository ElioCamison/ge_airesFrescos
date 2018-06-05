package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.ProductDAO;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.Model.Product;
import com.ge_airesFrescos.dbb.Conexio;

import java.util.ArrayList;
import java.util.List;

public class ProductImpDAO implements ProductDAO {

    final String INSERT = "INSERT INTO pressupost(name, description, image, price, stock) VALUES(?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE pressupost SET name = ?, description = ?, image = ?, price = ?, stock = ? WHERE id = ?";
    final String DELETE = "DELETE FROM pressupost WHERE id = ?";
    final String GETALL = "SELECT * FROM pressupost";
    final String GETONE = "SELECT * FROM pressupost WHERE id = ?";

    private Conexio connection;
    private List<Product> productList = new ArrayList();

    ProductImpDAO(Conexio connection){
        this.connection = connection;
    }


    @Override
    public void insert(Product p) {

    }

    @Override
    public void update(Product p) {

    }

    @Override
    public void delete(Product p) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getOne(int id) {
        return null;
    }
}

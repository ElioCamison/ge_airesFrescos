package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.BudgetHasProductDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.Model.BudgetHasProduct;
import com.ge_airesFrescos.Model.Person;
import com.ge_airesFrescos.dbb.Conexio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public BudgetHasProductImpDAO(Conexio conn){
        this.conn = conn;
    }

    @Override
    public void insert(com.ge_airesFrescos.Model.BudgetHasProduct p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(INSERT);
            prepStat.setInt(1, p.getId_producte());
            prepStat.setInt(2, p.getId_pressupost());
            int result = prepStat.executeUpdate();
            if (result == 0) {
                throw new MySQLException("Puede que no se haya guardado");
            }
        } catch (SQLException e) {
            throw new MySQLException("Error en SQL", e);
        } finally {
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (SQLException e) {
                    throw new MySQLException("Error en SQL", e);
                }
            }
        }
    }

    @Override
    public void update(com.ge_airesFrescos.Model.BudgetHasProduct p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(UPDATE);
            prepStat.setInt(1, p.getId_producte());
            prepStat.setInt(2, p.getId_pressupost());
            int result = prepStat.executeUpdate();
            if (result == 0) {
                throw new MySQLException("Puede que no se haya guardado");
            }
        } catch (SQLException e) {
            throw new MySQLException("Error en SQL", e);
        } finally {
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (SQLException e) {
                    throw new MySQLException("Error en SQL", e);
                }
            }
        }
    }

    @Override
    public void delete(com.ge_airesFrescos.Model.BudgetHasProduct p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(DELETE);
            prepStat.setInt(1, p.getId());
        } catch (SQLException e) {
            throw new MySQLException("Error en SQL", e);
        } finally {
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (SQLException e) {
                    throw new MySQLException("Error en SQL", e);
                }
            }
        }
    }

    private BudgetHasProduct convert(ResultSet rs) throws SQLException {
        int id = Integer.parseInt(rs.getString("id"));
        int id_producte = Integer.parseInt(rs.getString("id_producte"));
        int id_pressupost = Integer.parseInt(rs.getString("id_pressupost"));
        BudgetHasProduct budgetHasProduct = new BudgetHasProduct(id,id_producte,id_pressupost);
        return budgetHasProduct;
    }

    @Override
    public List<com.ge_airesFrescos.Model.BudgetHasProduct> getAll() throws MySQLException {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETALL);
            rs = prepStat.executeQuery();
            while (rs.next()) {
                budgetHasProductList.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new MySQLException("Error en SQL", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new MySQLException("Error en SQL", e);
                }
            }
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (SQLException e) {
                    throw new MySQLException("Error en SQL", e);
                }
            }
        }
        return budgetHasProductList;

    }

    @Override
    public com.ge_airesFrescos.Model.BudgetHasProduct getOne(int id) throws MySQLException {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        BudgetHasProduct budgetHasProduct = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETONE);
            prepStat.setInt(1, id);
            rs = prepStat.executeQuery();
            if (rs.next()) {
                budgetHasProduct = convert(rs);
            } else {
                throw new MySQLException("No se ha encontrado registros.");
            }
        } catch (SQLException e) {
            throw new MySQLException("Error en SQL", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new MySQLException("Error en SQL", e);
                }
            }
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (SQLException e) {
                    throw new MySQLException("Error en SQL", e);
                }
            }
        }
        return budgetHasProduct;
    }
}

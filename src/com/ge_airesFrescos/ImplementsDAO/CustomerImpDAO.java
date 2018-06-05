package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.CustomerDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.Model.Customer;
import com.ge_airesFrescos.dbb.Conexio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpDAO implements CustomerDAO {

    final String INSERT = "INSERT INTO pressupost(name, surname, adress, telephone, email, user, password) VALUES(?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE pressupost SET nom = ?, cognom = ?, adreça = ?, telefon = ?, email = ?, user = ?, password = ? WHERE id = ?";
    final String DELETE = "DELETE FROM pressupost WHERE id = ?";
    final String GETALL = "SELECT * FROM pressupost";
    final String GETONE = "SELECT * FROM pressupost WHERE id = ?";

    private Conexio conn;
    private List<Customer> customerList = new ArrayList();

    CustomerImpDAO(Conexio conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Customer p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(INSERT);
            prepStat.setString(1, p.getName());
            prepStat.setString(2, p.getSurname());
            prepStat.setString(3, p.getAdress());
            prepStat.setString(4, p.getTelephone());
            prepStat.setString(5, p.getEmail());
            prepStat.setString(6, p.getUser());
            prepStat.setString(7, p.getPassword());
            prepStat.executeUpdate();
            if (prepStat.executeUpdate() == 0) {
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
    public void update(Customer p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(UPDATE);
            prepStat.setString(1, p.getName());
            prepStat.setString(2, p.getSurname());
            prepStat.setString(3, p.getAdress());
            prepStat.setString(4, p.getTelephone());
            prepStat.setString(5, p.getEmail());
            prepStat.setString(6, p.getUser());
            prepStat.setString(7, p.getPassword());
            prepStat.setInt(8, p.getId());
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

    private Customer convert(ResultSet rs) throws SQLException {
        int id = Integer.parseInt(rs.getString("id"));
        String name         = rs.getString("name");
        String surname      = rs.getString("surname");
        String adress       = rs.getString("adress");
        String telephone    = rs.getString("telephone");
        String email        = rs.getString("email");
        String user         = rs.getString("user");
        String password     = rs.getString("password");
        Customer customer = new Customer(id, name,surname,adress,telephone,email,user,password);
        return customer;
    }

    @Override
    public void delete(Customer p) throws MySQLException {
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

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getOne(int id) {
        return null;
    }


}

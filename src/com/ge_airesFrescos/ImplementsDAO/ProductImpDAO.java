package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.ProductDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.Model.Product;
import com.ge_airesFrescos.dbb.Conexio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImpDAO implements ProductDAO {

    final String INSERT = "INSERT INTO producte(name, description, image, price, stock) VALUES(?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE producte SET name = ?, description = ?, image = ?, price = ?, stock = ? WHERE id = ?";
    final String DELETE = "DELETE FROM producte WHERE id = ?";
    final String GETALL = "SELECT * FROM producte";
    final String GETONE = "SELECT * FROM producte WHERE id = ?";

    public Conexio conn;
    private List<Product> productList = new ArrayList();

    public ProductImpDAO(Conexio conn){
        this.conn = conn;
    }


    @Override
    public void insert(Product p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(INSERT);
            prepStat.setString(1, p.getName());
            prepStat.setString(2, p.getDescription());
            prepStat.setString(3, p.getImage());
            prepStat.setFloat(4, p.getPrice());
            prepStat.setInt(5, p.getStock());
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
    public void update(Product p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(UPDATE);
            prepStat.setString(1, p.getName());
            prepStat.setString(2, p.getDescription());
            prepStat.setString(3, p.getImage());
            prepStat.setFloat(4, p.getPrice());
            prepStat.setInt(5, p.getStock());
            prepStat.setInt(6, p.getId());
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
    public void delete(Product p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(DELETE);
            prepStat.setInt(1, p.getId());
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

    private Product convert(ResultSet rs) throws SQLException {
        int id = Integer.parseInt(rs.getString("id"));
        String name = rs.getString("name");
        String description = rs.getString("description");
        String image = rs.getString("image");
        float price = Float.parseFloat(rs.getString("price"));
        int stock = Integer.parseInt(rs.getString("stock"));

        Product product = new Product(id,name, description, image, price, stock);

        return product;
    }

    @Override
    public List<Product> getAll() throws MySQLException {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETALL);
            rs = prepStat.executeQuery();
            while (rs.next()) {
                productList.add(convert(rs));
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
        return productList;
    }


    @Override
    public Product getOne(int id) throws MySQLException {

        PreparedStatement prepStat = null;
        ResultSet rs = null;
        Product product = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETONE);
            prepStat.setInt(1, id);
            rs = prepStat.executeQuery();
            if (rs.next()) {
                product = convert(rs);
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
        return product;
    }

}

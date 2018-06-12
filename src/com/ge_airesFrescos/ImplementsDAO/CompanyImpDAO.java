package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.CompanyDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.Model.Company;
import com.ge_airesFrescos.dbb.Conexio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyImpDAO implements CompanyDAO {

    final String INSERT = "INSERT INTO empresa(name, address) VALUES(?, ?)";
    final String UPDATE = "UPDATE empresa SET name = ?";
    final String DELETE = "DELETE FROM empresa WHERE id = ?";
    final String GETALL = "SELECT * FROM empresa";
    final String GETONE = "SELECT * FROM empresa WHERE id = ?";

    private Conexio conn;
    private List<Company> companyList = new ArrayList();

    public CompanyImpDAO(Conexio conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Company p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(INSERT);
            prepStat.setString(1, p.getName());
            prepStat.setString(2, p.getAddress());
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
    public void update(Company p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(UPDATE);
            prepStat.setString(1, p.getName());
            prepStat.setString(2, p.getAddress());
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
    public void delete(Company p) throws MySQLException {
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

    private Company convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String address = rs.getString("address");
        Company company = new Company(name,address);
        return company;
    }

    @Override
    public List<Company> getAll() throws MySQLException {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETALL);
            rs = prepStat.executeQuery();
            while (rs.next()) {
                companyList.add(convert(rs));
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
        return companyList;
    }

    @Override
    public Company getOne(int id) throws MySQLException {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        Company company = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETONE);
            prepStat.setInt(1, id);
            rs = prepStat.executeQuery();
            if (rs.next()) {
                company = convert(rs);
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
        return company;
    }

}

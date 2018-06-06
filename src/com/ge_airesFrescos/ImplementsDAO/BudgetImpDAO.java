package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.BudgetDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.dbb.Conexio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BudgetImpDAO implements BudgetDAO {

    // Les fetxes a Java empram un String, però a MySQL un datetime, probablemnt sorgeixin error... :S

    final String INSERT = "INSERT INTO pressupost(id_producte, id_treballador, id_empresa, id_client, total, data, observacions) VALUES(?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE pressupost SET id_producte = ?, id_treballador = ?, id_empresa = ?, id_client = ?, total = ?, data = ?, observacions = ? WHERE id = ?";
    final String DELETE = "DELETE FROM pressupost WHERE id = ?";
    final String GETALL = "SELECT * FROM pressupost";
    final String GETONE = "SELECT * FROM pressupost WHERE id = ?";

    public Conexio conn;
    private List<Budget> budgetList = new ArrayList();


    public BudgetImpDAO(Conexio conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Budget p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(INSERT);
            prepStat.setInt(1, p.getId_producte());
            prepStat.setInt(2, p.getId_treballador());
            prepStat.setInt(3, p.getId_empresa());
            prepStat.setInt(4, p.getId_client());
            prepStat.setFloat(5, p.getTotal());
            prepStat.setString(6, p.getData());
            prepStat.setString(7, p.getObservacions());
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
    public void update(Budget p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(UPDATE);
            prepStat.setInt(1, p.getId_producte());
            prepStat.setInt(2, p.getId_treballador());
            prepStat.setInt(3, p.getId_empresa());
            prepStat.setInt(4, p.getId_client());
            prepStat.setFloat(5, p.getTotal());
            prepStat.setString(6, p.getData());
            prepStat.setString(7, p.getObservacions());
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

    @Override
    public void delete(Budget p) throws MySQLException {
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


    private Budget convert(ResultSet rs) throws SQLException {
        int id_producte = Integer.parseInt(rs.getString("id_producte"));
        int id_treballador = Integer.parseInt(rs.getString("id_treballador"));
        int id_empresa = Integer.parseInt(rs.getString("id_empresa"));
        int id_client = Integer.parseInt(rs.getString("id_client"));
        float total = Float.parseFloat(rs.getString("total"));
        String data = rs.getString("data");
        String observacions = rs.getString("observacions");
        Budget budget = new Budget(id_producte, id_treballador, id_empresa, id_client, total, data, observacions);
        return budget;
    }

    @Override
    public List<Budget> getAll() throws MySQLException {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETALL);
            rs = prepStat.executeQuery();
            while (rs.next()) {
                budgetList.add(convert(rs));
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
        return budgetList;
    }

    @Override
    public Budget getOne(int id) throws MySQLException {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        Budget budget = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETONE);
            prepStat.setInt(1, id);
            rs = prepStat.executeQuery();
            if (rs.next()) {
                budget = convert(rs);
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
        return budget;
    }

}

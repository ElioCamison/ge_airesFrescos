package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.BudgetDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.dbb.Conexio;

import java.sql.PreparedStatement;
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

    private Conexio conn;
    private List<Budget> budgetList = new ArrayList();


    BudgetImpDAO(Conexio conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Budget p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(INSERT);
            prepStat.setInt(1,p.getId_producte());
            prepStat.setInt(2,p.getId_treballador());
            prepStat.setInt(3,p.getId_empresa());
            prepStat.setInt(4,p.getId_client());
            prepStat.setFloat(5,p.getTotal());
            prepStat.setString(6,p.getData());
            prepStat.setString(7,p.getObservacions());
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
    public void update(Budget p) {

    }

    @Override
    public void delete(Budget p) {

    }

    @Override
    public List<Budget> getAll() {
        return null;
    }

    @Override
    public Budget getOne(int id) {
        return null;
    }


}

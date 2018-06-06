package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.PersonDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.Model.Person;
import com.ge_airesFrescos.dbb.Conexio;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonImpDAO implements PersonDAO {

    final String INSERT = "INSERT INTO persona(name, surname, address, telephone, email, password, user, type) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE persona SET id_producte = ?, id_treballador = ?, id_empresa = ?, id_client = ?, total = ?, data = ?, observacions = ? WHERE id = ?";
    final String DELETE = "DELETE FROM persona WHERE id = ?";
    final String GETALL = "SELECT * FROM persona";
    final String GETONE = "SELECT * FROM persona WHERE id = ?";

    public Conexio conn;
    private List<Person> personList = new ArrayList();

    public PersonImpDAO(Conexio conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Person p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(INSERT);
            prepStat.setString(1, p.getName());
            prepStat.setString(2, p.getSurname());
            prepStat.setString(3, p.getAdress());
            prepStat.setString(4, p.getTelephone());
            prepStat.setString(5, p.getEmail());
            prepStat.setString(6, p.getPassword());
            prepStat.setString(7, p.getUser());
            prepStat.setString(8, p.getType());

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
    public void update(Person p) {

    }

    @Override
    public void delete(Person p) {

    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public Person getOne(int id) {
        return null;
    }


}

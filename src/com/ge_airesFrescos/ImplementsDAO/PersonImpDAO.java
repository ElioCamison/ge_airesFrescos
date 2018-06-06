package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.PersonDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.Model.Company;
import com.ge_airesFrescos.Model.Person;
import com.ge_airesFrescos.dbb.Conexio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void update(Person p) throws MySQLException {
        PreparedStatement prepStat = null;
        try {
            prepStat = conn.getConectar().prepareStatement(UPDATE);
            prepStat.setString(1, p.getName());
            prepStat.setString(2, p.getSurname());
            prepStat.setString(3, p.getAdress());
            prepStat.setString(4, p.getTelephone());
            prepStat.setString(5, p.getEmail());
            prepStat.setString(6, p.getPassword());
            prepStat.setString(7, p.getUser());
            prepStat.setString(8, p.getType());
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
    public void delete(Person p) throws MySQLException {
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

    private Person convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String address = rs.getString("address");
        String telephone = rs.getString("telephone");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String user = rs.getString("user");
        String type = rs.getString("type");

        Person person = new Person(name,surname,address,telephone,email,password,user,type);
        return person;
    }

    @Override
    public List<Person> getAll() throws MySQLException {
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETALL);
            rs = prepStat.executeQuery();
            while (rs.next()) {
                personList.add(convert(rs));
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
        return personList;

    }

    @Override
    public Person getOne(int id) throws MySQLException {

        PreparedStatement prepStat = null;
        ResultSet rs = null;
        Person person = null;
        try {
            prepStat = conn.getConectar().prepareStatement(GETONE);
            prepStat.setInt(1, id);
            rs = prepStat.executeQuery();
            if (rs.next()) {
                person = convert(rs);
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
        return person;
    }


}

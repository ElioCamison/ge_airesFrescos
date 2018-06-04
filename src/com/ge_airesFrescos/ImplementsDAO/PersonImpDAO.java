package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.PersonDAO;
import com.ge_airesFrescos.Model.Person;
import com.ge_airesFrescos.dbb.Conexio;

import java.util.ArrayList;
import java.util.List;

public class PersonImpDAO implements PersonDAO {

    private Conexio connection;
    private List<Person> personList = new ArrayList();


    @Override
    public void insert(Person p) {

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

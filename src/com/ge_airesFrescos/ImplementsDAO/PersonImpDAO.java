package com.ge_airesFrescos.ImplementsDAO;

import com.ge_airesFrescos.DAO.PersonDAO;
import com.ge_airesFrescos.ObjectClass.Customer;
import com.ge_airesFrescos.ObjectClass.Person;
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
    public Person getAll(Person p) {
        return null;
    }

    @Override
    public Person getOne(Person p) {
        return null;
    }
}
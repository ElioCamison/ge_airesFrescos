package com.ge_airesFrescos.Model;

public class Worker extends Person{

    private String user;
    private String password;
    private int id_department;

    public Worker(int id, String name, String surname, String adress, String telephone, String email, String user, String password, int id_department) {
        super(id, name, surname, adress, telephone, email);
        this.user = user;
        this.password = password;
        this.id_department = id_department;
    }

    public String getUser() {
        return user;
    }


    public int getId_department() {
        return id_department;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

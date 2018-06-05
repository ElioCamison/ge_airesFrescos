package com.ge_airesFrescos.Model;

public class Customer extends Person {

    private String user;
    private String password;


    public Customer(int id, String name, String surname, String adress, String telephone, String email, String user, String password) {
        super(id, name, surname, adress, telephone, email);
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.ge_airesFrescos.Model;

public class Person {

    private int id;
    private String name;
    private String surname;
    private String adress;
    private String telephone;
    private String email;
    private String password;
    private String user;
    private String type;

    public Person(int id, String name, String surname, String adress, String telephone, String email, String password, String user, String type) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.user = user;
        this.type = type;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", adress='" + adress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", user='" + user + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

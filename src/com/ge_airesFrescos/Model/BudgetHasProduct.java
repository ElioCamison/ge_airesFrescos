package com.ge_airesFrescos.Model;

public class BudgetHasProduct {

    private int id;
    private int id_producte;
    private int id_pressupost;

    public BudgetHasProduct(int id, int id_producte, int id_pressupost) {
        this.id = id;
        this.id_pressupost = id_pressupost;
        this.id_producte = id_producte;
    }

    public BudgetHasProduct(int id_producte, int id_pressupost) {
        this.id_pressupost = id_pressupost;
        this.id_producte = id_producte;
    }

    public int getId() {
        return id;
    }

    public int getId_producte() {
        return id_producte;
    }

    public int getId_pressupost() {
        return id_pressupost;
    }


    public void setId_producte(int id_producte) {
        this.id_producte = id_producte;
    }

    public void setId_pressupost(int id_pressupost) {
        this.id_pressupost = id_pressupost;
    }

    @Override
    public String toString() {
        return "BudgetHasProduct{" +
                "id=" + id +
                ", id_producte=" + id_producte +
                ", id_pressupost=" + id_pressupost +
                '}';
    }
}

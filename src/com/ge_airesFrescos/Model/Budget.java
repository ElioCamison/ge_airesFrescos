package com.ge_airesFrescos.Model;



public class Budget {

    private int id;
    private int id_producte;
    private int id_treballador;
    private int id_empresa;
    private int id_client;
    private float total;
    private String data;
    private String observacions;

    public Budget(int id, int id_producte, int id_treballador, int id_empresa, int id_client, float total, String data, String observacions) {
        this.id = id;
        this.id_producte = id_producte;
        this.id_treballador = id_treballador;
        this.id_empresa = id_empresa;
        this.id_client = id_client;
        this.total = total;
        this.data = data;
        this.observacions = observacions;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", id_producte=" + id_producte +
                ", id_treballador=" + id_treballador +
                ", id_empresa=" + id_empresa +
                ", id_client=" + id_client +
                ", total=" + total +
                ", data='" + data + '\'' +
                ", observacions='" + observacions + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getId_producte() {
        return id_producte;
    }

    public int getId_treballador() {
        return id_treballador;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public int getId_client() {
        return id_client;
    }

    public float getTotal() {
        return total;
    }

    public String getData() {
        return data;
    }

    public String getObservacions() {
        return observacions;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }
}

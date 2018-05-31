package com.ge_airesFrescos.dbb;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexio {

    private static final String CADENA_CONNEXIO = "jdbc:mysql://localhost/";
    private static final String USER_BBDD = "root";
    private static final String PASS_BBDD = "test";


    public synchronized Connection getConectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Establecemos la conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:10505/transactions?useServerPrepStmts=true", "root", "");
            return conexion;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }
}

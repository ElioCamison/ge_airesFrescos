package com.ge_airesFrescos.dbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexio implements AutoCloseable {

    // Conexió a casa
    // private static final String CADENA_CONNEXIO = "jdbc:mysql://localhost:10505";

    // Conexió a classe
    private static final String CADENA_CONNEXIO = "jdbc:mysql://localhost:3306";
    private static final String USER_BBDD = "root";
    // Conexió a casa
    // private static final String PASS_BBDD = "";
    private static final String PASS_BBDD = "test";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    static Connection conexion = null;

    public synchronized Connection getConectar() {
        if (conexion == null) {
            try {
                Class.forName(DRIVER);
                // Establecemos la conexión con la base de datos.
                conexion = DriverManager.getConnection( CADENA_CONNEXIO +"/ge_airesfrescos?useServerPrepStmts=true", USER_BBDD , PASS_BBDD );
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conexion;
        }

        return conexion;

    }

    @Override
    public void close() throws Exception {
        if(conexion != null){
            conexion.close();
        }
    }
}

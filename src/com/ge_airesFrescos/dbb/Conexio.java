package com.ge_airesFrescos.dbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexio {

    private static final String CADENA_CONNEXIO = "jdbc:mysql://localhost:10505";
    private static final String USER_BBDD = "root";
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
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (SQLException e){

                    }
                }
            }
            return conexion;
        }

        return conexion;

    }
}

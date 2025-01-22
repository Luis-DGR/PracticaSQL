package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Modificando_base_de_datos {
    public static void main(String[] args) {
        try {
            //necesitamos un objeto tipo Conection y la clase driverManagere

            //1*CREAR CONEXION
            Connection miConexion2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaexcel"
                    , "root", "alucard5555666*01/*3L");

            //2*CREAR OBJETO STATEMENT
            Statement miStatement2 = miConexion2.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

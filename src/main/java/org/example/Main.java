package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
    //creando coneccion con el servidor
        try{
            //necesitamos un objeto tipo Conection y la clase driverManagere

            //1*CREAR CONEXION
            Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaexcel"
            ,"root","alucard5555666*01/*3L");

            //2*CREAR OBJETO STATEMENT
            Statement miStatement=miConexion.createStatement();

            //3*EJECUTAR SQL
            ResultSet miResulset=miStatement.executeQuery("SELECT * FROM ppppp");

            //4*LEER RESULTSET (PROCESAR RESULTADOS)
            while (miResulset.next()){
                System.out.println(miResulset.getString("NOMBRE")+" "+"saldo: "+miResulset.getString("SALDO"));
            }



        } catch (Exception e) {
            System.out.println("no conecta");
            e.printStackTrace();
        }

    }
}
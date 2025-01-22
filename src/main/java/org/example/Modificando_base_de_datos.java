package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

            //CREAMOS LA INSTRUCCION

            //*INSERT
            String instruccionSQL="INSERT INTO ppppp (ID_USUARIO,NOMBRE,APELLIDO,SALDO,EMAIL) VALUES (4,'ALE','GUZMAN',50,'ALE@GMAIL.COM')";

            //*UPDATE
           // String instruccionSQL="UPDATE ppppp SET SALDO=5000 WHERE NOMBRE='ALE'";

            //*DELETE ((IMPORTANTE RECORDAR QUE DENTRO DE LA INSTRUCCION LOS Strings VAN ENTRE 'COMILLAS SIMPLES'))
           // String instruccionSQL="DELETE FROM ppppp WHERE NOMBRE='ALE'";



            //3*EJECUTAMOS
            miStatement2.executeUpdate(instruccionSQL);






        } catch (Exception e) {

        }
    }
}

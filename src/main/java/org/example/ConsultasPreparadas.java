package org.example;

import java.sql.*;

public class ConsultasPreparadas {
    public static void main(String[] args) {
        try {
            //necesitamos un objeto tipo Conection y la clase driverManagere

            //1*CREAR CONEXION
            Connection miConexion3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaexcel"
                    , "root", "alucard5555666*01/*3L");

            //2*CREAR OBJETO PREPARESTATEMENT
            PreparedStatement sentencia=miConexion3.prepareStatement("SELECT * FROM ppppp WHERE NOMBRE=?");

            //3*ESTABLECER PARAMETROS DE CONSULTA
            sentencia.setString(1,"JUAN");

            //4*EJECUTAR Y LEER RESULTADO
            ResultSet resultadoConsulta3= sentencia.executeQuery();

            while (resultadoConsulta3.next()){
                System.out.println(resultadoConsulta3.getInt(1)+" "+resultadoConsulta3.getString(2) +" "+resultadoConsulta3.getString(3)+" "+resultadoConsulta3.getInt(4) +" "+resultadoConsulta3.getString(5));
            }
            resultadoConsulta3.close();

//-------------------------------------------OLOVORGO----------------------------------------------
        } catch (SQLException e) {

        }



    }
}

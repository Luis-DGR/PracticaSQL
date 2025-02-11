package org.example;

import java.sql.*;

public class MetaDataos {
    public static void main(String[] args) {
     mostrarInfoTabla();

    }
    static void mostrarInfo_BBDD(){

        try(Connection miConect= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaexcel"
                , "root", "alucard5555666*01/*3L")){
            //OBTENCION METADATOS
            DatabaseMetaData datosBBDD= miConect.getMetaData();

            //MOSTRAMOS INFO DE LA BBDD
            System.out.println("Gestor de BBDD "+ datosBBDD.getDatabaseProductName());

            System.out.println("NUM VERSION" + datosBBDD.getDatabaseProductVersion());




        }catch (Exception a){
        a.printStackTrace();
        }


    }


    static void mostrarInfoTabla(){
        try(Connection miConect= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaexcel"
                , "root", "alucard5555666*01/*3L")){
            //OBTENCION METADATOS
            DatabaseMetaData datosBBDD= miConect.getMetaData();

            // Especifica el nombre de la tabla de la cual se desean obtener los metadatos de las columnas.


            // Especifica el nombre de la tabla de la cual se desean obtener los metadatos de las columnas.
            String nombreTabla = "ppppp";

            // Se utiliza el metodo getColumns para obtener los metadatos de las columnas de la tabla.
            // Parámetros:
            //   catalog: En MySQL, se puede dejar como null.
            //   schemaPattern: Normalmente null en MySQL.
            //   tableNamePattern: El nombre de la tabla.
            //   columnNamePattern: Patrón para los nombres de las columnas, "%" indica todas las columnas.
            ResultSet columnas = datosBBDD.getColumns(null, null, nombreTabla, "%");

            // Se recorre el ResultSet para procesar la información de cada columna.
            while (columnas.next()) {
                // Se obtiene el nombre de la columna.
                String nombreColumna = columnas.getString("COLUMN_NAME");

                // Se obtiene el tipo de dato de la columna.
                String tipoDato = columnas.getString("TYPE_NAME");

                // Se obtiene el tamaño (longitud) de la columna.
                int tamañoColumna = columnas.getInt("COLUMN_SIZE");

                // Se imprime en consola la información obtenida de la columna.
                System.out.println("Columna: " + nombreColumna +
                        " | Tipo: " + tipoDato +
                        " | Tamaño: " + tamañoColumna);
            }
        } catch (SQLException e) {
            // En caso de producirse una excepción SQL, se imprime la traza del error.
            e.printStackTrace();
        }
    }
}




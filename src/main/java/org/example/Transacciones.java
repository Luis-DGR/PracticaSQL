package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transacciones {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pruebaexcel";
        String usuario = "root";
        String contraseña = "alucard5555666*01/*3L";

        // Query con placeholders para evitar SQL Injection
        String sql1 = "UPDATE ppppp SET NOMBRE = ? WHERE ID_USUARIO = ?";
        String sql2 = "UPDATE ppppp SET SALDO = ? WHERE ID_USUARIO = ?";

        try (Connection miConexion3 = DriverManager.getConnection(url, usuario, contraseña)) {
            miConexion3.setAutoCommit(false); // Desactivar autocommit

            try (PreparedStatement stmt1 = miConexion3.prepareStatement(sql1);
                 PreparedStatement stmt2 = miConexion3.prepareStatement(sql2)) {

                // Parámetros para la primera consulta
                stmt1.setString(1, "Alejandra");
                stmt1.setInt(2, 4);
                stmt1.executeUpdate();

                // Parámetros para la segunda consulta
                stmt2.setInt(1, 300);
                stmt2.setInt(2, 4);
                stmt2.executeUpdate();

                miConexion3.commit();
                System.out.println("Se actualizó correctamente.");

            } catch (SQLException e) {
                miConexion3.rollback();
                System.err.println("Error en la transacción, se realizó rollback.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión con la base de datos.");
            e.printStackTrace();
        }
    }
}

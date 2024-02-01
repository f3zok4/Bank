package br.ufmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexaoFactory {
    public ConexaoFactory() {
    }

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/ufmt";
        String usuario = "root";
        String senha = "root";
        java.sql.Connection conexao;

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar" + e.getMessage(), e);
        }

        return conexao;
    }
}

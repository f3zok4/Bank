package br.ufmt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public final class PessoaDAO {
    public PessoaDAO() {
    }

    public static void inserir(Pessoa pessoa) {
        String sql = "INSERT INTO pessoas (nome, cidade) VALUES (?, ?)";
        try {
            Connection conexao = ConexaoFactory.getConnection();
            PreparedStatement consulta = conexao.prepareStatement(sql);
            consulta.setString(1, pessoa.getNome());
            consulta.setString(2, pessoa.getCidade());
            consulta.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir" + e.getMessage(), e);
        }
    }

    public static void atualizar(Pessoa pessoa) {
        String sql = "UPDATE pessoas SET nome = ?, cidade = ? WHERE id = ?";
        try {
            Connection conexao = ConexaoFactory.getConnection();
            PreparedStatement consulta = conexao.prepareStatement(sql);
            consulta.setString(1, pessoa.getNome());
            consulta.setString(2, pessoa.getCidade());
            consulta.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar" + e.getMessage(), e);
        }
    }

    public static void deletar(Pessoa pessoa) {
        String sql = "DELETE FROM pessoas WHERE id = ?";
        try {
            Connection conexao = ConexaoFactory.getConnection();
            PreparedStatement consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, pessoa.getID());
            consulta.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar" + e.getMessage(), e);
        }
    }

    public static List<Pessoa> listar() {
        String sql = "SELECT * FROM pessoas";
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            Connection conexao = ConexaoFactory.getConnection();
            PreparedStatement consulta = conexao.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cidade = resultado.getString("cidade");
                Pessoa pessoa = new Pessoa(id, nome, cidade);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar" + e.getMessage(), e);
        }
        return pessoas;
    }

    public static void printList() {
        List<Pessoa> pessoas = PessoaDAO.listar();
        for (Pessoa p : pessoas) {
            System.out.println("id: " + p.getID() + " Nome: " + p.getNome() + " Cidade: " + p.getCidade());
        }
    }

    public static void findNameLike(String nomeBusca) {
        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            Connection conexao = ConexaoFactory.getConnection();
            PreparedStatement consulta = conexao.prepareStatement(sql);
            consulta.setString(1, "%" + nomeBusca + "%");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cidade = resultado.getString("cidade");
                Pessoa pessoa = new Pessoa(id, nome, cidade);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar" + e.getMessage(), e);
        }
        for (Pessoa p : pessoas) {
            System.out.println("id: " + p.getID() + " Nome: " + p.getNome() + " Cidade: " + p.getCidade());
        }
    }
}

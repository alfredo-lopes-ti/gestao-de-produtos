package sistema.gestao.com.br.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema.gestao.com.br.model.Produto;

public class ProdutoDAO {

    public void cadastrar(Produto produto) {
        // Comando SQL parametrizado
        String sql = "INSERT INTO tb_produto (id, nome, categoria, valor, quantidade) VALUES (?, ?, ?, ?, ?)";

        // O try-with-resources fecha a conexão e o PreparedStatement automaticamente ao
        // terminar
        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Preenche os '?' com os valores vindos do objeto Produto (indexados a partir
            // de 1)
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getCategoria());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getQuantidade());

            // Executa o comando de alteração no banco
            stmt.executeUpdate();
            System.out.println("Produto salvo no banco de dados PostgreSQL com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto no banco: " + e.getMessage());
        }
    }

    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_produto";

        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getDouble("valor"),
                        rs.getInt("quantidade"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos do banco: " + e.getMessage());
        }

        return lista;
    }
}
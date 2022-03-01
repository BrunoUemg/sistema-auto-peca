/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

/**
 *
 * @author serpa
 */
public class ProdutoDAO {

    PreparedStatement pst;
    String sql;
    int idProduto;
    int idCategoria;
    int idMarca;

    public String salvarProduto(Produto produto) throws SQLException {
        sql = "INSERT INTO produto values(?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, produto.getNome());
        pst.setString(3, produto.getDescricao());
        pst.setInt(4, produto.getQuantidadeMin());
        pst.setInt(5, produto.getQuantidadeEstoque());
        pst.setFloat(6, produto.getValorCompra());
        pst.setFloat(7, produto.getValorSaida());
        pst.setString(8, produto.getCodigoBarras());
        pst.setInt(9, produto.getIdCategoria());
        pst.setInt(10, produto.getIdMarca());
        int row = pst.executeUpdate();
        pst.close();
        if (row == 1) {
            return "Produto Salvo com sucesso!";
        }
        return "Erro ao salvar produto!";
    }

    public List<Produto> readProduto() throws SQLException {
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        try {
            sql = "SELECT * FROM produto INNER JOIN categoria ON produto.idCategoria = categoria.idCategoria INNER JOIN marca ON produto.idMarca = marca.idMarca";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidadeMin(rs.getInt("quantidadeMin"));
                produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                produto.setValorCompra(rs.getFloat("valorCompra"));
                produto.setValorSaida(rs.getFloat("valorSaida"));
                produto.setCodigoBarras(rs.getString("codigoBarras"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setIdMarca(rs.getInt("idMarca"));
                produto.setNomeCategoria(rs.getString("descricaoCategoria"));
                produto.setNomeMarca(rs.getString("nomeMarca"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return produtos;
    }

        public List<Produto> readProdutoTop() throws SQLException {
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        try {
            sql = "SELECT *, sum(item_venda.quantidade) as totalVendas FROM item_venda INNER JOIN produto ON item_venda.idProduto = produto.idProduto GROUP BY item_venda.idProduto ORDER BY totalVendas DESC";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidadeMin(rs.getInt("quantidadeMin"));
                produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                produto.setValorCompra(rs.getFloat("valorCompra"));
                produto.setValorSaida(rs.getFloat("valorSaida"));
                produto.setCodigoBarras(rs.getString("codigoBarras"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setIdMarca(rs.getInt("idMarca"));
                produto.setNomeCategoria(rs.getString("totalVendas"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return produtos;
    }

    public List<Produto> readProdutoEstoque() throws SQLException {
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        try {
            sql = "SELECT * FROM produto INNER JOIN categoria ON produto.idCategoria = categoria.idCategoria INNER JOIN marca ON produto.idMarca = marca.idMarca WHERE produto.quantidadeEstoque<produto.quantidadeMin";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidadeMin(rs.getInt("quantidadeMin"));
                produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                produto.setValorCompra(rs.getFloat("valorCompra"));
                produto.setValorSaida(rs.getFloat("valorSaida"));
                produto.setCodigoBarras(rs.getString("codigoBarras"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setIdMarca(rs.getInt("idMarca"));
                produto.setNomeCategoria(rs.getString("descricaoCategoria"));
                produto.setNomeMarca(rs.getString("nomeMarca"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return produtos;
    }

    public List<Produto> readProdutoLike(String nome) throws SQLException {
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        try {
            sql = "SELECT * FROM produto INNER JOIN categoria ON produto.idCategoria = categoria.idCategoria INNER JOIN marca ON produto.idMarca = marca.idMarca WHERE produto.nome LIKE ?";
            pst = Conexao.getInstance().prepareStatement(sql);
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidadeMin(rs.getInt("quantidadeMin"));
                produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                produto.setValorCompra(rs.getFloat("valorCompra"));
                produto.setValorSaida(rs.getFloat("valorSaida"));
                produto.setCodigoBarras(rs.getString("codigoBarras"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setIdMarca(rs.getInt("idMarca"));
                produto.setNomeCategoria(rs.getString("descricaoCategoria"));
                produto.setNomeMarca(rs.getString("nomeMarca"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return produtos;
    }

    public List<Produto> readProdutoLikeEstoque(String nome) throws SQLException {
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        try {
            sql = "SELECT * FROM produto INNER JOIN categoria ON produto.idCategoria = categoria.idCategoria INNER JOIN marca ON produto.idMarca = marca.idMarca WHERE produto.quantidadeEstoque > 0 AND produto.nome LIKE ?";
            pst = Conexao.getInstance().prepareStatement(sql);
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidadeMin(rs.getInt("quantidadeMin"));
                produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                produto.setValorCompra(rs.getFloat("valorCompra"));
                produto.setValorSaida(rs.getFloat("valorSaida"));
                produto.setCodigoBarras(rs.getString("codigoBarras"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setIdMarca(rs.getInt("idMarca"));
                produto.setNomeCategoria(rs.getString("descricaoCategoria"));
                produto.setNomeMarca(rs.getString("nomeMarca"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return produtos;
    }

    public Produto BuscarProduto(String codigo) throws SQLException {
        sql = "SELECT * FROM produto INNER JOIN categoria ON produto.idCategoria = categoria.idCategoria INNER JOIN marca ON produto.IdMarca = marca.idMarca WHERE idProduto = " + codigo;
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Produto prod = null;
        while (rs.next()) {
            prod = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getString("descricao"), rs.getInt("quantidadeMin"), rs.getInt("quantidadeEstoque"), rs.getFloat("valorCompra"), rs.getFloat("valorSaida"), rs.getString("codigoBarras"), rs.getInt("idCategoria"), rs.getInt("idMarca"), rs.getString("descricaoCategoria"), rs.getString("nomeMarca"));
        }
        pst.close();
        return prod;
    }

    public String alterarProduto(Produto produto) throws SQLException {
        sql = "update produto set nome=?, descricao=?, quantidadeMin=?, codigoBarras=?, idCategoria=?, idMarca=? where idProduto=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, produto.getNome());
        pst.setString(2, produto.getDescricao());
        pst.setInt(3, produto.getQuantidadeMin());
        pst.setString(4, produto.getCodigoBarras());
        pst.setInt(5, produto.getIdCategoria());
        pst.setInt(6, produto.getIdMarca());
        pst.setInt(7, produto.getIdProduto());
        int rows = pst.executeUpdate();
        pst.close();
        if (rows == 1) {
            return "Alterado com sucesso!";
        }
        return "Erro ao alterar!";
    }

    public String excluirProduto(Produto produto) throws SQLException {
        sql = "delete from produto where idProduto=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, produto.getIdProduto());
        int rows = pst.executeUpdate();
        pst.close();
        if (rows == 1) {
            return "Excluido com sucesso!";
        }
        return "Erro ao excluir!";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Funcionario;
import model.Venda;
import model.ItensVenda;
import model.Produto;

/**
 *
 * @author serpa
 */
public class VendaDAO {

    PreparedStatement pst;
    String sql;
    PreparedStatement pst2;
    String sql2;
    int idVenda;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void salvarVenda(Venda venda) throws SQLException {
        sql = "INSERT INTO venda values(?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setInt(2, venda.getIdFunc());
        pst.setInt(3, venda.getCli().getIdCliente());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dataVenda = java.sql.Date.valueOf(sdf.format(venda.getDataVenda()));
        pst.setDate(4, dataVenda);
        pst.setDouble(5, venda.getValorTotal());
        int affectedRows = pst.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Erro ao finalizar venda.");
        }
        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idVenda = (int) generatedKeys.getLong(1);
            } else {
                throw new SQLException("Erro ao finalizar venda, nenhum ID obtido!");
            }
        }
        salvarItensVenda(venda.getItensVenda(), idVenda);

        pst.close();
    }

    public void salvarItensVenda(List<ItensVenda> itensVenda, int idVenda) throws SQLException {
        for (ItensVenda itens : itensVenda) {
            sql = "INSERT INTO item_venda values(?,?,?,?,?)";
            pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setDouble(2, itens.getPrecoUnitario());
            pst.setInt(3, idVenda);
            pst.setInt(4, itens.getProduto().getIdProduto());
            pst.setInt(5, itens.getQuantidade());
            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Erro ao finalizar compra");
            }

            String bus = "SELECT * FROM produto where idProduto = " + itens.getProduto().getIdProduto();

            ResultSet rs = pst.executeQuery(bus);
            int quantidade = 0;
            int quantidadeFinal = 0;

            while (rs.next()) {
                quantidade = rs.getInt("quantidadeEstoque");
            }
            quantidadeFinal = quantidade - itens.getQuantidade();
            sql = "UPDATE produto set quantidadeEstoque = ?, valorCompra = ? where idProduto = ?";
            pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, quantidadeFinal);
            pst.setDouble(2, itens.getPrecoUnitario());
            pst.setInt(3, itens.getProduto().getIdProduto());
            int affectedRows2 = pst.executeUpdate();
            if (affectedRows2 == 0) {
                throw new SQLException("Erro ao adicionar itens.");
            }

        }
    }

    public List<Venda> readVendasAll() throws SQLException {
        ResultSet rs = null;
        ResultSet rs2 = null;
        List<Venda> vendas = new ArrayList<>();
        try {
            sql = "SELECT * FROM venda INNER JOIN cliente ON venda.idCliente = cliente.idcliente INNER JOIN funcionario ON venda.idVendedor = funcionario.idFuncionario";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setIdVenda(rs.getInt("idVenda"));
                venda.setIdFunc(rs.getInt("idVendedor"));
                venda.setValorTotal(rs.getDouble("valorTotal"));
                venda.setDataVenda(rs.getDate("dataVenda"));
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                venda.setCli(cliente);
                vendas.add(venda);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return vendas;
    }

    public List<Venda> readVendasData(String i, String f) throws SQLException {
        ResultSet rs = null;
        ResultSet rs2 = null;
        List<Venda> vendas = new ArrayList<>();
        try {
            sql = "SELECT * FROM venda INNER JOIN cliente ON venda.idCliente = cliente.idcliente INNER JOIN funcionario ON venda.idVendedor = funcionario.idFuncionario WHERE (venda.dataVenda BETWEEN ? AND ?)";
            pst = Conexao.getInstance().prepareStatement(sql);
            pst.setString(1, i);
            pst.setString(2, f);
            rs = pst.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setIdVenda(rs.getInt("idVenda"));
                venda.setIdFunc(rs.getInt("idVendedor"));
                venda.setValorTotal(rs.getDouble("valorTotal"));
                venda.setDataVenda(rs.getDate("dataVenda"));
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                venda.setCli(cliente);
                vendas.add(venda);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return vendas;
    }

    public Venda buscaVenda(String codigo) throws SQLException {
        ResultSet rs = null;
        sql = "SELECT * FROM venda INNER JOIN cliente ON venda.idCliente = cliente.idcliente INNER JOIN funcionario ON venda.idVendedor = funcionario.idFuncionario WHERE venda.idVenda = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, codigo);
        rs = pst.executeQuery();
        Venda venda = new Venda();
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("idcliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setNumero(rs.getString("numero"));
            cliente.setCep(rs.getString("cep"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setEmail(rs.getString("email"));
            venda.setIdVenda(rs.getInt("idVenda"));
            venda.setIdFunc(rs.getInt("idVendedor"));
            venda.setDataVenda(rs.getDate("dataVenda"));
            venda.setCli(cliente);
            venda.setValorTotal(rs.getDouble("valorTotal"));
        }
        pst.close();
        return venda;

    }

    public List<ItensVenda> buscarItens(String codigo) throws SQLException {
        sql = "SELECT * FROM item_venda INNER JOIN produto ON item_venda.idProduto = produto.idProduto INNER JOIN venda ON item_venda.idVenda = venda.idVenda WHERE venda.idVenda = " + codigo;
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<ItensVenda> itensVenda = new ArrayList<>();
        while (rs.next()) {
            ItensVenda itemVenda = new ItensVenda();
            Produto produto = new Produto();
            itemVenda.setIdItem(rs.getInt("idItem"));
            itemVenda.setPrecoUnitario(rs.getDouble("valorUnitario"));
            itemVenda.setQuantidade(rs.getInt("quantidade"));
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
            itemVenda.setProduto(produto);
            itensVenda.add(itemVenda);
        }
        pst.close();
        return itensVenda;
    }

}

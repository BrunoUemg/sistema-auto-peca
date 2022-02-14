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
import java.util.List;
import model.Venda;
import model.ItensVenda;

/**
 *
 * @author serpa
 */
public class VendaDAO {

    PreparedStatement pst;
    String sql;
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
}

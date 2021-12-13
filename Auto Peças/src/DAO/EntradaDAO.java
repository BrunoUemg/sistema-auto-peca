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
import model.Entrada;
import model.ItensProdutos;

/**
 *
 * @author serpa
 */
public class EntradaDAO {

    PreparedStatement pst;
    String sql;
    int idEntrada;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void salvarEntrada(Entrada entrada) throws SQLException {
        sql = "INSERT INTO entrada values(?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, entrada.getNumNota());
        pst.setDouble(3, entrada.getValorNota());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dateNota = java.sql.Date.valueOf(sdf.format(entrada.getDataNota()));
        pst.setDate(4, dateNota);
        java.sql.Date dateEntrada = java.sql.Date.valueOf(sdf.format(entrada.getDataCompra()));
        pst.setDate(5, dateEntrada);
        pst.setString(6, entrada.getChaveNota());
        pst.setInt(7, entrada.getFornecedor().getIdForncedor());
        int affectedRows = pst.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Erro ao adicionar entrada.");
        }
        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idEntrada = (int) generatedKeys.getLong(1);
            } else {
                throw new SQLException("Erro ao cadastrar entrada, nenhum ID obtido!");
            }
        }
        salvarItensEntrada(entrada.getItensProdutos(), idEntrada);
        
        pst.close();
    }

    public void salvarItensEntrada(List<ItensProdutos> itensProdutos, int idEntrada) throws SQLException {
        for (ItensProdutos itens : itensProdutos) {
            sql = "INSERT INTO item_entrada values(?,?,?,?,?)";
            pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setInt(2, idEntrada);
            pst.setInt(3, itens.getProduto().getIdProduto());
            pst.setDouble(4, itens.getPrecoUnitario());
            pst.setInt(5, itens.getQuantidade());
            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Erro ao adicionar itens.");
            }
        }
    }
}

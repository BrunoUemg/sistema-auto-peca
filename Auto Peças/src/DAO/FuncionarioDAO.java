/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Funcionario;

/**
 *
 * @author Bruno
 */
public class FuncionarioDAO {

    
     PreparedStatement pst;
     String sql;
     int idFuncionario;

    public String salvarFuncionario(Funcionario funcionario) throws SQLException {
        sql = "INSERT INTO funcionario values(?,?,?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, funcionario.getNome());
        pst.setString(3, funcionario.getCpf());
        pst.setString(4, funcionario.getTelefone());
        pst.setString(5, funcionario.getCelular());
        pst.setString(6, funcionario.getEmail());
        pst.setString(7, funcionario.getEndereco());
        pst.setString(8, funcionario.getBairro());
        pst.setString(9, funcionario.getNumero());
        pst.setString(10, funcionario.getCargo());
        pst.setString(11, funcionario.getUsuario());
        pst.setString(12, funcionario.getSenha());
        
        int row = pst.executeUpdate();
        pst.close();
        if (row == 1) {
            return "Produto Salvo com sucesso!";
        }
        return "Erro ao salvar produto!";
    }
    }


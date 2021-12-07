/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Funcionario;

/**
 *
 * @author serpa
 */
public class UsuarioDAO {
    PreparedStatement pst;
    String sql;
    
    public ResultSet autenticarUsuario(Funcionario objFunc) throws SQLException{
        sql = "SELECT * FROM funcionario WHERE usuario = ? and senha = ?";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, objFunc.getUsuario());
        pst.setString(2, objFunc.getSenha());
        ResultSet rs = pst.executeQuery();
//        pst.close();
        return rs;
    }

}

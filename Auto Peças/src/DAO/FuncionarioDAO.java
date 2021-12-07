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
            return "Funcionario cadastrado com sucesso!";
        }
        return "Erro ao cadastrar funcionario!";
    }

    public List<Funcionario> readFuncionarios() throws SQLException {
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            sql = "SELECT * FROM funcionario";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCelular(rs.getString("celular"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return funcionarios;
    }
    
    public Funcionario BuscarFuncionario(String codigo) throws SQLException {
        sql = "SELECT * FROM funcionario WHERE idFuncionario = " + codigo;
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Funcionario func = null;
        while (rs.next()) {
            func = new Funcionario(rs.getInt("idFuncionario"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("celular"), rs.getString("email"), rs.getString("endereco"), rs.getString("bairro"), rs.getString("numero"), rs.getString("cargo"), rs.getString("usuario"), rs.getString("senha"));
        }
        pst.close();
        return func;
    }
    
    public String alterarFuncionario(Funcionario funcionario) throws SQLException {
        sql = "update funcionario set nome=?, cpf=?, telefone=?, celular=?, email=?, endereco=?, bairro=?, numero=?, cargo=?, usuario=? WHERE idFuncionario=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, funcionario.getNome());
        pst.setString(2, funcionario.getCpf());
        pst.setString(3, funcionario.getTelefone());
        pst.setString(4, funcionario.getCelular());
        pst.setString(5, funcionario.getEmail());
        pst.setString(6, funcionario.getEndereco());
        pst.setString(7, funcionario.getBairro());
        pst.setString(8, funcionario.getNumero());
        pst.setString(9, funcionario.getCargo());
        pst.setString(10, funcionario.getUsuario());

        pst.setInt(11, funcionario.getIdFuncionario());
        int rows = pst.executeUpdate();
        pst.close();
        if (rows == 1) {
            return "Alterado com sucesso!";
        }
        return "Erro ao alterar!";
    }
    
    public String excluirFuncionario(Funcionario funcionario) throws SQLException {
        sql = "delete from funcionario where idFuncionario=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, funcionario.getIdFuncionario());
        int rows = pst.executeUpdate();
        pst.close();
        if (rows == 1) {
            return "Excluido com sucesso!";
        }
        return "Erro ao excluir!";
    }
}

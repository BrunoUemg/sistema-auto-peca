/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import model.ClienteFisico;
import model.ClienteJuridico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author serpa
 */
public class ClienteDAO {

    PreparedStatement pst;
    String sql;
    int idCliente;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void salvarF(ClienteFisico clienteFisico) throws SQLException {
        sql = "INSERT INTO cliente values(?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, clienteFisico.getNome());
        pst.setString(3, clienteFisico.getEndereco());
        pst.setString(4, clienteFisico.getBairro());
        pst.setString(5, clienteFisico.getNumero());
        pst.setString(6, clienteFisico.getCep());
        pst.setString(7, clienteFisico.getCidade());
        pst.setString(8, clienteFisico.getTelefone());
        pst.setString(9, clienteFisico.getCelular());
        pst.setString(10, clienteFisico.getEmail());
        int affectedRows = pst.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Erro ao adicionar Cliente.");
        }
        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idCliente = (int) generatedKeys.getLong(1);
            } else {
                throw new SQLException("Erro ao criar o cliente, nenhum ID obtido!");
            }
        }
        sql = "INSERT INTO cliente_fisico values(?,?,?,?,?)";
        System.out.println(clienteFisico.getCpf());
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, clienteFisico.getCpf());
        pst.setString(3, clienteFisico.getRg());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = java.sql.Date.valueOf(sdf.format(clienteFisico.getDtaNascimento()));
        pst.setDate(4, date);
        pst.setInt(5, idCliente);
        pst.executeUpdate();
//        pst.execute();
        pst.close();
    }

    public void salvarJ(ClienteJuridico clienteJuridico) throws SQLException {
        sql = "INSERT INTO cliente values(?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, clienteJuridico.getNome());
        pst.setString(3, clienteJuridico.getEndereco());
        pst.setString(4, clienteJuridico.getBairro());
        pst.setString(5, clienteJuridico.getNumero());
        pst.setString(6, clienteJuridico.getCep());
        pst.setString(7, clienteJuridico.getCidade());
        pst.setString(8, clienteJuridico.getTelefone());
        pst.setString(9, clienteJuridico.getCelular());
        pst.setString(10, clienteJuridico.getEmail());
        int affectedRows = pst.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Erro ao adicionar Cliente.");
        }
        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idCliente = (int) generatedKeys.getLong(1);
            } else {
                throw new SQLException("Erro ao criar o cliente, nenhum ID obtido!");
            }
        }
        sql = "INSERT INTO cliente_juridico values(?,?,?,?,?)";
        System.out.println(clienteJuridico.getCnpj());
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, clienteJuridico.getCnpj());
        pst.setString(3, clienteJuridico.getInscricaoEstadual());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = java.sql.Date.valueOf(sdf.format(clienteJuridico.getFundacao()));
        pst.setDate(4, date);
        pst.setInt(5, idCliente);
        pst.executeUpdate();
//        pst.execute();
        pst.close();
    }

    public List<ClienteFisico> readF() throws SQLException {
        ResultSet rs = null;
        List<ClienteFisico> clientesFisico = new ArrayList<>();
        try {
            sql = "SELECT * FROM cliente INNER JOIN cliente_fisico ON cliente.idcliente = cliente_fisico.idcliente";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                ClienteFisico clienteFisico = new ClienteFisico();
                clienteFisico.setIdCliente(rs.getInt("idcliente"));
                clienteFisico.setNome(rs.getString("nome"));
                clienteFisico.setEndereco(rs.getString("endereco"));
                clienteFisico.setBairro(rs.getString("bairro"));
                clienteFisico.setNumero(rs.getString("numero"));
                clienteFisico.setCep(rs.getString("cep"));
                clienteFisico.setCidade(rs.getString("cidade"));
                clienteFisico.setTelefone(rs.getString("telefone"));
                clienteFisico.setCelular(rs.getString("celular"));
                clienteFisico.setEmail(rs.getString("email"));
                clienteFisico.setIdClienteFisico(rs.getInt("idcliente_fisico"));
                clienteFisico.setCpf(rs.getString("cpf"));
                clienteFisico.setRg(rs.getString("rg"));
                clienteFisico.setDtaNascimento(rs.getDate("dtNascimento"));
                clientesFisico.add(clienteFisico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return clientesFisico;
    }
    
    public List<Cliente> readCliente(String nome) throws SQLException {
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            sql = "SELECT * FROM cliente WHERE nome LIKE ? ";
            pst = Conexao.getInstance().prepareStatement(sql);
            pst.setString(1, "%"+nome+"%");
            rs = pst.executeQuery();

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
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return clientes;
    }

    public List<ClienteJuridico> readJ() throws SQLException {
        ResultSet rs = null;
        List<ClienteJuridico> clientesJuridico = new ArrayList<>();
        try {
            sql = "SELECT * FROM cliente INNER JOIN cliente_juridico ON cliente.idcliente = cliente_juridico.idcliente";
            pst = Conexao.getInstance().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                ClienteJuridico clienteJuridico = new ClienteJuridico();
                clienteJuridico.setIdCliente(rs.getInt("idcliente"));
                clienteJuridico.setNome(rs.getString("nome"));
                clienteJuridico.setEndereco(rs.getString("endereco"));
                clienteJuridico.setBairro(rs.getString("bairro"));
                clienteJuridico.setNumero(rs.getString("numero"));
                clienteJuridico.setCep(rs.getString("cep"));
                clienteJuridico.setCidade(rs.getString("cidade"));
                clienteJuridico.setTelefone(rs.getString("telefone"));
                clienteJuridico.setCelular(rs.getString("celular"));
                clienteJuridico.setEmail(rs.getString("email"));
                clienteJuridico.setIdClienteJuridico(rs.getInt("idcliente_juridico"));
                clienteJuridico.setCnpj(rs.getString("cnpj"));
                clienteJuridico.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
                clienteJuridico.setFundacao(rs.getDate("fundacao"));
                clientesJuridico.add(clienteJuridico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        return clientesJuridico;
    }

    public ClienteFisico BuscarF(String codigo) throws SQLException {
        sql = "SELECT * FROM cliente INNER JOIN cliente_fisico ON cliente.idcliente = cliente_fisico.idcliente WHERE cliente.idcliente = " + codigo;
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ClienteFisico clif = null;
        while (rs.next()) {
            clif = new ClienteFisico(rs.getInt("idcliente_fisico"), rs.getString("cpf"), rs.getString("rg"), rs.getDate("dtNascimento"),rs.getInt("idcliente"),rs.getString("nome"),rs.getString("endereco"),rs.getString("bairro"),rs.getString("numero"),rs.getString("cep"),rs.getString("cidade"),rs.getString("telefone"),rs.getString("celular"),rs.getString("email"));
        }
        pst.close();
        return clif;
    }
    
    public ClienteJuridico BuscarJ(String codigo) throws SQLException {
        sql = "SELECT * FROM cliente INNER JOIN cliente_juridico ON cliente.idcliente = cliente_juridico.idcliente WHERE cliente.idcliente = " + codigo;
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ClienteJuridico clij = null;
        while (rs.next()) {
            clij = new ClienteJuridico(rs.getInt("idcliente_juridico"), rs.getString("cnpj"), rs.getString("inscricaoEstadual"), rs.getDate("fundacao"),rs.getInt("idcliente"),rs.getString("nome"),rs.getString("endereco"),rs.getString("bairro"),rs.getString("numero"),rs.getString("cep"),rs.getString("cidade"),rs.getString("telefone"),rs.getString("celular"),rs.getString("email"));
        }
        pst.close();
        return clij;
    }
    
    public Cliente BuscarCliente(String codigo) throws SQLException {
        sql = "SELECT * FROM cliente WHERE idcliente = " + codigo;
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Cliente cli = null;
        while (rs.next()) {
            cli = new Cliente(
                    rs.getInt("idcliente"),
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("bairro"),
                    rs.getString("numero"),
                    rs.getString("cep"),
                    rs.getString("cidade"),
                    rs.getString("telefone"),
                    rs.getString("celular"),
                    rs.getString("email"));
        }
        pst.close();
        return cli;
    }
    
    
       public void alterarF(ClienteFisico cliente) throws SQLException{
        sql = "update cliente set nome=?, endereco=?, bairro=?, celular=?, telefone=?, cidade=?, cep=?, numero=?, email=? where idcliente=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getEndereco());
        pst.setString(3, cliente.getBairro());
        pst.setString(4, cliente.getCelular());
        pst.setString(5, cliente.getTelefone());
        pst.setString(6, cliente.getCidade());
        pst.setString(7, cliente.getCep());
        pst.setString(8, cliente.getNumero());
        pst.setString(9, cliente.getEmail());
        
        pst.setInt(10, cliente.getIdCliente());
        pst.execute();
        
        sql = "update cliente_fisico set cpf=?, rg=?, dtNascimento=?  where idcliente=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, cliente.getCpf());
        pst.setString(2, cliente.getRg());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = java.sql.Date.valueOf(sdf.format(cliente.getDtaNascimento()));
        pst.setDate(3, date);
        
        pst.setInt(4, cliente.getIdCliente());
        pst.executeUpdate();
        pst.close();
    }
       public void alterarJ(ClienteJuridico cliente) throws SQLException{
        sql = "update cliente set nome=?, endereco=?, bairro=?, celular=?, telefone=?, cidade=?, cep=?, numero=?, email=? where idcliente=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getEndereco());
        pst.setString(3, cliente.getBairro());
        pst.setString(4, cliente.getCelular());
        pst.setString(5, cliente.getTelefone());
        pst.setString(6, cliente.getCidade());
        pst.setString(7, cliente.getCep());
        pst.setString(8, cliente.getNumero());
        pst.setString(9, cliente.getEmail());
        pst.setInt(10, cliente.getIdCliente());
        pst.executeUpdate();
//        pst.execute();
        
        pst.setInt(10, cliente.getIdCliente());
       
        
        
        sql = "update cliente_juridico set cnpj=?, inscricaoEstadual=?, fundacao=?  where idcliente=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, cliente.getCnpj());
        pst.setString(2, cliente.getInscricaoEstadual());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = java.sql.Date.valueOf(sdf.format(cliente.getFundacao()));
        pst.setDate(3, date);
        
        pst.setInt(4, cliente.getIdCliente());
        pst.executeUpdate();
        pst.close();
    }
       
        public void excluirJ(ClienteJuridico cliente) throws SQLException{
        sql = "delete from cliente_juridico where idcliente=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, cliente.getIdCliente());
        pst.execute();
        sql = "delete from cliente where idcliente=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, cliente.getIdCliente());
        pst.execute();
        pst.close();
    }
        
               public void excluirF(ClienteFisico cliente) throws SQLException{
        sql = "delete from cliente_fisico where idcliente=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, cliente.getIdCliente());
        pst.execute();
        sql = "delete from cliente where idcliente=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, cliente.getIdCliente());
        pst.execute();
        pst.close();
    }


}



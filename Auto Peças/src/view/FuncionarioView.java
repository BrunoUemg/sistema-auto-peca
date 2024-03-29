/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.FuncionarioDAO;
import DAO.Session;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

/**
 *
 * @author serpa
 */
public class FuncionarioView extends javax.swing.JInternalFrame {

    Funcionario funcionario;
    FuncionarioDAO funcionarioDAO;

    /**
     * Creates new form Fornecedor
     */
    public FuncionarioView() {
        funcionarioDAO = new FuncionarioDAO();
        initComponents();
        this.setVisible(true);
        Session session = Session.getInstance();
        if ("Financeiro".equals(session.getCargo())) {
            btnNovo.setVisible(false);
            btnSalvar.setVisible(false);
            btnExcluir.setVisible(false);
            btnAlterar.setVisible(false);
            btnCancelar.setVisible(false);
        }
        try {
            readFuncionarioTable();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readFuncionarioTable() throws SQLException {
        DefaultTableModel modelFunc = (DefaultTableModel) tbFuncionario.getModel();
        modelFunc.setNumRows(0);
        for (Funcionario func : funcionarioDAO.readFuncionarios()) {
            modelFunc.addRow(new Object[]{
                func.getIdFuncionario(),
                func.getNome(),
                func.getCargo(),
                func.getCelular(),
                func.getEmail()
            });

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFornecedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtNum = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JFormattedTextField();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        cbbCargo = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tbFornecedor = new javax.swing.JScrollPane();
        tbFuncionario = new javax.swing.JTable();

        setClosable(true);
        setTitle("Funcionarios");

        jLabel1.setText("Código");

        jLabel3.setText("Nome");

        jLabel4.setText("Cargo");

        jLabel5.setText("CPF");

        jLabel6.setText("Telefone");

        jLabel7.setText("Celular");

        jLabel8.setText("E-mail");

        jLabel9.setText("Endereço");

        jLabel10.setText("Bairro");

        jLabel11.setText("Número");

        jLabel12.setText("Usuário");

        jLabel13.setText("Senha");

        txtCodigo.setEditable(false);

        txtNome.setEnabled(false);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        cbbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Financeiro", "Vendedor" }));
        cbbCargo.setEnabled(false);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFornecedorLayout = new javax.swing.GroupLayout(PanelFornecedor);
        PanelFornecedor.setLayout(PanelFornecedorLayout);
        PanelFornecedorLayout.setHorizontalGroup(
            PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PanelFornecedorLayout.createSequentialGroup()
                            .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PanelFornecedorLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(25, 25, 25)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelFornecedorLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(29, 29, 29)
                                    .addComponent(cbbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(95, 95, 95))
                                .addGroup(PanelFornecedorLayout.createSequentialGroup()
                                    .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addGap(49, 49, 49)
                                    .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(PanelFornecedorLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(46, 46, 46)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11)))
                            .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelFornecedorLayout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(63, 63, 63)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelFornecedorLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(72, 72, 72)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSenha))
                        .addGroup(PanelFornecedorLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(31, 31, 31)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelFornecedorLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(39, 39, 39)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFornecedorLayout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(616, Short.MAX_VALUE))
        );
        PanelFornecedorLayout.setVerticalGroup(
            PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFornecedorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(PanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)))
        );

        tbFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Cargo", "Celular", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFuncionarioMouseClicked(evt);
            }
        });
        tbFornecedor.setViewportView(tbFuncionario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tbFornecedor)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tbFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        funcionario = new Funcionario();
//       Funcionario cargo = (Funcionario) cbbCargo.getSelectedItem();
        if(txtNome.getText().isEmpty() || txtCpf.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos");
            txtNome.requestFocus();
        }else{
        funcionario.setCargo((String) cbbCargo.getSelectedItem());
        funcionario.setNome(txtNome.getText());
        funcionario.setCpf(txtCpf.getText());
        funcionario.setTelefone(txtTelefone.getText());
        funcionario.setCelular(txtCelular.getText());
        funcionario.setEmail(txtEmail.getText());
        funcionario.setEndereco(txtEndereco.getText());
        funcionario.setBairro(txtBairro.getText());
        funcionario.setNumero(txtNum.getText());
        funcionario.setUsuario(txtUsuario.getText());
        funcionario.setSenha(txtSenha.getText());

        try {
            JOptionPane.showMessageDialog(null, funcionarioDAO.salvarFuncionario(funcionario));
            readFuncionarioTable();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorView.class.getName()).log(Level.SEVERE, null, ex);
        }
        desabilita();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tbFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFuncionarioMouseClicked
        if (tbFuncionario.getSelectedRow() != -1) {
            try {
                funcionario = funcionarioDAO.BuscarFuncionario(tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(), 0).toString());
                txtCodigo.setText(String.valueOf(funcionario.getIdFuncionario()));
                txtNome.setText(funcionario.getNome());
                cbbCargo.setSelectedItem(funcionario.getCargo());
                txtCpf.setText(funcionario.getCpf());
                txtTelefone.setText(funcionario.getTelefone());
                txtCelular.setText(funcionario.getCelular());
                txtEmail.setText(funcionario.getEmail());
                txtEndereco.setText(funcionario.getEndereco());
                txtNum.setText(funcionario.getNumero());
                txtBairro.setText(funcionario.getBairro());
                txtUsuario.setText(funcionario.getUsuario());
                txtSenha.setText(null);
                preparaAlterar();
            } catch (SQLException ex) {
                Logger.getLogger(FornecedorView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_tbFuncionarioMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um funcionario na tabela");
            txtNome.requestFocus();
        } else {

            funcionario = new Funcionario();
            funcionario.setCargo((String) cbbCargo.getSelectedItem());
            funcionario.setNome(txtNome.getText());
            funcionario.setCpf(txtCpf.getText());
            funcionario.setTelefone(txtTelefone.getText());
            funcionario.setCelular(txtCelular.getText());
            funcionario.setEmail(txtEmail.getText());
            funcionario.setEndereco(txtEndereco.getText());
            funcionario.setBairro(txtBairro.getText());
            funcionario.setNumero(txtNum.getText());
            funcionario.setUsuario(txtUsuario.getText());
            funcionario.setSenha(txtSenha.getText());
            funcionario.setIdFuncionario(Integer.parseInt(txtCodigo.getText()));
            try {
                JOptionPane.showMessageDialog(null, funcionarioDAO.alterarFuncionario(funcionario));
                readFuncionarioTable();
            } catch (SQLException ex) {
                Logger.getLogger(FornecedorView.class.getName()).log(Level.SEVERE, null, ex);
            }
            desabilita();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        funcionario = new Funcionario();
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um funcionario");

        } else {
            funcionario.setIdFuncionario((int) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(), 0));
            int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir:" + txtNome.getText());
            if (confirma == 0) {
                try {
                    JOptionPane.showMessageDialog(null, funcionarioDAO.excluirFuncionario(funcionario));
                    readFuncionarioTable();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
                }
                desabilita();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       preparaNovo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desabilita();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void preparaNovo(){
        txtNome.setText("");
        txtBairro.setText("");
        txtCelular.setText("");
        txtCodigo.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtNum.setText("");
        txtSenha.setText("");
        txtTelefone.setText("");
        txtUsuario.setText("");
        txtEndereco.setText("");
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        txtNome.setEnabled(true);
        cbbCargo.setEnabled(true);
        btnNovo.setEnabled(false);
        
    }
    
    public void desabilita(){
        txtNome.setText("");
        txtBairro.setText("");
        txtCelular.setText("");
        txtCodigo.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtNum.setText("");
        txtSenha.setText("");
        txtTelefone.setText("");
        txtUsuario.setText("");
        txtEndereco.setText("");
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        txtNome.setEnabled(false);
        cbbCargo.setEnabled(false);
        btnNovo.setEnabled(true);
    }
    
    public void preparaAlterar(){
        txtNome.setEnabled(true);
        cbbCargo.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnNovo.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFornecedor;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbbCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane tbFornecedor;
    private javax.swing.JTable tbFuncionario;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNum;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JFormattedTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

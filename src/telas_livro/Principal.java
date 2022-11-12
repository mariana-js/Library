package telas_livro;
import telas_system.Administracao;
import classes_banco.Conexao_db;
import classes_basic.Informacoes;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import telas_usuario.Assinatura_Premium;
/**
 *
 * @author maria
 */
public class Principal extends javax.swing.JFrame {
    Conexao_db conexao;
    private Connection con;
    
    String sql = "select titulo,nome_autor,descricao,capa from livro order by titulo";
    String sqlPesquisa = "select titulo,nome_autor,descricao,capa from livro where titulo = ? or nome_autor = ? order by titulo";
    /**
     * Creates new form Catalogo
     */
    public Principal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);//Para abrir a tela inteira automáticamente
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        painel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        painel2 = new javax.swing.JPanel();
        tfPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbPesquisar = new javax.swing.JLabel();
        lbAdmin = new javax.swing.JLabel();
        tabela = new javax.swing.JTable();
        painel4 = new javax.swing.JPanel();
        lbEmprestimos = new javax.swing.JLabel();
        lbCategorias = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbHistorico = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        lbRecomendados = new javax.swing.JLabel();
        lbAreaPremium = new javax.swing.JLabel();
        lbCarrinho = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Página Principal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LIVRA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 130, 50));

        painel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Quem Somos");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Informações do Sistema");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Versão 1.0");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout painel3Layout = new javax.swing.GroupLayout(painel3);
        painel3.setLayout(painel3Layout);
        painel3Layout.setHorizontalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel3Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel18)
                .addGap(43, 43, 43)
                .addComponent(jLabel19)
                .addGap(266, 266, 266)
                .addComponent(jLabel20)
                .addContainerGap(694, Short.MAX_VALUE))
        );
        painel3Layout.setVerticalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42))
                    .addGroup(painel3Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        getContentPane().add(painel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 1410, 60));

        painel2.setBackground(new java.awt.Color(0, 0, 0, 80));

        tfPesquisa.setBackground(new java.awt.Color(0, 0, 0));
        tfPesquisa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfPesquisa.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisar:");

        lbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        lbPesquisar.setText("  ");
        lbPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPesquisarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painel2Layout = new javax.swing.GroupLayout(painel2);
        painel2.setLayout(painel2Layout);
        painel2Layout.setHorizontalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        painel2Layout.setVerticalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lbPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(painel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 650, 60));

        lbAdmin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lbAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAdminMouseClicked(evt);
            }
        });
        getContentPane().add(lbAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 100, 30));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Autor", "Descrição", "Imagem"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        getContentPane().add(tabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 1180, 350));
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(3).setResizable(false);
        }

        painel4.setBackground(new java.awt.Color(0, 0, 0));

        lbEmprestimos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbEmprestimos.setForeground(new java.awt.Color(255, 255, 255));
        lbEmprestimos.setText("EMPRESTIMOS");
        lbEmprestimos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEmprestimosMouseClicked(evt);
            }
        });

        lbCategorias.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbCategorias.setForeground(new java.awt.Color(255, 255, 255));
        lbCategorias.setText("CATEGORIAS");
        lbCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbHistorico.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHistorico.setForeground(new java.awt.Color(255, 255, 255));
        lbHistorico.setText("HISTÓRICO");
        lbHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbPerfil.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbPerfil.setForeground(new java.awt.Color(255, 255, 255));
        lbPerfil.setText("PERFIL");
        lbPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPerfilMouseClicked(evt);
            }
        });

        lbRecomendados.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbRecomendados.setForeground(new java.awt.Color(255, 255, 255));
        lbRecomendados.setText("RECOMENDADOS");
        lbRecomendados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbAreaPremium.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbAreaPremium.setForeground(new java.awt.Color(255, 255, 255));
        lbAreaPremium.setText("ÁREA PREMIUM");
        lbAreaPremium.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAreaPremium.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAreaPremiumMouseClicked(evt);
            }
        });

        lbCarrinho.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbCarrinho.setForeground(new java.awt.Color(255, 255, 255));
        lbCarrinho.setText("CARRINHO");
        lbCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCarrinhoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painel4Layout = new javax.swing.GroupLayout(painel4);
        painel4.setLayout(painel4Layout);
        painel4Layout.setHorizontalGroup(
            painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lbEmprestimos)
                .addGap(97, 97, 97)
                .addComponent(lbCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(lbHistorico)
                .addGap(98, 98, 98)
                .addComponent(lbRecomendados)
                .addGap(86, 86, 86)
                .addComponent(lbAreaPremium)
                .addGap(102, 102, 102)
                .addComponent(lbCarrinho)
                .addGap(138, 138, 138)
                .addComponent(lbPerfil)
                .addGap(70, 70, 70))
        );
        painel4Layout.setVerticalGroup(
            painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmprestimos)
                    .addComponent(lbCategorias)
                    .addComponent(jLabel13)
                    .addComponent(lbPerfil)
                    .addComponent(lbHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbRecomendados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAreaPremium, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCarrinho))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(painel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1360, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 700));

        setSize(new java.awt.Dimension(1380, 735));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {                                  
            // Ao abrir a tela principal exibir os livros e se for administrador a opção para as ferramentas do admin:
            Integer eAdmin = Integer.parseInt(Informacoes.eAdmin);
            
            conexao = new Conexao_db();
            
            try {
                con = (Connection) Conexao_db.Conectar();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreencherTabela(sql);
            
            
            System.out.println(eAdmin);
            if(eAdmin == 1){
                lbAdmin.setText("Administrador");
            } else {
                lbAdmin.setText("");
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Conexao_db.Desconectar();
  
    }//GEN-LAST:event_formWindowClosing

    private void lbAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAdminMouseClicked
        // Ao clicar em admin exibir página com as ferramentas do administrador:
        Integer eAdmin = Integer.parseInt(Informacoes.eAdmin);
        if(eAdmin == 1){
            Administracao adm = new Administracao();
            adm.setVisible(true);
            dispose();
            
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não possui previlégios para acessar as ferramentas de administrador!", "Não permitido!", 2);
    
        }
    }//GEN-LAST:event_lbAdminMouseClicked

    private void lbCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCarrinhoMouseClicked
        // Ao clicar em Carrinho:
        Carrinho carrinho = new Carrinho();
        carrinho.setVisible(true);
    }//GEN-LAST:event_lbCarrinhoMouseClicked

    private void lbPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPerfilMouseClicked
        // Ao clicar em Perfil:
        Perfil_Usuario perfil = new Perfil_Usuario();
        perfil.setVisible(true);
    }//GEN-LAST:event_lbPerfilMouseClicked

    private void lbEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEmprestimosMouseClicked
        // Ao clicar em emprestimos:
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setVisible(true);
    }//GEN-LAST:event_lbEmprestimosMouseClicked
    public void PreencherTabela(String sql) throws SQLException{ 
       PreparedStatement stmt = con.prepareStatement(sql);
       ResultSet rs = stmt.executeQuery(); //Resultado do banco de dados
       
       //Gravando as informações da tabela no banco de dados
       DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
       modelo.setNumRows(0);
       
       while(rs.next()) {
          modelo.addRow(new Object[]
          {
              rs.getInt("titulo"),
              rs.getString("descricao"),
              rs.getString("nome_autor"),
              rs.getString("capa"),
          });
       
     } //Fim while
      rs.close();
      stmt.close();
    }
    private void lbAreaPremiumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAreaPremiumMouseClicked
        //Ao clicar em área premium:
        //1º Verificar se já é usuário premium:
       Boolean epremium = Boolean.valueOf(Informacoes.ePremium);
       
       if (epremium == true ){
           //Exibir os livros premium na tabela
       } else {
          Assinatura_Premium ass = new Assinatura_Premium();
          ass.setVisible(true);
       }
       
    }//GEN-LAST:event_lbAreaPremiumMouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMouseClicked

    private void lbPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPesquisarMouseClicked
        try {
            // Ao clicar na lupa:
            String pesquisa = String.valueOf(tfPesquisa.getText());
            
            if (pesquisa.length()>0){
                PreencherTabela(sqlPesquisa);
                
            } else {
                JOptionPane.showMessageDialog(null, "O campo de pesquisa precisa ser preenchido!", "Erro!", 2);
            }
                   
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbPesquisarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbAdmin;
    private javax.swing.JLabel lbAreaPremium;
    private javax.swing.JLabel lbCarrinho;
    private javax.swing.JLabel lbCategorias;
    private javax.swing.JLabel lbEmprestimos;
    private javax.swing.JLabel lbHistorico;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbRecomendados;
    private javax.swing.JPanel painel2;
    private javax.swing.JPanel painel3;
    private javax.swing.JPanel painel4;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}

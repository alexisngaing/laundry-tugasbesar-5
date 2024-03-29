package view;

/**
 *
 * @author Adit
 */

import javax.swing.JOptionPane;
import control.TransaksiControl;
import control.CucianControl;
import control.MesinControl;
import control.PelangganControl;
import exception.inputKosongException;
import exception.uangKurangException;
import java.util.List;
import javax.swing.table.TableModel;
import model.Transaksi;
import model.Cucian;
import model.Mesin;
import model.Pelanggan;
import table.TableTransaksi;

public class TransaksiView extends javax.swing.JFrame {

    private TransaksiControl tControl;
    private CucianControl cControl;
    private MesinControl mControl;
    private PelangganControl pControl;
    
    List<Transaksi> listTransaksi;
    List<Cucian> listCucian;
    List<Mesin> listMesin;
    List<Pelanggan> listPelanggan;
    
    int selectedId = 0;
    String action = null;
    
    public TransaksiView() {
        initComponents();
        setComponent(false);
        bayarInput.setEnabled(false);
        tControl = new TransaksiControl();
        cControl = new CucianControl();
        mControl = new MesinControl();
        pControl = new PelangganControl();
        showTransaksi();
    }
    
    public void setComponent(boolean value) {
        totalBiayaField.setEnabled(value);
        bayarInput.setEnabled(value);
        kembalianField.setEnabled(value);
        
        bayarBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    
    public void clearText() {
        bayarInput.setText("");
        totalBiayaField.setText("");
        kembalianField.setText("");
    }
    
//    public void setEditDeleteBtn(boolean value) {
//        
//    }
    
    public void showTransaksi() {
        tableTransaksi.setModel(tControl.showDataTransaksi(""));
    }
    
    public void inputKosongException() throws inputKosongException {
        if (bayarInput.getText().isEmpty()) {
            throw new inputKosongException();
        }
    }
    
    public void uangKurangException() throws uangKurangException {
        if (Float.parseFloat(bayarInput.getText()) < Float.parseFloat(totalBiayaField.getText())) {
            throw new uangKurangException();
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

        panel1 = new javax.swing.JPanel();
        laundryLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pelangganPanel = new javax.swing.JPanel();
        pelangganLabel = new javax.swing.JLabel();
        cucianPanel = new javax.swing.JPanel();
        cucianLabel = new javax.swing.JLabel();
        transaksiPanel = new javax.swing.JPanel();
        transaksiLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();
        searchBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        pembayaranLabel = new javax.swing.JLabel();
        bayarPanel = new javax.swing.JPanel();
        totalBiayaLabel = new javax.swing.JLabel();
        totalBiayaField = new javax.swing.JTextField();
        bayarLabel = new javax.swing.JLabel();
        bayarInput = new javax.swing.JTextField();
        kembalianLabel = new javax.swing.JLabel();
        kembalianField = new javax.swing.JTextField();
        bayarBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(63, 114, 175));

        laundryLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        laundryLabel.setForeground(new java.awt.Color(255, 255, 255));
        laundryLabel.setText("LAUNDRY");

        pelangganPanel.setBackground(new java.awt.Color(219, 226, 239));
        pelangganPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelangganPanelMouseClicked(evt);
            }
        });

        pelangganLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pelangganLabel.setText("Pelanggan");

        javax.swing.GroupLayout pelangganPanelLayout = new javax.swing.GroupLayout(pelangganPanel);
        pelangganPanel.setLayout(pelangganPanelLayout);
        pelangganPanelLayout.setHorizontalGroup(
            pelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pelangganPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pelangganLabel)
                .addGap(40, 40, 40))
        );
        pelangganPanelLayout.setVerticalGroup(
            pelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pelangganPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(pelangganLabel)
                .addContainerGap())
        );

        cucianPanel.setBackground(new java.awt.Color(219, 226, 239));
        cucianPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cucianPanelMouseClicked(evt);
            }
        });

        cucianLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cucianLabel.setText("Cucian");

        javax.swing.GroupLayout cucianPanelLayout = new javax.swing.GroupLayout(cucianPanel);
        cucianPanel.setLayout(cucianPanelLayout);
        cucianPanelLayout.setHorizontalGroup(
            cucianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cucianPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cucianLabel)
                .addGap(72, 72, 72))
        );
        cucianPanelLayout.setVerticalGroup(
            cucianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cucianPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cucianLabel)
                .addContainerGap())
        );

        transaksiPanel.setBackground(new java.awt.Color(102, 102, 255));

        transaksiLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transaksiLabel.setText("Transaksi");

        javax.swing.GroupLayout transaksiPanelLayout = new javax.swing.GroupLayout(transaksiPanel);
        transaksiPanel.setLayout(transaksiPanelLayout);
        transaksiPanelLayout.setHorizontalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transaksiLabel)
                .addGap(50, 50, 50))
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(laundryLabel)
                .addGap(30, 30, 30))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(pelangganPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cucianPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transaksiPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(laundryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(pelangganPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cucianPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(transaksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(249, 247, 247));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 27)); // NOI18N
        jLabel1.setText("Transaksi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Data Pelanggan");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTransaksi);

        searchBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        searchBtn.setText("Cari");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        pembayaranLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pembayaranLabel.setText("Pembayaran");

        bayarPanel.setBackground(new java.awt.Color(255, 255, 255));

        totalBiayaLabel.setText("Total Biaya");

        totalBiayaField.setEditable(false);
        totalBiayaField.setText("Rp.0");
        totalBiayaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBiayaFieldActionPerformed(evt);
            }
        });

        bayarLabel.setText("Uang Bayar");

        bayarInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarInputActionPerformed(evt);
            }
        });

        kembalianLabel.setText("Kembalian");

        kembalianField.setEditable(false);
        kembalianField.setText("Rp.0");
        kembalianField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalianFieldActionPerformed(evt);
            }
        });

        bayarBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        bayarBtn.setText("Bayar");
        bayarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        cancelBtn.setText("Batal");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bayarPanelLayout = new javax.swing.GroupLayout(bayarPanel);
        bayarPanel.setLayout(bayarPanelLayout);
        bayarPanelLayout.setHorizontalGroup(
            bayarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bayarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bayarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bayarPanelLayout.createSequentialGroup()
                        .addGroup(bayarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kembalianLabel)
                            .addComponent(totalBiayaLabel)
                            .addComponent(bayarLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(bayarPanelLayout.createSequentialGroup()
                        .addGroup(bayarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kembalianField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bayarInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalBiayaField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bayarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        bayarPanelLayout.setVerticalGroup(
            bayarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bayarPanelLayout.createSequentialGroup()
                .addComponent(totalBiayaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalBiayaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bayarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bayarInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kembalianLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bayarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kembalianField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bayarBtn)
                    .addComponent(cancelBtn))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addComponent(bayarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pembayaranLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn)
                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(pembayaranLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bayarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bayarInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarInputActionPerformed

    private void kembalianFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalianFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembalianFieldActionPerformed

    private void totalBiayaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBiayaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalBiayaFieldActionPerformed

    private void pelangganPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelangganPanelMouseClicked
        // TODO add your handling code here:
        PelangganView pv = new PelangganView();
        this.dispose();
        pv.setVisible(true);
    }//GEN-LAST:event_pelangganPanelMouseClicked

    private void cucianPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cucianPanelMouseClicked
        // TODO add your handling code here:
        CucianView cv = new CucianView();
        this.dispose();
        cv.setVisible(true);
    }//GEN-LAST:event_cucianPanelMouseClicked

    private void tableTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransaksiMouseClicked
        // TODO add your handling code here:
        setComponent(true);
        int clickedRow = tableTransaksi.getSelectedRow();
        TableModel tableModel = tableTransaksi.getModel();
        
        selectedId = Integer.parseInt(tableModel.getValueAt(clickedRow, 0).toString());
        totalBiayaField.setText(tableModel.getValueAt(clickedRow, 4).toString());
    }//GEN-LAST:event_tableTransaksiMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
//        setEditDeleteBtn(false);
        setComponent(false);

        try {
            TableTransaksi transaksi = tControl.showDataTransaksi(searchInput.getText());
            if (transaksi.getRowCount() == 0){
                clearText();
//                setEditDeleteBtn(false);
                JOptionPane.showConfirmDialog(rootPane, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            } else {
                tableTransaksi.setModel(transaksi);
            }
        } catch(Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void bayarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarBtnActionPerformed
        // TODO add your handling code here:
        float kembalian = 0;
        try{
            inputKosongException();
            if(Float.parseFloat(bayarInput.getText()) < Float.parseFloat(totalBiayaField.getText())){
                JOptionPane.showMessageDialog(null, "Uang pembayaran kurang!");
            }else{
                kembalian = Float.parseFloat(bayarInput.getText()) - Float.parseFloat(totalBiayaField.getText());
                kembalianField.setText("Rp." + kembalian);
                JOptionPane.showMessageDialog(null, "Pembayaran Berhasil!");
                int clickedRow = tableTransaksi.getSelectedRow();
                TableModel tableModel = tableTransaksi.getModel();
                tControl.deleteTransaksi(selectedId);
                showTransaksi();
                selectedId = 0;
                totalBiayaField.setText("Rp.0");
                bayarInput.setText("");
                kembalianField.setText("Rp.0");
                setComponent(false);
            }
        }catch(inputKosongException e){
            JOptionPane.showMessageDialog(this, e.message());
        } 
            
    }//GEN-LAST:event_bayarBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        selectedId = 0;
        totalBiayaField.setText("Rp.0");
        bayarInput.setText("");
        setComponent(false);
        showTransaksi();
    }//GEN-LAST:event_cancelBtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bayarBtn;
    private javax.swing.JTextField bayarInput;
    private javax.swing.JLabel bayarLabel;
    private javax.swing.JPanel bayarPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel cucianLabel;
    private javax.swing.JPanel cucianPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField kembalianField;
    private javax.swing.JLabel kembalianLabel;
    private javax.swing.JLabel laundryLabel;
    private javax.swing.JPanel panel1;
    private javax.swing.JLabel pelangganLabel;
    private javax.swing.JPanel pelangganPanel;
    private javax.swing.JLabel pembayaranLabel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTable tableTransaksi;
    private javax.swing.JTextField totalBiayaField;
    private javax.swing.JLabel totalBiayaLabel;
    private javax.swing.JLabel transaksiLabel;
    private javax.swing.JPanel transaksiPanel;
    // End of variables declaration//GEN-END:variables
}

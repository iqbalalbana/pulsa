/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormPulsa.java
 *
 * Created on Jan 11, 2013, 8:30:01 AM
 */
package pulsa;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Otz
 */
public class FormPulsa extends javax.swing.JFrame {

    Connection Con;
    ResultSet RsTabel;
    Statement stm;
    private Object[][] dataTabel = null;
    private String[] headerHarga = {"KODE", "KETERANGAN", "HARGA"};
    private String[] headerDep = {"TANGGAL DEPOSIT", "NOMINAL"};
    private String[] headerTran = {"TANGGAL TRANSAKSI","KODE","KETERANGAN", "NO HANDPHONE", "HARGA"};

    /** Creates new form FormPulsa */
    public FormPulsa() {
        initComponents();
        open_db();
        baca_data_harga();
        baca_kode();
        baca_data_trans();
        baca_data_dep();
        tgl();

    }
    private void tgl() {
        Date now = new Date();
        SimpleDateFormat frm = new SimpleDateFormat("d-M-Y");
        String tgl = frm.format(now);
        JlabelTgl.setText(tgl);
        JlabelTgl1.setText(tgl);
    }
    private void baca_kode() {
        try {
            stm = (Statement) Con.createStatement();
            RsTabel = stm.executeQuery("select kode from daftar_harga");
            ResultSetMetaData meta = (ResultSetMetaData) RsTabel.getMetaData();
            int count = 0;
            while (RsTabel.next()) {
                jComboBoxKode.insertItemAt(RsTabel.getString("kode"), count);
                count++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    private void hapus(){
    jTextFieldNoHp.setText("");
    jComboBoxKode.setSelectedItem(null);
    jTextFieldKet.setText(null);
    jTextFieldHarga.setText(null);
    jTextFielddEP.setText(null);
    jTextFieldKode.setText(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPulsa = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelHarga = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextFieldKode = new javax.swing.JTextField();
        jTextFieldKet = new javax.swing.JTextField();
        jTextFieldHarga = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxKode = new javax.swing.JComboBox();
        jTextFieldNoHp = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTrx = new javax.swing.JTable();
        jButtonProses = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JlabelTgl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanelDep = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDep = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        JlabelTgl1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFielddEP = new javax.swing.JTextField();
        jButtonDep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FORM PENGISIAN PULSA");

        PanelPulsa.setBackground(new java.awt.Color(204, 255, 204));
        PanelPulsa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("APLIKASI PENGISIAN PULSA");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jTabbedPane1.setBackground(new java.awt.Color(51, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TabelHarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "KODE", "KETERANGAN", "HARGA"
            }
        ));
        jScrollPane1.setViewportView(TabelHarga);

        jLabel2.setText("KODE");

        jLabel3.setText("KETERANGAN");

        jLabel4.setText("HARGA");

        jButton1.setText("Simpan");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldHarga)
                            .addComponent(jTextFieldKet)
                            .addComponent(jTextFieldKode, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldKet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("DAFTAR HARGA", jPanel2);

        jLabel5.setText("NO HANDPHONE");

        jLabel6.setText("KODE ");

        jTableTrx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "KODE", "KETERANGAN", "NO HANDPHONE", "HARGA"
            }
        ));
        jScrollPane2.setViewportView(jTableTrx);

        jButtonProses.setText("Proses");
        jButtonProses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonProsesMouseClicked(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel7.setText("TANGGAL :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonProses)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxKode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldNoHp, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addComponent(JlabelTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonProses)
                            .addComponent(jButton3)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(JlabelTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("DAFTAR TRANSAKSI", jPanel3);

        jTableDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "TANGGAL DEPOSIT", "NOMINAL"
            }
        ));
        jScrollPane3.setViewportView(jTableDep);

        jLabel8.setText("TANGGAL :");

        jLabel9.setText("NOMINAL");

        jButtonDep.setText("DEPOSIT");
        jButtonDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDepMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDepLayout = new javax.swing.GroupLayout(jPanelDep);
        jPanelDep.setLayout(jPanelDepLayout);
        jPanelDepLayout.setHorizontalGroup(
            jPanelDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDepLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlabelTgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jTextFielddEP, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDep, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );
        jPanelDepLayout.setVerticalGroup(
            jPanelDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDepLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jTextFielddEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDep))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDepLayout.createSequentialGroup()
                        .addGroup(jPanelDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JlabelTgl1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DEPOSIT", jPanelDep);

        javax.swing.GroupLayout PanelPulsaLayout = new javax.swing.GroupLayout(PanelPulsa);
        PanelPulsa.setLayout(PanelPulsaLayout);
        PanelPulsaLayout.setHorizontalGroup(
            PanelPulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelPulsaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane1)
                .addGap(10, 10, 10))
        );
        PanelPulsaLayout.setVerticalGroup(
            PanelPulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPulsaLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        hapus();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String KdPulsa = jTextFieldKode.getText();
        String KetPulsa = jTextFieldKet.getText();
        String HargaPulsa = jTextFieldHarga.getText();
        String id = "0";
        if ("".equals(KdPulsa) || "".equals(KetPulsa) || "".equals(HargaPulsa)) {
            JOptionPane.showMessageDialog(PanelPulsa, "Data tidak boleh kosong", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                 stm.executeUpdate("INSERT INTO daftar_harga VALUES('" + id + "','" + KdPulsa + "','" + KetPulsa + "','" + HargaPulsa + "')");
                 baca_data_harga();
                 hapus();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        hapus();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButtonProsesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProsesMouseClicked
        String NoHp = jTextFieldNoHp.getText();
        String Kd = (String) jComboBoxKode.getSelectedItem();
        String tanggalan = JlabelTgl.getText();
        String id = "0";
        if ("".equals(NoHp) || Kd==null) {
            JOptionPane.showMessageDialog(PanelPulsa, "Data tidak boleh kosong", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                 stm.executeUpdate("INSERT INTO transaksi VALUES('" + id + "','" + NoHp + "','" + Kd + "','" + tanggalan + "')");
                  stm.executeUpdate("update deposit set nominal=nominal-(select harga from daftar_harga where kode='" + Kd + "')");
                 baca_data_trans();
                 baca_data_dep();
                 hapus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButtonProsesMouseClicked

    private void jButtonDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDepMouseClicked
        String tgldep = JlabelTgl1.getText();
        String nom = jTextFielddEP.getText();
        String id = "0";
        if ("".equals(tgldep) || "".equals(nom)) {
            JOptionPane.showMessageDialog(jPanelDep, "Data tidak boleh kosong", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                 stm.executeUpdate("update deposit set tgl_dep='" + tgldep + "',nominal=nominal+'" + nom + "'");
                 baca_data_dep();
                hapus();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButtonDepMouseClicked
    

    private void open_db() {
        try {
            Koneksi konek = new Koneksi("localhost", "root", "", "pulsa");
            Con = konek.getConnection();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private void baca_data_harga() {
        try {
            stm = (Statement) Con.createStatement();
            RsTabel = stm.executeQuery("select kode,ket,harga from daftar_harga");

            ResultSetMetaData meta = (ResultSetMetaData) RsTabel.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (RsTabel.next()) {
                baris = RsTabel.getRow();
            }

            dataTabel = new Object[baris][col];
            int x = 0;
            RsTabel.beforeFirst();
            while (RsTabel.next()) {
                dataTabel[x][0] = RsTabel.getString("kode");
                dataTabel[x][1] = RsTabel.getString("ket");
                dataTabel[x][2] = RsTabel.getString("harga");
                x++;
            }
            TabelHarga.setModel(new DefaultTableModel(dataTabel, headerHarga));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     private void baca_data_dep() {
        try {
            stm = (Statement) Con.createStatement();
            RsTabel = stm.executeQuery("select tgl_dep,nominal from deposit");

            ResultSetMetaData meta = (ResultSetMetaData) RsTabel.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (RsTabel.next()) {
               
                baris = RsTabel.getRow();
            }

            dataTabel = new Object[baris][col];
            int x = 0;
            RsTabel.beforeFirst();
            while (RsTabel.next()) {
                dataTabel[x][0] = RsTabel.getString("tgl_dep");
                dataTabel[x][1] = RsTabel.getString("nominal");
                x++;
            }
            jTableDep.setModel(new DefaultTableModel(dataTabel, headerDep));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void baca_data_trans() {
        try {
            stm = (Statement) Con.createStatement();
            RsTabel = stm.executeQuery("select t.tgl_trx, t.kode, t.no_hp,d.ket, d.harga from transaksi t, daftar_harga d where t.kode=d.kode");
            ResultSetMetaData meta = (ResultSetMetaData) RsTabel.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (RsTabel.next()) {
                baris = RsTabel.getRow();
            }

            dataTabel = new Object[baris][col];
            int x = 0;
            RsTabel.beforeFirst();
            while (RsTabel.next()) {
                dataTabel[x][0] = RsTabel.getString("t.tgl_trx");
                dataTabel[x][1] = RsTabel.getString("t.kode");
                dataTabel[x][2] = RsTabel.getString("d.ket");
                dataTabel[x][3] = RsTabel.getString("t.no_hp");
                dataTabel[x][4] = RsTabel.getString("d.harga");
                x++;
            }
            jTableTrx.setModel(new DefaultTableModel(dataTabel, headerTran));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

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
            java.util.logging.Logger.getLogger(FormPulsa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPulsa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPulsa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPulsa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FormPulsa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlabelTgl;
    private javax.swing.JLabel JlabelTgl1;
    private javax.swing.JPanel PanelPulsa;
    private javax.swing.JTable TabelHarga;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonDep;
    private javax.swing.JButton jButtonProses;
    private javax.swing.JComboBox jComboBoxKode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelDep;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDep;
    private javax.swing.JTable jTableTrx;
    private javax.swing.JTextField jTextFieldHarga;
    private javax.swing.JTextField jTextFieldKet;
    private javax.swing.JTextField jTextFieldKode;
    private javax.swing.JTextField jTextFieldNoHp;
    private javax.swing.JTextField jTextFielddEP;
    // End of variables declaration//GEN-END:variables
}

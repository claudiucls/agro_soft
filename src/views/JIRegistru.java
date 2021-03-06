/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dbUtil.DBConnect;
import dbUtil.Formatare;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import models.Document;
import models.Registru;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import services.DBQueries;

/**
 *
 * @author Claudiu
 */
public class JIRegistru extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIListaAngajati
     */
    private DBQueries db;
    private List<Document> docs;
    private double totIncasari = 0;
    private double totPlati = 0;
    private double sold = 0;
    private boolean validat;
    private static Registru r;
    private LocalDate today = LocalDate.now();
    private DecimalFormat df = new DecimalFormat("#.00");
            

    public JIRegistru() {
        initComponents();
        db = new DBQueries();
        setLocation(setCenterPoint());
        Locale local = new Locale("ro", "ro");
        jDateChooser1.setLocale(local);
        jTable1.setComponentPopupMenu(jPopupMenu1);
        clear();
    }

    public Point setCenterPoint() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Point p = new Point(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        return p;
    }

    public void clear() {
        jTextField1.setText(String.valueOf(db.getLastRegistruNrByYear(today)-1));
        jDateChooser1.setDate(null);
        docs = new ArrayList<>();
        refreshTableDocumente();
        soldPrecendetTxt.setText(String.valueOf(df.format(db.getSold(today))));
        totIncasari = 0;
        totPlati = 0;
        sold = 0;
        incasariTxt.setText(String.valueOf(totIncasari));
        platiTxt.setText(String.valueOf(totPlati));
        soldTxt.setText(String.valueOf(sold));
        idDoc.setVisible(false);
        idDoc.setText(String.valueOf("1"));
        validat = false;
        r = null;
    }

    public void clearDoc() {
        actTxt.setText("");
        explicatieTxt.setText("");
        valoareTxt.setText("");
        getTotIncasari();
        getTotPlati();
        incasariTxt.setText(String.valueOf(totIncasari));
        platiTxt.setText(String.valueOf(totPlati));
        soldTxt.setText(String.valueOf(df.format(db.getSold(today) + totIncasari - totPlati)));
        idDoc.setText(String.valueOf(docs.size() + 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        explicatieTxt = new javax.swing.JTextField();
        valoareTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        actTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        idDoc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        soldPrecendetTxt = new javax.swing.JTextField();
        incasariTxt = new javax.swing.JTextField();
        platiTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        soldTxt = new javax.swing.JTextField();

        jMenuItem1.setText("Modificare");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Stergere");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseReleased(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setClosable(true);
        setTitle("Registru de casa");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nr. Registru");

        jLabel2.setText("din Data");

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Explicatie");

        jLabel3.setText("Tip Document");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("PLATA");

        jLabel4.setText("Nr. act casa");

        jLabel6.setText("Valoare ");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("INCASARE");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Adauga");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        idDoc.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addGap(227, 227, 227)
                        .addComponent(idDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(explicatieTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valoareTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(idDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(actTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(valoareTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(explicatieTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setForeground(new java.awt.Color(0, 204, 0));
        jButton1.setText("<html>Salvare in  Registru de Casa</html>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Sold Precedent");

        jLabel8.setText("Total Incasari");

        jLabel11.setText("Total Plati");

        soldPrecendetTxt.setEditable(false);

        incasariTxt.setEditable(false);

        platiTxt.setEditable(false);

        jLabel12.setText("SOLD");

        soldTxt.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soldPrecendetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incasariTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(platiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soldTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(soldPrecendetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(incasariTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(platiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(soldTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(jButton1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void checkSold() {
        if (!(db.getLastRegistruId() > 1)) {
            String soldi = JOptionPane.showInputDialog(this, "Nu s-a gasit nicio inregistrare in registru de casa\n Introduceti soldul initial");
            Document d = new Document(1, "0", "Sold Initial",Double.parseDouble(soldi), 0);
            db.addDocInRegistru(d, 1);
            soldPrecendetTxt.setText(df.format(soldi));
        } else {
            soldPrecendetTxt.setText(String.valueOf(df.format(db.getSold(today))));
        }
    }

    public void refreshTableDocumente() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        List<Document> ds = docs;
        model.setColumnIdentifiers(new Object[]{"Nr.", "Nr. Act Casa", "Explicatie", "Incasari", "Plati"});
        Object[] row = new Object[5];
        for (int i = 0; i < ds.size(); i++) {
            row[0] = i + 1;
            row[1] = ds.get(i).getNrDoc();
            row[2] = ds.get(i).getExplicatie();
            row[3] = ds.get(i).getIntrare();
            row[4] = ds.get(i).getIesire();
            model.addRow(row);
        }

        jTable1.setModel(model);
        db.resizeColumnWidth(jTable1);
    }

    public void getTotIncasari() {
        totIncasari = 0;
        for (Document doc : docs) {
            totIncasari += doc.getIntrare();
        }
    }

    public void getTotPlati() {
        totPlati = 0;
        for (Document doc : docs) {
            totPlati += doc.getIesire();
        }
    }


    private void jMenuItem2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseReleased
        int row = jTable1.getSelectedRow();
        int id = (int) jTable1.getModel().getValueAt(row, 0);
        int rezult = JOptionPane.showConfirmDialog(null, "Sunteti sigur ca vreti sa stergeti?", " Confirmati stergerea", JOptionPane.YES_NO_OPTION);
        if (rezult == JOptionPane.YES_OPTION) {
            docs.remove(id - 1);
        }
        refreshTableDocumente();
        clearDoc();

    }//GEN-LAST:event_jMenuItem2MouseReleased

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        int row = jTable1.getSelectedRow();
        int id = (int) jTable1.getModel().getValueAt(row, 0) - 1;
        Document d = docs.get(id);
        actTxt.setText(d.getNrDoc());
        explicatieTxt.setText(d.getExplicatie());
        idDoc.setText(String.valueOf(d.getId()));
        if (d.getIntrare() == 0) {
            valoareTxt.setText(String.valueOf(d.getIesire()));
            jRadioButton2.setSelected(true);
        } else {
            valoareTxt.setText(String.valueOf(d.getIesire()));
            jRadioButton1.setSelected(true);
        }
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        checkSold();
        LocalDate date = null;
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Nu ati introdus data sau data invalida");
            return;
        } else {
            date = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ultima = db.getLastRegistruDate();
            if (ultima != null) {
                if (date.isBefore(ultima) || date.isEqual(ultima)) {
                    JOptionPane.showMessageDialog(null, "Exita o inregistrare cu o data precedenta sau egala cu cea selectata");
                    return;
                }
            }
        }
        if (Formatare.formatStringAsDouble(soldTxt.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Soldul nu trebuie sa fie negativ revizuiti documentele");
            return;
        }
        r = new Registru(Integer.parseInt(jTextField1.getText()),
                date,
                Formatare.formatStringAsDouble(soldPrecendetTxt.getText()),
                Formatare.formatStringAsDouble(soldTxt.getText()));

        if (!db.addRegistru(r)) {
            JOptionPane.showMessageDialog(null, "A aparut o eroare la salvarea Registrului de casa");
            return;
        }
        r.setId(db.getLastRegistruId());
        if (!docs.isEmpty()) {
            for (Document d : docs) {
                if (!db.addDocInRegistru(d, r.getId())) {
                    JOptionPane.showMessageDialog(null, "A aparut o eroare la salvarea documentului in registru");
                    return;
                }
            }
        }
        Map<String, Object> params = new HashMap<>();
        params.put("data", r.getDate());
        params.put("soldi",r.getSorldI());
        String absolutePath = "D:\\Ags_Soft\\Program Sursa\\rapoarte\\";
        params.put("SUBREPORT_DIR", absolutePath);
        Connection conn = DBConnect.getConnection();
        try {
            InputStream in = getClass().getResourceAsStream("/rapoarte/registru.jasper");
            JasperPrint jp = JasperFillManager.fillReport(in, params, conn);
            if (jp.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nu sunt inregistrari de afisat!");
                return;
            } else {
                JRViewer viewer1 = new JRViewer(jp);
                JFrame jf = new JFrame();
                jf.setLocation(0, 0);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                jf.setSize(dim);
                jf.add(viewer1);
                jf.setVisible(true);
                jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

        } catch (JRException ex) {
            Logger.getLogger(JIListareRegistre.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.hide();
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (actTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu ati introdus numarul de act casa al documentului");
            return;
        }
        if (explicatieTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu ati introdus explicatia documentului");
            return;
        }
        double nr = Formatare.formatStringAsDouble(valoareTxt.getText());
        double val = 0;
        if (nr != -1) {
            val = nr;
        } else {
            JOptionPane.showMessageDialog(null, "Valoarea introdus nu este un numar corect!");
            return;
        }
        double valIntrare = 0;
        double valIesire = 0;
        String tip = "";
        if (jRadioButton1.isSelected()) {
            valIntrare = val;
        } else if (jRadioButton2.isSelected()) {
            valIesire = val;
        }
        Document d = new Document(Integer.parseInt(idDoc.getText()), actTxt.getText(), explicatieTxt.getText(), valIntrare, valIesire);
        for (int i = 0; i < docs.size(); i++) {
            if (docs.get(i).equals(d)) {
                docs.set(i, d);
                refreshTableDocumente();
                clearDoc();
                return;
            }
        }
        docs.add(d);
        idDoc.setText(String.valueOf(docs.size() + 1));
        refreshTableDocumente();
        clearDoc();

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actTxt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField explicatieTxt;
    private javax.swing.JTextField idDoc;
    private javax.swing.JTextField incasariTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField platiTxt;
    private javax.swing.JTextField soldPrecendetTxt;
    private javax.swing.JTextField soldTxt;
    private javax.swing.JTextField valoareTxt;
    // End of variables declaration//GEN-END:variables
}

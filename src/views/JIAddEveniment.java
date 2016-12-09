/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Angajat;
import models.Event;
import org.apache.poi.ss.formula.functions.Days360;
import services.DBQueries;

/**
 *
 * @author Claudiu
 */
public class JIAddEveniment extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIListaAngajati
     */
    private DBQueries db;

    public JIAddEveniment() {
        initComponents();
        db = new DBQueries();
        setLocation(setCenterPoint());
        Locale local = new Locale("ro", "ro");
        dataDeLa.setLocale(local);
        dataPanaLa.setLocale(local);
        idTextField.setVisible(false);
        refreshList();
        refreshTableEvents();
        jTable1.setComponentPopupMenu(jPopupMenu1);
        idEventTxt.setVisible(false);
    }

    public Point setCenterPoint() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Point p = new Point(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        return p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void refreshList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        List<Angajat> angajati = db.findAngajati("", true);
        for (Angajat a : angajati) {
            model.addElement(a.getNume());
        }
        jList1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataDeLa = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        descriereTxt = new javax.swing.JTextField();
        numeTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        codCombo = new javax.swing.JComboBox<>();
        dataPanaLa = new com.toedter.calendar.JDateChooser();
        idEventTxt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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
        setTitle("Lista Angajati");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Adauga perioada Concedii/Libere"));

        jLabel2.setText("<html>Nume si Prenumele</html>");

        jLabel4.setText("Tip Liber");

        jLabel3.setText("Descriere");

        jLabel5.setText("Incepand cu");

        jButton1.setText("Salveaza ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        descriereTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriereTxtActionPerformed(evt);
            }
        });

        numeTxt.setEditable(false);

        jLabel6.setText("Terminand la");

        idTextField.setEditable(false);

        codCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CO - Concediu de odihna", "CM - Concediu medical", "FP - Concediu fara plata", "AN - Absent nemotivat", " " }));

        idEventTxt.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(descriereTxt)
                    .addComponent(dataPanaLa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataDeLa, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(codCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numeTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(idEventTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(descriereTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataDeLa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dataPanaLa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idEventTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("<html>Selecteaza Angajatul pentru care doresti sa faci modificari</html>");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 84, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void refreshTableEvents() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        List<Event> events = db.findAllEvents();
        model.setColumnIdentifiers(new Object[]{"nr.crt", "Descriere", "COD", "Data inceput", "Data sfarsit", "Pentru"});
        Object[] row = new Object[6];
        for (int i = 0; i < events.size(); i++) {
            row[0] = events.get(i).getId();
            row[1] = events.get(i).getDescriere();
            row[2] = events.get(i).getCod();
            row[3] = events.get(i).getDataDeLa();
            row[4] = events.get(i).getDataPanaLa();
            row[5] = db.getAngajatById(events.get(i).getAngajat()).getNume();
            model.addRow(row);
        }

        jTable1.setModel(model);
        db.resizeColumnWidth(jTable1);
    }

    private void descriereTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriereTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriereTxtActionPerformed

    public void clean() {
        numeTxt.setText("");
        descriereTxt.setText("");
        idTextField.setText("");
        idEventTxt.setText("");
        dataDeLa.setDate(null);
        dataPanaLa.setDate(null);
        codCombo.setSelectedIndex(0);

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (descriereTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Introduceti detalii despre perioada libera");
            return;
        }
        if (dataDeLa.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Nu ati introdus data de inceput");
            return;
        }
        if (dataPanaLa.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Nu ati introdus data de sfarsit");
            return;
        }
        LocalDate deLa = dataDeLa.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate panaLa = dataPanaLa.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long zile = DAYS.between(deLa, panaLa) + 1;
        if (zile < 1) {
            JOptionPane.showMessageDialog(null, "Perioada este prea mica, " + zile + " zile");
            return;
        }
        int index = codCombo.getSelectedIndex();
        String cod = "";
        switch (index) {
            case 0:
                cod = "CO";
                break;
            case 1:
                cod = "CM";
                break;
            case 2:
                cod = "FP";
                break;
            case 3:
                cod = "AN";
                break;
            case 4:
                cod = "LP";
                break;
            case 5:
                cod = "DL";
                break;
            case 6:
                cod = "X";
                break;
        }
        if (idEventTxt.getText().isEmpty()) {
            Event e = new Event(db.getLastEvent(), descriereTxt.getText(), cod,
                    deLa,
                    panaLa,
                    Integer.parseInt(idTextField.getText()));
            int rezultat = JOptionPane.showConfirmDialog(null, "Adaugati urmatorul concediu/liber de " + zile + " zile ?", "Confirmare liber Angajat!", JOptionPane.YES_NO_OPTION);
            if (rezultat == JOptionPane.YES_OPTION) {
                if (db.addEvent(e)) {
                    JOptionPane.showMessageDialog(null, "S-a inregistrat " + e.getCod() + " de " + zile + " zile pentru " + db.getAngajatById(e.getAngajat()).getNume());
                    clean();
                    refreshTableEvents();
                }
            }
        } else {
            int rezultat = JOptionPane.showConfirmDialog(null, "Adaugati urmatorul concediu/liber ?", "Confirmare liber Angajat!", JOptionPane.YES_NO_OPTION);
            if (rezultat == JOptionPane.YES_OPTION) {
                Event e = new Event(Integer.parseInt(idEventTxt.getText()), descriereTxt.getText(), cod,
                        deLa,
                        panaLa,
                        Integer.parseInt(idTextField.getText()));
                if (db.updateEvent(e)) {
                    JOptionPane.showMessageDialog(null, "S-a modificat " + e.getCod() + " de " + zile + " zile pentru " + db.getAngajatById(e.getAngajat()).getNume());
                    clean();
                    refreshTableEvents();
                }
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        String nume = jList1.getSelectedValue();
        Angajat a = db.getAngajatByName(nume);
        if (a != null) {
            idTextField.setText(String.valueOf(a.getId()));
            numeTxt.setText(a.getNume());
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jMenuItem2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseReleased
        int row = jTable1.getSelectedRow();
        int id = (int) jTable1.getModel().getValueAt(row, 0);
        int rezult = JOptionPane.showConfirmDialog(null, "Sunteti sigur ca vreti sa stergeti?", " Confirmati stergerea", JOptionPane.YES_NO_OPTION);
        if (rezult == JOptionPane.YES_OPTION) {
            if (db.deleteEvent(id)) {
                JOptionPane.showMessageDialog(null, "Concediul a fost sters!");
                refreshTableEvents();
            }
        }
    }//GEN-LAST:event_jMenuItem2MouseReleased

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        int row = jTable1.getSelectedRow();
        int id = (int) jTable1.getModel().getValueAt(row, 0);
        Event e = db.getEventById(id);
        idTextField.setText(String.valueOf(e.getAngajat()));
        idEventTxt.setText(String.valueOf(e.getId()));
        numeTxt.setText(db.getAngajatById(e.getAngajat()).getNume());
        descriereTxt.setText(e.getDescriere());
        dataDeLa.setDate(Date.valueOf(e.getDataDeLa()));
        dataPanaLa.setDate(Date.valueOf(e.getDataPanaLa()));
        String cod = e.getCod();
        switch (cod) {
            case "CO":
                codCombo.setSelectedIndex(0);
                break;
            case "CM":
                codCombo.setSelectedIndex(1);
                break;
            case "FP":
                codCombo.setSelectedIndex(2);
                break;
            case "AN":
                codCombo.setSelectedIndex(3);
                break;
            case "LP":
                codCombo.setSelectedIndex(4);
                break;
            case "D":
                codCombo.setSelectedIndex(5);
                break;
            case "X":
                codCombo.setSelectedIndex(6);
                break;
        }
    }//GEN-LAST:event_jMenuItem1MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> codCombo;
    private com.toedter.calendar.JDateChooser dataDeLa;
    private com.toedter.calendar.JDateChooser dataPanaLa;
    private javax.swing.JTextField descriereTxt;
    private javax.swing.JTextField idEventTxt;
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField numeTxt;
    // End of variables declaration//GEN-END:variables
}

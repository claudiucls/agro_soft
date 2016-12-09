/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dbUtil.DBConnect;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import models.Angajat;
import models.BonConsum;
import models.Client;
import models.Comanda;
import models.Document;
import models.Event;
import models.Factura;
import models.Furnizor;
import models.Gestiune;
import models.Nir;
import models.Produs;
import models.ProdusStoc;
import models.Registru;

/**
 *
 * @author Claudiu
 */
public class DBQueries {

    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rs;

    public DBQueries() {

    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public List<Angajat> findAngajati(String cauta, boolean activ) {
        try {
            List<Angajat> angajati = new ArrayList<>();
            conn = DBConnect.getConnection();
            String sql = "";
            if (activ) {
                sql = "select * from angajat where data_terminarii is null and nume like ? order by nume";
            } else {
                sql = "select * from angajat where nume like ? order by nume";
            }
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, "%" + cauta + "%");
            rs = pstat.executeQuery();
            Angajat a = null;
            while (rs.next()) {
                a = new Angajat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getShort(9));
                angajati.add(a);
            }
            return angajati;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public Angajat getAngajatByName(String nume) {
        Angajat a = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from angajat where nume like ?");
            pstat.setString(1, "%" + nume + "%");
            rs = pstat.executeQuery();
            while (rs.next()) {
                a = new Angajat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getShort(9));
                return a;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public Angajat getAngajatById(int id) {
        Angajat a = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from angajat where id = ?");
            pstat.setInt(1, id);
            rs = pstat.executeQuery();
            while (rs.next()) {
                a = new Angajat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getShort(9));
                return a;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public int getLastAngajatiId() {
        int n = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from angajat");
            rs = pstat.executeQuery();
            while (rs.next()) {
                n = rs.getInt("id");
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public int getLastProdusId() {
        int n = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from produs");
            rs = pstat.executeQuery();
            while (rs.next()) {
                n = rs.getInt("id_produs");
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public boolean addAngajat(Angajat a) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into angajat(nume,cnp,functia,data_angajarii,contract,salariu_brut,pers_int) values (?,?,?,?,?,?,?)");
            pstat.setString(1, a.getNume());
            pstat.setString(2, a.getCnp());
            pstat.setString(3, a.getFunctia());
            pstat.setDate(4, Date.valueOf(a.getDataAngajarii()));
            pstat.setString(5, a.getContract());
            pstat.setDouble(6, a.getSalariu());
            pstat.setShort(7, a.getPersInt());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean addNir(Nir nir) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into nir(nr_nir,data,tip_doc,factura,furnizor,gestiune) values (?,?,?,?,?,?)");
            pstat.setInt(1, nir.getNrNir());
            pstat.setDate(2, Date.valueOf(nir.getDate()));
            pstat.setString(3, nir.getTipDoc());
            pstat.setString(4, nir.getFactura());
            pstat.setString(5, nir.getFurnizor());
            pstat.setInt(6, nir.getGestiune());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean addProdusNou(Produs p) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into produs(denumire,um,tva,pret_unitar,cantitate_intrare,intrare) values(?,?,?,?,?,?)");
            pstat.setString(1, p.getDenumire());
            pstat.setString(2, p.getUm());
            pstat.setString(3, p.getTva());
            pstat.setDouble(4, p.getPretUnitar());
            pstat.setDouble(5, p.getCantitateIntrare());
            pstat.setInt(6, p.getIntrare());
            pstat.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public int getLastNir() {
        int n = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from nir");
            rs = pstat.executeQuery();
            while (rs.next()) {
                n = rs.getInt("id");
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public LocalDate getLastNirDate() {
        LocalDate date = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select data from nir order by data asc");
            rs = pstat.executeQuery();
            while (rs.next()) {
                date = rs.getDate("data").toLocalDate();
            }
            return date;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return date;
    }

    public int getNirByMounth(LocalDate d) {
        int n = 1;
        try {
            int luna = d.getMonthValue();
            int anul = d.getYear();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from nir where month(data)=? and year(data)=?");
            pstat.setInt(1, luna);
            pstat.setInt(2, anul);
            rs = pstat.executeQuery();
            while (rs.next()) {
                n++;
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return n;
    }

    public List<Furnizor> getFurnizori() {
        try {
            List<Furnizor> furnizori = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from furnizor");
            rs = pstat.executeQuery();
            Furnizor f = null;
            while (rs.next()) {
                f = new Furnizor(rs.getString("nume"), rs.getString("cui"), rs.getString("nr_registru"), rs.getString("banca"), rs.getString("cont"));
                furnizori.add(f);
            }
            return furnizori;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Client> getClienti() {
        try {
            List<Client> clienti = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from client");
            rs = pstat.executeQuery();
            Client c = null;
            while (rs.next()) {
                c = new Client(rs.getString("nume"), rs.getString("cui"), rs.getString("nr_registru"), rs.getString("adresa"), rs.getString("banca"), rs.getString("cont"));
                clienti.add(c);
            }
            return clienti;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public Client getClient(String c) {
        Client cl = new Client();
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from client where nume=?");
            pstat.setString(1, c);
            rs = pstat.executeQuery();
            while (rs.next()) {
                cl.setNume(rs.getString("nume"));
                cl.setCui(rs.getString("cui"));
                cl.setReg(rs.getString("nr_registru"));
                cl.setAdresa(rs.getString("adresa"));
                cl.setBanca(rs.getString("banca"));
                cl.setIban(rs.getString("cont"));
            }
            return cl;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return cl;
    }

    public Furnizor getFurnizor(String fur) {
        Furnizor f = new Furnizor();
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from furnizor where nume=?");
            pstat.setString(1, fur);
            rs = pstat.executeQuery();
            while (rs.next()) {
                f.setNume(rs.getString("nume"));
                f.setCui(rs.getString("cui"));
                f.setReg(rs.getString("nr_registru"));
                f.setBanca(rs.getString("banca"));
                f.setIban(rs.getString("cont"));
            }
            return f;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return f;
    }

    public List<Furnizor> getFurnizori(String cauta) {
        List<Furnizor> furnizori = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from furnizor where nume like ?");
            pstat.setString(1, "%" + cauta + "%");
            rs = pstat.executeQuery();
            Furnizor f = null;
            while (rs.next()) {
                f = new Furnizor(rs.getString("nume"), rs.getString("cui"), rs.getString("nr_registru"), rs.getString("banca"), rs.getString("cont"));
                furnizori.add(f);
            }
            return furnizori;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Client> getClienti(String cauta) {
        List<Client> clienti = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from client where nume like ?");
            pstat.setString(1, "%" + cauta + "%");
            rs = pstat.executeQuery();
            Client c = null;
            while (rs.next()) {
                c = new Client(rs.getString("nume"), rs.getString("cui"), rs.getString("nr_registru"), rs.getString("adresa"), rs.getString("banca"), rs.getString("cont"));
                clienti.add(c);
            }
            return clienti;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Gestiune> getGestiuni() {
        try {
            List<Gestiune> gestiuni = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from gestiune");
            rs = pstat.executeQuery();
            Gestiune g = null;
            while (rs.next()) {
                g = new Gestiune(rs.getInt("id"), rs.getString("nume").toUpperCase());
                gestiuni.add(g);
            }
            return gestiuni;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public boolean addFurnizor(Furnizor f) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into furnizor (nume,cui,nr_registru,banca,cont) values (?,?,?,?,?)");
            pstat.setString(1, f.getNume());
            pstat.setString(2, f.getCui());
            pstat.setString(3, f.getReg());
            pstat.setString(4, f.getBanca());
            pstat.setString(5, f.getCui());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public boolean addClient(Client c) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into client (nume,cui,nr_registru,adresa,banca,cont) values (?,?,?,?,?,?)");
            pstat.setString(1, c.getNume());
            pstat.setString(2, c.getCui());
            pstat.setString(3, c.getReg());
            pstat.setString(4, c.getAdresa());
            pstat.setString(5, c.getBanca());
            pstat.setString(6, c.getIban());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public boolean updateClient(Client c) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("update client set cui =?, nr_registru=?,adresa=?, banca=?, cont=? where nume=?");
            pstat.setString(1, c.getCui());
            pstat.setString(2, c.getReg());
            pstat.setString(3, c.getAdresa());
            pstat.setString(4, c.getBanca());
            pstat.setString(5, c.getIban());
            pstat.setString(6, c.getNume());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public boolean updateFurnizor(Furnizor f) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("update furnizor set cui =?, nr_registru=?, banca=?, cont=? where nume=?");
            pstat.setString(1, f.getCui());
            pstat.setString(2, f.getReg());
            pstat.setString(3, f.getBanca());
            pstat.setString(4, f.getIban());
            pstat.setString(5, f.getNume());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public Gestiune getGestiune(String text) {
        Gestiune gest = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from gestiune where nume = ?");
            pstat.setString(1, text);
            rs = pstat.executeQuery();
            while (rs.next()) {
                gest.setNume(rs.getString("nume").toUpperCase());
            }
            return gest;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return null;
    }

    public int getGestiuneId(String text) {
        int nr = -1;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from gestiune where nume = ?");
            pstat.setString(1, text);
            rs = pstat.executeQuery();
            while (rs.next()) {
                nr = rs.getInt("id");
            }
            return nr;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return -1;
    }

    public String getGestiuneFrinId(int id) {
        String gest = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from gestiune where id = ?");
            pstat.setInt(1, id);
            rs = pstat.executeQuery();
            while (rs.next()) {
                gest = rs.getString("nume");
            }
            return gest;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return gest;
    }

    public boolean deleteGestiune(Gestiune g) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from gestiune where nume=?");
            pstat.setString(1, g.getNume());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public boolean addGestiune(Gestiune g) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into gestiune(nume) values (?)");
            pstat.setString(1, g.getNume());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public boolean addComanda(Comanda c) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into comanda(nume) values (?)");
            pstat.setString(1, c.getNume());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteComanda(Comanda c) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from comanda where nume=?");
            pstat.setString(1, c.getNume());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public Comanda getComanda(String text) {
        Comanda com = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from comanda where nume = ?");
            pstat.setString(1, text);
            rs = pstat.executeQuery();
            while (rs.next()) {
                com = new Comanda(rs.getString("nume"));
            }
            return com;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return null;
    }

    public List<Comanda> getComenzi() {
        try {
            List<Comanda> comenzi = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from comanda");
            rs = pstat.executeQuery();
            Comanda c = null;
            while (rs.next()) {
                c = new Comanda(rs.getString("nume"));
                comenzi.add(c);
            }
            return comenzi;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Produs> getProduse(String cauta) {
        try {
            List<Produs> produse = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select denumire,um,tva,pret_unitar,stoc,valoare "
                    + "from (select denumire,um,tva,pret_unitar,round(sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as stoc,"
                    + "round(pret_unitar*sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as valoare from produs group by denumire, pret_unitar) as stoc_produse"
                    + " where denumire like ? order by stoc desc");
            pstat.setString(1, "%" + cauta + "%");
            rs = pstat.executeQuery();
            Produs p = null;
            while (rs.next()) {
                p = new Produs(rs.getString("denumire"), rs.getString("um"), rs.getString("tva"), rs.getDouble("pret_unitar"), rs.getDouble("stoc"), rs.getDouble("valoare"));
                produse.add(p);
            }
            return produse;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Produs> getProdusePerGestiune(int gestiune, String cauta) {
        try {
            List<Produs> produse = new ArrayList<>();
            conn = DBConnect.getConnection();
            if (gestiune == 0) {
                pstat = conn.prepareStatement("select denumire,um,tva,pret_unitar,stoc,valoare "
                        + "from (select denumire,um,tva,pret_unitar,round(sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as stoc,"
                        + "round(pret_unitar*sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as valoare,nir.gestiune from produs left join nir on produs.intrare=nir.id group by denumire, pret_unitar) as stoc_produse "
                        + " where denumire like ? and stoc>0 order by stoc desc"
                );
                pstat.setString(1, "%" + cauta + "%");
            } else {
                pstat = conn.prepareStatement("select denumire,um,tva,pret_unitar,stoc,valoare "
                        + "from (select denumire,um,tva,pret_unitar,round(sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as stoc,"
                        + "round(pret_unitar*sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as valoare,nir.gestiune from produs right join nir on produs.intrare=nir.id group by denumire, pret_unitar) as stoc_produse"
                        + " where gestiune =?  and denumire like ? order by stoc desc");
                pstat.setInt(1, gestiune);
                pstat.setString(2, "%" + cauta + "%");
            }
            rs = pstat.executeQuery();
            Produs p = null;
            while (rs.next()) {
                p = new Produs(rs.getString("denumire"), rs.getString("um"), rs.getString("tva"), rs.getDouble("pret_unitar"), rs.getDouble("stoc"), rs.getDouble("valoare"));
                produse.add(p);
            }
            return produse;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Produs> getStocuriPeGestiuni(int gestiune) {
        try {
            List<Produs> produse = new ArrayList<>();
            conn = DBConnect.getConnection();
            if (gestiune == 0) {
                pstat = conn.prepareStatement("select denumire,um,tva,pret_unitar,stoc,valoare "
                        + "from (select denumire,um,tva,pret_unitar,round(sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as stoc,"
                        + "round(pret_unitar*sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as valoare,nir.gestiune from produs left join nir on produs.intrare=nir.id group by denumire, pret_unitar) as stoc_produse"
                );
            } else {
                pstat = conn.prepareStatement("select denumire,um,tva,pret_unitar,stoc,valoare "
                        + "from (select denumire,um,tva,pret_unitar,sum(cantitate_intrare-cantitate_iesire-cantitate_facturat) as stoc,"
                        + "pret_unitar*sum(cantitate_intrare-cantitate_iesire-cantitate_facturat) as valoare,nir.gestiune from produs left join nir on produs.intrare=nir.id group by denumire, pret_unitar) as stoc_produse"
                        + " where gestiune = ? order by gestiune asc");
                pstat.setInt(1, gestiune);
            }
            rs = pstat.executeQuery();
            Produs p = null;
            while (rs.next()) {
                p = new Produs(rs.getString("denumire"), rs.getString("um"), rs.getString("tva"), rs.getDouble("pret_unitar"), rs.getDouble("stoc"), rs.getDouble("valoare"));
                if (p.getStoc() == 0) {
                    continue;
                }
                produse.add(p);
            }
            return produse;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public double getVT() {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select sum(valoare) from "
                    + "( select denumire, pret_unitar,sum(cantitate_intrare-cantitate_iesire-cantitate_facturat) as cantitate,"
                    + " sum(cantitate_intrare-cantitate_iesire-cantitate_facturat)*pret_unitar as valoare "
                    + "from produs group by denumire,pret_unitar ) as table_stoc ");
            rs = pstat.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public double getVTPeGestiuni(int gestiune) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select gestiune,sum(valoare) from "
                    + "(select denumire,um,tva,pret_unitar,sum(cantitate_intrare-cantitate_iesire-cantitate_facturat) as stoc,"
                    + " pret_unitar*sum(cantitate_intrare-cantitate_iesire-cantitate_facturat) as valoare,"
                    + "nir.gestiune from produs left join nir on produs.intrare=nir.id"
                    + " group by denumire, pret_unitar) as stoc_produse "
                    + "where gestiune = ? ");
            pstat.setInt(1, gestiune);
            rs = pstat.executeQuery();
            while (rs.next()) {
                return rs.getDouble(2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public Produs getProdus(String denumire, double pret) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select denumire,um,tva,pret_unitar,stoc,valoare "
                    + "from (select denumire,um,tva,pret_unitar,round(sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as stoc,"
                    + "round(pret_unitar*sum(cantitate_intrare-cantitate_iesire-cantitate_facturat),2) as valoare from produs group by denumire, pret_unitar) as stoc_produse"
                    + " where denumire = ? and pret_unitar=?");
            pstat.setString(1, denumire);
            pstat.setDouble(2, pret);
            rs = pstat.executeQuery();
            Produs p = null;
            while (rs.next()) {
                p = new Produs(rs.getString("denumire"), rs.getString("um"), rs.getString("tva"), rs.getDouble("pret_unitar"), rs.getDouble("stoc"), rs.getDouble("valoare"));
            }
            return p;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public boolean modificaAngajat(Angajat a) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("update angajat set nume =?,cnp =?, functia=?, data_angajarii=?,contract=?,salariu_brut=?,pers_int=? where id=?");
            pstat.setString(1, a.getNume());
            pstat.setString(2, a.getCnp());
            pstat.setString(3, a.getFunctia());
            pstat.setDate(4, Date.valueOf(a.getDataAngajarii()));
            pstat.setString(5, a.getContract());
            pstat.setDouble(6, a.getSalariu());
            pstat.setShort(7, a.getPersInt());
            pstat.setInt(8, a.getId());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public boolean incheieContract(Angajat a) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("update angajat set data_terminarii=? where id=?");
            pstat.setDate(1, Date.valueOf(a.getDataTerminarii()));
            pstat.setInt(2, a.getId());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public int getLastEvent() {
        int n = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from event");
            rs = pstat.executeQuery();
            while (rs.next()) {
                n = rs.getInt("id");
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public boolean addEvent(Event e) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into event(descriere,cod,dataDeLa,dataPanaLa,angajat) values (?,?,?,?,?)");
            pstat.setString(1, e.getDescriere());
            pstat.setString(2, e.getCod());
            pstat.setDate(3, Date.valueOf(e.getDataDeLa()));
            pstat.setDate(4, Date.valueOf(e.getDataPanaLa()));
            pstat.setInt(5, e.getAngajat());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean updateEvent(Event e) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("update event set descriere =?,cod=?,dataDeLa=?,dataPanaLa=?,angajat=? where id =?");
            pstat.setString(1, e.getDescriere());
            pstat.setString(2, e.getCod());
            pstat.setDate(3, Date.valueOf(e.getDataDeLa()));
            pstat.setDate(4, Date.valueOf(e.getDataPanaLa()));
            pstat.setInt(5, e.getAngajat());
            pstat.setInt(6, e.getId());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<Event> findAllEvents() {
        try {
            List<Event> events = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from event");
            rs = pstat.executeQuery();
            Event e = null;
            while (rs.next()) {
                e = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate(), rs.getInt(6));
                events.add(e);
            }
            return events;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public Event getEventById(int id) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from event where id =?");
            pstat.setInt(1, id);
            rs = pstat.executeQuery();
            Event e = null;
            while (rs.next()) {
                e = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate(), rs.getInt(6));
            }
            return e;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Event> getEventByIdAngajat(int id) {
        // Event e = null;
        List<Event> events = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from event where angajat =? order by dataPanaLa");
            pstat.setInt(1, id);
            rs = pstat.executeQuery();
            Event e = null;
            while (rs.next()) {
                e = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate(), rs.getInt(6));
                events.add(e);
            }
            return events;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public boolean deleteEvent(int id) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from event where id=?");
            pstat.setInt(1, id);
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public ProdusStoc existsaProdus(Produs p) {
        ProdusStoc ps = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("Select * from produs"
                    + "	where denumire = ? and um =? and tva=? and pret_unitar=?");
            pstat.setString(1, p.getDenumire());
            pstat.setString(2, p.getUm());
            pstat.setString(3, p.getTva());
            pstat.setDouble(4, p.getPretUnitar());
            rs = pstat.executeQuery();
            while (rs.next()) {
                ps = new ProdusStoc(rs.getInt(1), rs.getDouble(6));
            }
            return ps;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return ps;
    }

    public int getBCByMounth(LocalDate d) {
        int n = 1;
        try {
            int luna = d.getMonthValue();
            int anul = d.getYear();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from bon where month(data)=? and year(data)=?");
            pstat.setInt(1, luna);
            pstat.setInt(2, anul);
            rs = pstat.executeQuery();
            while (rs.next()) {
                n++;
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return n;
    }

    public int getLastBCId() {
        int n = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from bon");
            rs = pstat.executeQuery();
            while (rs.next()) {
                n = rs.getInt("id");
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public boolean addBon(BonConsum bon) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into bon(nr_iesire,data,comanda,idGestiune) values (?,?,?,?)");
            pstat.setInt(1, bon.getNrBon());
            pstat.setDate(2, Date.valueOf(bon.getData()));
            pstat.setString(3, bon.getComanda());
            pstat.setInt(4, bon.getGestiune());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean addProdusInBon(Produs p) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into produs(denumire,um,pret_unitar,cantitate_iesire,iesire) values(?,?,?,?,?)");
            pstat.setString(1, p.getDenumire());
            pstat.setString(2, p.getUm());
            pstat.setDouble(3, p.getPretUnitar());
            pstat.setDouble(4, p.getCantitateIesire());
            pstat.setInt(5, p.getIesire());
            pstat.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public LocalDate getLastBCDate() {
        LocalDate date = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select data from bon order by data asc");
            rs = pstat.executeQuery();
            while (rs.next()) {
                date = rs.getDate("data").toLocalDate();
            }
            return date;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return date;
    }

    public int getLastRegistruNrByYear(LocalDate today) {
        int n = 1;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from registru where year(data)=?");
            pstat.setDate(1, Date.valueOf(today));
            rs = pstat.executeQuery();
            while (rs.next()) {
                n++;
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return n;
    }

    public double getSold(LocalDate date) {
        double n = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select sum(valoare_intrare-valoare_iesire) as sold "
                    + "from document left join registru on document.registru=registru.id where data<=?");
            pstat.setDate(1, Date.valueOf(date));
            rs = pstat.executeQuery();
            while (rs.next()) {
                n = rs.getDouble("sold");
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return n;
    }

    public boolean addRegistru(Registru r) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into registru(nr_registru,data) values (?,?)");
            pstat.setInt(1, r.getNrReg());
            pstat.setDate(2, Date.valueOf(r.getDate()));
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean addDocInRegistru(Document d, int id_reg) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into document(nr_doc,explicatie,valoare_intrare,valoare_iesire,registru) values (?,?,?,?,?)");
            pstat.setString(1, d.getNrDoc());
            pstat.setString(2, d.getExplicatie());
            pstat.setDouble(3, d.getIntrare());
            pstat.setDouble(4, d.getIesire());
            pstat.setInt(5, id_reg);
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {;
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return false;
    }

    public int getLastRegistruId() {
        int n = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from registru");
            rs = pstat.executeQuery();
            while (rs.next()) {
                n = rs.getInt("id");
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public LocalDate getLastRegistruDate() {
        LocalDate ultima = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from registru order by data");
            rs = pstat.executeQuery();
            while (rs.next()) {
                ultima = rs.getDate("data").toLocalDate();
            }
            return ultima;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public Registru cautaRegistru(LocalDate cauta) {
        Registru r = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from registru where data=?");
            pstat.setDate(1, Date.valueOf(cauta));
            rs = pstat.executeQuery();
            while (rs.next()) {
                r = new Registru(rs.getInt("id"), rs.getInt("nr_registru"), rs.getDate("data").toLocalDate());
            }
            return r;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return r;
    }

    public List<Document> cautaDocumenteDupaRegistru(int id) {
        List<Document> docs = new ArrayList<>();
        Document doc = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from document where registru=?");
            pstat.setInt(1, id);
            rs = pstat.executeQuery();
            while (rs.next()) {
                doc = new Document(rs.getInt("id"), rs.getString("nr_doc"),
                        rs.getString("explicatie"), rs.getDouble("valoare_intrare"),
                        rs.getDouble("valoare_iesire"), rs.getInt("registru"));
                docs.add(doc);
            }
            return docs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return docs;
    }

    public List<Registru> getRegistreFrom(LocalDate dataDeLa, LocalDate dataPanaLa) {
        List<Registru> regs = new ArrayList<>();
        Registru r = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from registru where data>=? and data<=?");
            pstat.setDate(1, Date.valueOf(dataDeLa));
            pstat.setDate(2, Date.valueOf(dataPanaLa));
            rs = pstat.executeQuery();
            while (rs.next()) {
                r = new Registru(rs.getInt("id"), rs.getInt("nr_registru"), rs.getDate("data").toLocalDate());
                regs.add(r);
            }
            return regs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return regs;

    }

    public boolean deleteDocumenteDinRegistru(Registru r) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from document where registru=?");
            pstat.setInt(1, r.getId());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public boolean existaFacturaCuNr(int nrIesire) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from factura where nr_iesire=?");
            pstat.setInt(1, nrIesire);
            rs = pstat.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public int getLastFacturaId() {
        int n = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from factura");
            rs = pstat.executeQuery();
            while (rs.next()) {
                n = rs.getInt("id");
            }
            return n;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public boolean addFactura(Factura factura) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into factura(nr_iesire,data,client,gest) values (?,?,?,?)");
            pstat.setInt(1, factura.getNrFact());
            pstat.setDate(2, Date.valueOf(factura.getData()));
            pstat.setString(3, factura.getClient());
            pstat.setInt(4, factura.getGestiune());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean addProdusInFactura(Produs p) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("insert into produs(denumire,um,tva,pret_unitar,cantitate_facturat,factura) values(?,?,?,?,?,?)");
            pstat.setString(1, p.getDenumire());
            pstat.setString(2, p.getUm());
            pstat.setString(3, p.getTva());
            pstat.setDouble(4, p.getPretUnitar());
            pstat.setDouble(5, p.getCantitateFacturata());
            pstat.setInt(6, p.getFactura());
            pstat.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean updateFactura(Factura f) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("update factura set zile_scad=?, deleg_nume=?,deleg_ci=?, deleg_trans=?, chitanta=?,total=? where id=?");
            pstat.setInt(1, f.getZileScad());
            pstat.setString(2, f.getDelegNume());
            pstat.setString(3, f.getDelegCi());
            pstat.setString(4, f.getDelegTrans());
            pstat.setString(5, f.getChitanta());
            pstat.setDouble(6, f.getTotal());
            pstat.setInt(7, f.getId());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public Nir getNir(int nr, LocalDate data) {
        Nir nir = null;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from nir where nr_nir=? and data=?");
            pstat.setInt(1, nr);
            pstat.setDate(2, Date.valueOf(data));
            rs = pstat.executeQuery();
            while (rs.next()) {
                nir = new Nir(rs.getInt("id"), rs.getInt("nr_nir"), rs.getDate("data").toLocalDate(), rs.getString("tip_doc"), rs.getString("factura"), rs.getString("furnizor"), rs.getInt("gestiune"));
            }
            return nir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return nir;
    }

    public List<Produs> getProduseFromNir(int id) {
        try {
            List<Produs> produse = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from produs where intrare=? ");
            pstat.setInt(1, id);
            rs = pstat.executeQuery();
            Produs p = null;
            while (rs.next()) {
                p = new Produs(rs.getInt("id_produs"), rs.getString("denumire"), rs.getString("um"), rs.getString("tva"), rs.getDouble("pret_unitar"), rs.getDouble("cantitate_intrare"), 0.0);
                produse.add(p);
            }
            return produse;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public boolean updateNir(Nir nir) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("update nir set nr_nir=?, data=?,tip_doc=?, factura=?, furnizor=?,gestiune=? where id=?");
            pstat.setInt(1, nir.getNrNir());
            pstat.setDate(2, Date.valueOf(nir.getDate()));
            pstat.setString(3, nir.getTipDoc());
            pstat.setString(4, nir.getFactura());
            pstat.setString(5, nir.getFurnizor());
            pstat.setInt(6, nir.getGestiune());
            pstat.setInt(7, nir.getId());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public boolean deleteProduseDinNir(Nir nir) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from produs where intrare=?");
            pstat.setInt(1, nir.getId());
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public List<Nir> getAllNir() {
        try {
            List<Nir> niruri = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from nir");
            rs = pstat.executeQuery();
            Nir nir = null;
            while (rs.next()) {
                nir = new Nir(rs.getInt("id"), rs.getInt("nr_nir"), rs.getDate("data").toLocalDate(), rs.getString("tip_doc"), rs.getString("factura"), rs.getString("furnizor"), rs.getInt("gestiune"));
                niruri.add(nir);
            }
            return niruri;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<BonConsum> getAllBonConsum() {
        try {
            List<BonConsum> bonuri = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from bon");
            rs = pstat.executeQuery();
            BonConsum bon = null;
            while (rs.next()) {
                bon = new BonConsum(rs.getInt("id"), rs.getInt("nr_iesire"), rs.getDate("data").toLocalDate(), rs.getString("comanda"), rs.getInt("idGestiune"));
                bonuri.add(bon);
            }
            return bonuri;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Factura> getAllFactura() {
        try {
            List<Factura> facturi = new ArrayList<>();
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select * from factura");
            rs = pstat.executeQuery();
            Factura f = null;
            while (rs.next()) {
                f = new Factura(rs.getInt("id"), rs.getInt("nr_iesire"), rs.getDate("data").toLocalDate(), rs.getString("client"), rs.getInt("gest"), rs.getDouble("total"));
                facturi.add(f);
            }
            return facturi;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public double calcValBon(BonConsum bon) {
        double d = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select sum(pret_unitar*cantitate_iesire) as val from produs where iesire=?");
            pstat.setInt(1, bon.getId());
            rs = pstat.executeQuery();
            while (rs.next()) {
                d = rs.getDouble("val");
            }
            return d;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return d;
    }

    public double calcValNir(Nir nir) {
        double d = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select sum(pret_unitar*cantitate_intrare) as val from produs where intrare=?");
            pstat.setInt(1, nir.getId());
            rs = pstat.executeQuery();
            while (rs.next()) {
                d = rs.getDouble("val");
            }
            return d;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return d;
    }

    public double calcValFactura(Factura f) {
        double d = 0;
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("select total from factura where id=?");
            pstat.setInt(1, f.getId());
            rs = pstat.executeQuery();
            while (rs.next()) {
                d = rs.getDouble("total");
            }
            return d;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return d;
    }

    public boolean deleteNir(int id) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from nir where id=?");
            pstat.setInt(1, id);
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteFactura(int id) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from factura where id=?");
            pstat.setInt(1, id);
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteBon(int id) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from bon where id=?");
            pstat.setInt(1, id);
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteProduseDinFactura(int id) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from produs where factura=?");
            pstat.setInt(1, id);
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

    public boolean deleteProduseDinBon(int id) {
        try {
            conn = DBConnect.getConnection();
            pstat = conn.prepareStatement("delete from produs where iesire=?");
            pstat.setInt(1, id);
            pstat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }
}

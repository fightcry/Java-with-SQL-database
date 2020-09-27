package baseapp;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Wynik extends JDialog {
    public Wynik(Frame parent, String password, String username, int data) {
        super(parent, "Wynik", true);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://" +
                    "localhost\\SQL_Piotrek:24573;databaseName=Piotrek;" + "user=" + username + ";password=" + password);
            Statement stmt = con.createStatement();

            switch(data) {
                case 0: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Pracownik");
                    String[][] dane = new String[50][7];
                    int i = 0;
                    while (rs.next()) {
                        dane[i][0] = rs.getString("imie");
                        dane[i][1] = rs.getString("nazwisko");
                        dane[i][2] = rs.getString("PESEL");
                        dane[i][3] = rs.getFloat("pensja") + " PLN";
                        dane[i][4] = rs.getString("stanowisko");
                        dane[i][5] = rs.getString("data_zatrudnienia");
                        dane[i][6] = rs.getString("data_urodzenia");
                        i = i+1;
                    }
                    String[] nazwy = { "Imię", "Nazwisko", "PESEL", "Pensja", "Stanowisko", "Data zatrudnienia", "Data urodzenia" };
                    JTable tabela = new JTable(dane, nazwy);
                    JScrollPane sp=new JScrollPane(tabela);
                    tabela.setVisible(true);
                    sp.setSize(800, 800);
                    add(sp);
                    this.repaint();
                }
                break;
                case 1: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Klient");
                    String[][] dane = new String[50][5];
                    int i = 0;
                    while (rs.next()) {
                        dane[i][0] = rs.getString("imie");
                        dane[i][1] = rs.getString("nazwisko");
                        dane[i][2] = rs.getString("PESEL");
                        dane[i][3] = rs.getString("data_urodzenia");
                        dane[i][4] = rs.getFloat("kary") + " PLN";
                        i = i+1;
                    }

                    String[] nazwy = { "Imię", "Nazwisko", "PESEL", "Data urodzenia", "Kary"};
                    JTable tabela = new JTable(dane, nazwy);
                    JScrollPane sp=new JScrollPane(tabela);
                    tabela.setVisible(true);
                    sp.setSize(800, 800);
                    add(sp);
                }
                break;
                case 2: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Domek_letniskowy");
                    String[][] dane = new String[50][4];
                    int i = 0;
                    while (rs.next()) {
                        dane[i][0] = rs.getString("nazwa");
                        dane[i][1] = rs.getFloat("cena_za_noc") + " PLN";
                        dane[i][2] = rs.getString("data_budowy");
                        dane[i][3] = rs.getString("ilosc_miejsc");
                        i = i+1;
                    }

                    String[] nazwy = { "Nazwa", "Cena za noc", "Data budowy", "Ilość miejsc"};
                    JTable tabela = new JTable(dane, nazwy);
                    JScrollPane sp=new JScrollPane(tabela);
                    tabela.setVisible(true);
                    sp.setSize(600, 600);
                    add(sp);
                }
                break;
                case 3: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Rachunek_faktura");
                    String[][] dane = new String[50][7];
                    int i = 0;
                    while (rs.next()) {
                        dane[i][0] = rs.getFloat("cena_netto") + " PLN";
                        dane[i][1] = rs.getFloat("cena_brutto") + " PLN";
                        dane[i][2] = rs.getString("data_wystawienia");
                        if(rs.getBoolean("czy_oplacone"))
                            dane[i][3] = "Tak";
                        else
                            dane[i][3] = "Nie";
                        dane[i][4] = rs.getString("data_wplaty");
                        dane[i][5] = rs.getInt("rabat") * 100 + "%";
                        i = i+1;
                    }

                    String[] nazwy = { "Cena netto", "Cena brutto", "Data wystawienia", "Czy opłacone", "Data opłacenia", "Rabat"};
                    JTable tabela = new JTable(dane, nazwy);
                    JScrollPane sp=new JScrollPane(tabela);
                    tabela.setVisible(true);
                    sp.setSize(800, 800);
                    add(sp);
                }
                break;
                case 4: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Sprzet");
                    String[][] dane = new String[50][4];
                    int i = 0;
                    while (rs.next()) {
                        dane[i][0] = rs.getString("nazwa");
                        dane[i][1] = rs.getFloat("cena_za_godzine") + " PLN";
                        dane[i][2] = rs.getString("data_nastepnego_przegladu");
                        dane[i][3] = rs.getString("lokalizacja");
                        i = i+1;
                    }

                    String[] nazwy = { "Nazwa", "Cena za godzinę", "Data następnego przeglądu", "Lokalizacja"};
                    JTable tabela = new JTable(dane, nazwy);
                    JScrollPane sp=new JScrollPane(tabela);
                    tabela.setVisible(true);
                    sp.setSize(600, 600);
                    add(sp);
                }
                break;
                case 5: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Zarezerwowanie_sprzetu");
                    String[][] dane = new String[50][4];
                    int i = 0;
                    while (rs.next()) {
                        dane[i][0] = rs.getString("uwagi");
                        dane[i][1] = rs.getString("data_od");
                        dane[i][2] = rs.getString("data_do");
                        dane[i][3] = rs.getFloat("cena") + " PLN";
                        i = i+1;
                    }

                    String[] nazwy = { "Uwagi", "Data od", "Data do", "Cena"};
                    JTable tabela = new JTable(dane, nazwy);
                    JScrollPane sp=new JScrollPane(tabela);
                    tabela.setVisible(true);
                    sp.setSize(600, 600);
                    add(sp);
                }
                break;
                case 6: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Wypozyczenie_domkow");
                    String[][] dane = new String[50][3];
                    int i = 0;
                    while (rs.next()) {
                        dane[i][0] = rs.getFloat("laczna_cena") + " PLN";
                        dane[i][1] = rs.getString("data_zlozenia_zamowienia");
                        dane[i][2] = rs.getString("uwagi");
                        i = i+1;
                    }

                    String[] nazwy = { "Łączna cena", "Data złożenia zamówienia", "Uwagi"};
                    JTable tabela = new JTable(dane, nazwy);
                    JScrollPane sp=new JScrollPane(tabela);
                    tabela.setVisible(true);
                    sp.setSize(600, 600);
                    add(sp);
                }
                break;
                case 7: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Wypozyczenie_domku");
                    String[][] dane = new String[50][3];
                    int i = 0;
                    while (rs.next()) {
                        dane[i][0] = rs.getString("data__od");
                        dane[i][1] = rs.getString("data__do");
                        dane[i][2] = rs.getFloat("cena") + " PLN";
                        i = i+1;
                    }

                    String[] nazwy = { "Data od", "Data do", "Cena"};
                    JTable tabela = new JTable(dane, nazwy);
                    JScrollPane sp=new JScrollPane(tabela);
                    tabela.setVisible(true);
                    sp.setSize(600, 600);
                    add(sp);
                }
                break;
            }

        } catch (SQLException | ClassNotFoundException d) {
            d.printStackTrace();
        }
        setSize(800, 800);
        setLocationRelativeTo(parent);
    }
}

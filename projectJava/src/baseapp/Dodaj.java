package baseapp;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Dodaj extends JFrame {

    JLabel napis;
    JTextField u1, u2, u3, u4, u5, u6;
    JComboBox<String> c1;
    JComboBox<String> c2;
    JComboBox<String> c3;
    JButton dalej, wroc;

    public Dodaj(Frame parent, String password, String username, int dane) {
        setTitle("Dodawanie do bazy");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(parent);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://" +
                    "localhost\\SQL_Piotrek:24573;databaseName=Piotrek;" + "user=" + username + ";password=" + password);
            Statement stmt = con.createStatement();

            switch(dane) {
                case 0: {napis = new JLabel("Podaj dane rekordu do dodania oraz wybierz powiązane rekordy");
                    napis.setBounds(100, 10, 400, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Imię");
                    u1.setBounds(30, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Nazwisko");
                    u2.setBounds(240, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("PESEL");
                    u3.setBounds(450, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Pensja");
                    u4.setBounds(30, 110, 200, 30);
                    u4.setVisible(true);
                    add(u4);
                    u5 = new JTextField("Stanowisko");
                    u5.setBounds(240, 110, 200, 30);
                    u5.setVisible(true);
                    add(u5);
                    u6 = new JTextField("Data zatrudnienia");
                    u6.setBounds(450, 110, 200, 30);
                    u6.setVisible(true);
                    add(u6);

                    dalej = new JButton("Dodaj");
                    dalej.setBounds(260, 160, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 210, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String imie = u1.getText();
                                String nazwisko = u2.getText();
                                String PESEL = u3.getText();
                                String pensja = u4.getText();
                                String stanowisko = u5.getText();
                                String data_zatrudnienia = u6.getText();
                                String data_urodzenia;
                                if(Integer.parseInt(PESEL.substring(2,4)) > 12) {
                                    data_urodzenia = "20" + PESEL.substring(0, 2) + "/" + (Integer.parseInt(PESEL.substring(2,4))-20) + "/" + PESEL.substring(4,6);
                                }
                                else {
                                    data_urodzenia = "19" + PESEL.substring(0, 2) + "/" + PESEL.substring(2,4) + "/" + PESEL.substring(4,6);
                                }

                                try {
                                    int a = stmt.executeUpdate("INSERT INTO Pracownik(imie, nazwisko, PESEL, pensja, stanowisko, data_zatrudnienia, data_urodzenia)" +
                                            "VALUES ('" + imie + "', '" + nazwisko + "', '" + PESEL + "', '" + pensja + "', '" + stanowisko + "', '"
                                             + data_zatrudnienia + "', '" + data_urodzenia + "')");
                                    if (a > 0) {
                                        JOptionPane.showMessageDialog(this,
                                                "Poprawnie dodano rekord",
                                                "Sukces",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie udało się dodać rekordu, sprawdź dane",
                                                "Błąd",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch (SQLException throwables) {
                                    JOptionPane.showMessageDialog(this,
                                            "Nie dodano żadnego rekordu, spróbuj ponownie lub skontaktuj się z administratorem",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                }

                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
                }
                break;
                case 1: {napis = new JLabel("Podaj dane rekordu do dodania oraz wybierz powiązane rekordy");
                    napis.setBounds(100, 10, 400, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Imię");
                    u1.setBounds(30, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Nazwisko");
                    u2.setBounds(240, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("PESEL");
                    u3.setBounds(450, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Kary");
                    u4.setBounds(30, 110, 200, 30);
                    u4.setVisible(true);
                    add(u4);

                    dalej = new JButton("Dodaj");
                    dalej.setBounds(260, 160, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 210, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String imie = u1.getText();
                                String nazwisko = u2.getText();
                                String PESEL = u3.getText();
                                String kary = u4.getText();
                                String data_urodzenia;
                                if(Integer.parseInt(PESEL.substring(2,4)) > 12) {
                                    data_urodzenia = "20" + PESEL.substring(0, 2) + "/" + (Integer.parseInt(PESEL.substring(2,4))-20) + "/" + PESEL.substring(4,6);
                                }
                                else {
                                    data_urodzenia = "19" + PESEL.substring(0, 2) + "/" + PESEL.substring(2,4) + "/" + PESEL.substring(4,6);
                                }

                                try {
                                    int a = stmt.executeUpdate("INSERT INTO Klient(imie, nazwisko, PESEL, data_urodzenia, kary)" +
                                            "VALUES ('" + imie + "', '" + nazwisko + "', '" + PESEL + "', '" + data_urodzenia + "', '" + kary + "')");
                                    if (a > 0) {
                                        JOptionPane.showMessageDialog(this,
                                                "Poprawnie dodano rekord",
                                                "Sukces",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie udało się dodać rekordu, sprawdź dane",
                                                "Błąd",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch (SQLException throwables) {
                                    JOptionPane.showMessageDialog(this,
                                            "Nie dodano żadnego rekordu, spróbuj ponownie lub skontaktuj się z administratorem",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                }

                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
                }
                break;
                case 2: {
                    napis = new JLabel("Podaj dane rekordu do dodania oraz wybierz powiązane rekordy");
                    napis.setBounds(100, 10, 400, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Nazwa");
                    u1.setBounds(30, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Cena za noc");
                    u2.setBounds(240, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Data budowy");
                    u3.setBounds(450, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Ilość miejsc");
                    u4.setBounds(30, 110, 200, 30);
                    u4.setVisible(true);
                    add(u4);

                    dalej = new JButton("Dodaj");
                    dalej.setBounds(260, 160, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 210, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String nazwa = u1.getText();
                                String cena = u2.getText();
                                String data = u3.getText();
                                String ilosc_miejsc = u4.getText();

                                try {
                                    int a = stmt.executeUpdate("INSERT INTO Domek_letniskowy(nazwa, cena_za_noc, data_budowy, ilosc_miejsc)" +
                                            "VALUES ('" + nazwa + "', '" + cena + "', '" + data + "', '" + ilosc_miejsc + "')");
                                    if (a > 0) {
                                        JOptionPane.showMessageDialog(this,
                                                "Poprawnie dodano rekord",
                                                "Sukces",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie udało się dodać rekordu, sprawdź dane",
                                                "Błąd",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch (SQLException throwables) {
                                    JOptionPane.showMessageDialog(this,
                                            "Nie dodano żadnego rekordu, spróbuj ponownie lub skontaktuj się z administratorem",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                }

                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
                }
                break;
                case 3: {
                    napis = new JLabel("Podaj dane rekordu do dodania oraz wybierz powiązane rekordy");
                    napis.setBounds(100, 10, 400, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Data wpłaty");
                    u1.setBounds(30, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Czy oplacone? tak/nie");
                    u2.setBounds(240, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Rabat");
                    u3.setBounds(450, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Data wystawienia");
                    u4.setBounds(240, 110, 200, 30);
                    u4.setVisible(true);
                    add(u4);

                    String[] wybor = new String[500];
                    AtomicReference<Integer> domki = new AtomicReference<>(0);
                    int i = 0;
                    ResultSet rs = stmt.executeQuery("SELECT imie, nazwisko, data_zlozenia_zamowienia from Wypozyczenie_domkow INNER JOIN Klient on Klient.idKlient" +
                            " = Wypozyczenie_domkow.Klient_idKlient ORDER BY idWypozyczenie_domkow ASC");
                    while(rs.next())
                    {
                        wybor[i] = rs.getString("imie") + " " + rs.getString("nazwisko") + " " + rs.getString("data_zlozenia_zamowienia");
                        i = i + 1;
                    }
                    c1 = new JComboBox<>(wybor);
                    c1.setBounds(30, 110, 200, 30);
                    c1.setVisible(true);
                    add(c1);
                    c1.addActionListener(
                            g-> {
                                domki.set(c1.getSelectedIndex()+1);
                                try {
                                    ResultSet a = stmt.executeQuery("SELECT TOP " + domki + " idWypozyczenie_domkow FROM Wypozyczenie_domkow ORDER BY idWypozyczenie_domkow DESC");
                                    a.next();
                                    domki.set(a.getInt("idWypozyczenie_domkow"));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            });

                    dalej = new JButton("Dodaj");
                    dalej.setBounds(260, 160, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 210, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                double cena_nt = 0.0;
                                try {
                                    ResultSet c = stmt.executeQuery("SELECT laczna_cena from Wypozyczenie_domkow WHERE idWypozyczenie_domkow = " + domki);
                                    c.next();
                                    cena_nt = c.getFloat("laczna_cena");
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                                double cena_br = cena_nt * 1.23;
                                String data = u4.getText();
                                double rabat = Double.parseDouble(u3.getText());
                                String czy = u2.getText();
                                int czy_oplacone = 0;
                                if(czy.equals("tak"))
                                    czy_oplacone = 1;
                                String data_wp = u1.getText();

                                try {
                                    int a = stmt.executeUpdate("INSERT INTO Rachunek_faktura(cena_netto, cena_brutto, data_wystawienia, czy_oplacone, " +
                                            "data_wplaty, rabat, Wypozyczenie_domkow_idWypozyczenie_domkow) VALUES (" + cena_nt + ", " + cena_br + ", '" + data + "', "
                                            + czy_oplacone + ", '" + data_wp + "', " + rabat + ", " + domki + ")");
                                    if (a > 0) {
                                        JOptionPane.showMessageDialog(this,
                                                "Poprawnie dodano rekord",
                                                "Sukces",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie udało się dodać rekordu, sprawdź dane",
                                                "Błąd",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch (SQLException throwables) {
                                    JOptionPane.showMessageDialog(this,
                                            "Nie dodano żadnego rekordu, spróbuj ponownie lub skontaktuj się z administratorem",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                }

                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
                }
                break;
                case 4: {
                    napis = new JLabel("Podaj dane rekordu do dodania oraz wybierz powiązane rekordy");
                    napis.setBounds(100, 10, 400, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Nazwa");
                    u1.setBounds(30, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Cena za godzinę");
                    u2.setBounds(240, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Data przeglądu");
                    u3.setBounds(450, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Lokalizacja");
                    u4.setBounds(30, 110, 200, 30);
                    u4.setVisible(true);
                    add(u4);

                    dalej = new JButton("Dodaj");
                    dalej.setBounds(260, 160, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 210, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String nazwa = u1.getText();
                                String cena = u2.getText();
                                String data = u3.getText();
                                String lokalizacja = u4.getText();

                                try {
                                    int a = stmt.executeUpdate("INSERT INTO Sprzet(nazwa, cena_za_godzine, data_nastepnego_przegladu, lokalizacja)" +
                                            "VALUES ('" + nazwa + "', '" + cena + "', '" + data + "', '" + lokalizacja + "')");
                                    if (a > 0) {
                                        JOptionPane.showMessageDialog(this,
                                                "Poprawnie dodano rekord",
                                                "Sukces",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie udało się dodać rekordu, sprawdź dane",
                                                "Błąd",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch (SQLException throwables) {
                                    JOptionPane.showMessageDialog(this,
                                            "Nie dodano żadnego rekordu, spróbuj ponownie lub skontaktuj się z administratorem",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                }

                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
                }
                break;
                case 5: {
                    napis = new JLabel("Podaj dane rekordu do dodania oraz wybierz powiązane rekordy");
                    napis.setBounds(100, 10, 400, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Uwagi");
                    u1.setBounds(30, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Data od");
                    u2.setBounds(240, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Data do");
                    u3.setBounds(450, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Cena");
                    u4.setBounds(240, 160, 200, 30);
                    u4.setVisible(true);
                    add(u4);
                    String[] wybor = new String[500];
                    AtomicInteger pracownik = new AtomicInteger();
                    AtomicInteger klient = new AtomicInteger();
                    AtomicInteger sprzet = new AtomicInteger();
                    int i = 0;
                    ResultSet rs = stmt.executeQuery("SELECT imie, nazwisko from Pracownik");
                    while(rs.next())
                    {
                        wybor[i] = rs.getString("imie") + " " + rs.getString("nazwisko");
                        i = i + 1;
                    }
                    c1 = new JComboBox<>(wybor);
                    c1.setBounds(30, 110, 200, 30);
                    c1.setVisible(true);
                    add(c1);
                    c1.addActionListener(
                            g-> {
                                pracownik.set(c1.getSelectedIndex()+1);
                                try {
                                    ResultSet a = stmt.executeQuery("SELECT TOP " + pracownik + " idPracownik FROM Pracownik ORDER BY idPracownik DESC");
                                    a.next();
                                    pracownik.set(a.getInt("idPracownik"));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            });

                    String[] wybor2 = new String[500];
                    i = 0;
                    rs = stmt.executeQuery("SELECT imie, nazwisko from Klient");
                    while(rs.next())
                    {
                        wybor2[i] = rs.getString("imie") + " " + rs.getString("nazwisko");
                        i = i + 1;
                    }
                    c2 = new JComboBox<>(wybor2);
                    c2.setBounds(240, 110, 200, 30);
                    c2.setVisible(true);
                    add(c2);
                    c2.addActionListener(
                                    g-> {
                                        klient.set(c2.getSelectedIndex()+1);
                                        try {
                                            ResultSet a = stmt.executeQuery("SELECT TOP " + klient + " idKlient FROM Klient ORDER BY idKlient DESC");
                                            a.next();
                                            klient.set(a.getInt("idKlient"));
                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                        }
                                    });

                    String[] wybor3 = new String[500];
                    i = 0;
                    rs = stmt.executeQuery("SELECT nazwa from Sprzet");
                    while(rs.next())
                    {
                        wybor3[i] = rs.getString("nazwa");
                        i = i + 1;
                    }
                    c3 = new JComboBox<>(wybor3);
                    c3.setBounds(450, 110, 200, 30);
                    c3.setVisible(true);
                    add(c3);
                    c3.addActionListener(
                            g-> {
                                sprzet.set(c3.getSelectedIndex()+1);
                                try {
                                    ResultSet a = stmt.executeQuery("SELECT TOP " + sprzet + " idSprzet FROM Sprzet ORDER BY idSprzet DESC");
                                    a.next();
                                    sprzet.set(a.getInt("idSprzet"));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            });

                    dalej = new JButton("Dodaj");
                    dalej.setBounds(260, 210, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 260, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String uwagi = u1.getText();
                                String data_od = u2.getText();
                                String data_do = u3.getText();
                                String cena = u4.getText();

                                try {
                                    int a = stmt.executeUpdate("INSERT INTO Zarezerwowanie_sprzetu(uwagi, data_od, data_do, cena, Pracownik_idPracownik, Sprzet_idSprzet, " +
                                                    "Klient_idKlient)" +
                                            "VALUES ('" + uwagi + "', '" + data_od + "', '" + data_do + "', '" + cena + "', '" + pracownik
                                            + "', '" + sprzet + "', '" + klient + "')");

                                    if (a > 0) {
                                        JOptionPane.showMessageDialog(this,
                                                "Poprawnie dodano rekord",
                                                "Sukces",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie udało się dodać rekordu, sprawdź dane",
                                                "Błąd",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch (SQLException throwables) {
                                    JOptionPane.showMessageDialog(this,
                                            "Nie dodano żadnego rekordu, spróbuj ponownie lub skontaktuj się z administratorem",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                }

                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
                }
                break;
                case 6: {
                    napis = new JLabel("Podaj dane rekordu do dodania oraz wybierz powiązane rekordy");
                    napis.setBounds(100, 10, 400, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Cena");
                    u1.setBounds(30, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Data");
                    u2.setBounds(240, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Uwagi");
                    u3.setBounds(450, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);

                    String[] wybor = new String[500];
                    AtomicInteger pracownik = new AtomicInteger();
                    AtomicInteger klient = new AtomicInteger();
                    int i = 0;
                    ResultSet rs = stmt.executeQuery("SELECT imie, nazwisko from Pracownik");
                    while(rs.next())
                    {
                        wybor[i] = rs.getString("imie") + " " + rs.getString("nazwisko");
                        i = i + 1;
                    }
                    c1 = new JComboBox<>(wybor);
                    c1.setBounds(30, 110, 200, 30);
                    c1.setVisible(true);
                    add(c1);
                    c1.addActionListener(
                                    g-> {
                                        pracownik.set(c1.getSelectedIndex()+1);
                                        try {
                                            ResultSet a = stmt.executeQuery("SELECT TOP " + pracownik + " idPracownik FROM Pracownik ORDER BY idPracownik DESC");
                                            a.next();
                                            pracownik.set(a.getInt("idPracownik"));
                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                        }
                                    });

                    String[] wybor2 = new String[500];
                    i = 0;
                    rs = stmt.executeQuery("SELECT imie, nazwisko from Klient");
                    while(rs.next())
                    {
                        wybor2[i] = rs.getString("imie") + " " + rs.getString("nazwisko");
                        i = i + 1;
                    }
                    c2 = new JComboBox<>(wybor2);
                    c2.setBounds(240, 110, 200, 30);
                    c2.setVisible(true);
                    add(c2);
                    c2.addActionListener(
                            g-> {
                                klient.set(c2.getSelectedIndex()+1);
                                try {
                                    ResultSet a = stmt.executeQuery("SELECT TOP " + klient + " idKlient FROM Klient ORDER BY idKlient DESC");
                                    a.next();
                                    klient.set(a.getInt("idKlient"));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            });

                    dalej = new JButton("Dodaj");
                    dalej.setBounds(260, 210, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 260, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String uwagi = u3.getText();
                                String data = u2.getText();
                                String cena = u1.getText();

                                try {
                                    int a = stmt.executeUpdate("INSERT INTO Wypozyczenie_domkow(uwagi, data_zlozenia_zamowienia, laczna_cena, Pracownik_idPracownik, " +
                                            "Klient_idKlient) VALUES ('" + uwagi + "', '" + data + "', '" + cena + "', '" + pracownik + "', '" + klient + "')");
                                    if (a > 0) {
                                        JOptionPane.showMessageDialog(this,
                                                "Poprawnie dodano rekord",
                                                "Sukces",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie udało się dodać rekordu, sprawdź dane",
                                                "Błąd",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch (SQLException throwables) {
                                    JOptionPane.showMessageDialog(this,
                                            "Nie dodano żadnego rekordu, spróbuj ponownie lub skontaktuj się z administratorem",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                }

                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
                }
                break;
                case 7: {
                    napis = new JLabel("Podaj dane rekordu do dodania oraz wybierz powiązane rekordy");
                    napis.setBounds(100, 10, 400, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Cena");
                    u1.setBounds(30, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Data od");
                    u2.setBounds(240, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Data do");
                    u3.setBounds(450, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);

                    String[] wybor = new String[500];
                    AtomicInteger domek = new AtomicInteger();
                    AtomicInteger domki = new AtomicInteger();
                    int i = 0;
                    ResultSet rs = stmt.executeQuery("SELECT imie, nazwisko, data_zlozenia_zamowienia from Wypozyczenie_domkow INNER JOIN Klient on Klient.idKlient" +
                            " = Wypozyczenie_domkow.Klient_idKlient ORDER BY idWypozyczenie_domkow ASC");
                    while(rs.next())
                    {
                        wybor[i] = rs.getString("imie") + " " + rs.getString("nazwisko") + " " + rs.getString("data_zlozenia_zamowienia");
                        i = i + 1;
                    }
                    c1 = new JComboBox<>(wybor);
                    c1.setBounds(30, 110, 200, 30);
                    c1.setVisible(true);
                    add(c1);
                    c1.addActionListener(
                            g-> {
                                domki.set(c1.getSelectedIndex()+1);
                                try {
                                    ResultSet a = stmt.executeQuery("SELECT TOP " + domki + " idWypozyczenie_domkow FROM Wypozyczenie_domkow ORDER BY idWypozyczenie_domkow DESC");
                                    a.next();
                                    domki.set(a.getInt("idWypozyczenie_domkow"));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            });

                    String[] wybor2 = new String[500];
                    i = 0;
                    rs = stmt.executeQuery("SELECT nazwa from Domek_letniskowy");
                    while(rs.next())
                    {
                        wybor2[i] = rs.getString("nazwa");
                        i = i + 1;
                    }
                    c2 = new JComboBox<>(wybor2);
                    c2.setBounds(240, 110, 200, 30);
                    c2.setVisible(true);
                    add(c2);
                    c2.addActionListener(
                            g-> {
                                domek.set(c2.getSelectedIndex()+1);
                                try {
                                    ResultSet a = stmt.executeQuery("SELECT TOP " + domek + " id FROM Domek_letniskowy ORDER BY id DESC");
                                    a.next();
                                    domek.set(a.getInt("id"));
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            });

                    dalej = new JButton("Dodaj");
                    dalej.setBounds(260, 160, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 210, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String data_od = u2.getText();
                                String data_do = u3.getText();
                                String cena = u1.getText();

                                try {
                                    int a = stmt.executeUpdate("INSERT INTO Wypozyczenie_domku(cena, data__od, data__do, Wypozyczenie_domkow_idWypozyczenie_domkow, " +
                                            "Domek_letniskowy_id) VALUES ('" + cena + "', '" + data_od + "', '" + data_do + "', " + domki + ", " + domek + ")");
                                    if (a > 0) {
                                        JOptionPane.showMessageDialog(this,
                                                "Poprawnie dodano rekord",
                                                "Sukces",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie udało się dodać rekordu, sprawdź dane",
                                                "Błąd",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch (SQLException throwables) {
                                    JOptionPane.showMessageDialog(this,
                                            "Nie dodano żadnego rekordu, spróbuj ponownie lub skontaktuj się z administratorem",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
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

package baseapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PracownikMenu extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu Plik, Pomoc;
    JMenuItem SprawdzPolaczenie, Wyjscie, Informacja;
    JButton wPrac, wKlient, wDomekLetniskowy, wWypozyczenieDomkow, wSprzet, wFaktura, wZarezerwowanieSprzetu, wWypozyczenieDomku, wyswietl, dodaj, usun, wroc;
    JLabel informacja, plan;
    public static int data = 0, ekran = 0;

    public void PracownikMenu(String username, String password) {
        setWindowPosition(this, ekran);
        setTitle("Zarządzanie baza danych");
        setSize(570, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        plan = new JLabel("Co chcesz zrobić?");
        plan.setBounds(215, 10, 200, 30);
        plan.setVisible(true);
        add(plan);

        wyswietl = new JButton("Wyświetlić dane");
        wyswietl.setBounds(10, 60, 170, 30);
        wyswietl.setVisible(true);
        wyswietl.addActionListener(this);
        add(wyswietl);

        usun = new JButton("Usunąć dane");
        usun.setBounds(190, 60, 170, 30);
        usun.setVisible(true);
        usun.addActionListener(this);
        add(usun);

        dodaj = new JButton("Dodać dane");
        dodaj.setBounds(370, 60, 170, 30);
        dodaj.setVisible(true);
        dodaj.addActionListener(this);
        add(dodaj);

        wyswietl.addActionListener(
                e -> {
                    informacja = new JLabel("Wybierz opcję poniżej");
                    informacja.setBounds(215, 10, 200, 30);
                    informacja.setVisible(true);
                    add(informacja);

                    wPrac = new JButton("Wyświetl pracowników");
                    wPrac.setBounds(10, 60, 170, 30);
                    wPrac.setVisible(true);
                    wPrac.addActionListener(this);
                    add(wPrac);
                    wPrac.addActionListener(
                            g -> JOptionPane.showMessageDialog(this,
                                    "Nie można zobaczyć danych innych pracowników, skontaktuj się z administratorem",
                                    "Błąd",
                                    JOptionPane.ERROR_MESSAGE));

                    wKlient = new JButton("Wyświetl klientów");
                    wKlient.setBounds(190, 60, 170, 30);
                    wKlient.setVisible(true);
                    wKlient.addActionListener(this);
                    add(wKlient);
                    wKlient.addActionListener(
                            g -> {
                                data = 1;
                                Wynik wynikDlg = new Wynik(this, password, username, data);
                                wynikDlg.setVisible(true);
                            });

                    wDomekLetniskowy = new JButton("Wyświetl domki");
                    wDomekLetniskowy.setBounds(370, 60, 170, 30);
                    wDomekLetniskowy.setVisible(true);
                    wDomekLetniskowy.addActionListener(this);
                    add(wDomekLetniskowy);
                    wDomekLetniskowy.addActionListener(
                            g -> {
                                data = 2;
                                Wynik wynikDlg = new Wynik(this, password, username, data);
                                wynikDlg.setVisible(true);
                            });

                    wFaktura = new JButton("Wyświetl faktury");
                    wFaktura.setBounds(10, 110, 170, 30);
                    wFaktura.setVisible(true);
                    wFaktura.addActionListener(this);
                    add(wFaktura);
                    wFaktura.addActionListener(
                            g -> {
                                data = 3;
                                Wynik wynikDlg = new Wynik(this, password, username, data);
                                wynikDlg.setVisible(true);
                            });

                    wSprzet = new JButton("Wyświetl sprzęt");
                    wSprzet.setBounds(190, 110, 170, 30);
                    wSprzet.setVisible(true);
                    wSprzet.addActionListener(this);
                    add(wSprzet);
                    wSprzet.addActionListener(
                            g -> {
                                data = 4;
                                Wynik wynikDlg = new Wynik(this, password, username, data);
                                wynikDlg.setVisible(true);
                            });

                    wZarezerwowanieSprzetu = new JButton("Wyświetl rezerwacje");
                    wZarezerwowanieSprzetu.setBounds(370, 110, 170, 30);
                    wZarezerwowanieSprzetu.setVisible(true);
                    wZarezerwowanieSprzetu.addActionListener(this);
                    add(wZarezerwowanieSprzetu);
                    wZarezerwowanieSprzetu.addActionListener(
                            g -> {
                                data = 5;
                                Wynik wynikDlg = new Wynik(this, password, username, data);
                                wynikDlg.setVisible(true);
                            });

                    wWypozyczenieDomkow = new JButton("Wyświetl wypożyczenia domków");
                    wWypozyczenieDomkow.setBounds(35, 160, 230, 30);
                    wWypozyczenieDomkow.setVisible(true);
                    wWypozyczenieDomkow.addActionListener(this);
                    add(wWypozyczenieDomkow);
                    wWypozyczenieDomkow.addActionListener(
                            g -> {
                                data = 6;
                                Wynik wynikDlg = new Wynik(this, password, username, data);
                                wynikDlg.setVisible(true);
                            });

                    wWypozyczenieDomku = new JButton("Wyświetl wypożyczenie domku");
                    wWypozyczenieDomku.setBounds(275, 160, 230, 30);
                    wWypozyczenieDomku.setVisible(true);
                    wWypozyczenieDomku.addActionListener(this);
                    add(wWypozyczenieDomku);
                    wWypozyczenieDomku.addActionListener(
                            g -> {
                                data = 7;
                                Wynik wynikDlg = new Wynik(this, password, username, data);
                                wynikDlg.setVisible(true);
                            });
                    plan.setVisible(false);
                    remove(wyswietl);
                    remove(usun);
                    remove(dodaj);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(225, 210, 80, 30);
                    wroc.setVisible(true);
                    wroc.addActionListener(this);
                    add(wroc);
                    wroc.addActionListener(
                            g -> {
                                plan.setVisible(true);
                                add(wyswietl);
                                add(usun);
                                add(dodaj);
                                remove(informacja);
                                remove(wWypozyczenieDomku);
                                remove(wWypozyczenieDomkow);
                                remove(wZarezerwowanieSprzetu);
                                remove(wSprzet);
                                remove(wFaktura);
                                remove(wDomekLetniskowy);
                                remove(wKlient);
                                remove(wPrac);
                                remove(wroc);
                                this.repaint();
                            });
                    this.repaint();
                });

        usun.addActionListener(
                e -> {
                    informacja = new JLabel("Wybierz opcję poniżej");
                    informacja.setBounds(215, 10, 200, 30);
                    informacja.setVisible(true);
                    add(informacja);

                    wKlient = new JButton("Usuń klientów");
                    wKlient.setBounds(10, 60, 170, 30);
                    wKlient.setVisible(true);
                    wKlient.addActionListener(this);
                    add(wKlient);
                    wKlient.addActionListener(
                            g -> {
                                data = 1;
                                Usun usunDlg = new Usun(this, password, username, data);
                                usunDlg.setVisible(true);
                            });

                    wDomekLetniskowy = new JButton("Usuń domki");
                    wDomekLetniskowy.setBounds(190, 60, 170, 30);
                    wDomekLetniskowy.setVisible(true);
                    wDomekLetniskowy.addActionListener(this);
                    add(wDomekLetniskowy);
                    wDomekLetniskowy.addActionListener(
                            g -> {
                                data = 2;
                                Usun usunDlg = new Usun(this, password, username, data);
                                usunDlg.setVisible(true);
                            });


                    wSprzet = new JButton("Usuń sprzęt");
                    wSprzet.setBounds(370, 60, 170, 30);
                    wSprzet.setVisible(true);
                    wSprzet.addActionListener(this);
                    add(wSprzet);
                    wSprzet.addActionListener(
                            g -> {
                                data = 4;
                                Usun usunDlg = new Usun(this, password, username, data);
                                usunDlg.setVisible(true);
                            });

                    wZarezerwowanieSprzetu = new JButton("Usuń rezerwacje");
                    wZarezerwowanieSprzetu.setBounds(190, 110, 170, 30);
                    wZarezerwowanieSprzetu.setVisible(true);
                    wZarezerwowanieSprzetu.addActionListener(this);
                    add(wZarezerwowanieSprzetu);
                    wZarezerwowanieSprzetu.addActionListener(
                            g -> {
                                data = 5;
                                Usun usunDlg = new Usun(this, password, username, data);
                                usunDlg.setVisible(true);
                            });

                    wWypozyczenieDomkow = new JButton("Usuń wypożyczenia domków");
                    wWypozyczenieDomkow.setBounds(160, 160, 230, 30);
                    wWypozyczenieDomkow.setVisible(true);
                    wWypozyczenieDomkow.addActionListener(this);
                    add(wWypozyczenieDomkow);
                    wWypozyczenieDomkow.addActionListener(
                            g -> {
                                data = 6;
                                Usun usunDlg = new Usun(this, password, username, data);
                                usunDlg.setVisible(true);
                            });

                    wWypozyczenieDomku = new JButton("Usuń wypożyczenie domku");
                    wWypozyczenieDomku.setBounds(160, 210, 230, 30);
                    wWypozyczenieDomku.setVisible(true);
                    wWypozyczenieDomku.addActionListener(this);
                    add(wWypozyczenieDomku);
                    wWypozyczenieDomku.addActionListener(
                            g -> {
                                data = 7;
                                Usun usunDlg = new Usun(this, password, username, data);
                                usunDlg.setVisible(true);
                            });
                    plan.setVisible(false);
                    remove(wyswietl);
                    remove(usun);
                    remove(dodaj);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(225, 260, 80, 30);
                    wroc.setVisible(true);
                    wroc.addActionListener(this);
                    add(wroc);
                    wroc.addActionListener(
                            g -> {
                                plan.setVisible(true);
                                add(wyswietl);
                                add(usun);
                                add(dodaj);
                                remove(informacja);
                                remove(wWypozyczenieDomku);
                                remove(wWypozyczenieDomkow);
                                remove(wZarezerwowanieSprzetu);
                                remove(wSprzet);
                                remove(wDomekLetniskowy);
                                remove(wKlient);
                                remove(wroc);
                                this.repaint();
                            });
                    this.repaint();
                });

        dodaj.addActionListener(
                e -> {
                    informacja = new JLabel("Wybierz opcję poniżej");
                    informacja.setBounds(215, 10, 200, 30);
                    informacja.setVisible(true);
                    add(informacja);

                    wKlient = new JButton("Dodaj klientów");
                    wKlient.setBounds(10, 60, 170, 30);
                    wKlient.setVisible(true);
                    wKlient.addActionListener(this);
                    add(wKlient);
                    wKlient.addActionListener(
                            g -> {
                                data = 1;
                                Dodaj dodajDlg = new Dodaj(this, password, username, data);
                                dodajDlg.setVisible(true);
                            });

                    wDomekLetniskowy = new JButton("Dodaj domki");
                    wDomekLetniskowy.setBounds(190, 60, 170, 30);
                    wDomekLetniskowy.setVisible(true);
                    wDomekLetniskowy.addActionListener(this);
                    add(wDomekLetniskowy);
                    wDomekLetniskowy.addActionListener(
                            g -> {
                                data = 2;
                                Dodaj dodajDlg = new Dodaj(this, password, username, data);
                                dodajDlg.setVisible(true);
                            });

                    wFaktura = new JButton("Dodaj faktury");
                    wFaktura.setBounds(370, 60, 170, 30);
                    wFaktura.setVisible(true);
                    wFaktura.addActionListener(this);
                    add(wFaktura);
                    wFaktura.addActionListener(
                            g -> {
                                data = 3;
                                Dodaj dodajDlg = new Dodaj(this, password, username, data);
                                dodajDlg.setVisible(true);
                            });

                    wSprzet = new JButton("Dodaj sprzęt");
                    wSprzet.setBounds(90, 110, 170, 30);
                    wSprzet.setVisible(true);
                    wSprzet.addActionListener(this);
                    add(wSprzet);
                    wSprzet.addActionListener(
                            g -> {
                                data = 4;
                                Dodaj dodajDlg = new Dodaj(this, password, username, data);
                                dodajDlg.setVisible(true);
                            });

                    wZarezerwowanieSprzetu = new JButton("Dodaj rezerwacje");
                    wZarezerwowanieSprzetu.setBounds(280, 110, 170, 30);
                    wZarezerwowanieSprzetu.setVisible(true);
                    wZarezerwowanieSprzetu.addActionListener(this);
                    add(wZarezerwowanieSprzetu);
                    wZarezerwowanieSprzetu.addActionListener(
                            g -> {
                                data = 5;
                                Dodaj dodajDlg = new Dodaj(this, password, username, data);
                                dodajDlg.setVisible(true);
                            });

                    wWypozyczenieDomkow = new JButton("Dodaj wypożyczenia domków");
                    wWypozyczenieDomkow.setBounds(150, 160, 230, 30);
                    wWypozyczenieDomkow.setVisible(true);
                    wWypozyczenieDomkow.addActionListener(this);
                    add(wWypozyczenieDomkow);
                    wWypozyczenieDomkow.addActionListener(
                            g -> {
                                data = 6;
                                Dodaj dodajDlg = new Dodaj(this, password, username, data);
                                dodajDlg.setVisible(true);
                            });

                    wWypozyczenieDomku = new JButton("Dodaj wypożyczenie domku");
                    wWypozyczenieDomku.setBounds(150, 210, 230, 30);
                    wWypozyczenieDomku.setVisible(true);
                    wWypozyczenieDomku.addActionListener(this);
                    add(wWypozyczenieDomku);
                    wWypozyczenieDomku.addActionListener(
                            g -> {
                                data = 7;
                                Dodaj dodajDlg = new Dodaj(this, password, username, data);
                                dodajDlg.setVisible(true);
                            });
                    plan.setVisible(false);
                    remove(wyswietl);
                    remove(usun);
                    remove(dodaj);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(225, 260, 80, 30);
                    wroc.setVisible(true);
                    wroc.addActionListener(this);
                    add(wroc);
                    wroc.addActionListener(
                            g -> {
                                plan.setVisible(true);
                                add(wyswietl);
                                add(usun);
                                add(dodaj);
                                remove(informacja);
                                remove(wWypozyczenieDomku);
                                remove(wWypozyczenieDomkow);
                                remove(wZarezerwowanieSprzetu);
                                remove(wSprzet);
                                remove(wFaktura);
                                remove(wDomekLetniskowy);
                                remove(wKlient);
                                remove(wroc);
                                this.repaint();
                            });
                    this.repaint();
                });

        menuBar = new JMenuBar();
        Plik = new JMenu("Menu");
        Pomoc = new JMenu("Pomoc");

        SprawdzPolaczenie = new JMenuItem("Sprawdź połączenie", 'O');
        Wyjscie = new JMenuItem("Wyjście");
        Plik.add(SprawdzPolaczenie);
        SprawdzPolaczenie.addActionListener(this);
        Plik.add(Wyjscie);

        Wyjscie.addActionListener(this);
        Wyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        Informacja = new JMenuItem("Informacja");
        Pomoc.add(Informacja);
        Informacja.addActionListener(this);

        setJMenuBar(menuBar);
        menuBar.add(Plik);
        menuBar.add(Pomoc);
    }

    private void setWindowPosition(JFrame window, int screen)
    {

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] allDevices = env.getScreenDevices();
        int topLeftX, topLeftY, screenX, screenY, windowPosX, windowPosY;

        if (screen < allDevices.length && screen > -1)
        {
            topLeftX = allDevices[screen].getDefaultConfiguration().getBounds().x;
            topLeftY = allDevices[screen].getDefaultConfiguration().getBounds().y;

            screenX  = allDevices[screen].getDefaultConfiguration().getBounds().width;
            screenY  = allDevices[screen].getDefaultConfiguration().getBounds().height;
        }
        else
        {
            topLeftX = allDevices[0].getDefaultConfiguration().getBounds().x;
            topLeftY = allDevices[0].getDefaultConfiguration().getBounds().y;

            screenX  = allDevices[0].getDefaultConfiguration().getBounds().width;
            screenY  = allDevices[0].getDefaultConfiguration().getBounds().height;
        }

        windowPosX = ((screenX - window.getWidth())  / 2) + topLeftX;
        windowPosY = ((screenY - window.getHeight()) / 2) + topLeftY;

        window.setLocation(windowPosX - 285, windowPosY - 400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object zrodlo = e.getSource();
        if (zrodlo == Wyjscie) {
            int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno?", "Pytanie", JOptionPane.YES_NO_OPTION);
            if (odp == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
        if (zrodlo == Informacja) {
            JOptionPane.showMessageDialog(this, "O programie ... \n Aplikacje bazodanowe", "Tytuł", JOptionPane.WARNING_MESSAGE);
        }

        if (zrodlo == SprawdzPolaczenie) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://" +
                        "localhost\\SQL_Piotrek:24573;databaseName=Piotrek;" + "user=admin;password=admin;");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT GETDATE() as kolumna");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Połączenie nadal trwa", "Status połączenia", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Połączenie zerwane", "Status połączenia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException | ClassNotFoundException d) {
                d.printStackTrace();
            }
        }
    }
}

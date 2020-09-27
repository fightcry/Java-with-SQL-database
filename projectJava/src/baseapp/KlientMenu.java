package baseapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class KlientMenu extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu Plik, Pomoc;
    JMenuItem SprawdzPolaczenie, Wyjscie, Informacja;
    JButton wDomekLetniskowy, wSprzet, wyswietl, wroc;
    JLabel informacja, plan;
    public static int data = 0, ekran = 0;

    public void KlientMenu(String password, String username) {
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

        wyswietl.addActionListener(
                e -> {
                    informacja = new JLabel("Wybierz opcję poniżej");
                    informacja.setBounds(215, 10, 200, 30);
                    informacja.setVisible(true);
                    add(informacja);

                    wDomekLetniskowy = new JButton("Wyświetl domki");
                    wDomekLetniskowy.setBounds(10, 60, 170, 30);
                    wDomekLetniskowy.setVisible(true);
                    wDomekLetniskowy.addActionListener(this);
                    add(wDomekLetniskowy);
                    wDomekLetniskowy.addActionListener(
                            g -> {
                                data = 2;
                                Wynik wynikDlg = new Wynik(this, password, username, data);
                                wynikDlg.setVisible(true);
                            });

                    wSprzet = new JButton("Wyświetl sprzęt");
                    wSprzet.setBounds(190, 60, 170, 30);
                    wSprzet.setVisible(true);
                    wSprzet.addActionListener(this);
                    add(wSprzet);
                    wSprzet.addActionListener(
                            g -> {
                                data = 4;
                                Wynik wynikDlg = new Wynik(this, password, username, data);
                                wynikDlg.setVisible(true);
                            });

                    plan.setVisible(false);
                    remove(wyswietl);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(225, 110, 80, 30);
                    wroc.setVisible(true);
                    wroc.addActionListener(this);
                    add(wroc);
                    this.repaint();
                    wroc.addActionListener(
                            g -> {
                                plan.setVisible(true);
                                add(wyswietl);
                                remove(informacja);
                                remove(wSprzet);
                                remove(wDomekLetniskowy);
                                remove(wroc);
                                this.repaint();
                            });
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

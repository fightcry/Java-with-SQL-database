package baseapp;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Usun extends JFrame {

    JLabel napis;
    JTextField u1, u2, u3, u4;
    JButton dalej, wroc;

    public Usun(Frame parent, String password, String username, int dane) {
        setTitle("Usuwanie z baz danych");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(parent);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://" +
                    "localhost\\SQL_Piotrek:24573;databaseName=Piotrek;" + "user=" + username + ";password=" + password);
            Statement stmt = con.createStatement();
            switch (dane) {
                case 0: {
                    napis = new JLabel("Podaj imię, nazwisko, PESEL do usunięcia. Zostaw pole puste by nie szukać po tym polu");
                    napis.setBounds(100, 10, 600, 30);
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

                    dalej = new JButton("Usuń");
                    dalej.setBounds(260, 110, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 160, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String imie = u1.getText();
                                String nazwisko = u2.getText();
                                String PESEL = u3.getText();
                                if (imie.equals("Imię") || nazwisko.equals("Nazwisko") || PESEL.equals("PESEL"))
                                    JOptionPane.showMessageDialog(this,
                                            "Zmień dane z domyślnych lub wyczyść pola",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                else if (imie.isEmpty()) {
                                    if (nazwisko.isEmpty()) {
                                        if (PESEL.isEmpty()) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Podaj jakiekolwiek dane",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            try {
                                                stmt.executeUpdate("DELETE Pracownik where PESEL='" + PESEL + "'");
                                            } catch (SQLException throwables) {
                                                throwables.printStackTrace();
                                            }
                                        }
                                    } else if (PESEL.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Pracownik where nazwisko='" + nazwisko + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Pracownik where nazwisko='" + nazwisko + "' AND PESEL='" + PESEL + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (nazwisko.isEmpty()) {
                                    if (PESEL.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Pracownik where imie='" + imie + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Pracownik where imie='" + imie + "' AND PESEL='" + PESEL + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (PESEL.isEmpty()) {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Pracownik where imie='" + imie + "' AND nazwisko='" + nazwisko + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Pracownik where imie='" + imie + "' AND nazwisko='" + nazwisko + "' AND PESEL='" + PESEL + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
                }
                break;
                case 1: {
                    napis = new JLabel("Podaj imię, nazwisko, PESEL do usunięcia. Zostaw pole puste by nie szukać po tym polu");
                    napis.setBounds(100, 10, 600, 30);
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

                    dalej = new JButton("Usuń");
                    dalej.setBounds(260, 110, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 160, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String imie = u1.getText();
                                String nazwisko = u2.getText();
                                String PESEL = u3.getText();
                                if (imie.equals("Imię") || nazwisko.equals("Nazwisko") || PESEL.equals("PESEL"))
                                    JOptionPane.showMessageDialog(this,
                                            "Zmień dane z domyślnych lub wyczyść pola",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                else if (imie.isEmpty()) {
                                    if (nazwisko.isEmpty()) {
                                        if (PESEL.isEmpty()) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Podaj jakiekolwiek dane",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            try {
                                                int a = stmt.executeUpdate("DELETE Klient where PESEL='" + PESEL + "'");
                                                if (a > 0) {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Poprawnie usunięto " + a + " rekordów",
                                                            "Sukces",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                            "Błąd",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            } catch (SQLException throwables) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                        "Błąd",
                                                        JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } else if (PESEL.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Klient where nazwisko='" + nazwisko + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Klient where nazwisko='" + nazwisko + "' AND PESEL='" + PESEL + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (nazwisko.isEmpty()) {
                                    if (PESEL.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Klient where imie='" + imie + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Klient where imie='" + imie + "' AND PESEL='" + PESEL + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (PESEL.isEmpty()) {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Klient where imie='" + imie + "' AND nazwisko='" + nazwisko + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Klient where imie='" + imie + "' AND nazwisko='" + nazwisko + "' AND PESEL='" + PESEL + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                    wroc.addActionListener(
                            g -> dispose());
                    this.repaint();
                }
                break;
                case 2: {
                    setSize(750, 800);
                    napis = new JLabel("Podaj nazwę, datę budowy(yyyy/mm/dd) oraz ilość miejsc do usunięcia. Zostaw pole puste by nie szukać po tym polu");
                    napis.setBounds(25, 10, 700, 60);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Nazwa");
                    u1.setBounds(55, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Data budowy");
                    u2.setBounds(265, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Ilość miejsc");
                    u3.setBounds(475, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);

                    dalej = new JButton("Usuń");
                    dalej.setBounds(285, 110, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(285, 160, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String imie = u1.getText();
                                String nazwisko = u2.getText();
                                String PESEL = u3.getText();
                                if (imie.equals("Nazwa") || nazwisko.equals("Data budowy") || PESEL.equals("Ilość miejsc"))
                                    JOptionPane.showMessageDialog(this,
                                            "Zmień dane z domyślnych lub wyczyść pola",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                else if (imie.isEmpty()) {
                                    if (nazwisko.isEmpty()) {
                                        if (PESEL.isEmpty()) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Podaj jakiekolwiek dane",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            try {
                                                int a = stmt.executeUpdate("DELETE Domek_letniskowy where ilosc_miejsc='" + PESEL + "'");
                                                if (a > 0) {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Poprawnie usunięto " + a + " rekordów",
                                                            "Sukces",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                            "Błąd",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            } catch (SQLException throwables) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                        "Błąd",
                                                        JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } else if (PESEL.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Domek_letniskowy where data_budowy='" + nazwisko + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Domek_letniskowy where data_budowy='" + nazwisko + "' AND ilosc_miejsc='" + PESEL + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (nazwisko.isEmpty()) {
                                    if (PESEL.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Domek_letniskowy where nazwa='" + imie + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Domek_letniskowy where nazwa='" + imie + "' AND ilosc_miejsc='" + PESEL + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (PESEL.isEmpty()) {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Domek_letniskowy where nazwa='" + imie + "' AND data_budowy='" + nazwisko + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Domek_letniskowy where nazwa='" + imie + "' AND data_budowy='" + nazwisko + "' AND ilosc_miejsc='" + PESEL + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                    wroc.addActionListener(
                            g -> dispose());
                    this.repaint();
                }
                break;
                case 3: {
                    setSize(750, 800);
                    napis = new JLabel("Podaj cenę netto, datę wystawienia(yyyy/mm/dd) oraz imię i nazwisko klienta. Zostaw pole puste by nie szukać po tym polu");
                    napis.setBounds(25, 10, 640, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Cena netto");
                    u1.setBounds(53, 60, 135, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Data wystawienia");
                    u2.setBounds(198, 60, 135, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Imię");
                    u3.setBounds(343, 60, 135, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Nazwisko");
                    u4.setBounds(488, 60, 135, 30);
                    u4.setVisible(true);
                    add(u4);

                    dalej = new JButton("Usuń");
                    dalej.setBounds(285, 110, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(285, 160, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String cena = u1.getText();
                                String data = u2.getText();
                                String imie = u3.getText();
                                String nazwisko = u4.getText();
                                if (cena.equals("Cena netto") || nazwisko.equals("Nazwisko") || imie.equals("Imie") || data.equals("Data wystawienia"))
                                    JOptionPane.showMessageDialog(this,
                                            "Zmień dane z domyślnych lub wyczyść pola",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                else if (cena.isEmpty()) {
                                    if (data.isEmpty()) {
                                        if (imie.isEmpty() || nazwisko.isEmpty()) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Podaj jakiekolwiek dane",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            try {
                                                int a = stmt.executeUpdate("DELETE Rachunek_faktura FROM Rachunek_faktura JOIN Wypozyczenie_domkow ON Wypozyczenie_domkow_idWypozyczenie_domkow" +
                                                        "=Wypozyczenie_domkow.idWypozyczenie_domkow JOIN Klient ON Klient.idKlient = Wypozyczenie_domkow.Klient_idKlient" +
                                                        " WHERE Klient.imie='" + imie + "' AND Klient.nazwisko='" + nazwisko + "'");
                                                if (a > 0) {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Poprawnie usunięto " + a + " rekordów",
                                                            "Sukces",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                            "Błąd",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            } catch (SQLException throwables) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                        "Błąd",
                                                        JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } else if (imie.isEmpty() || nazwisko.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Rachunek_faktura where data_wystawienia='" + data + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Rachunek_faktura FROM Rachunek_faktura JOIN Wypozyczenie_domkow ON Wypozyczenie_domkow_idWypozyczenie_domkow" +
                                                    "=Wypozyczenie_domkow.idWypozyczenie_domkow JOIN Klient ON Klient.idKlient = Wypozyczenie_domkow.Klient_idKlient" +
                                                    " WHERE Klient.imie='" + imie + "' AND Klient.nazwisko='" + nazwisko + "' AND Rachunek_faktura.data_wystawienia='" + data + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (data.isEmpty()) {
                                    if (imie.isEmpty() || nazwisko.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Rachunek_faktura where cena_netto='" + cena + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Rachunek_faktura FROM Rachunek_faktura JOIN Wypozyczenie_domkow ON Wypozyczenie_domkow_idWypozyczenie_domkow" +
                                                    "=Wypozyczenie_domkow.idWypozyczenie_domkow JOIN Klient ON Klient.idKlient = Wypozyczenie_domkow.Klient_idKlient" +
                                                    " WHERE Klient.imie='" + imie + "' AND Klient.nazwisko='" + nazwisko + "' AND Rachunek_faktura.cena_netto='" + cena + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (imie.isEmpty() || nazwisko.isEmpty()) {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Rachunek_faktura where cena_netto='" + cena + "' AND data_wystawienia='" + data + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Rachunek_faktura FROM Rachunek_faktura JOIN Wypozyczenie_domkow ON Wypozyczenie_domkow_idWypozyczenie_domkow" +
                                                "=Wypozyczenie_domkow.idWypozyczenie_domkow JOIN Klient ON Klient.idKlient = Wypozyczenie_domkow.Klient_idKlient" +
                                                " WHERE Klient.imie='" + imie + "' AND Klient.nazwisko='" + nazwisko + "' AND Rachunek_faktura.cena_netto='" + cena +
                                                "' AND Rachunek_faktura.data_wystawienia='" + data + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                    wroc.addActionListener(
                            g -> dispose());
                    this.repaint();
                }
                break;
                case 4: {
                    napis = new JLabel("Podaj nazwę, cenę, lokalizację do usunięcia. Zostaw pole puste by nie szukać po tym polu");
                    napis.setBounds(100, 10, 600, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Nazwa");
                    u1.setBounds(30, 60, 200, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Cena");
                    u2.setBounds(240, 60, 200, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Lokalizacja");
                    u3.setBounds(450, 60, 200, 30);
                    u3.setVisible(true);
                    add(u3);

                    dalej = new JButton("Usuń");
                    dalej.setBounds(260, 110, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(260, 160, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String nazwa = u1.getText();
                                String cena = u2.getText();
                                String lokalizacja = u3.getText();
                                if (nazwa.equals("Nazwa") || cena.equals("Cena") || lokalizacja.equals("Lokalizacja"))
                                    JOptionPane.showMessageDialog(this,
                                            "Zmień dane z domyślnych lub wyczyść pola",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                else if (nazwa.isEmpty()) {
                                    if (cena.isEmpty()) {
                                        if (lokalizacja.isEmpty()) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Podaj jakiekolwiek dane",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            try {
                                                int a = stmt.executeUpdate("DELETE Sprzet where lokalizacja='" + lokalizacja + "'");
                                                if (a > 0) {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Poprawnie usunięto " + a + " rekordów",
                                                            "Sukces",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                            "Błąd",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            } catch (SQLException throwables) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                        "Błąd",
                                                        JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } else if (lokalizacja.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Sprzet where cena_za_godzine='" + cena + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Sprzet where cena_za_godzine='" + cena + "' AND lokalizacja='" + lokalizacja + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (cena.isEmpty()) {
                                    if (lokalizacja.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Sprzet where nazwa='" + nazwa + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Sprzet where nazwa='" + nazwa + "' AND lokalizacja='" + lokalizacja + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (lokalizacja.isEmpty()) {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Sprzet where nazwa='" + nazwa + "' AND cena_za_godzine='" + cena + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Sprzet where nazwa='" + nazwa + "' AND cena_za_godzine='" + cena + "' AND PESEL='" + lokalizacja + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                    wroc.addActionListener(
                            g -> dispose()
                    );
                    this.repaint();
                }
                break;
                case 5: {
                    setSize(750, 800);
                    napis = new JLabel("Podaj cenę, datę od(yyyy/mm/dd) oraz imię i nazwisko klienta. Zostaw pole puste by nie szukać po tym polu");
                    napis.setBounds(25, 10, 640, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Cena");
                    u1.setBounds(53, 60, 135, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Data od");
                    u2.setBounds(198, 60, 135, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Imię");
                    u3.setBounds(343, 60, 135, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Nazwisko");
                    u4.setBounds(488, 60, 135, 30);
                    u4.setVisible(true);
                    add(u4);

                    dalej = new JButton("Usuń");
                    dalej.setBounds(285, 110, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(285, 160, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String cena = u1.getText();
                                String data = u2.getText();
                                String imie = u3.getText();
                                String nazwisko = u4.getText();
                                if (cena.equals("Cena") || nazwisko.equals("Nazwisko") || imie.equals("Imie") || data.equals("Data do"))
                                    JOptionPane.showMessageDialog(this,
                                            "Zmień dane z domyślnych lub wyczyść pola",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                else if (cena.isEmpty()) {
                                    if (data.isEmpty()) {
                                        if (imie.isEmpty() || nazwisko.isEmpty()) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Podaj jakiekolwiek dane",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            try {
                                                int a = stmt.executeUpdate("DELETE Zarezerwowanie_sprzetu FROM Zarezerwowanie_sprzetu JOIN Klient ON Klient_idKlient = " +
                                                        "idKlient WHERE imie='" + imie + "'AND nazwisko='" + nazwisko + "'");
                                            } catch (SQLException throwables) {
                                                throwables.printStackTrace();
                                            }
                                        }
                                    } else if (imie.isEmpty() || nazwisko.isEmpty()) {
                                        try {
                                            stmt.executeUpdate("DELETE Zarezerwowanie_sprzetu WHERE data_od='" + data + "'");
                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Zarezerwowanie_sprzetu FROM Zarezerwowanie_sprzetu JOIN Klient ON Klient_idKlient = " +
                                                    "idKlient WHERE imie='" + imie + "'AND nazwisko='" + nazwisko + "' AND Zarezerwowanie_sprzetu.data_od='" + data + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (data.isEmpty()) {
                                    if (imie.isEmpty() || nazwisko.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Zarezerwowanie_sprzetu WHERE cena='" + cena + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Zarezerwowanie_sprzetu FROM Zarezerwowanie_sprzetu JOIN Klient ON Klient_idKlient = " +
                                                    "idKlient WHERE imie='" + imie + "'AND nazwisko='" + nazwisko + "' AND Zarezerwowanie_sprzetu.cena='" + cena + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (imie.isEmpty() || nazwisko.isEmpty()) {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Zarezerwowanie_sprzetu WHERE cena='" + cena + "' AND data_od='" + data + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Zarezerwowanie_sprzetu FROM Zarezerwowanie_sprzetu JOIN Klient ON Klient_idKlient = " +
                                                "idKlient WHERE imie='" + imie + "'AND nazwisko='" + nazwisko + "' AND Zarezerwowanie_sprzetu.data_od='" + data + "'AND Zarezerwowanie_sprzetu.cena='" + cena + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                    wroc.addActionListener(
                            g -> dispose());
                    this.repaint();
                }
                break;
                case 6: {
                    setSize(750, 800);
                    napis = new JLabel("Podaj cenę, datę(yyyy/mm/dd) oraz imię i nazwisko klienta. Zostaw pole puste by nie szukać po tym polu");
                    napis.setBounds(25, 10, 640, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Cena łączna");
                    u1.setBounds(53, 60, 135, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Data złożenia zamówienia");
                    u2.setBounds(198, 60, 135, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Imię");
                    u3.setBounds(343, 60, 135, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Nazwisko");
                    u4.setBounds(488, 60, 135, 30);
                    u4.setVisible(true);
                    add(u4);

                    dalej = new JButton("Usuń");
                    dalej.setBounds(285, 110, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(285, 160, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String cena = u1.getText();
                                String data = u2.getText();
                                String imie = u3.getText();
                                String nazwisko = u4.getText();
                                if (cena.equals("Cena łączna") || nazwisko.equals("Nazwisko") || imie.equals("Imie") || data.equals("Data złożenia zamówienia"))
                                    JOptionPane.showMessageDialog(this,
                                            "Zmień dane z domyślnych lub wyczyść pola",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                else if (cena.isEmpty()) {
                                    if (data.isEmpty()) {
                                        if (imie.isEmpty() || nazwisko.isEmpty()) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Podaj jakiekolwiek dane",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            try {
                                                int a = stmt.executeUpdate("DELETE Wypozyczenie_domkow FROM Wypozyczenie_domkow " + "JOIN Klient ON Klient.idKlient=" +
                                                        "Wypozyczenie_domkow.Klient_idKlient" +
                                                        " WHERE Klient.imie='" + imie + "' AND Klient.nazwisko='" + nazwisko + "'");
                                                if (a > 0) {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Poprawnie usunięto " + a + " rekordów",
                                                            "Sukces",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                            "Błąd",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            } catch (SQLException throwables) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                        "Błąd",
                                                        JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } else if (imie.isEmpty() || nazwisko.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Wypozyczenie_domkow WHERE data_zlozenia_zamowienia='" + data + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Wypozyczenie_domkow FROM Wypozyczenie_domkow " + "JOIN Klient ON Klient.idKlient=" +
                                                    "Wypozyczenie_domkow.Klient_idKlient" +
                                                    " WHERE Klient.imie='" + imie + "' AND Klient.nazwisko='" + nazwisko + "' AND Wypozyczenie_domkow.data_zlozenia_zamowienia='" +
                                                    data + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (data.isEmpty()) {
                                    if (imie.isEmpty() || nazwisko.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Wypozyczenie_domkow WHERE laczna_cena='" + cena + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Wypozyczenie_domkow FROM Wypozyczenie_domkow " + "JOIN Klient ON Klient.idKlient=" +
                                                    "Wypozyczenie_domkow.Klient_idKlient" +
                                                    " WHERE Klient.imie='" + imie + "' AND Klient.nazwisko='" + nazwisko + "' AND Wypozyczenie_domkow.laczna_cena='" +
                                                    cena + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (imie.isEmpty() || nazwisko.isEmpty()) {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Wypozyczenie_domkow WHERE laczna_cena='" + cena + "' AND data_zlozenia_zamowienia='" + data + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Wypozyczenie_domkow FROM Wypozyczenie_domkow " + "JOIN Klient ON Klient.idKlient=" +
                                                "Wypozyczenie_domkow.Klient_idKlient" +
                                                " WHERE Klient.imie='" + imie + "' AND Klient.nazwisko='" + nazwisko + "' AND Wypozyczenie_domkow.laczna_cena='" +
                                                cena + "' AND Wypozyczenie_domkow.data_zlozenia_zamowienia='" + data + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                    wroc.addActionListener(
                            g -> dispose());
                    this.repaint();
                }
                break;
                case 7: {
                    setSize(750, 800);
                    napis = new JLabel("Podaj nazwę, datę(yyyy/mm/dd) oraz imię i nazwisko klienta. Zostaw pole puste by nie szukać po tym polu");
                    napis.setBounds(25, 10, 640, 30);
                    napis.setVisible(true);
                    add(napis);
                    u1 = new JTextField("Nazwa");
                    u1.setBounds(53, 60, 135, 30);
                    u1.setVisible(true);
                    add(u1);
                    u2 = new JTextField("Data od");
                    u2.setBounds(198, 60, 135, 30);
                    u2.setVisible(true);
                    add(u2);
                    u3 = new JTextField("Imię");
                    u3.setBounds(343, 60, 135, 30);
                    u3.setVisible(true);
                    add(u3);
                    u4 = new JTextField("Nazwisko");
                    u4.setBounds(488, 60, 135, 30);
                    u4.setVisible(true);
                    add(u4);

                    dalej = new JButton("Usuń");
                    dalej.setBounds(285, 110, 170, 30);
                    dalej.setVisible(true);
                    add(dalej);

                    wroc = new JButton("Wróć");
                    wroc.setBounds(285, 160, 170, 30);
                    wroc.setVisible(true);
                    add(wroc);

                    dalej.addActionListener
                            (g -> {
                                String nazwa = u1.getText();
                                String data = u2.getText();
                                String imie = u3.getText();
                                String nazwisko = u4.getText();
                                if (nazwa.equals("Nazwa") || nazwisko.equals("Nazwisko") || imie.equals("Imie") || data.equals("Data od"))
                                    JOptionPane.showMessageDialog(this,
                                            "Zmień dane z domyślnych lub wyczyść pola",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE);
                                else if (nazwa.isEmpty()) {
                                    if (data.isEmpty()) {
                                        if (imie.isEmpty() || nazwisko.isEmpty()) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Podaj jakiekolwiek dane",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            try {
                                                int a = stmt.executeUpdate("DELETE Wypozyczenie_domku FROM Wypozyczenie_domku JOIN Wypozyczenie_domkow ON Wypozyczenie_domkow_idWypozyczenie_domkow IN" +
                                                "(SELECT idWypozyczenie_domkow FROM Wypozyczenie_domkow JOIN Wypozyczenie_domku ON idWypozyczenie_domkow = " +
                                                        "Wypozyczenie_domkow_idWypozyczenie_domkow JOIN Klient ON Klient_idKlient = idKlient WHERE imie='" + imie + "'AND nazwisko='" + nazwisko + "')");
                                                if (a > 0) {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Poprawnie usunięto " + a + " rekordów",
                                                            "Sukces",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(this,
                                                            "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                            "Błąd",
                                                            JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            } catch (SQLException throwables) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                        "Błąd",
                                                        JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } else if (imie.isEmpty() || nazwisko.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Wypozyczenie_domku WHERE data__od='" + data + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Wypozyczenie_domku FROM Wypozyczenie_domku JOIN Wypozyczenie_domkow ON Wypozyczenie_domkow_idWypozyczenie_domkow IN" +
                                                    "(SELECT idWypozyczenie_domkow FROM Wypozyczenie_domkow JOIN Wypozyczenie_domku ON idWypozyczenie_domkow = " +
                                                    "Wypozyczenie_domkow_idWypozyczenie_domkow JOIN Klient ON Klient_idKlient = idKlient WHERE imie='" + imie + "'AND nazwisko='" + nazwisko + "'" +
                                                    "AND data_zlozenia_zamowienia='" + data + "')");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (data.isEmpty()) {
                                    if (imie.isEmpty() || nazwisko.isEmpty()) {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Wypozyczenie_domku FROM Wypozyczenie_domku JOIN Wypozyczenie_domkow ON Wypozyczenie_domkow_idWypozyczenie_domkow IN" +
                                                    "(SELECT idWypozyczenie_domkow FROM Wypozyczenie_domkow JOIN Wypozyczenie_domku ON idWypozyczenie_domkow = " +
                                                    "Wypozyczenie_domkow_idWypozyczenie_domkow JOIN Klient ON Klient_idKlient = idKlient)" +
                                                    "JOIN Domek_letniskowy ON Domek_letniskowy_id = id WHERE nazwa='" + nazwa + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            int a = stmt.executeUpdate("DELETE Wypozyczenie_domku FROM Wypozyczenie_domku JOIN Wypozyczenie_domkow ON Wypozyczenie_domkow_idWypozyczenie_domkow IN" +
                                                    "(SELECT idWypozyczenie_domkow FROM Wypozyczenie_domkow JOIN Wypozyczenie_domku ON idWypozyczenie_domkow = " +
                                                    "Wypozyczenie_domkow_idWypozyczenie_domkow JOIN Klient ON Klient_idKlient = idKlient WHERE imie='" + imie + "'AND nazwisko='" + nazwisko + "')" +
                                                    "JOIN Domek_letniskowy ON Domek_letniskowy_id = id WHERE nazwa='" + nazwa + "'");
                                            if (a > 0) {
                                                JOptionPane.showMessageDialog(this,
                                                        "Poprawnie usunięto " + a + " rekordów",
                                                        "Sukces",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this,
                                                        "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                        "Błąd",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (SQLException throwables) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                    "Błąd",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else if (imie.isEmpty() || nazwisko.isEmpty()) {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Wypozyczenie_domku FROM Wypozyczenie_domku" +
                                                "JOIN Domek_letniskowy ON Domek_letniskowy_id = id WHERE nazwa='" + nazwa + "' AND data__od='" + data + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    try {
                                        int a = stmt.executeUpdate("DELETE Wypozyczenie_domku FROM Wypozyczenie_domku JOIN Wypozyczenie_domkow ON Wypozyczenie_domkow_idWypozyczenie_domkow IN" +
                                                "(SELECT idWypozyczenie_domkow FROM Wypozyczenie_domkow JOIN Wypozyczenie_domku ON idWypozyczenie_domkow = " +
                                                "Wypozyczenie_domkow_idWypozyczenie_domkow JOIN Klient ON Klient_idKlient = idKlient WHERE imie='" + imie + "'AND nazwisko='" + nazwisko + "')" +
                                                "JOIN Domek_letniskowy ON Domek_letniskowy_id = id WHERE nazwa='" + nazwa + "' AND data__od='" + data + "'");
                                        if (a > 0) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Poprawnie usunięto " + a + " rekordów",
                                                    "Sukces",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this,
                                                    "Nie usunięto żadnego rekordu, sprawdź wpisane dane",
                                                    "Błąd",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } catch (SQLException throwables) {
                                        JOptionPane.showMessageDialog(this,
                                                "Nie usunięto żadnego rekordu, sprawdź wpisane dane lub czy istnieją referencje do danego rekordu",
                                                "Błąd",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                    wroc.addActionListener(
                            g -> dispose());
                    this.repaint();
                }
                break;

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

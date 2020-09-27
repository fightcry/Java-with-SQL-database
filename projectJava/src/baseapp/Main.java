package baseapp;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Logowanie do systemu");
        final JButton btnLogin = new JButton("Kliknij by się zalogować");

        btnLogin.addActionListener(
                e -> {
                    Login loginDlg = new Login(frame);
                    loginDlg.setVisible(true);
                    if(loginDlg.isSucceeded()){
                        btnLogin.setText("Poprawnie zalogowano " + loginDlg.getUsername() + "!");

                        if(loginDlg.getUsername().equals("pracownik")) {
                            PracownikMenu menuPrac = new PracownikMenu();
                            menuPrac.setVisible(true);
                            menuPrac.PracownikMenu(loginDlg.getUsername(), loginDlg.getPassword());
                        }
                        if(loginDlg.getUsername().equals("admin")) {
                            AdminMenu menuAdm = new AdminMenu();
                            menuAdm.setVisible(true);
                            menuAdm.AdminMenu(loginDlg.getUsername(), loginDlg.getPassword());
                        }
                        if(loginDlg.getUsername().equals("klient")) {
                            KlientMenu menuKl = new KlientMenu();
                            menuKl.setVisible(true);
                            menuKl.KlientMenu(loginDlg.getUsername(), loginDlg.getPassword());
                        }
                        frame.dispose();
                    }
                });
        setWindowPosition(frame, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.setVisible(true);
    }

    private static void setWindowPosition(JFrame window, int screen)
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

        window.setLocation(windowPosX - 150, windowPosY - 50);
    }
}

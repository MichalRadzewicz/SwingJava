package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Okno extends JFrame  implements ActionListener {
    private JTextField login;
    private JPasswordField password;
    private JButton bLogin,bReset,bExit;
    private JLabel lLogin,lHaslo,lpokazhaslo;
    private JCheckBox cpokazhaslo;
    Okno2 okno2 = new Okno2();
    String log1 = "admin";
    String has1 = "1234";
    String log2 = "admin1";
    String has2 = "5678";





    public Okno() {
        okno2.setTitle("Zarządzanie Magazynem 1.0.0");
        okno2.setLayout(null);
        okno2.setVisible(false);
        okno2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno2.setBounds(0,100,1215,800);
        okno2.setResizable(false);

        login = new JTextField();
        login.setBounds(130,50,100,20);
        login.setToolTipText("Podaj Login");
        login.setText("admin");
        add(login);

        password =  new JPasswordField();
        password.setBounds(130,70,100,20);
        password.setToolTipText("Podaj Hasło");
        password.setEchoChar('₪');
        password.setText("1234");
        add(password);

        lLogin = new JLabel("Login:");
        lLogin.setBounds(95,50,50,20);
        add(lLogin);


        lHaslo = new JLabel("Hasło:");
        lHaslo.setBounds(95,70,50,20);
        add(lHaslo);

        lpokazhaslo = new JLabel("Pokaż Hasło");
        lpokazhaslo.setBounds(230,73,100,20);
        add(lpokazhaslo);



        bLogin = new JButton("Zaloguj");
        bLogin.setBounds(20,100,100,20);
        bLogin.addActionListener(this);
        add(bLogin);

        bReset = new JButton("Reset");
        bReset.setBounds(130,100,100,20);
        bReset.addActionListener(this);
        add(bReset);

        cpokazhaslo = new JCheckBox();
        cpokazhaslo.setBounds(300,75,15,15);
        cpokazhaslo.addActionListener(this);
        cpokazhaslo.setBackground(Color.GRAY);
        add(cpokazhaslo);


        bExit = new JButton("Exit");
        bExit.setBounds(240,100,100,20);
        bExit.addActionListener(this);
        add(bExit);

    }
    public void reset(){
        login.setText("");
        password.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        Object zrodlo = event.getSource();
        if(zrodlo==bLogin){

            if(login.getText().equals(log1) && password.getText().equals(has1) || login.getText().equals(log2) && password.getText().equals(has2)) {
                okno2.setVisible(true);

                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null,"Błędny Login lub Hasło \n Wpisz ponownie dane.","ERROR",JOptionPane.WARNING_MESSAGE);
                reset();
            }
        }
        else if(zrodlo==bReset){
            reset();
        }
        else if(zrodlo==bExit){
            int odpowiedz = JOptionPane.showConfirmDialog(this,"Czy na Pewno chcesz wyjść z programu?","Już odchodzisz?",JOptionPane.YES_NO_OPTION);

            if(odpowiedz==JOptionPane.YES_OPTION){
                dispose();
            }

        }
        else if(zrodlo == cpokazhaslo){
            if(cpokazhaslo.isSelected())
                password.setEchoChar((char) 0);
            else
                password.setEchoChar('₪');

        }

    }
}

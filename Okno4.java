package com.company;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Okno4 extends JFrame implements ActionListener,ChangeListener {
    JButton bdodajPrzedmiot,busunwiersz,bwyczysc;
    JTextField textField1, textField2, textField3, textField4;
    JLabel powierzchnia,nazwa,identyfikator,opis,iloscPrzedmiotow;
    JTable tabelka;
    JPanel panel;
    JSlider slider;
    DefaultTableModel model2;
    JComboBox comboBox;
    JMenuBar menuBar;
    JMenu Zmien_kolor,pomoc;
    JMenuItem rgb,oAplikacji,wyjscie;
    static int id = 11;
    String[] row = new String[4];




    public Okno4() {
        setTitle("Dodaj Przedmiot");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(800,250,795,615);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBounds(0, 0, 800, 600);
        add(panel);

        powierzchnia = new JLabel("Powierzchnia:");
        powierzchnia.setBounds(0,240,80,20);
        panel.add(powierzchnia);

        nazwa = new JLabel("Nazwa:");
        nazwa.setBounds(0,280,80,20);
        panel.add(nazwa);

        identyfikator = new JLabel("ID:");
        identyfikator.setBounds(0,320,80,20);
        panel.add(identyfikator);

        opis = new JLabel("Opis:");
        opis.setBounds(0,350,80,40);
        panel.add(opis);

        iloscPrzedmiotow = new JLabel("Dostępność Przedmiotów:");
        iloscPrzedmiotow.setBounds(400,310,150,40);
        panel.add(iloscPrzedmiotow);


        bdodajPrzedmiot = new JButton();
        bdodajPrzedmiot.setBounds(160, 215, 135, 40);
        bdodajPrzedmiot.setText("Dodaj Przedmiot");
        bdodajPrzedmiot.addActionListener(this);
        panel.add(bdodajPrzedmiot);

        bwyczysc = new JButton();
        bwyczysc.setBounds(160, 260, 135, 40);
        bwyczysc.setText("Wyczyść ");
        bwyczysc.addActionListener(this);
        panel.add(bwyczysc);

        busunwiersz = new JButton();
        busunwiersz.setBounds(160, 305, 135, 40);
        busunwiersz.setText("Usuń wiersz");
        busunwiersz.addActionListener(this);
        panel.add(busunwiersz);

        textField1 = new JTextField();
        textField1.setBounds(0, 260, 150, 20);
        textField1.addActionListener(this);
        textField1.setToolTipText("Podaj Powierzchnię");
        panel.add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(0, 300, 150, 20);
        textField2.addActionListener(this);
        textField2.setToolTipText("Podaj Nazwę");
        panel.add(textField2);

        textField3 = new JTextField();
        textField3.setBounds(0, 340, 50, 20);
        textField3.addActionListener(this);
        textField3.setText("11");
        textField3.setEditable(false);
        panel.add(textField3);

        textField4 = new JTextField();
        textField4.setBounds(0, 377, 150, 20);
        textField4.addActionListener(this);
        textField2.setToolTipText("Podaj Opis");
        panel.add(textField4);

        slider = new JSlider(0,15,0);
        slider.setBounds(300,340,400,40);
        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(3);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setEnabled(false);
        slider.addChangeListener(this);
        panel.add(slider);


        tabelka = new JTable();
        tabelka.setBounds(0, 400, 780, 550);
        tabelka.setBackground(Color.GREEN);

        JScrollPane scrollPane = new JScrollPane(tabelka);
        scrollPane.setBounds(0, 400, 780, 155);
        panel.add(scrollPane);

        String[] collumns = {"ID", "Nazwa", "Powierzchnia", "Opis"};
        model2 = new DefaultTableModel();
        tabelka.setModel(model2);
        model2.setColumnIdentifiers(collumns);




        menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        Zmien_kolor = new JMenu("Zmień Kolor");
        pomoc = new JMenu("Pomoc");

        menuBar.add(Zmien_kolor);
        menuBar.add(pomoc);

        rgb = new JMenuItem("RGB");
        oAplikacji = new JMenuItem("O Aplikacji");
        wyjscie = new JMenuItem("Wyjście");
        wyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl W"));

        Zmien_kolor.add(rgb);
        pomoc.add(oAplikacji);
        pomoc.add(wyjscie);

        rgb.addActionListener(this);
        oAplikacji.addActionListener(this);
        wyjscie.addActionListener(this);


    }

    private void removeSelectedRows() {
        int[] wybrane_wiersze = tabelka.getSelectedRows();

        for (int i = 0; i < wybrane_wiersze.length; i++)
            model2.removeRow(tabelka.getSelectedRow());
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object zrodlo = actionEvent.getSource();
        if (zrodlo == bdodajPrzedmiot) {
            if (textField1.getText().length() > 0 && textField2.getText().length() > 0 && textField4.getText().length() > 0) {

                try {
                    row[0] = textField3.getText();
                    row[1] = textField2.getText();
                    row[2] = String.valueOf(Double.parseDouble(textField1.getText()));
                    row[3] = textField4.getText();
                    model2.addRow(row);
                    slider.setValue(tabelka.getRowCount());
                    textField3.setText(String.valueOf(tabelka.getRowCount()+11));
                    textField1.setText("");
                    textField2.setText("");
                    textField4.setText("");

                    if (tabelka.getRowCount() > 15) {
                        textField1.setEditable(false);
                        textField2.setEditable(false);
                        textField4.setEditable(false);
                        textField1.setBackground(Color.RED);
                        textField2.setBackground(Color.RED);
                        textField4.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Wpisales za duzo", "Uwaga!", JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Możesz wpisać tylko cyfry","Uwaga!!",JOptionPane.WARNING_MESSAGE);
                    textField3.setText(String.valueOf(tabelka.getRowCount()+10));
                    slider.setValue(tabelka.getRowCount());
                    slider.addChangeListener(this);
                }

            }
            else
                JOptionPane.showMessageDialog(null, "Uzupełnij wszystkie pola", "Uwaga!", JOptionPane.ERROR_MESSAGE);


        }
        else if (zrodlo == busunwiersz) {
            removeSelectedRows();
            slider.setValue(tabelka.getRowCount());
            textField1.setEditable(true);
            textField2.setEditable(true);
            textField4.setEditable(true);
            textField1.setBackground(Color.WHITE);
            textField2.setBackground(Color.WHITE);
            textField4.setBackground(Color.WHITE);

        }
        else if(zrodlo==bwyczysc){
            model2.setRowCount(0);
            slider.setValue(0);
            textField3.setText(String.valueOf(id=11));
            textField1.setEditable(true);
            textField2.setEditable(true);
            textField4.setEditable(true);
            textField1.setBackground(Color.WHITE);
            textField2.setBackground(Color.WHITE);
            textField4.setBackground(Color.WHITE);


        }
        else if(zrodlo==wyjscie){
            int odpowiedz =  JOptionPane.showConfirmDialog(null,"Czy na pewno chcesz wyjść","Wyjście",JOptionPane.YES_NO_OPTION);
            if(odpowiedz==JOptionPane.YES_OPTION) {
                dispose();
            }
        }
        else if(zrodlo==rgb){
            Color Wybrany_kolor = JColorChooser.showDialog(null,"Podaj kolor:",Color.PINK);
            panel.setBackground(Wybrany_kolor);
            tabelka.setBackground(Wybrany_kolor);
        }
        else if(zrodlo==oAplikacji){
            JOptionPane.showMessageDialog(null,"Aplikacja została stworzona przez \n Michała Radzewicza  i  Jest projektem z GUI 2020 :)");
        }


    }


    @Override
    public void stateChanged(ChangeEvent changeEvent) {

    }
}


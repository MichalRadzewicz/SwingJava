package com.company;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Okno3 extends JFrame implements ActionListener,ChangeListener {
    JButton bdodajmagazyn, busunwiersz,bwyczysc;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JLabel powierzchnia,lokalizacja,identyfikator,iloscMagazynow,mozliwoscPrzechowania,m2;
    JTable tabelka;
    JPanel panel;
    JSlider slider;
    DefaultTableModel model2;

    JComboBox comboBox;
    static int id = 4;
    String[] row = new String[4];
    String[] collumns = {"Identyfikator", "Powierzchnia", "Lokalizacja", "Możliwość przechowywania"};




    public Okno3() {
        setTitle("Dodaj Magzayn");
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

        lokalizacja = new JLabel("Lokalizacja:");
        lokalizacja.setBounds(0,280,80,20);
        panel.add(lokalizacja);

        identyfikator = new JLabel("ID:");
        identyfikator.setBounds(0,320,80,20);
        panel.add(identyfikator);

        iloscMagazynow = new JLabel("Dostępność Magazynów:");
        iloscMagazynow.setBounds(400,310,150,40);
        panel.add(iloscMagazynow);

        mozliwoscPrzechowania = new JLabel("Możliwosć Przechowania:");
        mozliwoscPrzechowania.setBounds(0,350,150,40);
        panel.add(mozliwoscPrzechowania);

        m2 = new JLabel("m²");
        m2.setBounds(150,265,15,15);
        panel.add(m2);


        bdodajmagazyn = new JButton();
        bdodajmagazyn.setBounds(170, 215, 120, 40);
        bdodajmagazyn.setText("Dodaj Magazyn");
        bdodajmagazyn.addActionListener(this);
        panel.add(bdodajmagazyn);

        bwyczysc = new JButton();
        bwyczysc.setBounds(170, 260, 120, 40);
        bwyczysc.setText("Wyczyść ");
        bwyczysc.addActionListener(this);
        panel.add(bwyczysc);

        busunwiersz = new JButton();
        busunwiersz.setBounds(170, 305, 120, 40);
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
        textField2.setToolTipText("Podaj Lokalizację");
        panel.add(textField2);

        textField3 = new JTextField();
        textField3.setBounds(0, 340, 50, 20);
        textField3.addActionListener(this);
        textField3.setText("4");
        textField3.setEditable(false);
        panel.add(textField3);

        textField4 = new JTextField();
        textField4.setBounds(0, 380, 50, 20);
        textField4.addActionListener(this);
        textField4.setEditable(false);

        slider = new JSlider(0,6,0);
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

        model2 = new DefaultTableModel();
        tabelka.setModel(model2);
        model2.setColumnIdentifiers(collumns);


        comboBox = new JComboBox();
        panel.add(comboBox);
        comboBox.addActionListener(this);
        comboBox.setBounds(0, 380, 50, 20);
        comboBox.addItem("TAK");
        comboBox.addItem("NIE");


    }

    public void removeSelectedRows() {
        int[] wybrane_wiersze = tabelka.getSelectedRows();

        for (int i = 0; i < wybrane_wiersze.length; i++)
            model2.removeRow(tabelka.getSelectedRow());
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object zrodlo = actionEvent.getSource();
        if (zrodlo == bdodajmagazyn) {
            if (textField1.getText().length() > 0 && textField2.getText().length() > 0   ) {

                try {
                    row[0] = textField3.getText();
                    row[2] = textField2.getText();
                    row[1] = String.valueOf(Double.parseDouble(textField1.getText()));
                    row[3] = textField4.getText();
                    model2.addRow(row);
                    slider.setValue(tabelka.getRowCount());
                    textField3.setText(String.valueOf(tabelka.getRowCount()+4));
                    textField1.setText("");
                    textField2.setText("");

                    if (tabelka.getRowCount()>6) {
                        textField1.setEditable(false);
                        textField2.setEditable(false);
                        textField1.setBackground(Color.RED);
                        textField2.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(null,"Wpisales za duzo","Uwaga!",JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Możesz wpisać tylko cyfry","Uwaga!!",JOptionPane.WARNING_MESSAGE);
                    textField3.setText(String.valueOf(tabelka.getRowCount()+4));
                    slider.setValue(tabelka.getRowCount());
                    slider.addChangeListener(this);
                }

            }

            else {
                JOptionPane.showMessageDialog(null, "Uzupełnij wszystkie pola", "Uwaga!", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (zrodlo == busunwiersz) {
            removeSelectedRows();
            slider.setValue(tabelka.getRowCount());
            textField1.setEditable(true);
            textField2.setEditable(true);
            textField4.setEditable(true);
            comboBox.setEditable(true);
            textField1.setBackground(Color.WHITE);
            textField2.setBackground(Color.WHITE);

        } else if (zrodlo == comboBox) {
            String wybranie = (String) comboBox.getSelectedItem();
            switch (wybranie){
                case "TAK":
                    textField4.setText("Tak");
                    break;
                case "NIE":
                    textField4.setText("Nie");
                    break;

            }

        }
        else if(zrodlo==bwyczysc){
            model2.setRowCount(0);
            slider.setValue(0);
            textField3.setText(String.valueOf(id=4));
            textField1.setEditable(true);
            textField2.setEditable(true);
            comboBox.setEditable(true);
            textField1.setBackground(Color.WHITE);
            textField2.setBackground(Color.WHITE);



        }

    }


    @Override
    public void stateChanged(ChangeEvent changeEvent) {

    }
}


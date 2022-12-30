package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Okno2 extends JFrame implements ActionListener {
    JPanel panel;
    JLabel listaPrzedmiotow, listaMagazynow;
    JButton bdodaj_magazyn, beksportujMagazyn, beksportujPrzemdiot, bdodajprzedmiot, busun, bzapisz, bdodajprzemiotdomagazynu, busunztabeli;
    JTable tabela, tabela2, tabela3;
    String[] wiersz = new String[4];
    String[] wiersz2 = new String[5];
    Okno3 okno3 = new Okno3();
    Okno4 okno4 = new Okno4();
    DefaultTableModel model, model2, model3;
    JMenuBar menuBar;
    JMenu Zmien_kolor, pomoc;
    JMenuItem rgb, oAplikacji, wyjscie;
    String[] kolumny = {"Identyfikator", "Lokalizacja", "Powierzchnia", "Możliwość przechowywania"};
    String[] kolumny2 = {"Identyfikator", "Nazwa", "Powierzchnia", "Opis"};
    String[] kolumny3 = {"ID Magazynu", "Powierzchnia Magazynu", "Przedmiot", "ID Przedmiotu", "Powierchnia Przedmiotu"};
    Double aktualny_stan1, aktualny_stan2, aktualny_stan3, aktualny_stan4, aktualny_stan5, aktualny_stan6;
    boolean flag = true;

    public Okno2() {
        okno3.setVisible(false);
        okno4.setVisible(false);

        Font font = new Font("Helvetica", Font.ITALIC, 16);


        panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBounds(0, 0, 1200, 800);
        add(panel);

        listaMagazynow = new JLabel("Lista Magazynów (Max 6) :");
        listaMagazynow.setBounds(420, 0, 150, 20);
        listaMagazynow.setForeground(Color.RED);
        panel.add(listaMagazynow);

        listaPrzedmiotow = new JLabel("Lista Przedmiotów (Max 15):");
        listaPrzedmiotow.setBounds(830, 0, 170, 20);
        listaPrzedmiotow.setForeground(Color.RED);
        panel.add(listaPrzedmiotow);


        bdodaj_magazyn = new JButton("Dodaj Magazyn");
        bdodaj_magazyn.setBounds(70, 50, 180, 40);
        bdodaj_magazyn.addActionListener(this);
        bdodaj_magazyn.setFont(font);
        panel.add(bdodaj_magazyn);

        bdodajprzedmiot = new JButton("Dodaj Przedmiot");
        bdodajprzedmiot.setBounds(70, 100, 180, 40);
        bdodajprzedmiot.addActionListener(this);
        bdodajprzedmiot.setFont(font);
        panel.add(bdodajprzedmiot);

        beksportujMagazyn = new JButton("Eksportuj magazyn ");
        beksportujMagazyn.setBounds(70, 150, 180, 40);
        beksportujMagazyn.addActionListener(this);
        beksportujMagazyn.setFont(font);
        panel.add(beksportujMagazyn);

        beksportujPrzemdiot = new JButton("Eksportuj przedmiot ");
        beksportujPrzemdiot.setBounds(70, 200, 180, 40);
        beksportujPrzemdiot.addActionListener(this);
        beksportujPrzemdiot.setFont(font);
        panel.add(beksportujPrzemdiot);

        busun = new JButton("Usuń przedmiot/magazyn");
        busun.setBounds(70, 250, 180, 40);
        busun.addActionListener(this);
        busun.setFont(font);
        panel.add(busun);

        bzapisz = new JButton("Zapisz");
        bzapisz.setBounds(70, 300, 180, 40);
        bzapisz.addActionListener(this);
        bzapisz.setFont(font);
        panel.add(bzapisz);

        busunztabeli = new JButton("Usuń przemiot z magazynu");
        busunztabeli.setBounds(300, 380, 300, 40);
        busunztabeli.addActionListener(this);
        busunztabeli.setFont(font);
        panel.add(busunztabeli);

        bdodajprzemiotdomagazynu = new JButton("Dodaj przemiot do magazynu");
        bdodajprzemiotdomagazynu.setBounds(730, 380, 300, 40);
        bdodajprzemiotdomagazynu.addActionListener(this);
        bdodajprzemiotdomagazynu.setFont(font);
        panel.add(bdodajprzemiotdomagazynu);

        tabela = new JTable();
        tabela.setBounds(280, 25, 400, 300);
        tabela.setBackground(Color.GREEN);
        tabela.setForeground(Color.RED);


        model = new DefaultTableModel();
        tabela.setModel(model);
        model.setColumnIdentifiers(kolumny);
        model.addRow(new String[]{"1", "Warszawa", Double.toString(100), "Tak"});
        model.addRow(new String[]{"2", "Gdańsk", Double.toString(200), "Tak"});
        model.addRow(new String[]{"3", "Wrocław", Double.toString(300), "Tak"});

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(280, 25, 400, 300);
        panel.add(scrollPane);
        //=====================================================

        tabela2 = new JTable();
        tabela2.setBounds(700, 25, 400, 300);
        tabela2.setBackground(Color.GREEN);
        tabela2.setForeground(Color.RED);

        model2 = new DefaultTableModel();
        tabela2.setModel(model2);
        model2.setColumnIdentifiers(kolumny2);

        JScrollPane scrollPane2 = new JScrollPane(tabela2);
        scrollPane2.setBounds(700, 25, 400, 300);
        panel.add(scrollPane2);

        model2.addRow(new String[]{"1", "Szafa", Double.toString(10), "Szafa pana Krawczyka"});
        model2.addRow(new String[]{"2", "Szafka Nocna", Double.toString(5), "Szafka nocna bez nóżek"});
        model2.addRow(new String[]{"3", "Łóżko", Double.toString(8), "Łóżko na wymiane"});
        model2.addRow(new String[]{"4", "Komoda", Double.toString(15), "Komoda do domu"});
        model2.addRow(new String[]{"5", "Rower", Double.toString(2), "Używany rower"});
        model2.addRow(new String[]{"6", "Drzwi", Double.toString(3), "Drzwi Kowalskiego"});
        model2.addRow(new String[]{"7", "Komputer", Double.toString(1), "Komputer-system Win"});
        model2.addRow(new String[]{"8", "Samochód", Double.toString(5), "Samochód z lombardu"});
        model2.addRow(new String[]{"9", "Telewizor", Double.toString(2), "Telewizor znaleziony"});
        model2.addRow(new String[]{"10", "Kanapa", Double.toString(4), "Kanapa do spania"});

        //===============================================================

        tabela3 = new JTable();
        tabela3.setBounds(0, 450, 1200, 200);
        tabela3.setBackground(Color.YELLOW);
        tabela3.setForeground(Color.RED);

        model3 = new DefaultTableModel();
        tabela3.setModel(model3);
        model3.setColumnIdentifiers(kolumny3);

        JScrollPane scrollPane3 = new JScrollPane(tabela3);
        scrollPane3.setBounds(0, 450, 1200, 200);
        panel.add(scrollPane3);

        //==================================================================

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

    void remove() {
        int[] wybrane_wiersze = tabela.getSelectedRows();
        int[] wybrane_wiersze2 = tabela2.getSelectedRows();

        for (int i = 0; i < wybrane_wiersze.length; i++)
            model.removeRow(tabela.getSelectedRow());

        for (int i = 0; i < wybrane_wiersze2.length; i++)
            model2.removeRow(tabela2.getSelectedRow());

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object zrodlo = actionEvent.getSource();

        try {
            if( flag) {
                aktualny_stan1 = Double.parseDouble(String.valueOf(tabela.getValueAt(0, 2)));
                flag = false;
                aktualny_stan2 = Double.parseDouble(String.valueOf(tabela.getValueAt(1, 2)));
                flag = false;
                aktualny_stan3 = Double.parseDouble(String.valueOf(tabela.getValueAt(2, 2)));
                flag = false;
                aktualny_stan4 = Double.parseDouble(String.valueOf(tabela.getValueAt(3, 2)));
                flag = false;
                aktualny_stan5 = Double.parseDouble(String.valueOf(tabela.getValueAt(4, 2)));
                flag = false;
                aktualny_stan6 = Double.parseDouble(String.valueOf(tabela.getValueAt(5, 2)));
                flag = false;
            }
        } catch (Exception e) {

        }
        if (zrodlo == bdodaj_magazyn) {
            okno3.setVisible(true);

        } else if (zrodlo == beksportujMagazyn) {
            if(tabela.getRowCount()<=5) {
                int index[] = okno3.tabelka.getSelectedRows();
                okno3.tabelka.getModel();

                for (int i = 0; i < index.length; i++) {

                    wiersz[0] = String.valueOf(okno3.tabelka.getModel().getValueAt(i, 0));
                    wiersz[1] = String.valueOf(okno3.tabelka.getModel().getValueAt(i, 2));
                    wiersz[2] = String.valueOf(okno3.tabelka.getModel().getValueAt(i, 1));
                    wiersz[3] = String.valueOf(okno3.tabelka.getModel().getValueAt(i, 3));

                    model.addRow(wiersz);

                }
                okno3.model2.setRowCount(0);
                okno3.textField1.setEditable(true);
                okno3.textField2.setEditable(true);
                okno3.comboBox.setEditable(true);
                okno3.textField1.setBackground(Color.WHITE);
                okno3.textField2.setBackground(Color.WHITE);
                okno3.slider.setValue(0);
                okno3.textField3.setText(String.valueOf(tabela.getRowCount() + 1));
            }
            else
                JOptionPane.showMessageDialog(null,"Za dużo magazynów");



        } else if (zrodlo == beksportujPrzemdiot) {
            if(tabela2.getRowCount()<=17) {
                int[] index2 = okno4.tabelka.getSelectedRows();
                okno4.tabelka.getModel();

                for (int i = 0; i < index2.length; i++) {


                    wiersz[0] = String.valueOf(okno4.tabelka.getModel().getValueAt(i, 0));
                    wiersz[1] = String.valueOf(okno4.tabelka.getModel().getValueAt(i, 1));
                    wiersz[2] = String.valueOf(okno4.tabelka.getModel().getValueAt(i, 2));
                    wiersz[3] = String.valueOf(okno4.tabelka.getModel().getValueAt(i, 3));

                    model2.addRow(wiersz);
                }

                okno4.model2.setRowCount(0);
                okno4.textField1.setEditable(true);
                okno4.textField2.setEditable(true);
                okno4.textField4.setEditable(true);
                okno4.textField1.setBackground(Color.WHITE);
                okno4.textField2.setBackground(Color.WHITE);
                okno4.textField4.setBackground(Color.WHITE);
                okno4.slider.setValue(0);
                okno4.textField3.setText(String.valueOf(tabela.getRowCount() + 1));
            }
            else
                JOptionPane.showMessageDialog(null,"Za dużo przedmiotów");


        }
        else if (zrodlo==bdodajprzemiotdomagazynu) {

            if (tabela.getSelectedRows().length > 0 && tabela2.getSelectedRows().length > 0 ) {
                if(aktualny_stan1>=Double.parseDouble(String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(),2))) && aktualny_stan2>=Double.parseDouble(String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(),2))) &&
                        aktualny_stan3>=Double.parseDouble(String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(),2)))
                ) {


                    wiersz2[0] = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0));


                    if (tabela.isRowSelected(0)) {
                        Double a = Double.parseDouble(String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(), 2)));
                        aktualny_stan1 = Double.parseDouble(String.valueOf(aktualny_stan1 - a));
                        wiersz2[1] = String.valueOf(aktualny_stan1);
                    }
                    else if (tabela.isRowSelected(1)) {
                        Double b = Double.parseDouble(String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(), 2)));
                        aktualny_stan2 = Double.parseDouble(String.valueOf(aktualny_stan2 - b));
                        wiersz2[1] = String.valueOf(aktualny_stan2);
                    } else if (tabela.isRowSelected(2)) {
                        Double c = Double.parseDouble(String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(), 2)));
                        aktualny_stan3 = Double.parseDouble(String.valueOf(aktualny_stan3 - c));
                        wiersz2[1] = String.valueOf(aktualny_stan3);
                    } else if (tabela.isRowSelected(3)) {
                        Double d = Double.parseDouble(String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(), 2)));
                        aktualny_stan4 = Double.parseDouble(String.valueOf(aktualny_stan4 - d));
                        wiersz2[1] = String.valueOf(aktualny_stan4);
                    } else if (tabela.isRowSelected(4)) {
                        Double e = Double.parseDouble(String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(), 2)));
                        aktualny_stan5 = Double.parseDouble(String.valueOf(aktualny_stan5 - e));
                        wiersz2[1] = String.valueOf(aktualny_stan5);
                    } else if (tabela.isRowSelected(5)) {
                        Double f = Double.parseDouble(String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(), 2)));
                        aktualny_stan6 = Double.parseDouble(String.valueOf(aktualny_stan6 - f));
                        wiersz2[1] = String.valueOf(aktualny_stan6);
                    }



                    int indexprzedmiot[] = tabela2.getSelectedRows();
                    for (int i = 0; i < indexprzedmiot.length; i++) {
                        wiersz2[2] = String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(), 1));
                        wiersz2[3] = String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(), 0));
                        wiersz2[4] = String.valueOf(tabela2.getValueAt(tabela2.getSelectedRow(), 2));

                        model3.addRow(wiersz2);
                    }

                }
                else
                    JOptionPane.showMessageDialog(null,"Więcej nie zmieszczę");
            }


            else
                JOptionPane.showMessageDialog(null,"Nie wybrałeś żadnego wiersza z tabelki :)","BRAK WIERSZA!",JOptionPane.WARNING_MESSAGE);
        }
        else if(zrodlo==busunztabeli){
            int[] w = tabela3.getSelectedRows();

            for (int i = 0; i < w.length; i++)
                model3.removeRow(tabela3.getSelectedRow());
        }
        else if (zrodlo == bdodajprzedmiot) {
            okno4.setVisible(true);
        }
        else if(zrodlo==busun){
            remove();
        }
        else if(zrodlo==bzapisz){

            try {
                tabela3.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nie można zapisać dokumentu");
            }
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


        }
        else if(zrodlo==oAplikacji){
            JOptionPane.showMessageDialog(null,"Aplikacja została stworzona przez \n Michała Radzewicza  i  służy do zarządzania magazynami w firmie");
        }
    }
}
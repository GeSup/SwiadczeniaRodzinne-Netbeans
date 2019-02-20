/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swidczeniarodzinne;

import javax.swing.*;

/**
 * @author Jerzy
 */
public class Osoba extends JInternalFrame {

    private String imie, nazwisko, ulica, nrDomu, miejscowosc, poczta, kodPocztowy;
    private String plec;
    private int id, pesel, dzienUrodzenia, miesiacUrodzenia, rokUrodzenia;
    private double dochod, przychod = 0, podatek = 0, skladkaSpoleczna = 0, skladkaZdrowotna = 0;
    private double dochodOpodatkowany, dochodNieopodatkowany, dochodUzyskany = 0, dochodUtracony = 0;
    private double inneNieopodatkowane[], sumaInneNieopodatkowane;

    Osoba() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }

    void ustawImie(String imie) {
        this.imie = imie;
    }

    String pobierzImie() {
        return imie;
    }

    void ustawNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    String pobierzNazwisko() {
        return nazwisko;
    }

    void ustawUlice(String ulica) {
        this.ulica = ulica;
    }

    String pobierzUlice() {
        return ulica;
    }

    void ustawNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    String pobierzNrDomu() {
        return nrDomu;
    }

    void ustawMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    String pobierzMiejscowosc() {
        return miejscowosc;
    }

    void ustawPoczta(String poczta) {
        this.poczta = poczta;
    }

    String pobierzPoczta() {
        return poczta;
    }

    void ustawKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    String pobierzKodPocztowy() {
        return kodPocztowy;
    }

    void ustawId(int id) {
        this.id = id;
    }

    Integer pobierzId() {
        return id;
    }

    void ustawPesel(int pesel) {
        this.pesel = pesel;
    }

    Integer pobierzPesel() {
        return pesel;
    }

    void ustawDateUrodzenia(int dzienUrodzenia, int miesiacUrodzenia, int rokUrodzenia) {
        this.dzienUrodzenia = dzienUrodzenia;
        this.miesiacUrodzenia = miesiacUrodzenia;
        this.rokUrodzenia = rokUrodzenia;
    }

    void ustawPlec(String plec) {
        this.plec = plec;
    }

    String pobierzPlec() {
        return plec;
    }

    void ustawDochodOpodatkowany(double przychod, double podatek, double skladkaSpoleczna, double skladkaZdrowotna) {
        this.przychod = przychod;
        this.podatek = podatek;
        this.skladkaSpoleczna = skladkaSpoleczna;
        this.skladkaZdrowotna = skladkaZdrowotna;
    }

    void wyliczenieDochoduOpodatkwanegoUS(double przychod, double podatek, double skladkaSpoleczna, double skladkaZdrowotnad) {
        dochodOpodatkowany = przychod - podatek - skladkaSpoleczna - skladkaZdrowotna;
    }

    void wyliczenieDochoduNieopodatkowanego(double haPrzeliczeniowych, double inne[], double dochodGus) {
        for (int i = 0; i < inne.length; i++) {
            sumaInneNieopodatkowane += inne[i];
        }
        dochodNieopodatkowany = (haPrzeliczeniowych * dochodGus + sumaInneNieopodatkowane) / 12;
    }

    void utracony(double utrata[]) {
        for (int i = 0; i < utrata.length; i++) {
            dochodUtracony += utrata[i];
        }
    }

    void uzyskany(double uzysk[]) {
        for (int i = 0; i < uzysk.length; i++) {
            dochodUzyskany += uzysk[i];
        }
    }

    void dochodMiesieczny(double dochodOpodatkowany, double dochodNieopodatkowany, double dochodUzyskany, double dochodUtracony) {
        dochod = dochodOpodatkowany + dochodNieopodatkowany + dochodUzyskany + dochodUtracony;
    }
}

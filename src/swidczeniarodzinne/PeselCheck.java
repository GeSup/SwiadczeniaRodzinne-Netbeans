/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swidczeniarodzinne;

/**
 *
 * @author Jerzy
 */
public class PeselCheck {
    
    private byte PESEL[] = new byte[11];
    boolean popraw = false;
    int rok, miesiac, dzien;
 
 
    public PeselCheck(String psl) {
 
        try {
            if (psl.length() != 11) {
                popraw = false;
            } else {
 
                for (int i = 0; i < 11; i++) {
                    PESEL[i] = Byte.parseByte(psl.substring(i, i + 1));
                }
 
                if (sumKont() && sprMies() && sprDnia()) {
                    popraw = true;
                } else {
                    popraw = false;
                }
 
            }
        } catch (NullPointerException e) {
            System.out.println("Błąd " + e);
        }
    }
 
    public int rokUr() {
        rok = 10 * PESEL[0];
        rok += PESEL[1];
        miesiac = 10 * PESEL[2];
        miesiac += PESEL[3];
        if (miesiac > 80 && 93 < miesiac) {
            rok += 1800;
        } else if (miesiac > 0 && 13 > miesiac) {
            rok += 1900;
        } else if (miesiac > 20 && 33 > miesiac) {
            rok += 2000;
        } else if (miesiac > 40 && 53 > miesiac) {
            rok += 2100;
        } else if (miesiac > 60 && 73 > miesiac) {
            rok += 2200;
        }
        return rok;
    }
 
    public int MiesiacUr() {
        miesiac = 10 * PESEL[2];
        miesiac += PESEL[3];
        if (miesiac > 80 && miesiac < 93) {
            miesiac -= 80;
        } else if (miesiac > 20 && miesiac < 33) {
            miesiac -= 20;
        } else if (miesiac > 40 && miesiac < 53) {
            miesiac -= 40;
        } else if (miesiac > 60 && miesiac < 73) {
            miesiac -= 60;
        }
        return miesiac;
    }
 
    public int dzienUr() {
        dzien = 10 * PESEL[4];
        dzien += PESEL[5];
        return dzien;
    }
 
    public String plec() {
        if (popraw) {
            if (PESEL[9] % 2 == 1) {
                return "Mężczyzna";
            } else {
                return "Kobieta";
            }
        } else {
            return "---";
        }
    }
 
    private boolean sumKont() {
        int sum = 1 * PESEL[0]
                + 3 * PESEL[1]
                + 7 * PESEL[2]
                + 9 * PESEL[3]
                + 1 * PESEL[4]
                + 3 * PESEL[5]
                + 7 * PESEL[6]
                + 9 * PESEL[7]
                + 1 * PESEL[8]
                + 3 * PESEL[9];
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;
 
        if (sum == PESEL[10]) {
            return true;
        } else {
            return false;
        }
    }
 
    private boolean sprMies() {
        int miesiace = MiesiacUr();
        if (miesiace > 0 && miesiace < 13) {
            return true;
        } else {
            return false;
        }
    }
 
    private boolean sprDnia() {
        int roki = rokUr();
        int miesiace = MiesiacUr();
        int dziena = dzienUr();
        if ((dziena > 0 && dziena < 32)
                && (miesiace == 1 || miesiace == 3 || miesiace == 5
                || miesiace == 7 || miesiace == 8 || miesiace == 10
                || miesiace == 12)) {
            return true;
        } else if ((dziena > 0 && dziena < 31)
                && (miesiace == 4 || miesiace == 6 || miesiace == 9
                || miesiace == 11)) {
            return true;
        } else if ((dziena > 0 && dziena < 30 && rokPrzest(roki))
                || (dziena > 0 && dziena < 29 && !rokPrzest(roki))) {
            return true;
        } else {
            return false;
        }
    }
 
    private boolean rokPrzest(int rok) {
        if (rok % 4 == 0 && rok % 100 != 0 || rok % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

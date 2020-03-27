package zsigmond1989.debugger;

import java.util.*;

/**
 * UGYFEL BEJELENTESE:
 * Egy adott honapban foglalasra ki kellene jelolnie bizonyos napokat.
 * A januari majdnem jo, ott csak az egyik van elcsuszva egy nappal.
 * De a februari mar harommal!
 * Az oktoberit meg sem neztem :(.
 *
 * Mikorra tudjatok javitani?
 */
public class DebugTask2 {
    public static void main(String[] args) {
        OsztalyteremFoglalas2020 foglalas = new OsztalyteremFoglalas2020();
        List<Integer> januariDatumok = foglalas.foglal(Honap.Januar, Arrays.asList(Nap.Hetfo, Nap.Szerda, Nap.Pentek));
        List<Integer> februariDatumok = foglalas.foglal(Honap.Februar, Arrays.asList(Nap.Szombat));
        List<Integer> oktoberiDatumok = foglalas.foglal(Honap.Oktober, Arrays.asList(Nap.Kedd, Nap.Csutortok));
        System.out.println("2020 JANUÁR: " + januariDatumok);
        System.out.println("2020 FEBRUÁR: " + februariDatumok);
        System.out.println("2020 OKTÓBER: " + oktoberiDatumok);
    }
}

class OsztalyteremFoglalas2020 {

    public List<Integer> foglal(Honap honap, List<Nap> napok) {
        int j = 0;
        if (honap.equals(Honap.Januar)) {
            j=2;
        }
        if (honap.equals(Honap.Februar)){
            j=5;
        }
        if (honap.equals(Honap.Oktober)){
            j=3;
        }
        return osszegyujt(honap.getNapok(), napok, j);
    }

    private List<Integer> osszegyujt(int max, List<Nap> napok,int j) {
        List datumok = new ArrayList();



        for (int i=1+j; i<=max+j; i++) {
            if (i % 7 == 1) {
                if (napok.contains(Nap.Hetfo)) {
                    datumok.add(i-j);
                }
            }

            if (i % 7 == 2) {
                if (napok.contains(Nap.Kedd)) {
                    datumok.add(i-j);
                }
            }

            if (i % 7 == 3) {
                if (napok.contains(Nap.Szerda)) {
                    datumok.add(i-j);
                }
            }

            if (i % 7 == 4) {
                if (napok.contains(Nap.Csutortok)) {
                    datumok.add(i-j);
                }
            }

            if (i % 7 == 5) {
                if (napok.contains(Nap.Pentek)) {
                    datumok.add(i-j);
                }
            }

            if (i % 7 == 6) {
                if (napok.contains(Nap.Szombat)) {
                    datumok.add(i-j);
                }
            }

            if (i % 7 == 0) {
                if (napok.contains(Nap.Vasarnap)) {
                    datumok.add(i-j);
                }
            }
        }

        return datumok;
    }


}

enum Honap {
    Januar(31),
    Februar(29),
    Marcius(31),
    Aprilis(30),
    Majus(31),
    Junius(30),
    Julius(31),
    Augusztus(30),
    Szeptember(30),
    Oktober(31),
    November(30),
    December(31);

    private int napok;
    Honap(int napok) {
        this.napok = napok;
    }

    public int getNapok() {
        return napok;
    }
}

enum Nap {
    Hetfo, Kedd, Szerda, Csutortok, Pentek, Szombat, Vasarnap
}
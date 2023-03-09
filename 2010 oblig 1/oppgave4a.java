import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class oppgave4a {
    public static ArrayList<Integer> finalList = new ArrayList();

    public static void midt(int[] o) {
        // finner midten
        int midten = o.length / 2;

        // variabler
        int antallHoyre = 0;
        int antallVenstre = 0;
        int peker;

        // legger midterste til den print lista
        finalList.add(o[midten]);

        // teller antall i høyre siden og venstre siden
        for (int i = midten + 1; i < o.length; i++) {
            // System.out.println(o[i]);
            antallHoyre++;
        }
        for (int i = 0; i < midten; i++) {
            // System.out.println(o[i]);
            antallVenstre++;
        }

        // lager listene med høyre og venstre
        int[] hoyreListe = new int[antallHoyre];
        int[] venstreListe = new int[antallVenstre];

        // looper og legger til i nye høyre og venstre lister
        peker = 0;
        for (int i = midten + 1; i < o.length; i++) {
            hoyreListe[peker] = o[i];
            peker++;
        }
        peker = 0;
        for (int i = 0; i < midten; i++) {
            venstreListe[peker] = o[i];
            peker++;
        }

        // regresjon gjennom de nye listene
        if (hoyreListe.length > 0) {
            midt(hoyreListe);
        }
        if (venstreListe.length > 0) {
            midt(venstreListe);
        }

    }

    public static void main(String[] args) throws Exception {
        // scanner åpner filen
        Scanner sc = new Scanner(new File("enTilTi"));

        // leser første linjen som angir antall linjer å lese
        int kjorAnt = Integer.parseInt(sc.nextLine());

        // lager array med antall inputs
        int[] liste = new int[kjorAnt];

        // adder alle tallene til lista
        for (int i = 0; i < kjorAnt; i++) {
            liste[i] = Integer.parseInt(sc.nextLine());
        }

        // kjører koden som lager ny liste med riktig rekkefølge
        midt(liste);

        // looper gjennom lista og printer balansert tre
        for (int i : finalList) {
            System.out.println(i);
        }

    }
}

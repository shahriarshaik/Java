/*
 * notater til meg selv
 * kan bare bruke heap. aka priorityQueue
 * fra priorityQueue kan jeg bare bruke disse methodene:
 *      offer()
 *      poll()
 *      size()
 * 
 *  offer() = setter inn som add()
 *  poll() = fjerner / henter ut, usikker hvilken
 */

import java.util.Scanner;
import java.io.File;
import java.util.PriorityQueue;

public class oppgave4b {

    public static void midt(PriorityQueue<Integer> o) {
        // finner midten
        int midten = o.size() / 2;

        // variabler
        PriorityQueue<Integer> venstreListe = new PriorityQueue<>();

        // size = 11
        // dette lager venstre siden
        for (int i = 0; i < midten; i++) {
            venstreListe.offer(o.poll());
        }

        // size = 6
        // printer ut svaret / midten
        System.out.println("popper ut: " + o.poll());

        System.out.println(o.size());
        // size = 5
        // denne lager hoyre siden

        if (o.size() > 0) {
            midt(o);
        }
        if (venstreListe.size() > 0) {
            midt(venstreListe);
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> liste = new PriorityQueue<>();

        Scanner sc = new Scanner(new File("enTilTi"));

        // leser første linjen som angir antall linjer å lese
        int kjorAnt = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < kjorAnt; i++) {
            liste.offer(Integer.parseInt(sc.nextLine()));
        }

        midt(liste);
    }
}

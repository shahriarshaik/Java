import javax.swing.*;
import java.util.ArrayList;

public class Model {
    GUI gui;
    randomtall rand = new randomtall(0, 11);
    ArrayList<JLabel> slangen;
    int rettning;
    int hodeY = 6;
    int hodeX = 6;
    boolean kjorer;
    Thread tid;
    int retningen;


    public Model(GUI gui) {
        this.gui = gui;
        slangen = gui.slangen;
        rettning = gui.rettning;
        retningen = gui.rettning;
    }

    public void spreEpler() {
        for (int eple = 0; eple < 10; eple++) {
            int x = rand.tall();
            int y = rand.tall();
            while (gui.erEpleEllerslange(y, x)) {
                x = rand.tall();
                y = rand.tall();
            }
            gui.leggTilEple(y, x);
        }
    }

    public void bevegelse() {
        if(gui.erNesteEple(hodeY, hodeX, gui.rettning)){
            System.out.println("skal spise");
            nyLengde();
            if (gui.rettning == 8) { // retning opp
                etNyttEple();
                spiseOpp();
            } else if (gui.rettning == 2) { // retning ned
                etNyttEple();
                spiseNed();
            } else if (gui.rettning == 6) { // retning høyre
                etNyttEple();
                spiseHoyre();
            } else if (gui.rettning == 4) { // retning venstre
                etNyttEple();
                spiseVenstre();
            }
        } else{
            if(gui.erNesteSlange(hodeY, hodeX, gui.rettning)){
                System.out.println("holder på å treffe slange");
                if (gui.rettning == 8) { // retning opp
                    gaaOpp();
                    System.out.println("game Over, traff deg selv");
                    System.exit(0);
                } else if (gui.rettning == 2) { // retning ned
                    gaaNed();
                    System.out.println("game Over, traff deg selv");
                    System.exit(0);
                } else if (gui.rettning == 6) { // retning høyre
                    gaaHoyre();
                    System.out.println("game Over, traff deg selv");
                    System.exit(0);
                } else if (gui.rettning == 4) { // retning venstre
                    gaaVenstre();
                    System.out.println("game Over, traff deg selv");
                    System.exit(0);
                }
            }else{
                System.out.println("vanlig");
            if (gui.rettning == 8) { // retning opp
                try {
                    gaaOpp();
                } catch (Exception e) {
                    System.out.println("game Over, traff veggen");
                    System.exit(0);
                }
            } else if (gui.rettning == 2) { // retning ned
                try {
                    gaaNed();
                } catch (Exception e) {
                    System.out.println("game Over, traff veggen");
                    System.exit(0);
                }
            } else if (gui.rettning == 6) { // retning høyre
                try {
                    gaaHoyre();
                } catch (Exception e) {
                    System.out.println("game Over, traff veggen");
                    System.exit(0);
                }
            } else if (gui.rettning == 4) { // retning venstre
                try {
                    gaaVenstre();
                } catch (Exception e) {
                    System.out.println("game Over, traff veggen");
                    System.exit(0);
                }
            }
            }
        }
    }

    public void gaaOpp() {
        gui.leggTilSlange(hodeY - 1 , hodeX);
        hodeY--;
        int kord[] = hentHaleKord(gui.slangen.get(gui.slangen.size() - 1));
        gui.fjernSlange(kord[0], kord[1]);
    }

    public void gaaNed() {
        gui.leggTilSlange(hodeY + 1 , hodeX);
        hodeY++;
        int kord[] = hentHaleKord(gui.slangen.get(gui.slangen.size() - 1));
        gui.fjernSlange(kord[0], kord[1]);
    }

    public void gaaHoyre() {
        gui.leggTilSlange(hodeY, hodeX + 1);
        hodeX++;
        int kord[] = hentHaleKord(gui.slangen.get(gui.slangen.size() - 1));
        //System.out.println("kordinater: " + kord[1] +" " + kord[0]);
        gui.fjernSlange(kord[0], kord[1]);
        //System.out.println("halen etter fjerning: "+ gui.slangen.get(gui.slangen.size() - 1).getText());
    }

    public void gaaVenstre() {
        gui.leggTilSlange(hodeY, hodeX - 1);
        hodeX--;
        int kord[] = hentHaleKord(gui.slangen.get(gui.slangen.size() - 1));
        //System.out.println("kordinater: " + kord[1] +" " + kord[0]);
        gui.fjernSlange(kord[0], kord[1]);
        //System.out.println("halen etter fjerning: "+ gui.slangen.get(gui.slangen.size() - 1).getText());
    }

    public void spiseOpp() {
        gui.leggTilSlange(hodeY - 1 , hodeX);
        hodeY--;
    }

    public void spiseNed() {
        gui.leggTilSlange(hodeY + 1 , hodeX);
        hodeY++;
    }

    public void spiseHoyre() {
        gui.leggTilSlange(hodeY, hodeX + 1);
        hodeX++;
    }

    public void spiseVenstre() {
        gui.leggTilSlange(hodeY, hodeX - 1);
        hodeX--;
    }

    public void etNyttEple() {
        int x = rand.tall();
        int y = rand.tall();
        while (gui.erEpleEllerslange(y, x)) {
            x = rand.tall();
            y = rand.tall();
        }
        gui.leggTilEple(y, x);
    }

    public void nyLengde() {
        gui.lengde.setText("Lengde: " + (slangen.size()+1));
    }

    public int[] hentHaleKord(JLabel hale) { // tror denne funker
        int[] kord = new int[2];
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 12; x++) {
                if (hale == gui.bokser[y][x]) {
                    kord[0] = y;
                    kord[1] = x;
                }
            }
        }
        return kord;
    }

}

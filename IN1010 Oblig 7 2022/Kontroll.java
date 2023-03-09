import java.util.ArrayList;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Kontroll {
    public GUI gui;
    Model model;
    int haleLengde;
    ArrayList<JLabel> slangen;
    int[] hale;

    public Kontroll() {
        gui = new GUI();
        model = new Model(gui);
        haleLengde = gui.slangen.size();
        slangen = gui.slangen;
    }

    public void start() {
        model.spreEpler();
        //model.gui.bokser[6][3].setText("+");
        //hale = model.hentHaleKord(gui.slangen.get(gui.slangen.size() - 1));
        model.tid = new Thread();
        model.kjorer = true;
        while(model.kjorer){
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            model.bevegelse();
        }
        /*
        model.bevegelse();
        model.bevegelse();
        model.bevegelse();
        model.rettning = 8;
        model.bevegelse();
        model.bevegelse();
        model.bevegelse();
        model.rettning = 6;
        model.bevegelse();
        model.bevegelse();
        model.bevegelse();
        model.rettning = 2;
        model.bevegelse();
        model.bevegelse();
        model.bevegelse();
        model.rettning = 4;
        model.bevegelse();
        model.bevegelse();
        model.bevegelse();
        /*
        /*
         * for (int i = 0; i < 5; i++) {
         * try {
         * TimeUnit.SECONDS.sleep(1);
         * model.bevegelse();
         * } catch (Exception e) {
         * // TODO: handle exception
         * }
         * }
         */
    }

}

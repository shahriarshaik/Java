import java.awt.*;
import java.awt.event.*;

import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.util.ArrayList;

public class GUI implements ActionListener {
    JFrame hovedVindu;
    JPanel hovedPanel, oppePanel, verdenPanel, tittelPanel, tomPanel, spill; // TODO
    int rettning = 4;
    JButton opp, ned, hoyre, venstre, slutt;
    JLabel[][] bokser = new JLabel[12][12];
    JLabel lengde; 
    ArrayList<JLabel> slangen = new ArrayList<>();

    GUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(1);
        }

        tomPanel = new JPanel();
        tomPanel.setSize(700, 900);

        hovedVindu = new JFrame("snake");
        hovedVindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hovedVindu.setSize(700, 900);
        // hovedVindu.setPreferredSize(new Dimension(600, 600));

        hovedPanel = new JPanel();
        hovedPanel.setLayout(new BorderLayout());
        hovedPanel.setSize(700, 900);

        tittelPanel = new JPanel();
        tittelPanel.setSize(500, 30);
        tittelPanel.setBounds(100, 5, 500, 30);
        // tittelPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        // tittelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        JLabel testTest = new JLabel("Snake");
        testTest.setHorizontalAlignment(JLabel.CENTER);
        testTest.setVerticalAlignment(JLabel.CENTER);
        testTest.setForeground(Color.green);

        oppePanel = new JPanel();
        oppePanel.setBounds(50, 40, 600, 200);
        oppePanel.setSize(600, 200);
        oppePanel.setLayout(new GridLayout(0, 2));
        oppePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        oppePanel.setBackground(Color.gray);

        lengde = new JLabel("Lengde: 1");
        lengde.setHorizontalAlignment(JLabel.CENTER);
        oppePanel.add(lengde);

        JPanel knapper = new JPanel();
        knapper.setLayout(new BorderLayout());
        opp = new JButton("opp");
        ned = new JButton("ned");
        hoyre = new JButton("hoyre");
        venstre = new JButton("venstre");
        slutt = new JButton("exit");
        knapper.add(opp, BorderLayout.NORTH);
        knapper.add(ned, BorderLayout.SOUTH);
        knapper.add(hoyre, BorderLayout.EAST);
        knapper.add(venstre, BorderLayout.WEST);
        knapper.add(slutt, BorderLayout.CENTER);

        opp.addActionListener(this);
        ned.addActionListener(this);
        hoyre.addActionListener(this);
        venstre.addActionListener(this);
        slutt.addActionListener(this);

        oppePanel.add(knapper);

        spill = new JPanel();
        spill.setSize(700, 495);
        spill.setBounds(65, 240, 570, 570);
        spill.setLayout(new GridLayout(12, 12));
        spill.setBackground(Color.gray);
        spill.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        for (int y = 1; y <= 12; y++) {
            for (int x = 1; x <= 12; x++) {
                JLabel box = new JLabel(" ");
                box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                bokser[y - 1][x - 1] = box;
                spill.add(box);
            }
        }
        hovedVindu.add(hovedPanel);
        tittelPanel.add(testTest);
        hovedPanel.add(oppePanel);
        hovedPanel.add(spill);
        hovedPanel.add(tittelPanel);
        hovedVindu.setVisible(true);
        startpos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == slutt) {
            System.exit(0);
        } else if (e.getSource() == opp && rettning != 2) {
            rettning = 8;
            System.out.println(rettning);
        } else if (e.getSource() == ned && rettning != 8) {
            rettning = 2;
            System.out.println(rettning);
        } else if (e.getSource() == hoyre && rettning != 4) {
            rettning = 6;
            System.out.println(rettning);
        } else if (e.getSource() == venstre && rettning != 6) {
            rettning = 4;
            System.out.println(rettning);
        }
    }

    public void startpos() {
        JLabel hode = bokser[6][6];
        JLabel kropp = bokser[6][7];
        JLabel hale = bokser[6][8];
        slangen.add(hode);
        slangen.add(kropp);
        slangen.add(hale);
        hode.setText(":");
        hode.setHorizontalAlignment(JLabel.CENTER);
        hode.setVerticalAlignment(JLabel.CENTER);
        hode.setForeground(Color.green);
        hode.setFont(new Font("Serif", Font.PLAIN, 40));
        //slangen.add(hode);

        hale.setText("-");
        hale.setHorizontalAlignment(JLabel.CENTER);
        hale.setVerticalAlignment(JLabel.CENTER);
        hale.setForeground(Color.green);
        hale.setFont(new Font("Serif", Font.PLAIN, 40));
        //slangen.add(kropp);

        kropp.setText("-");
        kropp.setHorizontalAlignment(JLabel.CENTER);
        kropp.setVerticalAlignment(JLabel.CENTER);
        kropp.setForeground(Color.green);
        kropp.setFont(new Font("Serif", Font.PLAIN, 40));
        //slangen.add(hale);

    }

    public void leggTilEple(int y, int x) {
        JLabel gjeldende = bokser[y][x];
        gjeldende.setText("+");
        gjeldende.setHorizontalAlignment(JLabel.CENTER);
        gjeldende.setForeground(Color.red);
        gjeldende.setFont(new Font("Serif", Font.PLAIN, 40));
    }

    public boolean erEpleEllerslange(int y, int x) {
        String rute = bokser[y][x].getText();
        if (rute.equals(":")) {
            return true;
        } else if (rute.equals("-")) {
            return true;
        } else if (rute.equals("*")) {
            return true;
        } else if (rute.equals("+")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean erNesteEple(int y, int x, int dir) {
        try {
            if(dir == 8){
                if(bokser[y-1][x].getText().equals("+")){
                    return true;
                } else {
                    return false;
                }
            } else if(dir == 2){
                if(bokser[y+1][x].getText().equals("+")){
                    return true;
                } else {
                    return false;
                }
            } else if(dir == 6){
                if(bokser[y][x+1].getText().equals("+")){
                    return true;
                } else {
                    return false;
                }
            } else if(dir == 4){
                if(bokser[y][x-1].getText().equals("+")){
                    return true;
                } else {
                    return false;
                }
            } else{
                return false; 
            }
        } catch (Exception e) {
        }
        return false;
    }

    /*
    public boolean erNesteEple(int y, int x, int dir) {
        if(dir == 8){
            return bokser[y-1][x].getText().equals("$");
        } else if(dir == 2){
            return bokser[y+1][x].getText().equals("$");
        } else if(dir == 6){
            return bokser[y][x+1].getText().equals("$");
        } else if(dir == 2){
            return bokser[y][x-1].getText().equals("$");
        }
        else{ return false;}
    }
    */

    public boolean erNesteSlange(int y, int x, int dir) {
        try {
            if(dir == 8){
                if(bokser[y-1][x].getText().equals("-")){
                    return true;
                } else {
                    return false;
                }
            } else if(dir == 2){
                if(bokser[y+1][x].getText().equals("-")){
                    return true;
                } else {
                    return false;
                }
            } else if(dir == 6){
                if(bokser[y][x+1].getText().equals("-")){
                    return true;
                } else {
                    return false;
                }
            } else if(dir == 4){
                if(bokser[y][x-1].getText().equals("-")){
                    return true;
                } else {
                    return false;
                }
            } else{
                return false; 
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void leggTilSlange(int y, int x) {
        JLabel gjeldende = bokser[y][x];
        slangen.add(0, gjeldende);
        gjeldende.setText("-");
        gjeldende.setHorizontalAlignment(JLabel.CENTER);
        gjeldende.setForeground(Color.green);
        gjeldende.setFont(new Font("Serif", Font.PLAIN, 40));
        System.out.println("("+ x + ", " + y + ")");
    }

    public void fjernSlange(int y, int x) {
        JLabel gjeldende = bokser[y][x];
        System.out.println("fjerner: " + gjeldende.getText());
        gjeldende.setText(" ");
        slangen.remove(gjeldende);
    }

}

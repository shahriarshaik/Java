import javax.swing.*;

public class snakeFrame extends JFrame {
    snakeFrame() {
        // this.add(new kontroller()); // TODO fiks denne
        this.setTitle("Snake spill"); // dette er tittel
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // denne får den til å slutte ved å trykke x
        this.setResizable(false);
        this.pack(); // denne får den til å starte så compact som mulig
        this.setVisible(true);
        this.setLocationRelativeTo(null); // vet ikke om jeg trenger denne

    }

}

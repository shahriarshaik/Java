import java.util.Random;

public class randomtall {

    private int min;
    private int max;
    private Random rand = new Random();

    public randomtall(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int tall() {
        return rand.nextInt(max + min) + min;
    }

}

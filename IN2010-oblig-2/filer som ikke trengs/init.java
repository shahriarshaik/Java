class init {
public static void main(String[] args) {

    long startTime = System.nanoTime();

    int tall = 0;
    int antall = 1000000000;
    for (int i = 0; i < antall; i++) {
        tall++;
    }
    for (int i = 0; i < antall; i++) {
        tall++;
    }
    for (int i = 0; i < antall; i++) {
        tall++;
    }
    for (int i = 0; i < antall; i++) {
        tall++;
    }
    for (int i = 0; i < antall; i++) {
        tall++;
    }
    for (int i = 0; i < antall; i++) {
        tall++;
    }
    long endTime = System.nanoTime();
    System.out.println(tall);

    long duration = (endTime - startTime);
    System.out.println(duration + " millisek");  
    }
}
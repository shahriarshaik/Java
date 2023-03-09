import java.util.Scanner;
import java.io.File;

public class hovedprog {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        Set<Integer> set = null;
        // File fil = new File("eksempel_input.txt");
        Scanner sc = new Scanner(new File("oppgave4eks"));
        // Scanner input = new Scanner(System.in);
        int antallganger = Integer.parseInt(sc.next());
        String inputString = "";
        for (int i = 0; i < antallganger; i++) { // for loop som looper antall ganger oppgitt
            inputString = sc.nextLine(); // leser input
            String[] splitte = inputString.split(" "); // splitter input
            try {
                if (splitte[0].equals("contains")) { // contains, true = finnes, false = finnes ikke
                    try {
                        if (set.contains(set, Integer.parseInt(splitte[1])).data == Integer.parseInt(splitte[1])) {
                            // System.out.println("True");
                        }
                    } catch (Exception e) {
                        // System.out.println("False");
                    }
                } else if (splitte[0].equals("insert")) { // insert
                    if (set == null) {
                        set = new Set<>(Integer.parseInt(splitte[1]));
                    } else {
                        set.insert(set, Integer.parseInt(splitte[1]));
                    }
                } else if (splitte[0].equals("remove")) { // remove
                    set = set.remove(set, Integer.parseInt(splitte[1]));
                } else if (splitte[0].equals("size")) { // size
                    set.size();
                    // System.out.println(set.size());
                } else {
                    // System.out.println("wrong input given: " + splitte[0]);
                    i--;
                }
            } catch (Exception e) {
            }
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        // System.out.println("siste linje");
    }
}

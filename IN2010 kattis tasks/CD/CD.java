package CD;

import java.util.Scanner;
import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CD {
    public static void main(String[] args) throws Exception {

        // File inputFile = new File("CD/A.0.in");
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String[] CDs;
        int Jack;
        int Jill;
        int same = 0;

        // Scanner inRead = new Scanner(inputFile);
        CDs = scan.readLine().split(" ");
        // CDs = inRead.nextLine().split(" ");
        Jack = Integer.parseInt(CDs[0]);
        Jill = Integer.parseInt(CDs[1]);
        String[] jackList = new String[Jack];
        String[] jillList = new String[Jill];
        for (int i = 0; i < Jack; i++) {
            jackList[i] = scan.readLine();
        }
        for (int i = 0; i < Jill; i++) {
            jillList[i] = scan.readLine();
        }
        String empty = scan.readLine();
        for (int i = 0; i < jackList.length; i++) {
            for (int j = 0; j < jillList.length; j++) {
                if (jackList[i].equals(jillList[j])) {
                    same++;
                }
            }
        }

        System.out.println(same);
    }
}

import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class hovedprog {

    void insertion(int sorter[]){
        Insertion insertion = new Insertion();
        insertion.A = sorter;
        insertion.sort();
        for (int i : insertion.A) {
            System.out.println(i);
        }
    }

    void minQ(int[] sorter){
        QuickSort minQ = new QuickSort();
        minQ.sorter = sorter;
        minQ.quickSort(sorter, 0, sorter.length - 1);
        for (int i : sorter) {
            System.out.println(i);
        }
    }

    void levereQ(int[] sorter){
        Quick quick = new Quick();
        quick.A = sorter;
        quick.sort();
        for (int i : quick.A) {
            System.out.println(i);
        }
    }
    void bubble(int[] sorter){
        BubbleSort bubble = new BubbleSort();
        bubble.A = sorter;
        bubble.sort();
        for (int i : bubble.A) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) throws Exception {
        hovedprog hp = new hovedprog();

        //alle filene som variabler
        String nearly_sorted_10 = "inputs/nearly_sorted_10";
        String nearly_sorted_100 = "inputs/nearly_sorted_100";
        String nearly_sorted_1000 = "inputs/nearly_sorted_1000";
        String nearly_sorted_10000 = "inputs/nearly_sorted_10000";
        String nearly_sorted_100000 = "inputs/nearly_sorted_100000";
        String nearly_sorted_1000000 = "inputs/nearly_sorted_1000000";
        String random_10 = "inputs/random_10";
        String random_100 = "inputs/random_100";
        String random_1000 = "inputs/random_1000";
        String random_10000 = "inputs/random_10000";
        String random_100000 = "inputs/random_100000";
        String random_1000000 = "inputs/random_1000000";
        String valgt = null;

        System.out.println("velg fil: \n1. nearly_sorted_10 \n2. nearly_sorted_100 \n3. nearly_sorted_1000 \n4. nearly_sorted_10000 \n5. nearly_sorted_100000 \n6. nearly_sorted_1000000\n7. random_10\n8. random_100\n9. random_1000\n10. random_10000\n11. random_100000\n12. random_100000");

        Scanner filvalg = new Scanner(System.in);


    while(valgt == null){
        String valg = filvalg.nextLine();
        if(valg.equals("1")){
            valgt = nearly_sorted_10;
        }
        else if(valg.equals("2")){
            valgt = nearly_sorted_100;
        }
        else if(valg.equals("3")){
            valgt = nearly_sorted_1000;
        }
        else if(valg.equals("4")){
            valgt = nearly_sorted_10000;
        }
        else if(valg.equals("5")){
            valgt = nearly_sorted_100000;
        }
        else if(valg.equals("6")){
            valgt = nearly_sorted_1000000;
        }
        else if(valg.equals("7")){
            valgt = random_10;
        }
        else if(valg.equals("8")){
            valgt = random_100;
        }
        else if(valg.equals("9")){
            valgt = random_1000;
        }
        else if(valg.equals("10")){
            valgt = random_10000;
        }
        else if(valg.equals("11")){
            valgt = random_100000;
        }
        else if(valg.equals("12")){
            valgt = random_1000000;
        }
        else {
            System.out.println("Feil tastetrykk");
        }
    }
    filvalg.close();

        
        //leser antall linjer i filen 
        Scanner les = new Scanner(new File(valgt));
        int antallLinjer = 0; 
        while(les.hasNextLine()){
            les.nextLine();
            antallLinjer++;
        }
        les.close();
        
        int[] sorter = new int[antallLinjer];
        int peker = 0;

        les = new Scanner(new File(valgt));
        while(les.hasNextLine()){
            sorter[peker] = Integer.parseInt(les.nextLine());
            peker++;
        }

        long startTime = System.nanoTime();

        //hp.insertion(sorter);
        //hp.minQ(sorter);
        //hp.levereQ(sorter);
        hp.bubble(sorter);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime); 

        System.out.println("det tok: " + (duration / 1000000) + " millisekunder");
        //System.out.println(InS.runStringFormat());
        //System.out.println(InS.headerString());
        //System.out.println("antall swaps: "+ InS.swaps);
        //System.out.println("antall comparisons: "+ InS.comparisons);
    }
}

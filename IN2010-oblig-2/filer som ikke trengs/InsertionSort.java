public class InsertionSort {

    int sorter[];

    public InsertionSort(int sorter[]){
        this.sorter = sorter;
    }
    public InsertionSort(){
    }

    void sorter(){
        for (int i = 1; i < sorter.length; i++) {
            int peker = sorter[i];
            int j = i - 1; 

            while (j >= 0 && sorter[j] > peker){
                sorter[j + 1] = sorter[j];
                j--;
            }
            sorter[j + 1] = peker; 
        }
    }

    void sorter(int[] toSort){
        sorter = toSort;
        for (int i = 1; i < sorter.length; i++) {
            int peker = sorter[i];
            int j = i - 1; 

            while (j >= 0 && sorter[j] > peker){
                sorter[j + 1] = sorter[j];
                j--;
            }
            sorter[j + 1] = peker; 
        }
    }

    /* 
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
		InsertionSort ob = new InsertionSort(arr);
        ob.sorter();
        
        for (int i : arr) {
            System.out.println(i);
        }
        
    }
    */

}

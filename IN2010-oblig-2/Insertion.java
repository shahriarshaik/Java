class Insertion extends Sorter {
    public Insertion(int[] A){
        this.A = A;
    }
    public Insertion(){
    }

    void sort() {//     i < A.length
        for (int i = 1; lt(i, A.length); i++) {
            int peker = A[i];
            int j = i - 1; 
            
      //    while (j >= 0 && A[j] > peker){
            while (geq(j, 0) && gt(A[j], peker)){
                swaps++;
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = peker; 
        }
    }

    String algorithmName() {
        return "insertion";
    }
}
public class BubbleSort extends Sorter{

    public BubbleSort(){
    }

    void sort(){
        int n = A.length;
        //             i < (n - 1)
        for(int i = 0; lt(i, (n - 1)); i++){
            //             j < (n - i - 1)
            for(int j = 0; lt(j, (n - i - 1)); j++){
                // A[j] > A[j +1]
                if(gt(A[j], A[j +1])){
                    //swap(A[j], A[j + 1]);
                    //swap(j, j + 1);
                    //swap(A[j+1], A[j]);
                    swaps++;
                    int peker = A[j];
                    A[j] = A[j+1];
                    A[j+1] = peker;
                }
            }
        }
    }

    void sort(int[] A){
        int n = A.length;
        this.A = A;
        //             i < (n - 1)
        for(int i = 0; lt(i, (n-1)); i++){
            //             j < (n - i - 1
            for(int j = 0; lt(j, (n - i - 1)); j++){
                // A[j] > A[j +1]
                if(gt(A[j], A[j + 1])){
                    //swap(A[j], A[j + 1]);
                    //swap(j, j + 1);
                    //swap(A[j+1], A[j]);
                    swaps++;
                    int peker = A[j];
                    A[j] = A[j+1];
                    A[j+1] = peker;
                }
            }
        }
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to test above
    public static void main(String args[])
    {
        BubbleSort ob = new BubbleSort();
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }


    @Override
    String algorithmName() {
        return "Bubble";
    }

}

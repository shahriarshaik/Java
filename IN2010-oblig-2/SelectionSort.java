public class SelectionSort extends Sorter{

    public SelectionSort(){}

    void sort(){
        int n = A.length;
//                     i < n - 1
        for(int i = 0; lt(i, n - 1); i++){
            int lavindex = i; 
            //                  j < n
            for( int j = i + 1; lt(j, n); j++){
                // A[j] < A[lavindex]
                if(lt(A[j], A[lavindex])){
                    lavindex = j;
                }
            }
            swaps++;
            int peker = A[lavindex];
            A[lavindex] = A[i];
            A[i] = peker;
        }
    }

    void sort(int[] A){
        int n = A.length;
//                     i < n - 1
        for(int i = 0; lt(i, n - 1); i++){
            int lavindex = i; 
            //                  j < n
            for( int j = i + 1; lt(j, n); j++){
                // A[j] < A[lavindex]
                if(lt(A[j], A[lavindex])){
                    lavindex = j;
                }
            }
            swaps++;
            int peker = A[lavindex];
            A[lavindex] = A[i];
            A[i] = peker;
        }
    }

    @Override
    String algorithmName() {
        return "Selection";
    }

}

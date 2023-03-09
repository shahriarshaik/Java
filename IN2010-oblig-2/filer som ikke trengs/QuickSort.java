
public class QuickSort {

    int[] sorter;

    public QuickSort(int[] sorter){
        this.sorter = sorter;
    }
    public QuickSort(){
    }

    void swap(int[] sorter, int i, int j){
        int peker = sorter[i];
        sorter[i] = sorter[j];
        sorter[j] = peker;
    }

    int fordele(int[] sorter, int lav ,int hoy){
        
        int peker = sorter[hoy];
        int index = (lav - 1);

        for( int j = lav; j <= hoy - 1 ; j++){

            if(sorter[j]<peker){
                index++;
                swap(sorter, index, j);
            }
        }
        swap(sorter, index + 1, hoy);
        return (index + 1);
    }

    void quickSort(int[] sorter, int lav, int hoy){
        if(lav < hoy){
            int p = fordele(sorter, lav, hoy);

            quickSort(sorter, lav, p - 1);
            quickSort(sorter, p + 1, hoy);
        }
    }

    void printArray(int[] arr, int size){
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

    public static void main(String[] args){
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

        QuickSort QS = new QuickSort(arr);

		QS.quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		QS.printArray(arr, n);
	}
}

class Quick extends Sorter {

    public Quick(){}
    public Quick(int[] A){
        this.A = A;
    }

    void sort() {
        // lav < hoy
        int lav = 0;
        int hoy = A.length - 1;
        if(lt(lav, hoy)){
            int p = fordele(A, lav, hoy);

            sort(A, lav, p - 1);
            sort(A, p + 1, hoy);
        }
    }


    void sort(int[] A, int lav, int hoy) {
        // lav < hoy
        if(lt(lav, hoy)){
            int p = fordele(A, lav, hoy);

            sort(A, lav, p - 1);
            sort(A, p + 1, hoy);
        }
    }

    int fordele(int[] sorter, int lav ,int hoy){
        
        int peker = sorter[hoy];
        int index = (lav - 1);
//                      //j <= (hoy - 1)
        for( int j = lav; leq(j, (hoy -1)) ; j++){
//             sorter[j]<peker
            if(lt(sorter[j], peker)){
                index++;
              //swap(sorter, index, j);
                swap(index, j);
            }
        }
    //  swap(sorter, index + 1, hoy);
        swap(index + 1, hoy);
        return (index + 1);
    }


    String algorithmName() {
        return "quick";
    }
}
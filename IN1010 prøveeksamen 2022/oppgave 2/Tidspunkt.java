public class Tidspunkt implements Comparable<Tidspunkt>{

    int aar, mnd,  dag,  time,  min, sek;

    Tidspunkt(int aar, int mnd, int dag, int time, int min, int sek){
        this.aar = aar;
        this.mnd = mnd;
        this.dag = dag;
        this.time = time; 
        this.min = min;
    }

    @Override
    public int compareTo(Tidspunkt o) {
        return 0;
    }
    
}

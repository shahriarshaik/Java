public class Sil implements Runnable {
    PasientPrio liste;
    AnalyseBuffer buffer;
    int prio;
    Sil(PasientPrio liste, int prio, AnalyseBuffer buffer){
        this.liste = liste;
        this.buffer = buffer;
        this.prio = prio;
    }

    @Override
    public void run(){
        Pasient p = liste.hentUt(prio);
        if(p instanceof KvinneligPasient){
            if(Sykehus.iFaresonenKvinne(p)){
                buffer.add(p);
            }
        }
        else {
            if(Sykehus.iFaresonenMann(p)){
                buffer.add(p);
            }
        }
    }

}

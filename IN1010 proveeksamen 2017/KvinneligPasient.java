public class KvinneligPasient extends Pasient{
    KvinneligPasient(String navn, String fnr, int prio){
        super(navn, fnr, prio);
    }

    @Override
    void iFaresone(){
        Sykehus.iFaresonenKvinne(this);
    }
}

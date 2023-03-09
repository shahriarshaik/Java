public class Avdeling {
    PasientAdm pasienter;

    void settInn(Pasient p){
        pasienter.settInnPasient(p);
    }

    Pasient hentUt(Pasient P){
        return pasienter.hentUt(P);
    }

    Pasient hentUt(int i){
        return pasienter.hentUt(i);
    }

}

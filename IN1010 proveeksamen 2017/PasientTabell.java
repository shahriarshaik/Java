public class PasientTabell extends PasientAdm {

    int lengde;
    Pasient[] pasients = new Pasient[lengde];
    int lastLoc = 0;
    boolean ferdig = false; 

    public PasientTabell(int lengde){
        this.lengde = lengde;
    }
    
    @Override
    void settInnPasient(Pasient p){
        for(int x = lastLoc; x < pasients.length; x++){ //looper gjennom resterende senger
            if(pasients[x] == null){ // finner ledig seng
                pasients[x] = p;
                p.sengNr = x;
                lastLoc = x;
            }else{ //hvis gjeldende ikke er ledig sjekker om den er mot slutten av listen
                if((x-pasients.length) == 1){
                    ferdig =true;
                }
            }
        }
        if(ferdig){
            int teller = 0;
            for (Pasient pasient : pasients) {
                teller++;
                if(pasient == null){
                    pasient = p;
                    p.sengNr = teller;
                    lastLoc = teller;
                    break;
                }
            }
        }
    }


    @Override
    Pasient hentUt(Pasient p){
        int sengenr = p.sengNr;
        Pasient taUt = null;
        if(pasients[sengenr] != null){
            taUt = pasients[sengenr];
            pasients[sengenr] = null;
            return taUt;
        }
        return taUt;
    }
    @Override
    Pasient hentUt(int i){
        Pasient taUt;
        for(int x = 0; x< pasients.length; x++){
            if(pasients[x].prioritet == i){
                taUt = pasients[x];
                taUt.sengNr = -1;
                pasients[x] = null;
                return taUt;
            }
        }
        return null;
    }
}

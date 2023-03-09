public class PasientPrio extends PasientAdm {

    Pasient[] Startprio = new Pasient[Pasient.MAXPASPRIO + 1];
    Pasient[] Sluttprio = new Pasient[Pasient.MAXPASPRIO + 1];

    @Override
    public void settInnPasient(Pasient p) {
        if (Startprio[p.prioritet] == null) {
            Startprio[p.prioritet] = p;
            Sluttprio[p.prioritet] = p;
        } else {
            Sluttprio[p.prioritet].neste = p;
            Sluttprio[p.prioritet] = p;
        }
    }

    @Override
    public Pasient hentUt(Pasient p) {
        int prioritet = p.prioritet;
        Pasient startPasient = Startprio[prioritet];
        Pasient forrige = Startprio[prioritet];
        int index = 0;
        while (p.navn.equals(startPasient.navn) != true) {
            startPasient = startPasient.neste;
            index++;
        }
        for (int i = 0; i < index; i++) {
            forrige = forrige.neste;
        }
        forrige.neste = p.neste;
        return p;
    }

    @Override
    public Pasient hentUt(int i) {
        if(Startprio[i] == null){
            return null;
        } else{
        Pasient forste = Startprio[i];
        if(forste.neste == null){
            Startprio[i]=null;
        }else{
            Startprio[i] = forste.neste;
        }
        return forste;
        }
    }
}

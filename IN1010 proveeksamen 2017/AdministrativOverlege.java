public class AdministrativOverlege extends Overlege implements Administrator{

    String ansvarskode;


    public AdministrativOverlege(String navn, String ansattidentifikasjon, int legeNummer, String spesialiseringstype, String ansvarskode){
        super(navn, ansattidentifikasjon, legeNummer, spesialiseringstype);
        this.ansvarskode = ansvarskode;
    }

    @Override
    public String hentAnsvarskode() {
        return ansvarskode;
    }

}

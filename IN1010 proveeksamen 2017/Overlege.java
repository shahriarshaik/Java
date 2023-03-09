public class Overlege extends Lege{

    String spesialiseringstype;

    public Overlege(String navn, String ansattidentifikasjon, int legeNummer, String spesialiseringstype){
        super(navn, ansattidentifikasjon,legeNummer);
        this.spesialiseringstype = spesialiseringstype;
    }
}

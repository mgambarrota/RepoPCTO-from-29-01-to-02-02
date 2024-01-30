package it.betacom.model;

public class Foto extends Media{

    private String risoluzione;
    private String ISO;
    private String lunghezzaFocale;

    public Foto(Integer idMedia, String nomeMedia, String pesoMedia, String estensioneMedia, String autoreFile, String risoluzione, String ISO, String lunghezzaFocale) {
        super(idMedia, nomeMedia, pesoMedia, estensioneMedia, autoreFile);
        this.risoluzione = risoluzione;
        this.ISO = ISO;
        this.lunghezzaFocale = lunghezzaFocale;
    }

    public String getRisoluzione() {
        return risoluzione;
    }

    public void setRisoluzione(String risoluzione) {
        this.risoluzione = risoluzione;
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }

    public String getLunghezzaFocale() {
        return lunghezzaFocale;
    }

    public void setLunghezzaFocale(String lunghezzaFocale) {
        this.lunghezzaFocale = lunghezzaFocale;
    }


    @Override
    public String toString() {
        return "Foto{" +
                "risoluzione='" + risoluzione + '\'' +
                ", ISO=" + ISO +
                ", lunghezzaFocale='" + lunghezzaFocale + '\'' +
                "} " + super.toString();
    }
}

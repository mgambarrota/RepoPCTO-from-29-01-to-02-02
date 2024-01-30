package it.betacom.model;

public class Video extends Media{
    private String risoluzione;
    private String durata;

    public Video(Integer idMedia, String nomeMedia, String pesoMedia, String estensioneMedia, String autoreFile, String risoluzione, String durata) {
        super(idMedia, nomeMedia, pesoMedia, estensioneMedia, autoreFile);
        this.risoluzione = risoluzione;
        this.durata = durata;
    }

    public String getRisoluzione() {
        return risoluzione;
    }

    public void setRisoluzione(String risoluzione) {
        this.risoluzione = risoluzione;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }


    @Override
    public String toString() {
        return "Video{" +
                "risoluzione='" + risoluzione + '\'' +
                ", durata=" + durata +
                "} " + super.toString();
    }
}

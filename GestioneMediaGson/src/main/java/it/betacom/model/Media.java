package it.betacom.model;

public class Media {
    private Integer idMedia;
    private String nomeMedia;
    private String pesoMedia;
    private String estensioneMedia;

    public Media(Integer idMedia, String nomeMedia, String pesoMedia, String estensioneMedia, String autoreFile) {
        this.idMedia = idMedia;
        this.nomeMedia = nomeMedia;
        this.pesoMedia = pesoMedia;
        this.estensioneMedia = estensioneMedia;
        this.autoreFile = autoreFile;
    }

    private String autoreFile;

    public Integer getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(Integer idMedia) {
        this.idMedia = idMedia;
    }

    public String getNomeMedia() {
        return nomeMedia;
    }

    public void setNomeMedia(String nomeMedia) {
        this.nomeMedia = nomeMedia;
    }

    public String getPesoMedia() {
        return pesoMedia;
    }

    public void setPesoMedia(String pesoMedia) {
        this.pesoMedia = pesoMedia;
    }

    public String getEstensioneMedia() {
        return estensioneMedia;
    }

    public void setEstensioneMedia(String estensioneMedia) {
        this.estensioneMedia = estensioneMedia;
    }

    public String getAutoreFile() {
        return autoreFile;
    }

    public void setAutoreFile(String autoreFile) {
        this.autoreFile = autoreFile;
    }

    @Override
    public String toString() {
        return "Media{" +
                "idMedia='" + idMedia + '\'' +
                ", nomeMedia='" + nomeMedia + '\'' +
                ", pesoMedia=" + pesoMedia +
                ", estensioneMedia='" + estensioneMedia + '\'' +
                ", autoreFile='" + autoreFile + '\'' +
                '}';
    }
}

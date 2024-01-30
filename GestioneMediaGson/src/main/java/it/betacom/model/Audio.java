package it.betacom.model;

public class Audio extends Media{

    private String samplePrecision; //bit
    private String canaleAudio; //mono o stereo
    private String frequenza; //hz

    public Audio(Integer idMedia, String nomeMedia, String pesoMedia, String estensioneMedia, String autoreFile, String samplePrecision, String canaleAudio, String frequenza) {
        super(idMedia, nomeMedia, pesoMedia, estensioneMedia, autoreFile);
        this.samplePrecision = samplePrecision;
        this.canaleAudio = canaleAudio;
        this.frequenza = frequenza;
    }

    public String getSamplePrecision() {
        return samplePrecision;
    }

    public void setSamplePrecision(String samplePrecision) {
        this.samplePrecision = samplePrecision;
    }

    public String getCanaleAudio() {
        return canaleAudio;
    }

    public void setCanaleAudio(String canaleAudio) {
        this.canaleAudio = canaleAudio;
    }

    public String getFrequenza() {
        return frequenza;
    }

    public void setFrequenza(String frequenza) {
        this.frequenza = frequenza;
    }


    @Override
    public String toString() {
        return "Audio{" +
                "samplePrecision='" + samplePrecision + '\'' +
                ", canaleAudio='" + canaleAudio + '\'' +
                ", frequenza=" + frequenza +
                "} " + super.toString();
    }
}


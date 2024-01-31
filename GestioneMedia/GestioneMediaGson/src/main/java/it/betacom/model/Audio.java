package it.betacom.model;

public class Audio extends Media {
    private int durata;
    public Audio(double dimensione, String nome, String formato, int durata) {
        super(dimensione, nome, formato);
        this.durata = durata;
    }
    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "durata=" + durata +
                ", dimensione=" + dimensione +
                ", nome='" + nome + '\'' +
                ", formato='" + formato + '\'' +
                "}";
    }
}

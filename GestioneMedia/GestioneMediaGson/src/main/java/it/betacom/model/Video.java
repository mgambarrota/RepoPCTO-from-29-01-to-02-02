package it.betacom.model;

public class Video extends Media{
    private int durata;

    public Video(double dimensione, String nome, String formato, int durata) {
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
        return "\nVideo{" +
                "durata=" + durata +
                ", dimensione=" + dimensione +
                ", nome='" + nome + '\'' +
                ", formato='" + formato + '\'' +
                "}";
    }
}

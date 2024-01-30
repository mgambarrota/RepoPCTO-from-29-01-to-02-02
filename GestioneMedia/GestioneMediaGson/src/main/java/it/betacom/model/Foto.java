package it.betacom.model;

import java.util.Arrays;

public class Foto extends Media{
    private int[] risoluzione = new int[2];

    public Foto(double dimensione, String nome, int risoluzioneX, int risoluzioneY, String formato) {
        super(dimensione, nome, formato);
        this.risoluzione = new int[]{risoluzioneX, risoluzioneY};
    }

    public int[] getRisoluzione() {
        return risoluzione;
    }

    public void setRisoluzione(int[] risoluzione) {
        this.risoluzione = risoluzione;
    }

    @Override
    public String toString() {
        return "\nFoto{" +
                "risoluzione=" + Arrays.toString(risoluzione) +
                ", dimensione=" + dimensione +
                ", nome='" + nome + '\'' +
                ", formato='" + formato + '\'' +
                "}";
    }
}

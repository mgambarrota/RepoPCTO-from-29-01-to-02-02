package it.betacom.model;

public class Media {
    protected double dimensione;
    protected String nome;
    protected String formato;

    public Media (double dimensione, String nome, String formato){
        this.dimensione = dimensione;
        this.nome = nome;
        this.formato = formato;
    }

    public double getDimensione() {
        return dimensione;
    }

    public void setDimensione(double dimensione) {
        this.dimensione = dimensione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "\nMedia{" +
                "dimensione=" + dimensione +
                ", nome='" + nome + '\'' +
                ", formato='" + formato + '\'' +
                "}";
    }
}

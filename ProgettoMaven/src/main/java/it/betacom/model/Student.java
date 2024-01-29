package it.betacom.model;

public class Student {
    private String nome;
    private int eta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nome=" + nome +
                ", eta=" + eta +
                '}';
    }
}

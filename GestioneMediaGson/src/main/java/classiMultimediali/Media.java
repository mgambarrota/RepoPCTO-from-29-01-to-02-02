package classiMultimediali;

public class Media {
    private double dimensione;
    private String nome;

    public Media(){
        nome = "Standard";
        dimensione = 1;
    }
    public Media(String nome, double dimensione){
        this.nome = nome;
        this.dimensione = dimensione;
    }

    public String getNome() {
        return nome;
    }
    public double getDimensione() {
        return dimensione;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDimensione(double dimensione) {
        this.dimensione = dimensione;
    }

    public String toString() {
        return  "nome= " + nome +
                ", dimensione= " + dimensione;
    }
}

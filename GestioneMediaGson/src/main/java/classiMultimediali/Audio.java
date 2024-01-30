package classiMultimediali;

public class Audio extends Media {
    private int durata;

    public Audio(){
        super();
        durata = 3;
    }
    public Audio(double dimensione, String nome, int  durata){
        super(nome, dimensione);
        this.durata=durata;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", durata=" + durata;
    }
}

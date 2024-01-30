package classiMultimediali;

public class Video extends Media{
    private int durata;
    private String qualità;

    public Video(){
        super();
        durata = 4;
        qualità = "HD";
    }
    public Video(double dimensione, String nome, int  durata, String qualità){
        super(nome, dimensione);
        this.durata = durata;
        this.qualità = qualità;
    }

    public String getQualità() {
        return qualità;
    }

    public int getDurata() {
        return durata;
    }

    public void setQualità(String qualità) {
        this.qualità = qualità;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return  super.toString()+
                ", durata=" + durata +
                ", qualità='" + qualità;
    }
}

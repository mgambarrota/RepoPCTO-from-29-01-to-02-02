package classiMultimediali;

public class Foto extends Media {
    private int altezza, larghezza;

    public Foto(){
        super();
        altezza = 2;
        larghezza = 2;
    }
    public Foto(double dimensione, String nome, int  altezza, int larghezza){
        super(nome, dimensione);
        this.altezza=altezza;
        this.larghezza=larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", altezza=" + altezza +
                ", larghezza=" + larghezza;
    }
}

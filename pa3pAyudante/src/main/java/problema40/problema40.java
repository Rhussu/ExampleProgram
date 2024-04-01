package problema40;

public class problema40 {
    public static void main(String[] args) {
        System.out.println("UwU");
    }
}
abstract class Bebida {
    private int serie;

    public Bebida(int serie) {
        this.serie = serie;
    }

    public int getSerie() {
        return serie;
    }

    public abstract String beber();
}

class Sprite extends Bebida{
    public Sprite(int serie) {
        super(serie);
    }
    public String beber() {
        return "sprite";
    }
}

class Fanta extends Bebida{
    public Fanta(int serie) {
        super(serie);
    }
    public String beber() {
        return "fanta";
    }
}

class Kem extends Bebida{
    public Kem(int serie) {
        super(serie);
    }
    public String beber() {
        return "kem";
    }
}

class CocaCola extends Bebida{
    public CocaCola(int serie) {
        super(serie);
    }
    public String beber() {
        return "cocacola";
    }
}

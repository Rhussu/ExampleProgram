package problema41;

import java.util.ArrayList;

public class problema41 {
    public static void main(String[] args) {
        System.out.println("UwU");
    }
}

class Deposito {
    private ArrayList<Bebida> almacen;

    public Deposito() {
        almacen = new ArrayList<Bebida>();
    }

    public void addBebida(Bebida b) {
        almacen.add(b);
    }
    public Bebida getBebida() {
        if(almacen.size() != 0) {
            return almacen.remove(0);
        }
        return null;
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

class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }
    public String beber() {
        return "sprite";
    }
}

class Fanta extends Bebida {
    public Fanta(int serie) {
        super(serie);
    }
    public String beber() {
        return "fanta";
    }
}

class Kem extends Bebida {
    public Kem(int serie) {
        super(serie);
    }
    public String beber() {
        return "kem";
    }
}

class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    public String beber() {
        return "cocacola";
    }
}

package problema42;

import java.util.ArrayList;

public class problema42 {
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
class Bebida {
    private int serie;

    public Bebida(int serie) {
        this.serie = serie;
    }

    public int getSerie() {
        return serie;
    }

    public  String beber() {
        return "sabor: ";
    };
}

class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }
    public String beber() {
        return super.beber() + "sprite";
    }
}

class Fanta extends Bebida {
    public Fanta(int serie) {
        super(serie);
    }
    public String beber() {
        return super.beber() + "fanta";
    }
}

class Kem extends Bebida {
    public Kem(int serie) {
        super(serie);
    }
    public String beber() {
        return super.beber() + "kem";
    }
}

class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    public String beber() {
        return super.beber() + "cocacola";
    }
}

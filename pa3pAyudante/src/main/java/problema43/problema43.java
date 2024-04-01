package problema43;

import java.util.ArrayList;

public class problema43 {
    public static void main(String[] args) {
        System.out.println("UwU");
        Expendedor exp = new Expendedor(2);
        Moneda m;

        Bebida b=null;
        m=new Moneda();b=exp.comprarBebida(m,1);
        if(b!=null)System.out.println(b.getSerie()+", "+b.beber());
                m=new Moneda();
                b=exp.comprarBebida(m,1);
        if(b!=null)System.out.println(b.getSerie()+", "+b.beber());
                m=new Moneda();
                b=exp.comprarBebida(m,1);
        m=new Moneda();
        b=exp.comprarBebida(m,2);
        if(b!=null)System.out.println(b.getSerie()+", "+b.beber());
                m=new Moneda();
                b=exp.comprarBebida(m,2);
        if(b!=null)System.out.println(b.getSerie()+", "+b.beber());
                m=new Moneda();
                b=exp.comprarBebida(m,2);
    }
}

class Expendedor {
    private Deposito coca;
    private Deposito sprite;

    public Expendedor(int cuantas) {
        coca = new Deposito();
        sprite = new Deposito();
        for (int i = 0; i < cuantas; i++) {
            coca.addBebida(new CocaCola(i + 100));
            sprite.addBebida(new Sprite(i + 200));
        }
    }

    public Bebida comprarBebida(Moneda m, int cual) {
        if(m == null) {
            return null;
        } else {
            if(cual == 1) {
                return coca.getBebida();
            } else if (cual == 2) {
                return sprite.getBebida();
            }
        }
        return null;
    }
}

class Moneda {

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

    public String beber() {
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
class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    public String beber() {
        return super.beber() + "cocacola";
    }
}

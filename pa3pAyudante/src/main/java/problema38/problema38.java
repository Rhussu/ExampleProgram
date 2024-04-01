package problema38;

public class problema38 {
    public static void main(String[] args) {
        System.out.println("OwO");
    }
}

class CuatroOperaciones extends SumaResta {
    public CuatroOperaciones(float uno, float dos) {
        super(uno, dos);
    }

    public float multiplica() {
        return uno * dos;
    }

    public float divide() {
        return uno / dos;
    }
}

class SumaResta {
    protected float uno;
    protected float dos;

    public SumaResta(float uno, float dos) {
        this.uno = uno;
        this.dos = dos;
    }

    public float suma() {
        return uno + dos;
    }

    public float resta() {
        if(uno > dos)
            return uno - dos;
        return dos - uno;
    }
}

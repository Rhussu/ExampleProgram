package problema39;

public class problema39 {
    public static void main(String[] args) {
        System.out.println("OwO");
    }
}
class CuatroOperaciones extends SumaResta {
    public CuatroOperaciones(float uno, float dos) {
        super(uno, dos);
    }

    public float multiplica() {
        return getUno() * getDos();
    }

    public float divide() {
        return getUno() / getDos();
    }
}

class SumaResta {
    private float uno;
    private float dos;

    public SumaResta(float uno, float dos) {
        this.uno = uno;
        this.dos = dos;
    }

    public float getUno() {
        return uno;
    }

    public float getDos() {
        return dos;
    }

    public float suma() {
        return uno + dos;
    }

    public float resta() {
        return uno - dos;
    }
}

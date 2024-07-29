package POO_Hilos.Actividad;

public class AlfanuméricoTipos implements Runnable{
        //Atributos de AlfanuméricoTipos
    private Tipo TipoCaracter;

        //Constructores de AlfanuméricoTipos
    public AlfanuméricoTipos(Tipo tipoCaracter) {
        this.TipoCaracter = tipoCaracter;
    }

    //Asignadores de atributos de AlfanuméricoTipos (setter)
    //Lectores de atributos de AlfanuméricoTipos (getter)

        //Métodos de AlfanuméricoTipos
    public synchronized static void ImprimirLetras(Tipo tipo) throws InterruptedException {
        String resultado = "";
        System.out.println("Imprímanse las letras");
        for (int i = 65; i < 91; i++){
            if(i == 78) {
                resultado += (char) i;
                resultado += (char)209;
            } else {
                resultado += (char) i;
            }
            Thread.sleep(20);
        }
        System.out.println(resultado);
    }
    public synchronized static void ImprimirNúmeros(Tipo tipo){
        String Numérico = "";
        Integer i = 0;
        System.out.println("Que se hagan los números");
        try {
            while(i < 9) {
                Numérico += Integer.toString(++i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Numérico);
    }

    @Override
    public void run() {
        try {
            switch (this.TipoCaracter) {
                case LETRA -> ImprimirLetras(Tipo.LETRA);
                case NÚMERO -> ImprimirNúmeros(Tipo.NÚMERO);
            }
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

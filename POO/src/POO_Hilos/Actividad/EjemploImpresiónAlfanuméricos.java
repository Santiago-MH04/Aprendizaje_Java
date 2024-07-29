package POO_Hilos.Actividad;

public class EjemploImpresiónAlfanuméricos {
    public static void main(String[] args) {
            //Imprimir números
        new Thread(new AlfanuméricoTipos(Tipo.NÚMERO)).start();

            //Imprimir letras
        new Thread(new AlfanuméricoTipos(Tipo.LETRA)).start();
    }
}

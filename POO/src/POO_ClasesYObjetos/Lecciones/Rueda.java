package POO_ClasesYObjetos.Lecciones;

public class Rueda {
        //Atributos de rueda
    private String fabricante;
    private int rin;
    private double ancho;

        //Constructor de atributos de rueda
    public Rueda(String fabricante, int rin, double ancho) {
        this.fabricante = fabricante;
        this.rin = rin;
        this.ancho = ancho;
    }

        //Lector de atributos de rueda
    public String getFabricante() {
        return fabricante;
    }
        public int getRin() {
            return rin;
        }
            public double getAncho() {
                return ancho;
            }
}

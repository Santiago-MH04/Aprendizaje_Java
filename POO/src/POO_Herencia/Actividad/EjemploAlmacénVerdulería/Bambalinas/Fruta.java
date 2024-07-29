package POO_Herencia.Actividad.EjemploAlmacénVerdulería.Bambalinas;

import java.util.Scanner;

public class Fruta extends Producto{
        //Atributos de Fruta
    private double Peso;
    private String Color;

        //Constructores de Fruta
    public Fruta() {
    }
        public Fruta(String nombre, double precio, double peso) {
            super(nombre, precio);
            this.Peso = peso;
        }
            public Fruta(String nombre, double precio, double peso, String color) {
                this(nombre, precio, peso);
                this.Color = color;
            }

        //Asignadores de atributos de Fruta (setter)
    public void setPeso(double peso) {
        this.Peso = peso;
    }
        public void setColor(String color) {
            this.Color = color;
        }

        //Lectores de atributos de Fruta (getter)
    public double getPeso() {
        return this.Peso;
    }
        public String getColor() {
            return this.Color;
        }

        //Otros métodos de Fruta
    /*@Override
    public void setPrecio() {
        Scanner s = new Scanner(System.in);
        System.out.print("¿Cuál es el peso unitario de las frutas a comprar [$/kg]? (Por favor, ingrese un entero)");
        int pesoUnitario = s.nextInt();
        double precio = this.Peso*(pesoUnitario);
        return precio;
    }*/

    @Override
    public String toString() {
        return super.toString() +
                "\nPeso de las frutas seleccionadas: " + this.Peso + " [kg]" +
                "\nColor: " + this.Color;
    }
}

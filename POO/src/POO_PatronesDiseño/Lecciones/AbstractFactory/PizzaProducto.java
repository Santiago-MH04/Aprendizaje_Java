package POO_PatronesDiseño.Lecciones.AbstractFactory;

import java.util.ArrayList;
import java.util.List;

abstract public class PizzaProducto {
        //Atributos de PizzaProducto
    protected String Nombre;
    protected String Masa;
    protected String Salsa;
    protected List<String> Ingredientes;

        //Constructores de PizzaProducto
    public PizzaProducto() {
        this.Ingredientes = new ArrayList<>();
    }

    //Asignadores de atributos de PizzaProducto (setter)
        //Lectores de atributos de PizzaProducto (getter)
    public String getNombre() {
        return this.Nombre;
    }

     //Métodos de PizzaProducto
    public void Preparar(){
        System.out.println("Preparando: " + this.Nombre);
        System.out.println("Seleccionando la masa: " + this.Masa);
        System.out.println("Agregando la salsa : " + this.Salsa);
        System.out.println("Agregando ingredientes:");
        this.Ingredientes.forEach(System.out::println);
    }
    abstract public void Hornear();     //Cada pizzería fabrica su pizza como mejor le parezca
    abstract public void Cortar();     //Cada pizzería corta su pizza como mejor le parezca
    public void Empacar(){
        System.out.println("Empacando la pizza de don Cangrejo para que la disfrutes");
    }

    @Override
    public String toString() {
        return "Pizza de don Cangrejo {" +
                "Nombre: " + this.Nombre +
                ", masa: " + this.Masa +
                ", salsa: " + this.Salsa +
                ", ingredientes:" + this.Ingredientes +
                '}';
    }
}

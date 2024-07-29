package POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto;

import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzaProducto;

public class PizzaBigotesPepperoni extends PizzaProducto {
    //Atributos de PizzaBigotesPepperoni
        //Constructores de PizzaBigotesPepperoni
    public PizzaBigotesPepperoni() {
        super();
        Nombre = "Pizza de Pepperoni de Bigotes";
        Masa = "Masa delgada a la piedra";
        Salsa = "Pasta di pomodoro";
        Ingredientes.add("Queso provolone");
        Ingredientes.add("Pepperoni");
        Ingredientes.add("Orégano");
    }

    //Asignadores de atributos de PizzaBigotesPepperoni (setter)
    //Lectores de atributos de PizzaBigotesPepperoni (getter)
        //Métodos de PizzaBigotesPepperoni
    @Override
    public void Hornear() {
        System.out.println("Hornear por 90' a 80°C");
    }
    @Override
    public void Cortar() {
        System.out.println("Cortar en triángulos");
    }
}

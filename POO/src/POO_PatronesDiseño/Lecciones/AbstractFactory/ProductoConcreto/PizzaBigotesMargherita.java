package POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto;

import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzaProducto;

public class PizzaBigotesMargherita extends PizzaProducto {
    //Atributos de PizzaBigotesMargherita
        //Constructores de PizzaBigotesMargherita
    public PizzaBigotesMargherita() {
        super();
        Nombre = "Pizza Margherita de Bigotes";
        Masa = "Masa delgada a la piedra crocante";
        Salsa = "Pasta di pomodoro";
        Ingredientes.add("Queso mozzarella");
        Ingredientes.add("Albahaca");
        Ingredientes.add("Tomates");
    }
    //Asignadores de atributos de PizzaBigotesMargherita (setter)
    //Lectores de atributos de PizzaBigotesMargherita (getter)
        //Métodos de PizzaBigotesMargherita
    @Override
    public void Hornear() {
        System.out.println("Hornear en leña a 120 °C por 25'");
    }
    @Override
    public void Cortar() {
        System.out.println("Rebanar la pizza en porciones circulares");
    }
}

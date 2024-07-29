package POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto;

import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzaProducto;

public class PizzaBigotesLudovica extends PizzaProducto {
    //Atributos de PizzaBigotesLudovica
        //Constructores de PizzaBigotesLudovica
    public PizzaBigotesLudovica() {
        super();
        Nombre = "Pizza Ludovica de Bigotes";
        Masa = "Masa madre";
        Salsa = "Pasta de tomate";
        Ingredientes.add("Queso mozzarella");
        Ingredientes.add("Anchoas");
        Ingredientes.add("Albahaca");
        Ingredientes.add("Aceitunas negras");
    }

    //Asignadores de atributos de PizzaBigotesLudovica (setter)
    //Lectores de atributos de PizzaBigotesLudovica (getter)
        //Métodos de PizzaBigotesLudovica
    @Override
    public void Hornear() {
        System.out.println("Horneando por 30' a 125 °C");
    }
    @Override
    public void Cortar() {
        System.out.println("Cortando rebanadas de porciones circulares");
    }
}

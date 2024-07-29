package POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto;

import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzaProducto;

public class PizzaRedHouseMargherita extends PizzaProducto {
    //Atributos de PizzaRedHouseHawaiana
        //Constructores de PizzaRedHouseHawaiana
    public PizzaRedHouseMargherita() {
        super();
        Nombre = "Pizza Margherita de Red House";
        Masa = "Masa delgada a la piedra";
        Salsa = "Pasta de tomate concentrada";
        Ingredientes.add("Queso mozzarella");
        Ingredientes.add("Albahaca");
        Ingredientes.add("Tomate");
        Ingredientes.add("Aceitunas negras");

    }

    //Asignadores de atributos de PizzaRedHouseHawaiana (setter)
    //Lectores de atributos de PizzaRedHouseHawaiana (getter)
        //Métodos de PizzaRedHouseHawaiana
    @Override
    public void Hornear() {
        System.out.println("Hornear en leña por 20' a 150°C");
    }
    @Override
    public void Cortar() {
        System.out.println("Rebanando la pizza en tajadas circulares");
    }
}

package POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto;

import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzaProducto;

public class PizzaRedHouseRoma extends PizzaProducto {
    //Atributos de PizzaRedHouseHawaiana
        //Constructores de PizzaRedHouseHawaiana
    public PizzaRedHouseRoma() {
        super();
        Nombre = "Pizza Roma de Red House";
        Masa = "Masa gruesa";
        Salsa = "Pasta de tomate y aalsa BBQ";
        Ingredientes.add("Queso mozzarella");
        Ingredientes.add("Carne a la bolognesa");
        Ingredientes.add("Tocineta");
        Ingredientes.add("Pimienta cayenne");

    }

    //Asignadores de atributos de PizzaRedHouseHawaiana (setter)
    //Lectores de atributos de PizzaRedHouseHawaiana (getter)
        //Métodos de PizzaRedHouseHawaiana
    @Override
    public void Hornear() {
        System.out.println("Hornear por 35' a 100°C");
    }
    @Override
    public void Cortar() {
        System.out.println("Rebanando la pizza en tajadas circulares");
    }
}

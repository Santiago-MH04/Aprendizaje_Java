package POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto;

import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzaProducto;

public class PizzaRedHouseHawaiana extends PizzaProducto {
    //Atributos de PizzaRedHouseHawaiana
        //Constructores de PizzaRedHouseHawaiana
    public PizzaRedHouseHawaiana() {
        super();
        Nombre = "Pizza hawaiana de Red House";
        Masa = "Masa orgánica";
        Salsa = "Salsa BBQ";
        Ingredientes.add("Queso mozzarella");
        Ingredientes.add("Jamón");
        Ingredientes.add("Piña");
    }

    //Asignadores de atributos de PizzaRedHouseHawaiana (setter)
    //Lectores de atributos de PizzaRedHouseHawaiana (getter)
        //Métodos de PizzaRedHouseHawaiana
    @Override
    public void Hornear() {
        System.out.println("Hornear por 20' a 180°C");
    }
    @Override
    public void Cortar() {
        System.out.println("Rebanando la pizza en trozos rectangulares");
    }
}

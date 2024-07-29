package POO_PatronesDiseño.Lecciones.AbstractFactory;

import POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto.PizzaBigotesLudovica;
import POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto.PizzaBigotesMargherita;
import POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto.PizzaBigotesPepperoni;

public class PizzeríaBigotesFactory extends PizzeríaZonaAbstractFactory{
    //Atributos de PizzeríaBigotesFactory
    //Constructores de PizzeríaBigotesFactory
    //Asignadores de atributos de PizzeríaBigotesFactory (setter)
    //Lectores de atributos de PizzeríaBigotesFactory (getter)

        //Métodos de PizzeríaBigotesFactory
    @Override
    PizzaProducto CrearPizza(String Sabor) {
        PizzaProducto Orden = null;
        switch(Sabor){
            case "Ludovica" -> Orden = new PizzaBigotesLudovica();
            case "Pepperoni" -> Orden = new PizzaBigotesPepperoni();
            case "Margarita" -> Orden = new PizzaBigotesMargherita();
        }
        return Orden;
    }
}

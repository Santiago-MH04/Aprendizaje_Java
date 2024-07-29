package POO_PatronesDiseño.Lecciones.AbstractFactory;

import POO_PatronesDiseño.Lecciones.AbstractFactory.ProductoConcreto.*;

public class PizzeríaRedHouseFactory extends PizzeríaZonaAbstractFactory{
    //Atributos de PizzeríaRedHouseFactory
    //Constructores de PizzeríaRedHouseFactory
    //Asignadores de atributos de PizzeríaRedHouseFactory (setter)
    //Lectores de atributos de PizzeríaRedHouseFactory (getter)

        //Métodos de PizzeríaRedHouseFactory
    @Override
    PizzaProducto CrearPizza(String Sabor) {
        PizzaProducto Orden = null;
        switch(Sabor){
            case "Hawaiana" -> Orden = new PizzaRedHouseHawaiana();
            case "Roma" -> Orden = new PizzaRedHouseRoma();
            case "Margarita" -> Orden = new PizzaRedHouseMargherita();
        }
        return Orden;
    }
}

package POO_PatronesDiseño.Lecciones.AbstractFactory.Ejemplo;

import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzaProducto;
import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzeríaBigotesFactory;
import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzeríaRedHouseFactory;
import POO_PatronesDiseño.Lecciones.AbstractFactory.PizzeríaZonaAbstractFactory;

public class EjemploLaPizzaDeDonCangrejo {
    public static void main(String[] args) {
            //Crear las sucursales
        PizzeríaZonaAbstractFactory CarlosE = new PizzeríaBigotesFactory();
        PizzeríaZonaAbstractFactory ParqueCopa = new PizzeríaRedHouseFactory();

            //Ordenar las pizzas
        PizzaProducto MiPizza = CarlosE.OrdenarPizza("Ludovica");
        System.out.println("Bruce, Bruce... come la " + MiPizza.getNombre().toLowerCase());
            MiPizza = CarlosE.OrdenarPizza("Pepperoni");
        System.out.println("Hacer fila antes de poder conseguir " + MiPizza.getNombre().toLowerCase());
            MiPizza = CarlosE.OrdenarPizza("Margarita");
        System.out.println("La " + MiPizza.getNombre().toLowerCase( ) + " es menos clásica que la de Due Amici");

            MiPizza = ParqueCopa.OrdenarPizza("Roma");
        System.out.println("Vamos a esperar dos horas para que nos atiendan y nos den la " + MiPizza.getNombre().toLowerCase());
            MiPizza = ParqueCopa.OrdenarPizza("Hawaiana");
        System.out.println("La " + MiPizza.getNombre().toLowerCase() + " sólo la venden a domicilio");
            MiPizza = ParqueCopa.OrdenarPizza("Margarita");
        System.out.println("La " + MiPizza.getNombre().toLowerCase() + " es la mejor pizza, para ti y para mí");

            //Ver detalle completo
        System.out.println("MiPizza: " + MiPizza.toString().toLowerCase());
    }
}

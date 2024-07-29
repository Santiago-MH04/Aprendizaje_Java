package POO_PatronesDiseño.Lecciones.AbstractFactory;

abstract public class PizzeríaZonaAbstractFactory {
    //Atributos de PizzeríaZonaAbstractFactory
    //Constructores de PizzeríaZonaAbstractFactory
    //Asignadores de atributos de PizzeríaZonaAbstractFactory (setter)
    //Lectores de atributos de PizzeríaZonaAbstractFactory (getter)

        //Métodos de PizzeríaZonaAbstractFactory
    abstract PizzaProducto CrearPizza(String Sabor);
    public PizzaProducto OrdenarPizza(String Sabor){
        PizzaProducto Pizza = CrearPizza(Sabor);
        System.out.println("Fabricando la pizza " + Pizza.getNombre() + " para ti y para mí");
            Pizza.Preparar();
            Pizza.Hornear();
            Pizza.Cortar();
            Pizza.Empacar();
        return Pizza;
    }
}

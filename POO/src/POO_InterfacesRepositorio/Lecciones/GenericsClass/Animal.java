package POO_InterfacesRepositorio.Lecciones.GenericsClass;

public class Animal {
        //Atributos de Animal
    private String Especie;
    private String Nombre;

        //Constructores de Animal
    public Animal(String especie, String nombre) {
        this.Especie = especie;
        this.Nombre = nombre;
    }

    //Asignadores de atributos de Animal (setter)
        //Lectores de atributos de Animal (getter)
    public String getEspecie() {
        return this.Especie;
    }
        public String getNombre() {
            return this.Nombre;
        }

    //Métodos de Animal
}

package POO_PatronesDiseño.Lecciones.Composite;

public class Archivo extends Componente{
    //Atributos de Componente
        //Constructores de Componente
    public Archivo(String nombre) {
        super(nombre);
    }

    //Asignadores de atributos de Componente (setter)
    //Lectores de atributos de Componente (getter)
        //Métodos de Componente
    @Override
    public String Mostrar(int Nivel) {
        return "\t".repeat(Nivel) + Nombre;              //Se muestra el atributo protegido de la clase padre
    }
    @Override
    public boolean Buscar(String Nombre) {
        return this.Nombre.equalsIgnoreCase(Nombre);    //Con el this se evitan todas las posibles ambigüedades
    }
}

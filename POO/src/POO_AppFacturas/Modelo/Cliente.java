package POO_AppFacturas.Modelo;

public class Cliente {
        //Atributos de la clase Cliente
    private String Nombre;
    private String NIT;

        //Asignadores de atributos (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
        public void setNIT(String NIT) {
            this.NIT = NIT;
        }

        //Lectores de atributos (getter)
    public String getNombre() {
        return Nombre;
    }
        public String getNIT() {
            return NIT;
        }
}

package APIServlet.Session.Lecciones.Models;

public class Categoria {
        //Atributos de Categoría
    private Long ID;
    private String Nombre;

    //Constructores de Categoría
        //Asignadores de atributos de Categoría (setter)
    public void setID(Long ID) {
        this.ID = ID;
    }
        public void setNombre(String nombre) {
            this.Nombre = nombre;
        }

        //Lectores de atributos de Categoría (getter)
    public Long getID() {
        return this.ID;
    }
        public String getNombre() {
            return this.Nombre;
        }

    //Métodos de Categoría
}

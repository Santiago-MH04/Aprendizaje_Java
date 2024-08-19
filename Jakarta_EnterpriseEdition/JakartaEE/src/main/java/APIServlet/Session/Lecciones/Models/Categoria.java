package APIServlet.Session.Lecciones.Models;

public class Categoria {
        //Atributos de Categoria
    private Long ID;
    private String Nombre;

        //Constructores de Categoria
    public Categoria() {
    }

        //Asignadores de atributos de Categoria (setters)
    public void setID(Long ID) {
        this.ID = ID;
    }
        public void setNombre(String nombre) {
            this.Nombre = nombre;
        }

        //Lectores de atributos de Categoria (getters)
    public Long getID() {
        return this.ID;
    }
        public String getNombre() {
            return this.Nombre;
        }

    //Métodos de Categoria
}

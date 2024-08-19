package APIServlet.Session.Lecciones.Models;

public class Usuario {
        //Atributos de Usuario
    private Long ID;
    private String NombreUsuario;
    private String Contraseña;
    private String Correo;

        //Constructores de Usuario
    public Usuario() {
    }

        //Asignadores de atributos de Usuario (setters)
    public void setID(Long ID) {
        this.ID = ID;
    }
        public void setNombreUsuario(String nombreUsuario) {
            this.NombreUsuario = nombreUsuario;
        }
            public void setContraseña(String contraseña) {
                this.Contraseña = contraseña;
            }
                public void setCorreo(String correo) {
                    this.Correo = correo;
                }

        //Lectores de atributos de Usuario (getters)
    public Long getID() {
        return this.ID;
    }
        public String getNombreUsuario() {
            return this.NombreUsuario;
        }
            public String getContraseña() {
                return this.Contraseña;
            }
                public String getCorreo() {
                    return this.Correo;
                }

    //Métodos de Usuario
}

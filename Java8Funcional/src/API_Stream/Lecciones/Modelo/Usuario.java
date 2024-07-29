package API_Stream.Lecciones.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
        //Atributos de Usuario
    private String Nombre;
    private String Apellido;
    private Integer ID;
    private static int ÚltimoID;
    private List<Factura> Facturas;

        //Constructores de Usuario
    public Usuario(String nombre, String apellido) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.ID = ++ÚltimoID;
        this.Facturas = new ArrayList<>();
    }

        //Asignadores de atributos de Usuario (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
        public void setApellido(String apellido) {
            this.Apellido = apellido;
        }
            public void setID(Integer ID) { this.ID = ID; }
                public void addFactura(Factura factura) {
                    this.Facturas.add(factura);
                    factura.setUsuarioFactura(this);
                }

        //Lectores de atributos de Usuario (getter)
    public String getNombre() {
        return this.Nombre;
    }
        public String getApellido() {
            return this.Apellido;
        }
            public Integer getID() {
                return this.ID;
            }
                public List<Factura> getFacturas() {
                    return this.Facturas;
                }

        //Métodos de Usuario
    @Override
    public String toString() {
        return this.Nombre + " " + this.Apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(Nombre, usuario.Nombre) && Objects.equals(Apellido, usuario.Apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Apellido);
    }
}

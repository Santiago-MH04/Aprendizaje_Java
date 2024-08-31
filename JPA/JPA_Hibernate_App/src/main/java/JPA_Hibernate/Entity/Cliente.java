package JPA_Hibernate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
        //Atributos de Cliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para denotar que es un atributo autoincremental
    private Long id;
    private String nombre;
    private String apellido;
    @Column(name = "forma_pago")    //Para cuando las columnas y los atributos no llevan el mismo nombre
    private String formaPago;

        //Constructores de Cliente
    public Cliente() {} //El constructor vacío debe ir sí o sí
    public Cliente(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Cliente(String nombre, String apellido, String formaPago) {
        this(nombre, apellido);
        this.formaPago = formaPago;
    }

        //Asignadores de atributos de Cliente (setters)
    public void setId(Long id) {
        this.id = id;
    }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
            public void setApellido(String apellido) {
                this.apellido = apellido;
            }
                public void setFormaPago(String formaPago) {
                    this.formaPago = formaPago;
                }

        //Lectores de atributos de Cliente (getters)
    public Long getId() {
        return this.id;
    }
        public String getNombre() {
            return this.nombre;
        }
            public String getApellido() {
                return this.apellido;
            }
                public String getFormaPago() {
                    return this.formaPago;
                }

        //Métodos de Cliente

    @Override
    public String toString() {
        return "id: " + this.id +
                ". Nombre: " + this.nombre +
                ". Apellido: " + this.apellido +
                ". Forma de pago: " + this.formaPago;
    }
}

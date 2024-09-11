package JPA_Hibernate.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    /*@Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column(name = "fecha_ultima_modificacion")
    private LocalDateTime fechaUltimaModificacion;*/
    @Embedded   //Para inyectar estos atributos que estamos usando
    private Auditoria auditoria = new Auditoria();  //Así, los atributos de Auditoria son también atributos de esta clase Entity

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

    /*@PrePersist
    public void prePersist(){
        System.out.println("Iniciando ando algo antes del persist() de " + this.getClass().getSimpleName());
        this.fechaCreacion = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        System.out.println("Iniciando ando algo antes del merge() de " + this.getClass().getSimpleName());
        this.fechaUltimaModificacion = LocalDateTime.now();
    }*/

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
                    /*public void setFechaCreacion(LocalDateTime fechaCreacion) {
                        this.fechaCreacion = fechaCreacion;
                    }
                        public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
                            this.fechaUltimaModificacion = fechaUltimaModificacion;
                        }*/

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
                    /*public LocalDateTime getFechaCreacion() {
                        return this.fechaCreacion;
                    }
                        public LocalDateTime getFechaUltimaModificacion() {
                            return this.fechaUltimaModificacion;
                        }*/

        //Métodos de Cliente
    @Override
    public String toString() {  //Falta gestionar NullPointerException cuando las propiedades sean nulas
        LocalDateTime fechaCreacion = (this.auditoria != null) ? this.auditoria.getFechaCreacion() : null;
        LocalDateTime fechaModificacion = (this.auditoria != null) ? this.auditoria.getFechaUltimaModificacion() : null;

        return "id: " + this.id +
                ". Nombre: " + this.nombre +
                ". Apellido: " + this.apellido +
                ". Forma de pago: " + this.formaPago +
                ". Creado en: " + fechaCreacion +
                ". Modificado en: " + fechaModificacion;
    }
}

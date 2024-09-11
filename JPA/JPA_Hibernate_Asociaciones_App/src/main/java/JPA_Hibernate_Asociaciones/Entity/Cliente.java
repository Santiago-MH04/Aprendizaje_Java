package JPA_Hibernate_Asociaciones.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {  //Luego de cada cambio en nombre de llaves foráneas se recomienda eliminar las tablas manualmente de la base de datos
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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  //Un Cliente, varias Direcciones -- Se actualizan en la llave foránea todos los posibles cambios, y se elimina la llave foránea cuando se elimina la fila
    /*@JoinColumn(name = "cliente_id")*/    //Si dejamos que maneje las foreign key automáticamente, crea una tabla intermedia
    @JoinTable(name = "tbl_clientes_direcciones",   //Para personalizar nuestra propia tabla de enlace
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "direccion_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"direccion_id"}))    //Como son muchas Direcciones por Cliente, el direccion_id debe ser unico en la tabla
    private List<Direccion> direcciones;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)  //Un Cliente, varias Facturas -- Se actualizan en la llave foránea todos los posibles cambios, y se elimina la llave foránea cuando se elimina la fila
    private List<Factura> facturas; //Es obligatorio decirle qué clase Entity va a la otra, y lleva la unicidad de la relación. Debe llamarse igual que el atributo en el otro sentido de la bidireccionalidad
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)   //Un Cliente, una suscripción  -- Se actualizan en la llave foránea todos los posibles cambios, y se elimina la llave foránea cuando se elimina la fila
    /*@JoinColumn(name = "cliente_detalle_id")*/
    private ClienteDetalle detalle;


        //Constructores de Cliente
    public Cliente() {  //El constructor vacío debe ir sí o sí
        this.direcciones = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }
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
                            public void setAuditoria(Auditoria auditoria) {
                                this.auditoria = auditoria;
                            }
                                public void setDirecciones(List<Direccion> direcciones) {
                                    this.direcciones = direcciones;
                                }
                                    public void setFacturas(List<Factura> facturas) {
                                        this.facturas = facturas;
                                    }
                                        public void setClienteDetalle(ClienteDetalle detalle) {
                                            this.detalle = detalle;
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
                    /*public LocalDateTime getFechaCreacion() {
                        return this.fechaCreacion;
                    }
                        public LocalDateTime getFechaUltimaModificacion() {
                            return this.fechaUltimaModificacion;
                        }*/
                            public Auditoria getAuditoria() {
                                return this.auditoria;
                            }
                                public List<Direccion> getDirecciones() {
                                    return this.direcciones;
                                }
                                    public List<Factura> getFacturas() {
                                        return this.facturas;
                                    }
                                        public ClienteDetalle getDetalle() {
                                            return this.detalle;
                                        }

        //Métodos de Cliente
    public Cliente addFactura(Factura factura) {    //Para optimizar la invocación de resultados
        this.facturas.add(factura);
        factura.setCliente(this);
        return this;
    }

    public Cliente removeFactura(Factura factura) {
        this.facturas.remove(factura);
        factura.setCliente(null);
        return this;
    }

    public void addClienteDetalle(ClienteDetalle detalle) {
        this.setClienteDetalle(detalle);
        detalle.setCliente(this);
    }
    public void removeClienteDetalle(ClienteDetalle detalle) {
        detalle.setCliente(null);
        this.setClienteDetalle(null);
    }

    @Override
    public String toString() {  //Falta gestionar NullPointerException cuando las propiedades sean nulas
        LocalDateTime fechaCreacion = (this.auditoria != null) ? this.auditoria.getFechaCreacion() : null;
        LocalDateTime fechaModificacion = (this.auditoria != null) ? this.auditoria.getFechaUltimaModificacion() : null;

        return "id: " + this.id +
                ". Nombre: " + this.nombre +
                ". Apellido: " + this.apellido +
                ". Forma de pago: " + this.formaPago +
                ". Creado en: " + fechaCreacion +
                ". Modificado en: " + fechaModificacion +
                ". Direcciones: " + this.direcciones +
                ". Facturas: " + this.facturas +
                ". Detalle: {" + this.detalle + '}';
    }
}

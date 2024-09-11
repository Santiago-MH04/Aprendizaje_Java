package JPA_Hibernate_Asociaciones.Entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "facturas")
public class Factura {  //Luego de cada cambio en nombre de llaves foráneas se recomienda eliminar las tablas manualmente de la base de datos
        //Atributos de Factura
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que cree ids autoincrementales
    private Long id;
    private String descripcion;
    private Long total;
    @ManyToOne  //Muchas facturas para un cliente -- Al no tener más anotaciones, se la supone dueña de la relación
    @JoinColumn(name = "id_cliente")   //Para que el nombre de la llave foránea no se cree por defecto (nombreAtributo_columnaReferenciada)
    private Cliente cliente;

        //Constructores de Factura
    public Factura() {    }
    public Factura(String descripcion, Long total) {
        this();
        this.descripcion = descripcion;
        this.total = total;
    }

        //Asignadores de atributos de Factura (setters)
    public void setId(Long id) {
        this.id = id;
    }
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
            public void setTotal(Long total) {
                this.total = total;
            }
                public void setCliente(Cliente cliente) {
                    this.cliente = cliente;
                }

        //Lectores de atributos de Factura (getters)
    public Long getId() {
        return this.id;
    }
        public String getDescripcion() {
            return this.descripcion;
        }
            public Long getTotal() {
                return this.total;
            }
                public Cliente getCliente() {
                    return this.cliente;
                }

        //Métodos de Factura
    @Override
    public String toString() {
        return "Factura ----> " + this.descripcion + '\n' +
                "id factura: " + this.id +
                ". Cliente: " + this.cliente.getNombre() + " " + this.cliente.getApellido() +   //Para evitar llamados cíclicos infinitos. Aunque, probemos
                ". Forma de pago: " + this.cliente.getFormaPago() +
                ". Total: $" + this.total + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(this.id, factura.id) && Objects.equals(this.descripcion, factura.descripcion) && Objects.equals(this.total, factura.total);
    }
}

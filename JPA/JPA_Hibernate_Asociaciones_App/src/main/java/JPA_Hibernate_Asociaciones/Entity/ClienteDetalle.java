package JPA_Hibernate_Asociaciones.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes_detalles")
public class ClienteDetalle {   //La clase dueña de una relación es aquella con una columna con el nombre de la clase enlazada
        //Atributos de ClienteDetalle
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean prime;
    @Column(name = "puntos_acumulados")
    private Long puntosAcumulados;
    @OneToOne/*(cascade = CascadeType.ALL)*/    //Un Cliente, una suscripción  -- Se actualizan en la llave foránea todos los posibles cambios, y se elimina la llave foránea cuando se elimina la fila
    @JoinColumn(name = "cliente_id")    //Así, ClienteDetalle se va a convertir en la dueña de la relación
    private Cliente cliente;

        //Constructores de ClienteDetalle
    public ClienteDetalle() {    }
    public ClienteDetalle(boolean prime, Long puntosAcumulados) {
        this();
        this.prime = prime;
        this.puntosAcumulados = puntosAcumulados;
    }

        //Asignadores de atributos de ClienteDetalle (setters)
    public void setId(Long id) {
        this.id = id;
    }
        public void setPrime(boolean prime) {
            this.prime = prime;
        }
            public void setPuntosAcumulados(Long puntosAcumulados) {
                this.puntosAcumulados = puntosAcumulados;
            }
                public void setCliente(Cliente cliente) {
                    this.cliente = cliente;
                }

        //Lectores de atributos de ClienteDetalle (getters)
    public Long getId() {
        return this.id;
    }
        public boolean isPrime() {
            return this.prime;
        }
            public Long getPuntosAcumulados() {
                return this.puntosAcumulados;
            }
                public Cliente getCliente() {
                    return this.cliente;
                }

        //Métodos de ClienteDetalle

    @Override
    public String toString() {
        String estaSuscrito = prime ? " prime" : "no suscrito";
        return "Detalles adicionales: " +
                "ID Suscripción: " + this.id +
                ". Suscripción: " + estaSuscrito +
                ". Puntos: " + this.puntosAcumulados /*+
                ". Cliente" + this.cliente.getNombre() + " " + this.cliente.getApellido()*/; //Así para evitar bucles cíclicos infinitos
    }
}

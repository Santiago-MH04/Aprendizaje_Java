package JPA_Hibernate_Asociaciones.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion {
        //Atributos de Direccion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private int numero;

        //Constructores de Direccion
    public Direccion() {    }
    public Direccion(String calle, int numero) {    //El id no se pasa por argumento, por ser autoincremental
        this();
        this.id = id;
        this.calle = calle;
        this.numero = numero;
    }

        //Asignadores de atributos de Direccion (setters)
    public void setId(Long id) {
        this.id = id;
    }
        public void setCalle(String calle) {
            this.calle = calle;
        }
            public void setNumero(int numero) {
                this.numero = numero;
            }

        //Lectores de atributos de Direccion (getters)
    public Long getId() {
        return this.id;
    }
        public String getCalle() {
            return this.calle;
        }
            public int getNumero() {
                return this.numero;
            }

        //Métodos de Direccion


    @Override
    public String toString() {
        return "Dirección: " +
                "idDirección: " + this.id + ". " +
                this.numero +
                " calle de " + this.calle;
    }
}

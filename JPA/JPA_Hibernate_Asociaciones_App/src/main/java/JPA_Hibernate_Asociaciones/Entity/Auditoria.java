package JPA_Hibernate_Asociaciones.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Embeddable //Para que pueda hacer parte de todas las clases donde lo estemos embebiendo. Es decir, se puede utilizar en otra clase Entity
public class Auditoria {
        //Atributos de Auditoria
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column(name = "fecha_ultima_modificacion")
    private LocalDateTime fechaUltimaModificacion;

        //Constructores de Auditoria
    public Auditoria() {    }

        //Asignadores de atributos de Auditoria (setters)
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
        public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
            this.fechaUltimaModificacion = fechaUltimaModificacion;
        }

        //Lectores de atributos de Auditoria (getters)
    public LocalDateTime getFechaCreacion() {
            return this.fechaCreacion;
        }
        public LocalDateTime getFechaUltimaModificacion() {
        return this.fechaUltimaModificacion;
    }

        //Métodos de Auditoria
    @PrePersist
    public void prePersist(){
        System.out.println("Iniciando ando algo antes del persist() de " + this.getClass().getSimpleName());
        this.fechaCreacion = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        System.out.println("Iniciando ando algo antes del merge() de " + this.getClass().getSimpleName());
        this.fechaUltimaModificacion = LocalDateTime.now();
    }
}

package JPA_Hibernate_Asociaciones.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "alumnos")
public class Alumno {
        //Atributos de Alumno
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})  //La clase Entity principal (dueña de la relación) es la que maneja la cascada -- No va el orphanRemoval, al ser muchos a muchos, se jode la cosa si alguien elimina un curso
    @JoinTable(name = "tbl_alumnos_cursos",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"alumno_id", "curso_id"}))
    private List<Curso> cursos;

        //Constructores de Alumno
    public Alumno() {
        this.cursos = new ArrayList<>();
    }
    public Alumno(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

        //Asignadores de atributos de Alumno (setters)
    public void setId(Long id) {
        this.id = id;
    }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
            public void setApellido(String apellido) {
                this.apellido = apellido;
            }
                public void setCursos(List<Curso> cursos) {
                    this.cursos = cursos;
                }

        //Lectores de atributos de Alumno (getters)
    public Long getId() {
        return this.id;
    }
        public String getNombre() {
            return this.nombre;
        }
            public String getApellido() {
                return this.apellido;
            }
                public List<Curso> getCursos() {
                    return this.cursos;
                }

        //Métodos de Alumno
    public Alumno addCurso(Curso curso){
        this.cursos.add(curso);
        curso.getAlumnos().add(this);
        return this;
    }

    public void removeCurso(Curso curso){
        this.cursos.remove(curso);
        curso.getAlumnos().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(this.id, alumno.id);
    }

    @Override
    public String toString() {
        return "Alumno -> {" +
                "id: " + this.id +
                ". Nombre: " + this.nombre +
                ". Apellido: " + this.apellido +
                ". Cursos: " + this.cursos +
                '}';
    }
}

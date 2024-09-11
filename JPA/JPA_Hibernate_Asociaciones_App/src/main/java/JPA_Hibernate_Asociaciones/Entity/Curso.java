package JPA_Hibernate_Asociaciones.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cursos")
public class Curso {
        //Atributos de Curso
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String docente;
    @ManyToMany(mappedBy = "cursos")
    private List<Alumno> alumnos;

        //Constructores de Curso
    public Curso() {
        this.alumnos = new ArrayList<>();
    }
    public Curso(String titulo, String docente) {
        this();
        this.titulo = titulo;
        this.docente = docente;
    }

        //Asignadores de atributos de Curso (setters)
    public void setId(Long id) {
        this.id = id;
    }
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
            public void setDocente(String docente) {
                this.docente = docente;
            }
                public void setAlumnos(List<Alumno> alumnos) {
                    this.alumnos = alumnos;
                }

        //Lectores de atributos de Curso (getters)v
    public Long getId() {
        return this.id;
    }
        public String getTitulo() {
            return this.titulo;
        }
            public String getDocente() {
                return this.docente;
            }
                public List<Alumno> getAlumnos() {
                    return this.alumnos;
                }

        //Métodos de Curso
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(this.id, curso.id);
    }

    @Override
    public String toString() {
        return "Curso -> " +
                "id: " + this.id +
                ". Nombre: " + this.titulo +
                ". Docente: " + this.docente + "\n";    //No se incluye los estudiantes del curso, por no caer en el bucle infinito
    }
}

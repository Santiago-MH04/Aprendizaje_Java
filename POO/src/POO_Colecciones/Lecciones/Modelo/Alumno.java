package POO_Colecciones.Lecciones.Modelo;

import java.util.Objects;

public class Alumno implements Comparable<Alumno>{
        //Atributos de Alumno
    private String Nombre;
    private Integer Nota;

        //Constructores de Alumno
    public Alumno() {
    }
    public Alumno(String nombre, Integer nota) {
        this.Nombre = nombre;
        this.Nota = nota;
    }

        //Asignadores de atributos de Alumno (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
        public void setNota(Integer nota) {
            this.Nota = nota;
        }

        //Lectores de atributos de Alumno (getter)
    public String getNombre() {
        return this.Nombre;
    }
        public Integer getNota() {
            return this.Nota;
        }

        //Métodos de Alumno
    @Override
    public String toString() {
        return this.Nombre +
                ". Nota: " + this.Nota;
    }
    @Override
    public int compareTo(Alumno a) {
        if(this.Nombre == null){
            return 0;
        }
        return this.getNombre().compareTo(a.getNombre());
                /*if(this.getNota() == a.getNota()) {
                    return 0;
                } if(this.getNota() > a.getNota()) {
                    return 1;
                } else {
                    return -1;
                }*/
                    /*if(this.getNota() == null){
                        return 0;
                    }
                    return this.getNota().compareTo(a.getNota());*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(this.Nombre, alumno.Nombre) && Objects.equals(this.Nota, alumno.Nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Nota);
    }
}

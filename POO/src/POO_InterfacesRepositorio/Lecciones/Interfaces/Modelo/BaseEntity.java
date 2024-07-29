package POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo;

import java.util.Objects;

public class BaseEntity {
        //Atributos de BaseEntity
    protected Integer ID;
    private static int ÚltimoID;

        //Constructores de BaseEntity
    public BaseEntity() {
        this.ID = ++ÚltimoID;
    }

        //Asignadores de atributos de BaseEntity (setter)
    public void setID(Integer id) {
        this.ID = id;
    }

        //Lectores de atributos de BaseEntity (getter)
    public Integer getID() {
        return this.ID;
    }

        //Métodos de BaseEntity
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity base = (BaseEntity) o;
        //return this.ID != null && this.ID.equals(cliente.getID());
        return Objects.equals(ID, base.ID);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}

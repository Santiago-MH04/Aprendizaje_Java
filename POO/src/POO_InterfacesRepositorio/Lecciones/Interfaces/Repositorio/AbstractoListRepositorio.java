package POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio;

import POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo.BaseEntity;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Excepciones.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractoListRepositorio<T extends BaseEntity> implements RepositorioPleno<T>{
        //Atributos de AbstractoListRepositorio<T>
    protected List<T> DataSource;

        //Constructores de AbstractoListRepositorio<T>
    public AbstractoListRepositorio() {
        this.DataSource = new ArrayList<>();
    }

    //Asignadores de atributos de AbstractoListRepositorio<T> (setter)
    //Lectores de atributos de AbstractoListRepositorio<T> (getter)
        //Métodos de AbstractoListRepositorio<T>
    @Override
    public int Total() {
        return this.DataSource.size();
    }

    //Implementación de CrudRepositorio<T>
    @Override
    public List<T> Listar() {
        return this.DataSource;
    }

    @Override
    public T porID(Integer id) throws LecturaAccesoDatoException{
        if (id == null || id <= 0){
            throw new LecturaAccesoDatoException("ID inválido. Debe ser mayor que 0");
        }
        T Resultado = null;
        for(T cli : this.DataSource){
            if(cli.getID() != null && cli.getID().equals(id)){
                Resultado = cli;
                break;
            }
        }
        if(Resultado == null){
            throw new LecturaAccesoDatoException("No existe el registro con ID: " + id);
        }
        return Resultado;
    }

    @Override
    public void Crear(T t) throws EscrituraAccesoDatoException{
        if(t == null){
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }
        if(this.DataSource.contains(t)){
            throw new RegistroDuplicadoAccesoDatoException("Error: el objeto con " + t.getID() +
                    " ya existe en el repositorio.");
        }
        this.DataSource.add(t);
    }
    @Override
    public void Eliminar(Integer id) throws LecturaAccesoDatoException{
        //Cliente c = this.porID(id);
        //this.DataSource.remove(c);
        this.DataSource.remove(this.porID(id));
    }
    //Implementación de OrdenableRepositorio<T>
    //Implementación de PaginableRepositorio<T>
    @Override
    public List<T> Listar(int desde, int hasta) {
        return this.DataSource.subList(desde, hasta);
    }
}

package POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio;

public interface RepositorioPleno<T> extends OrdenableRepositorio<T>,
        PaginableRepositorio<T>,
        CrudRepositorio<T>,
        ContableRepositorio{
}

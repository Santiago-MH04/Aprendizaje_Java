package POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio;

import java.util.List;

public interface PaginableRepositorio<T> {
        //Métodos de PaginableRepositorio
    List<T> Listar(int desde, int hasta);
}

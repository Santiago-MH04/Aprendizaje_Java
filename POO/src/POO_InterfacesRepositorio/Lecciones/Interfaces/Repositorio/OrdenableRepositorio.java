package POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio;

import java.util.List;

public interface OrdenableRepositorio<T> {
        //Métodos de OrdenableRepositorio
    List<T> Listar(String atributo, Dirección dir);
}

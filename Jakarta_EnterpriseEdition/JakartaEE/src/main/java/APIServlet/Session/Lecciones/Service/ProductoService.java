package APIServlet.Session.Lecciones.Service;

import APIServlet.Session.Lecciones.Models.Categoria;
import APIServlet.Session.Lecciones.Models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
        //Métodos de ProductoService
    List<Producto> Listar();
    List<Categoria> ListarCategoria();
    Optional<Producto> PorID(Long ID);
    Optional<Categoria> PorIDCategoria(Long ID);
    void Guardar(Producto producto);
    void Eliminar (Long ID);
    Optional<Producto> BuscarProducto(String NombreProducto);
}

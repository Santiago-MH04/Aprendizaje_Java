package APIServlet.Headers.Service;

import APIServlet.Headers.Models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
        //Métodos de ProductoService
    List<Producto> Listar();
    Optional<Producto> BuscarProducto(String NombreProducto);
}

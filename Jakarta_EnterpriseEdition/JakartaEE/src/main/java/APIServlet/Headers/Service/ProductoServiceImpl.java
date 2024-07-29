package APIServlet.Headers.Service;

import APIServlet.Headers.Models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{
    //Atributos de ProductoServiceImpl
    //Constructores de ProductoServiceImpl
    //Asignadores de atributos de ProductoServiceImpl (setter)
    //Lectores de atributos de ProductoServiceImpl (getter)
        //Métodos de ProductoServiceImpl
    @Override
    public List<Producto> Listar() {
        return Arrays.asList(
                new Producto(1L, "Ordenador portátil", "Informática", 250000),
                new Producto(2L, "Mesa de escritorio", "Oficina", 10000),
                new Producto(3L, "Teclado mecánico", "Informática", 125000)
        );
    }

    @Override
    public Optional<Producto> BuscarProducto(String NombreProducto) {
        return this.Listar().stream()
                .filter(p -> {
                    if(NombreProducto == null || NombreProducto.isBlank()){
                        return false;
                    }
                    return p.getNombre().toLowerCase().contains(NombreProducto.toLowerCase());
                }).findFirst();
    }
}

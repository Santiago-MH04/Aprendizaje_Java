package APIServlet.Session.Lecciones.Service;

import APIServlet.Session.Lecciones.Models.Categoria;
import APIServlet.Session.Lecciones.Models.Producto;
import jakarta.enterprise.inject.Alternative;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.EMPTY_LIST;

/*@Alternative*/    //Así, el Service que se inyecta por defecto es el que no tenga esta anotación, es más simple así
                    //No hay que anotarlo con ApplicationScoped, dado que el beans.xml registra todo.
                    //La anotación @Alternative se reemplaza con el calificador @ProductoServicePrincipal
public class ProductoServiceImpl implements ProductoService {
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
    public List<Categoria> ListarCategoria() {
        return Collections.EMPTY_LIST;  //Así nos evitamos cualquier problemo, y ya todo quedó solucionado, molto bello
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
    @Override
    public Optional<Producto> PorID(Long ID) {
        return this.Listar().stream()
                .filter(p -> p.getID().equals(ID))
                .findAny();
    }
    @Override
    public Optional<Categoria> PorIDCategoria(Long categoriaID) {
        return this.ListarCategoria().stream()
                .filter(c -> c.getID().equals(categoriaID))
                .findAny();
    }

    @Override
    public void Guardar(Producto producto) {
        if(this.PorID(producto.getID()).isPresent()){
            Producto p = this.PorID(producto.getID()).get(); //El ID y la fecha de registro no se modifican
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());  //No se ingresan SKU ni categoría por no ser atributos de Producto al momento de construir esta clase, esto es meramente ilustrativo
            System.out.println("Producto " + p.getNombre() + " actualizado con éxito");
        } else {
            this.Listar().add(producto);
            System.out.println("Producto " + producto.getNombre() + " ingresado con éxito");
        }
    }

    @Override
    public void Eliminar(Long ID) {
        this.PorID(ID).ifPresent(p -> {
            this.Listar().remove(p);
            System.out.println("Producto " + p.getNombre() + " eliminado con éxito");
        });
    }
}

package POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Lista;

import POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo.Producto;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.*;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractoListRepositorio<Producto> {
    //Atributos de ProductoListRepositorio
    //Constructores de ProductoListRepositorio
    //Asignadores de atributos de ProductoListRepositorio (setter)
    //Lectores de atributos de ProductoListRepositorio (getter)

        //Métodos de ProductoListRepositorio
    public static int Ordenar (String atributo, Producto alpha, Producto beta){
        int Resultadinho = 0;
        atributo = atributo.toLowerCase();

        switch (atributo){
            case "id" -> Resultadinho = alpha.getID().compareTo(beta.getID());
            case "descripción" -> Resultadinho = alpha.getDescripción().compareTo(beta.getDescripción());
            case "precio" -> Resultadinho = alpha.getPrecio().compareTo(beta.getPrecio());
        }
        return Resultadinho;
    }
    @Override
    public void Editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porID(producto.getID());
        p.setDescripción(producto.getDescripción());
        p.setPrecio(producto.getPrecio());
    }
    @Override
    public List<Producto> Listar(String campo, Dirección dir) {
        List<Producto> ListaOrdenada = new ArrayList<>(this.DataSource);
        ListaOrdenada.sort((Producto a, Producto b) -> {
            int Resultado = 0;
            if (dir == Dirección.ASC){
                Resultado = Ordenar(campo, a,b);
            } else if (dir == Dirección.DESC) {
                Resultado = Ordenar(campo, b,a);
            }
            return Resultado;
        });
        return ListaOrdenada;
    }
}

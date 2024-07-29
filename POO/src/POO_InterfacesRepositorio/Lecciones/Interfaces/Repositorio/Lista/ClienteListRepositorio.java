package POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Lista;

import POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo.*;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.AbstractoListRepositorio;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Dirección;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractoListRepositorio<Cliente> {
    //Atributos de ClienteListRepositorio<Cliente>
    //Constructores de ClienteListRepositorio<Cliente>
    //Asignadores de atributos de ClienteListRepositorio<Cliente> (setter)
    //Lectores de atributos de ClienteListRepositorio<Cliente> (getter)

        //Métodos de ClienteListRepositorio<Cliente>
    public static int Ordenar (String atributo, Cliente alpha, Cliente beta){
        int Resultadinho = 0;
        atributo = atributo.toLowerCase();

        switch (atributo){
            case "id" -> Resultadinho = alpha.getID().compareTo(beta.getID());
            case "nombre" -> Resultadinho = alpha.getNombre().compareTo(beta.getNombre());
            case "apellido" -> Resultadinho = alpha.getApellido().compareTo(beta.getApellido());
        }
        return Resultadinho;
    }
        //Implementación de CrudRepositorio<Cliente>
    @Override
    public void Editar(Cliente cliente) throws LecturaAccesoDatoException {
        Cliente c = this.porID(cliente.getID());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }
        //Implementación de OrdenableRepositorio<Cliente>
    @Override
    public List<Cliente> Listar(String campo, Dirección dir) {
        List<Cliente> ListaOrdenada = new ArrayList<>(this.DataSource);
        ListaOrdenada.sort((Cliente a, Cliente b) -> {
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

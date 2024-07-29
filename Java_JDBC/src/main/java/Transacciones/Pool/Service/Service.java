package Transacciones.Pool.Service;

import Transacciones.Pool.Models.Categoría;
import Transacciones.Pool.Models.Producto;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    //Atributos de Service
    //Constructores de Service
    //Asignadores de atributos de Service (setter)
    //Lectores de atributos de Service (getter)

        //Métodos de Service
    List<Producto> Listar() throws SQLException;
        List<Categoría> ListarCategorías() throws SQLException;
    Producto PorID(Long id) throws SQLException;
        Categoría CategoríaPorID(Long id) throws SQLException;
    Producto Guardar(Producto producto) throws SQLException;
        Categoría GuardarCategoría(Categoría categoría) throws SQLException;

    void Eliminar(Long id) throws SQLException;
        void EliminarCategoría(Long id) throws SQLException;

    void GuardarProductoConCategoria(Producto producto, Categoría categoría) throws SQLException;
}

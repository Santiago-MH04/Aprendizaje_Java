package APIServlet.Session.Lecciones.Service;

import APIServlet.Session.Lecciones.Configs.Calificadores.ProductoServicePrincipal;
import APIServlet.Session.Lecciones.Configs.Estereotipos.Servicio;
import APIServlet.Session.Lecciones.Interceptores.Logging;
import APIServlet.Session.Lecciones.Models.Categoria;
import APIServlet.Session.Lecciones.Models.Producto;
import APIServlet.Session.Lecciones.Repositorios.CategoriaRepositorioJDBCImpl;
import APIServlet.Session.Lecciones.Repositorios.ProductoRepositorioJDBCImpl;
import APIServlet.Session.Lecciones.Repositorios.Repositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/*@Logging*/    //Aquí, aplica para todos los métodos de la clase, y se ejecuta la instrucción del interceptor mientras se envuelve la ejecución de cada método, cuando se lo invoque
/*@ApplicationScoped*/   //Lo que es único por cada request es una conexión
@Servicio
@ProductoServicePrincipal/*@Named("defecto")*/  //Así, nos ahorramos inyectar el @Named o el @Alternative
public class ProductoServiceJDBCImpl implements ProductoService {
        //Atributos de ProductoServiceJDBCImpl
    @Inject
    private Repositorio<Producto> RepoProductoJDBC;
    @Inject
    private Repositorio<Categoria> RepoCategoriaJDBC;

        //Constructores de ProductoServiceJDBCImpl
    public ProductoServiceJDBCImpl() {
    }
    /*public ProductoServiceJDBCImpl(Connection connection) {
        this.RepoProductoJDBC = new ProductoRepositorioJDBCImpl(connection);
        this.RepoCategoriaJDBC = new CategoriaRepositorioJDBCImpl(connection);
    } */  //Como el contenedor contiene la instancia de la conexión, este método
          // se vuelve redundante, y puede generar conflictos

    //Asignadores de atributos de ProductoServiceJDBCImpl (setters)
    //Lectores de atributos de ProductoServiceJDBCImpl (getters)
        //Métodos de ProductoServiceJDBCImpl
    @Override
    /*@Logging*/    //Este método, propio de un componente CDI, se va a interceptar (recordemos que el interceptor aplica en clases y métodos)
    public List<Producto> Listar() {
        try {
            return this.RepoProductoJDBC.Listar();
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Categoria> ListarCategorias() {
        try {
            return this.RepoCategoriaJDBC.Listar();
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    /*@Logging*/    //Este método, propio de un componente CDI, se va a interceptar (recordemos que el interceptor aplica en clases y métodos)
    public Optional<Producto> PorID(Long ID) {
        try {
            return Optional.ofNullable(this.RepoProductoJDBC.PorID(ID));
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Categoria> PorIDCategoria(Long ID) {
        try {
            return Optional.ofNullable(this.RepoCategoriaJDBC.PorID(ID));
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void Guardar(Producto producto) {
        try {
            this.RepoProductoJDBC.Guardar(producto);
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void Eliminar(Long ID) {
        try {
            this.RepoProductoJDBC.Eliminar(ID);
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Producto> BuscarProducto(String NombreProducto) {
        return Optional.empty();
    }
}

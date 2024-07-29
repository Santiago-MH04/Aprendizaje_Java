package APIServlet.Session.Lecciones.Repositorios;

import APIServlet.Session.Lecciones.Configs.Calificadores.MisLogs;
import APIServlet.Session.Lecciones.Configs.Calificadores.MySQLConn;
import APIServlet.Session.Lecciones.Configs.Estereotipos.Repository;
import APIServlet.Session.Lecciones.Models.Categoria;
import APIServlet.Session.Lecciones.Models.Producto;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/*@ApplicationScoped*/  //Lo que es único por cada request es una conexión
@Repository //El @PostConstruct y el @PreDestroy son importantes para saber cuándo ver esto en los logs
public class ProductoRepositorioJDBCImpl implements Repositorio<Producto>{
        //Atributos de ProductoRepositorioJDBCImpl
    @Inject
    @MySQLConn /*@Named("conn")*/   //Uso de calificadores
    private Connection Conn;    //Esta conexión implementa el pool de conexiones
                                //No es necesario manejar el constructor con una conexión, pues el contenedor gestiona la instancia
                                // de la conexión
    @Inject //Usar un modificador transient únicamente en los objetos de contexto SessionScoped o ConversationScoped que implementen la interfaz serializable
    @MisLogs/*@Named("misLogs")*/
    private Logger Log; //Un objeto Logger no se guarda en la sesión (no es serializable)

        //Constructores de ProductoRepositorioJDBCImpl
    public ProductoRepositorioJDBCImpl() {
    }
    /*public ProductoRepositorioJDBCImpl(Connection conn) {
        this.Conn = conn;
    }*/       //Como el contenedor contiene la instancia de la conexión, este método
              // se vuelve redundante, y puede generar conflictos
    @PostConstruct
    public void Iniciar(){
        /*System.out.println("Creando un repositorio de " + this.getClass().getSimpleName() + " conectado a la base de datos");*/
        this.Log.info("Creando un repositorio de " + this.getClass().getSimpleName() + " conectado a la base de datos");
    }
    @PreDestroy
    public void Destruir(){
        /*System.out.println("Destruyendo el repositorio de " + this.getClass().getSimpleName() + " conectado a la base de datos");*/
        this.Log.info("Destruyendo el repositorio de " + this.getClass().getSimpleName() + " conectado a la base de datos");
    }

        //Asignadores de atributos de ProductoRepositorioJDBCImpl (setter)
    public void setConn(Connection conn) {
        this.Conn = conn;
    }

        //Lectores de atributos de ProductoRepositorioJDBCImpl (getter)
    public Connection getConn() {
        return this.Conn;
    }

    //Métodos de ProductoRepositorioJDBCImpl
    private static Producto CrearProducto(ResultSet rs) throws SQLException {
        //Crear objeto de la clase Producto
        Producto p = new Producto();
        Categoria c = new Categoria();
            p.setID(rs.getLong("id"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getInt("precio"));
            p.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
            c.setID(rs.getLong("categoria_id"));
            c.setNombre(rs.getString("categoria"));
            p.setCategoria(c);
            p.setSKU(rs.getString("sku"));
        return p;
    }

    @Override
    public List<Producto> Listar() throws SQLException {
        List<Producto> Productos = new ArrayList<>();
            //Obtener la conexión a la base de datos
        try (Statement Stmt = Conn.createStatement();
             ResultSet RS = Stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     "inner join categorias as c ON (p.categoria_id = c.id) order by p.id ASC")    //Hay que hacerlo, para evitar ambigüedades
        ){
                //Recorrer el cursor
            while (RS.next()) {
                Producto P = CrearProducto(RS);
                    //Añadir producto a la lista
                Productos.add(P);
            }
        }
        return Productos;
    }

    @Override
    public Producto PorID(Long ID) throws SQLException {
        Producto Productinho = null;
            //Obtener la conexión a la base de datos
        try (PreparedStatement PS = this.Conn.prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p" +
                " inner join categorias as c ON (p.categoria_id = c.id)" +
                " WHERE p.id = ? ")) {
            PS.setLong(1, ID);
                //Recorrer el cursor
            try(ResultSet RS = PS.executeQuery()){
                if(RS.next()){
                    Productinho = CrearProducto(RS);
                }
            }
        }
        return Productinho;
    }
    @Override
    public void Guardar(Producto producto) throws SQLException {
            //Pre-preparar la sentencia
        String SQL;
            //Ver si hay que actualizar o crear un producto en lista
        if (producto.getID() != null && producto.getID() > 0){  //Se actualiza un producto
            SQL = "UPDATE productos SET nombre = ?, precio = ?, sku = ?, categoria_id = ?  WHERE id = ?";
        } else{
            SQL = "INSERT INTO productos (nombre, precio, sku, categoria_id, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        }
            //Realizar la instrucción
        try(PreparedStatement PS = Conn.prepareStatement(SQL)){
            PS.setString(1, producto.getNombre());
            PS.setInt(2, producto.getPrecio());
            PS.setString(3, producto.getSKU());
            PS.setLong(4, producto.getCategoria().getID());
            if (producto.getID() != null && producto.getID() > 0){
                PS.setLong(5, producto.getID());
            } else {
                PS.setDate(5, Date.valueOf(producto.getFechaRegistro()));   //Así se convierte un LocalDate es un Date sql
            }
            PS.executeUpdate();
        }
    }
    @Override
    public void Eliminar(Long ID) throws SQLException {
        String SQL = "DELETE p.* FROM productos as p WHERE p.id = ?";
        try(PreparedStatement PS = Conn.prepareStatement(SQL)){
            PS.setLong(1, ID);
            PS.executeUpdate();
        }
    }
}

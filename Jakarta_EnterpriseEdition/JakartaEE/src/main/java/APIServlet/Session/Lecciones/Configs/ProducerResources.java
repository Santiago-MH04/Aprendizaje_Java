package APIServlet.Session.Lecciones.Configs;

import APIServlet.Session.Lecciones.Configs.Calificadores.MySQLConn;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@ApplicationScoped
//También puede aplicar @Dependent (aunque arroja errores). Así, cuando el bean-discovery-mode esté en annotated, esto va a correr bárbaro
public class ProducerResources {
        //Atributos de ProducerResources
    @Inject //Usar un modificador transient únicamente en los objetos de contexto SessionScoped o ConversationScoped que implementen la interfaz serializable
    private Logger Log; //Un objeto Logger no se guarda en la sesión (no es serializable)
    @Resource(name="jdbc/MySQLDB")   //Así, y no con @Inject, dado que es un recurso de Tomcat
    private DataSource ds;

    //Constructores de ProducerResources
    //Asignadores de atributos de ProducerResources (setters)
    //Lectores de atributos de ProducerResources (getters)
        //Métodos de ProducerResources
    @Produces
    @RequestScoped
    @MySQLConn/*@Named("conn")*/
    private Connection BeanConnection() throws SQLException, NamingException {
        /*Context initContext = new InitialContext();
        Context envContext = (Context)initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/MySQLDB");
        Connection conn = ds.getConnection(); */      //Para ahorrar espacio en la memoria
        return this.ds.getConnection();
    }
    @Produces
    private Logger beanLogger(InjectionPoint injectionPoint){   //Así, se obtiene el nombre de cualquier clase que use este método
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());  //Debe llamarse beanLogger en camelCase. Método cuasirrecursivo
    }
    public void close(@Disposes @MySQLConn Connection connection) throws SQLException {
        connection.close(); //Cierra la conexión de manera automática. Debe llamarse close
        /*System.out.println("Cerrando la conexión a la base de datos MySQL");*/
        this.Log.info("Cerrando la conexión a la base de datos MySQL"); //Una inyección autorreferenciada
    }
}

package APIServlet.Session.Actividades.Actividad7_Cursos.Configs;

import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores.LogsAct;
import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores.MySQLConnAct;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@ApplicationScoped  //También puede ir @Dependent
public class ProducerResourcesAct {
        //Atributos de ProducerResourcesAct
    @Inject
    @LogsAct
    private Logger LogAct;
    @Resource(name="jdbc/MySQLDB")   //Así, y no con @Inject, dado que es un recurso de Tomcat
    private DataSource dsAct;

    //Constructores de ProducerResourcesAct
    //Asignadores de atributos de ProducerResourcesAct (setter)
    //Lectores de atributos de ProducerResourcesAct (getter)
        //Métodos de ProducerResourcesAct
    @Produces
    @RequestScoped
    @MySQLConnAct /*@Named("connAct")*/
    private Connection BeanConnectionAct() throws SQLException {
        /*Context initContext = new InitialContext();*/
        /*Context envContext = (Context)initContext.lookup("java:/comp/env");*/
        /*DataSource dsAct = (DataSource) envContext.lookup("jdbc/MySQLDB");*/
        /*Connection conn = dsAct.getConnection();*/       //Para ahorrar espacio en la memoria
            return this.dsAct.getConnection();
    }
                //Subinciso: asociados con la información a la consola
            @Produces
            @LogsAct
            private Logger beanLoggerAct(InjectionPoint injectionPoint){
                return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
            }

    public void close(@Disposes @MySQLConnAct Connection connection) throws SQLException {
        connection.close();
        this.LogAct.info("Cerrando la conexión a la base de datos de los cursos");
    }
}

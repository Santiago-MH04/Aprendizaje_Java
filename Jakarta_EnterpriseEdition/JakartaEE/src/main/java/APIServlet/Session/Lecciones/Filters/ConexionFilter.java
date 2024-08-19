package APIServlet.Session.Lecciones.Filters;

import APIServlet.Session.Lecciones.BaseDatos.ConexionBaseDatos;
import APIServlet.Session.Lecciones.BaseDatos.ConexionBaseDatosDS;
import APIServlet.Session.Lecciones.Configs.Calificadores.MySQLConn;
import APIServlet.Session.Lecciones.Service.ServiceJDBCException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {
        //Atributos de ConexionFilter
    /*@Inject*/
    /*@MySQLConn*//*@Named("conn")*/
    /*private Connection conn;*/   //Esta conexión implementa el pool de conexiones

    //Constructores de ConexionFilter
    //Asignadores de atributos de ConexionFilter (setters)
    //Lectores de atributos de ConexionFilter (getters)
        //Métodos de ConexionFilter
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            //Conexión con la base de datos (el try-catch lo maneja el interceptor)
        /*try*//*(*//**//*Connection ConnRequest = ConexionBaseDatos.getConnection();*//**//*
            *//**//*Connection ConnRequest = ConexionBaseDatosDS.getConnection();*//**//*
            *//**//*Connection ConnRequest = this.conn*//**//*)*//*{
            Connection ConnRequest = this.conn; //Para usar la anotación @Disposes
                //Manejo de transacciones con autocommit (se maneja con el interceptor)
            if(ConnRequest.getAutoCommit()){
                ConnRequest.setAutoCommit(false);
            }
        */
            try {
                    //Capturar la conexión, para usarla después con los controladores
                /*request.setAttribute("conn", ConnRequest); */      //Esto luego se podrá comentar
                chain.doFilter(request, response);
                    //Cerrar el autocommit (se maneja con el interceptor)
                /*ConnRequest.commit();*/
            } catch (ServiceJDBCException e) {  /*SQLException |*/
                /*ConnRequest.rollback();*/
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage()); //Enviar cualquier posible error
                e.printStackTrace();
            }
        /*} catch (SQLException | NamingException e) {
            e.printStackTrace();
            e.fillInStackTrace();   //Para probar luego
        }*/
    }
}

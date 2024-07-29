package APIServlet.Session.Actividades.Actividad7_Cursos.FiltroDBActividad;

import APIServlet.Session.Actividades.Actividad7_Cursos.ConexiónDBActividad.ConexiónBDActividad;
import APIServlet.Session.Actividades.Actividad7_Cursos.ConexiónDBActividad.ConexiónBD_DSActividad;
import APIServlet.Session.Actividades.Actividad7_Cursos.ServiceActividad.ServiceJDBCActividadException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexiónBDFilter implements Filter {
    //Atributos de ConexiónBDFilter
    //Constructores de ConexiónBDFilter
    //Asignadores de atributos de ConexiónBDFilter (setter)
    //Lectores de atributos de ConexiónBDFilter (getter)
        //Métodos de ConexiónBDFilter
    @Override //¿Cómo carajos se ejecuta automáticamente el interceptor?
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            //Conexión con la base de datos
        /* try (*//*Connection Conn = ConexiónBDActividad.getConnectionBD();*//*
             Connection Conn = ConexiónBD_DSActividad.getConnectionDB()){ */
            //Manejo de transacciones con autocommit
            /* if(Conn.getAutoCommit()){
                Conn.setAutoCommit(false);
            } */
        try {
                //Capturar la conexión, para usarla después con los controladores
            /*servletRequest.setAttribute("connAct", Conn);*/
            //Filtrar
            filterChain.doFilter(servletRequest, servletResponse);
                //Cerrar el autocommit
            /*Conn.commit();*/
        } catch (/*SQLException |*/ ServiceJDBCActividadException e) {  // /*SQLException |*/
            /*Conn.rollback();*/
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage()); //Enviar cualquier posible error
            e.printStackTrace();
        }
        /*} catch (SQLException | NamingException e){
            e.printStackTrace();
        }*/
    }
}

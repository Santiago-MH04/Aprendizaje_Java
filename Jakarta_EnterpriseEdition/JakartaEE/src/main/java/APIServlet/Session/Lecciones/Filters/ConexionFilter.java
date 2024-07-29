package APIServlet.Session.Lecciones.Filters;

import APIServlet.Session.Lecciones.Service.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")    //Va a actuar sobre todos los controladores
public class ConexionFilter implements Filter {
        //Atributos de ConexiónFilter
            //Ya los maneja el interceptor
    /*@Inject*/
    /*@MySQLConn*/ /*@Named("conn")*/   //Uso de calificadores
    /*private Connection conn;*/  //Esta conexión implementa el pool de conexiones

    //Constructores de ConexiónFilter
    //Asignadores de atributos de ConexiónFilter (setter)
    //Lectores de atributos de ConexiónFilter (getter)
        //Métodos de ConexiónFilter
    @Override   //Este método se ejecuta automáticamente
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            //Conexión con la base de datos (el try-catch lo maneja el interceptor)
        /*try *//*(*//* *//*Connection ConnRequest = ConexiónBaseDatos.getConnection();*//*
         *//*Connection ConnRequest = ConexionBaseDatosDS.getConnection();*//*
         *//*Connection ConnRequest = this.conn*//* *//*)*//* {*/
        /*Connection ConnRequest = this.conn; //Para usar la anotación @Disposes*/
        //Manejo de transacciones con autocommit (se maneja con el interceptor)
            /*if(ConnRequest.getAutoCommit()){
                ConnRequest.setAutoCommit(false);
            }*/
        try {
                //Capturar la conexión, para usarla después con los controladores
            /*servletRequest.setAttribute("conn", ConnRequest);*/       //Esto luego se podrá comentar
                //Filtrar
            filterChain.doFilter(servletRequest, servletResponse);
                //Cerrar el autocommit (se maneja con el interceptor)
            /*ConnRequest.commit();*/
        } catch (ServiceJDBCException e) { // /*SQLException |*/
            /*ConnRequest.rollback();*/
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage()); //Enviar cualquier posible error
            e.printStackTrace();
        }
        /*} catch (SQLException *//*| NamingException*//* e){
            e.printStackTrace();
        }*/
    }
}

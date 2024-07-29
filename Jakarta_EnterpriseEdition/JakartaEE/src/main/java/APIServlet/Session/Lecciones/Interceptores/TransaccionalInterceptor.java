package APIServlet.Session.Lecciones.Interceptores;

import APIServlet.Session.Lecciones.Configs.Calificadores.*;
import APIServlet.Session.Lecciones.Service.ServiceJDBCException;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.io.Serializable;
import java.sql.Connection;
import java.util.logging.Logger;

@TransaccionalJDBC    //Aquí enlazamos e implementamos
@Interceptor          //¡Cuidadongos! Debe ser en singular
public class TransaccionalInterceptor implements Serializable{
        //Atributos de TransaccionalInterceptor
            //Como es un interceptor de métodos transaccionales,
            // requiere usar una conexión a base de datos, y al log de Tomcat
    @Inject //Usar un modificador transient únicamente en los objetos de contexto SessionScoped o ConversationScoped que implementen la interfaz serializable
    @MisLogs    /*@Named("misLogs")*/
    private Logger Log; //Un objeto Logger no se guarda en la sesión (no es serializable)
    @Inject
    @MySQLConn
    private Connection Conn;    //Aquí vamos a reemplazar lo que hace el filtro. Gestionar excepciones con try-catch

    //Constructores de TransaccionalInterceptor
    //Asignadores de atributos de TransaccionalInterceptor (setter)
    //Lectores de atributos de TransaccionalInterceptor (getter)
        //Métodos de TransaccionalInterceptor
    @AroundInvoke //Se debe usar para indicar que este método es el quid del interceptor
    public Object Transaccional(InvocationContext invocationContext) throws Exception{  //Representa la invocación del método,
                                                                                        // y contiene toda la información del método
                                                                                        // que lo invoca
            //Manejo de transacciones
        if(this.Conn.getAutoCommit()){
            this.Conn.setAutoCommit(false);
        }
        try {
            //Englobando ando
            this.Log.info(" --------  Iniciando transacción en " +
                    "el método " + invocationContext.getMethod().getName() +
                    " de la clase " + invocationContext.getMethod().getDeclaringClass().getSimpleName() +
                    " -------- ");
            Object Resultado = invocationContext.proceed(); //Aquí se recolecta la información del invocador
                //¿Todo salió bien? En caso afirmatorio, cerrar el commit
            this.Conn.commit();
            this.Log.info(" --------  Realizando commit y finalizando transacción en " +
                    "el método " + invocationContext.getMethod().getName() +
                    " de la clase " + invocationContext.getMethod().getDeclaringClass().getSimpleName() +
                    " -------- ");
            return Resultado;
        } catch (ServiceJDBCException e){
            this.Conn.rollback();
            throw e;    //Se relanza la excepción
        }
    }
}

package APIServlet.Session.Actividades.Actividad7_Cursos.Interceptores;

import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores.LogsAct;
import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores.MySQLConnAct;
import APIServlet.Session.Actividades.Actividad7_Cursos.ServiceActividad.ServiceJDBCActividadException;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.sql.Connection;
import java.util.logging.Logger;

@TransaccionalAct
@Interceptor
public class TransaccionalActInterceptor {
    //Atributos de TransaccionalActInterceptor
        //Al ser un interceptor de métodos transaccionales,
        // requiere usar una conexión a la base de datos, y al log de Tomcat
    @Inject
    @LogsAct
    private Logger LogAct;
    @Inject
    @MySQLConnAct
    private Connection ConnAct;

    //Constructores de TransaccionalActInterceptor
    //Asignadores de atributos de TransaccionalActInterceptor (setter)
    //Lectores de atributos de TransaccionalActInterceptor (getter)

        //Métodos de TransaccionalActInterceptor
    @AroundInvoke
    public Object TransaccionalAct(InvocationContext invocationContext) throws Exception {
            //Manejo de transacciones
        if(this.ConnAct.getAutoCommit()){
            this.ConnAct.setAutoCommit(false);
        }
        try{
                //Englobando ando
            this.LogAct.info(" --------  Iniciando transacción en " +
                    "el método " + invocationContext.getMethod().getName() +
                    " de la clase " + invocationContext.getMethod().getDeclaringClass().getSimpleName() +
                    "-------- ");
                Object ResultadoAct = invocationContext.proceed();
                    //¿Todo salió bien? En caso afirmatorio, cerrar el commit
                this.ConnAct.commit();
            this.LogAct.info(" --------  Realizando commit y finalizando transacción en " +
                    "el método " + invocationContext.getMethod().getName() +
                    " de la clase " + invocationContext.getMethod().getDeclaringClass().getSimpleName() +
                    "-------- ");
            return ResultadoAct;
        } catch(ServiceJDBCActividadException e){
            this.ConnAct.rollback();
            throw e;    //Para relanzar la excepción al filtro
        }
    }
}

package APIServlet.Session.Actividades.Actividad7_Cursos.Interceptores;

import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores.LogsAct;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.io.Serializable;
import java.util.logging.Logger;

@LoggingAct
@Interceptor
public class LoggingActInterceptor {
        //Atributos de LoggingActInterceptor
    @Inject
    @LogsAct
    private Logger LogAct;
    //Constructores de LoggingActInterceptor
    //Asignadores de atributos de LoggingActInterceptor (setter)
    //Lectores de atributos de LoggingActInterceptor (getter)
        //Métodos de LoggingActInterceptor
    @AroundInvoke
    public Object LoggingAct(InvocationContext invocationContext) throws Exception {
        this.LogAct.info(" ********  Entrando antes de invocar el método " +
                invocationContext.getMethod().getName() +
                " del componente CDI" +
                invocationContext.getMethod().getDeclaringClass() + " ******** ");
        Object ResultadoAct = invocationContext.proceed();
        this.LogAct.info(" ********  Saliendo luego de invocar el método " +
                invocationContext.getMethod().getName() +
                " del componente CDI" +
                invocationContext.getMethod().getDeclaringClass() + " ******** ");
        return ResultadoAct;
    }
}

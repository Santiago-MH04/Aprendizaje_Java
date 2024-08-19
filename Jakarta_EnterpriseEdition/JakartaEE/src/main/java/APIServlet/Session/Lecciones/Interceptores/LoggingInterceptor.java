package APIServlet.Session.Lecciones.Interceptores;

import APIServlet.Session.Lecciones.Configs.Calificadores.MisLogs;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Logging    //Aquí enlazamos e implementamos
@Interceptor    //¡Cuidadongos! Debe ser en singular
public class LoggingInterceptor {
        //Atributos de LoggingInterceptor
    @Inject //Usar un modificador transient únicamente en los objetos de contexto SessionScoped o ConversationScoped que implementen la interfaz serializable
    @MisLogs/*@Named("misLogs")*/
    private Logger Log; //Un objeto Logger no se guarda en la sesión (no es serializable)

    //Constructores de LoggingInterceptor
    //Asignadores de atributos de LoggingInterceptor (setters)
    //Lectores de atributos de LoggingInterceptor (getters)
        //Métodos de LoggingInterceptor
    @AroundInvoke   //Se debe usar para indicar que este método es el quid del interceptor
    public Object Logging(InvocationContext invocationContext) throws Exception {  //Representa la invocación del método,
                                                                                   // y contiene toda la información del método
                                                                                   // que lo invoca
        this.Log.info("**** Entrando antes de convocar el método " +
                invocationContext.getMethod().getName() +
                " del componente CDI " +
                invocationContext.getMethod().getDeclaringClass() + " ****");
        Object Resultado = invocationContext.proceed();     //Aquí se recolecta la información del invocador
        this.Log.info("**** Saliendo luego de convocar el método " +
                invocationContext.getMethod().getName() +
                " del componente CDI " +
                invocationContext.getMethod().getDeclaringClass() + " ****");
        return Resultado;
    }
}

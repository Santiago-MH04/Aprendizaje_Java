package ExpresionesLambda.Lecciones;

import ExpresionesLambda.Lecciones.Modelo.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {
            //Una expresión lambda es una implementación al vuelo
        Consumer<String> Consumidor = saludo -> {
            System.out.println(saludo);
        };
        Consumidor.accept("Saludos");

        Consumer<String> Consumidor2 = System.out::println;
        Consumidor2.accept("Hola, ¿qué tal?");

        List<String> Nombres = Arrays.asList("Quesozuelos", "Colín Colín", "Elías Floriciento", "Manuelitas torombolitas", "Santiaguito");
        Nombres.forEach(Consumidor2);   //A cada elemento de la lista se le aplica la acción en Consumidor2

            /*LocalDateTime data = LocalDateTime.now();
            //DateTimeFormatter forma = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM yyyy");
            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm'h'");
            String Fecha = forma.format(data);
        System.out.println(Fecha);*/

        Consumer<LocalDate> Fecha = (LocalDate fecha) -> {
            DateTimeFormatter forma = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy");
            String LaFecha = forma.format(fecha);
            System.out.println(LaFecha);
        };
        Fecha.accept(LocalDate.now());

        BiConsumer<String, Integer> BiConsumidor  = (String Nombre, Integer Edad) -> { //Especificar de qué tipo son los argumentos no es necesario, dado que están determinados en el operador diamante
            System.out.println(Nombre + " tiene " + Edad + " años");
        };
        BiConsumidor.accept("Quesozuelos", 5);

        Supplier<Usuario> CrearUsuario = () -> new Usuario();
        Usuario usuario = CrearUsuario.get();

        BiConsumer<Usuario, String> AsignarNombre = Usuario::setNombre;
        AsignarNombre.accept(usuario, "doña Floooor");
        System.out.println("Nombre usuario: " + usuario.getNombre());

        Supplier<String> Proveedor = () -> {
            return "Hola mundo: -> lambda supplier";
        };
        System.out.println(Proveedor.get());    //Este método get() es propio de la interfaz Supplier
    }
}

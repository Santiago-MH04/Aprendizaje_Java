package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.stream.Stream;

public class EjemploStream_OperadorFilter_Single2 {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
                //Uso de los métodos del Optional para "evitar" excepciones
        Usuario usuario = Stream.of("Quesozuelos Pechochuelos" , "Colín Colín", "Elías Floriciento", "Manuelitas torombolitas", "Santiaguito Bonitico", "Manuelitas Feítas")
                .map(Nombre -> new Usuario(Nombre.split(" ")[0], Nombre.split(" ")[1]))
                .peek(System.out::println)  //Elemento inspección, funciona una vez las otras acciones han finalizado y hasta que se terminan
                .filter(u -> u.getID().equals(2))
                .findFirst().orElseGet(() -> new Usuario("Pepito", "Pérez")); //Operador final

        System.out.println(usuario); //Así se obtiene un único objeto
    }
}

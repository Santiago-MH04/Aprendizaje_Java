package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.stream.Stream;

public class EjemploStream_OperadorFilter_AnyMatch {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
        boolean Existe = Stream.of("Quesozuelos Pechochuelos" , "Colín Colín", "Elías Floriciento", "Manuelitas torombolitas", "Santiaguito Bonitico", "Manuelitas Feítas")
                .map(Nombre -> new Usuario(Nombre.split(" ")[0], Nombre.split(" ")[1]))
                .peek(System.out::println)  //Elemento inspección, funciona una vez las otras acciones han finalizado y hasta que se terminan
                .anyMatch(u -> u.getID().equals(7)); //Operador final

        System.out.println((Existe)? "Sí" : "No"); //Así se obtiene un único objeto

    }
}

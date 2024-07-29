package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.stream.Stream;

public class EjemploStream_OperadorFilter_Count {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
        long Cuentas = Stream.of("Quesozuelos Pechochuelos" , "Colín Colín", "Elías Floriciento", "Manuelitas torombolitas", "Santiaguito Bonitico", "Manuelitas Feítas")
                .map(Nombre -> new Usuario(Nombre.split(" ")[0], Nombre.split(" ")[1]))
                .peek(System.out::println)  //Elemento inspección, funciona una vez las otras acciones han finalizado y hasta que se terminan
                .count(); //Operador final

        System.out.println(Cuentas); //Así se obtiene un conteo de los objetos del Stream

    }
}

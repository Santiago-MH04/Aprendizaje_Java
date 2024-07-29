package POO_Colecciones.Actividad;

import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;


public class OperadorAéreo {
        //Atributos de OperadorAéreo
        //Atributos para leer el archivo
    private BufferedReader Lector; //Recibe el archivo
    private String Línea; //Lee cada línea del archivo
    private String[] Categorías = null; //Crea un vector con cada elemento del archivo, susceptible de ser manipulado

        //Atributos asociados con los vuelos
    private List<Vuelo> ListaVuelos = new ArrayList<>();

    //Constructores de OperadorAéreo
    //Asignadores de atributos de OperadorAéreo (setter)
        //Lectores de atributos de OperadorAéreo (getter)
    public List<Vuelo> getListaVuelos() {
        return this.ListaVuelos;
    }

    //Métodos de OperadorAéreo
        //Métodos de manipulación de archivo
    public void addVuelo(Vuelo vuelo){
        this.ListaVuelos.add(vuelo);
    }
        public static Vuelo AsignarCategorías(String[] categorías){
            Vuelo vuelo = new Vuelo();
            for(int i = 0; i < categorías.length; i++){
                switch (i) {
                    case 0 -> vuelo.setMatrícula(categorías[i]);
                    case 1 -> vuelo.setOrigen(categorías[i]);
                    case 2 -> vuelo.setDestino(categorías[i]);
                    case 3 -> vuelo.setFechaLlegada(vuelo.StringtoFecha(categorías[i]));
                    case 4 -> vuelo.setOcupantes(Integer.parseInt(categorías[i]));
                }
            }
            return vuelo;
        }
    public static int Ordenar (String atributo, Vuelo alpha, Vuelo beta){
        int Resultadinho = 0;
        atributo = atributo.toLowerCase();

        switch (atributo){
            case "ocupantes" -> Resultadinho = alpha.getOcupantes().compareTo(beta.getOcupantes());
            case "llegada" -> Resultadinho = alpha.getFechaLlegada().compareTo(beta.getFechaLlegada());
        }
        return Resultadinho;
    }

    public List<Vuelo> Filtrar(String campo, DirecciónOrdenamiento dir) {
        List<Vuelo> ListadeVuelosOrdenada = new ArrayList<>(this.getListaVuelos());
        ListadeVuelosOrdenada.sort((Vuelo a, Vuelo b) -> {
            int Resultado = 0;
            if (dir == DirecciónOrdenamiento.ASC){
                Resultado = Ordenar(campo, a,b);
            } else if (dir == DirecciónOrdenamiento.DESC) {
                Resultado = Ordenar(campo, b,a);
            }
            return Resultado;
        });
        return ListadeVuelosOrdenada;
    }
    public static int OpzioneFinale(){
        int resultado = 0;
        String[] OpcionesFinales = {"Sí", "No"};
        int OpciónOcupantes = JOptionPane.showOptionDialog(null, "¿Deseas seguir buscando?",
                "Aeropuerto SCL", 0,
                JOptionPane.INFORMATION_MESSAGE,
                null, OpcionesFinales, null);
        resultado = (OpciónOcupantes == 0)? 1 : resultado;
        return resultado;
    }

    public void MagiaMagia(){
            //Obtener información filtrada del archivo
        do {
            String[] Opciones = {"Ocupantes", "Llegada"};
            int Opción = JOptionPane.showOptionDialog(null, "¿Acerca de qué más quieres saber?",
                    "Aeropuerto Comodoro Arturo Merino Benítez SCL", 0,
                    JOptionPane.QUESTION_MESSAGE, null, Opciones, null);
            if(Opción == 0) {
                String[] OpcionesOcupantes = {"Más ocupado", "Menos ocupado"};
                int OpciónOcupantes = JOptionPane.showOptionDialog(null, "Buscar el vuelo...",
                        "Aeropuerto SCL", 0,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, OpcionesOcupantes, null);
                if(OpciónOcupantes == 0){
                        //Buscar el vuelo más ocupado
                    List<Vuelo> Orden = this.Filtrar("Ocupantes", DirecciónOrdenamiento.ASC);
                    System.out.println("La lista ordenada de manera ascendente, según sus ocupantes, es: ");
                    Orden.forEach(System.out::println);
                    System.out.println("\nEl vuelo más ocupado es: ");
                    System.out.println(Orden.get(Orden.size()-1));
                    System.out.println();

                        //Preguntar si continuar, o comenzar de nuevo
                    OpzioneFinale();

                } else if (OpciónOcupantes == 1) {
                        //Buscar el vuelo menos ocupado
                    List<Vuelo> Orden = this.Filtrar("Ocupantes", DirecciónOrdenamiento.DESC);
                    System.out.println("La lista ordenada de manera descendente, según sus ocupantes, es: ");
                    Orden.forEach(System.out::println);
                    System.out.println("\nEl vuelo menos ocupado es: ");
                    System.out.println(Orden.get(Orden.size()-1));
                    System.out.println();

                        //Preguntar si continuar, o comenzar de nuevo
                    OpzioneFinale();
                }
            } else if (Opción == 1) {
                String[] OpcionesLlegada = {"Más reciente", "Más antiguo"};
                int OpciónOcupantes = JOptionPane.showOptionDialog(null, "Buscar el vuelo...",
                        "Aeropuerto SCL", 0,
                        JOptionPane.INFORMATION_MESSAGE, null, OpcionesLlegada, null);
                if(OpciónOcupantes == 0){
                    //Buscar el vuelo más reciente
                    List<Vuelo> Orden = this.Filtrar("FechaLlegada", DirecciónOrdenamiento.ASC);
                    System.out.println("La lista ordenada de manera cronólogica, es: ");
                    Orden.forEach(System.out::println);
                    System.out.println("\nEl vuelo más reciente es: ");
                    System.out.println(Orden.get(Orden.size()-1));
                    System.out.println();

                        //Preguntar si continuar, o comenzar de nuevo
                    OpzioneFinale();
                }
                if(OpciónOcupantes == 1){
                        //Buscar el vuelo más antiguo
                    List<Vuelo> Orden = this.Filtrar("FechaLlegada", DirecciónOrdenamiento.DESC);
                    System.out.println("La lista ordenada de manera retrocronológica, es: ");
                    Orden.forEach(System.out::println);
                    System.out.println("\nEl vuelo más antiguo es: ");
                    System.out.println(Orden.get(0));
                    System.out.println();

                    //Preguntar si continuar, o comenzar de nuevo
                    OpzioneFinale();
                }
            }
        } while (OpzioneFinale() == 1);
    }


        //Métodos de lectura de archivo
    public void LeerArchivo(String rutaArchivo){
        try{
            Reader LeerRuta = new InputStreamReader(new FileInputStream(rutaArchivo), "UTF-8"); //Dejar así,
            // para que lea bien los archivos
            Lector = new BufferedReader(LeerRuta);
            //Lector = new BufferedReader(new FileReader(rutaArchivo));
            int cuentas = 0; //Contador de líneas, para no trabajar con la primera
            while ((Línea = Lector.readLine()) != null) {
                if(cuentas > 0){
                    Categorías = Línea.split(";");
                    this.addVuelo(AsignarCategorías(Categorías));    //Añadir elementos a la lista de vuelos
                    //ImprimirLínea();
                }
                cuentas++;
            }
            Lector.close(); //Interrumpe el curso del BufferedReader para que no se quede iterando por siempre
            Línea = null;
            Categorías = null;

            //ImprimirLista();
            MagiaMagia();

        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }

    public void ImprimirLínea(){
        for(String Categoría : Categorías){
            System.out.print(Categoría + " | ");
        }
        System.out.println();
    }

    public void ImprimirLista(){
        this.getListaVuelos().forEach(System.out::println);
    }
}

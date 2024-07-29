package POO_Recursividad;

import POO_Recursividad.Modelo.Componente;

import java.util.stream.Stream;

public class EjemploRecursividad {
    public static void main(String[] args) {
            //Construir un objeto modular
        Componente PC = new Componente("Gabinete");
        Componente FuentePotencia = new Componente("Fuente de potencia 700 W");
        Componente PlacaMadre = new Componente("Mainboard Asus-AMD");
            //Especificar a los componentes particulares de la placa madre
        Componente Ram = new Componente("Memoria Ram 32Gb");
        Componente SSD = new Componente("Disco sólido 2 Tb");
        Componente CPU = new Componente("CPU AMD Ryzen 9");
            //Especificar a los componentes particulares de la CPU
        Componente Ventilador = new Componente("Ventilador CPU");
        Componente Disipador = new Componente("Disipador de calor");
        Componente TarjetaVideo = new Componente("Nvidia RTX 3080 8 Gb");
        Componente GPU = new Componente("GPU Nvidia RTX");
            //Especificar a los componentes particulares de la GPU
        Componente GPU_Ram = new Componente("4 Gb Ram");
        Componente GPU_Ram2 = new Componente("4 Gb Ram");
        Componente Ventiladores = new Componente("Ventiladores GPU");

            //Comenzar a encadenar componentes
        CPU.addComponente(Ventilador)
                .addComponente(Disipador);
        TarjetaVideo.addComponente(GPU)
                .addComponente(GPU_Ram)
                .addComponente(GPU_Ram2)
                .addComponente(Ventiladores);
        PlacaMadre.addComponente(CPU)
                .addComponente(TarjetaVideo)
                .addComponente(Ram)
                .addComponente(SSD);
        PC.addComponente(FuentePotencia)
                .addComponente(PlacaMadre)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Ratón"));

            //Dos maneras distintas de mostrar el mismo fenómeno
        //MétodoRecursivo(PC, 0);
        MétodoRecursivoStream(PC, 0)
                .forEach(Com -> System.out.println("\t".repeat(Com.getNivel()) + Com.getNombre()));
    }

    public static void MétodoRecursivo(Componente C, int Nivel){
        System.out.println("\t".repeat(Nivel) + C.getNombre());         //El método String.repeat(int cantidad) repite el String dado
        // cuantas veces como indique dicha cantidad. En este caso, el tabulador
        if(C.TieneHijos()){                         //Este if funciona como cota de control
            for(Componente Hijo : C.getHijos()){
                MétodoRecursivo(Hijo, (Nivel + 1));
            }
        }
    }
    public static Stream<Componente> MétodoRecursivoStream(Componente C, int Nivel){
        C.setNivel(Nivel);
        return Stream.concat(Stream.of(C),
                C.getHijos().stream()
                        .flatMap(Hijo -> MétodoRecursivoStream(Hijo, (Nivel + 1))));
    }
}

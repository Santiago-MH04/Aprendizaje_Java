package POO_Paquetes.Hogar;

import POO_Paquetes.Jardín.Perro;
import static POO_Paquetes.Hogar.Persona.*;

public class EjemploHogar {
    public static void main(String[] args) {

        Persona p = new Persona();
            p.setNombre("Pepito");
            p.setApellido("Pérez");

        Perro perro = new Perro();
        String saludo = saludar();
    }
}

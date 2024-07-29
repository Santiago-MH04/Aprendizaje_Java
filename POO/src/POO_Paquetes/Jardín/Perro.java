package POO_Paquetes.Jardín;

import POO_Paquetes.Hogar.Persona;

public class Perro {
    protected String nombre;
    protected String raza;

        //Creador de métodos
    String jugar(Persona persona){
        return persona.LanzarPelota();
    }
}

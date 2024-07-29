package ValorVSReferencia;

class Persona{
    private String nombre;
    public void modificarNombre (String nuevoNombre){
        this.nombre = nuevoNombre;
    }
    public String leerNombre() {
        return this.nombre;
    }
}

public class PasarPorReferencia2 {
    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.modificarNombre("Santiago");
        System.out.println("persona.nombre = " + persona.leerNombre());

            //Antes de probando();
        System.out.println("Antes de llamar al método probando");

            //Después de probando();
        System.out.println("Después de llamar al método probando \n");
        probando(persona);
        System.out.println("persona.nombre = " + persona.leerNombre());

        System.out.println("Finaliza el método probando, y modifica el nombre de la persona");
    }

    public static void probando (Persona persona) {
            //Prueba con el método Probando
        System.out.println("Inicio del método probando");
        persona.modificarNombre("Queso y Cocacolo");
        System.out.println("Finalización del método probando");
    }
}

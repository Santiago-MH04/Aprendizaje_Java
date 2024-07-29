package POO_Colecciones.Lecciones.Map;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {

        Map<String, Object> Persona = new TreeMap<>((a, b) -> b.compareTo(a)); //Las llaves son únicas, los valores pueden ser repetidos.
                                               // En caso de que se repitan las llaves, sólo se muestra la última ocurrencia.
                                               // Un TreeMap no admite elementos nulos, a no ser que sobreescribamos la interfaz comparable
                                               //Map<String, Object> Persona = new TreeMap<>(Comparator.reverseOrder());
                                               //Map<String, Object> Persona = new TreeMap<>(Comparator.comparing(String::length).reversed());
        Persona.put("Nombre", "Juanito");
        Persona.put("Apellido", "Alimaña");
        Persona.put("Apellido paterno", "Alimaña");
        Persona.put("Correo", "juanito.a@correo.com");
        Persona.put("Edad", 25);

        Map<String, String> Dirección = new HashMap<>();
        Dirección.put("País", "Locombia");
        Dirección.put("Departamento", "Antioquia");
        Dirección.put("Ciudad", "Copacabana");
        Dirección.put("Calle" , "Carrera 64 # 47-81");
        Dirección.put("Interior", "240");

        Persona.put("Dirección", Dirección);
        System.out.println("Persona: " + Persona);
    }
}

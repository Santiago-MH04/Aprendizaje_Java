package POO_Colecciones.Lecciones.Map;

import java.util.*;

public class EjemploHashMap {
    public static void main(String[] args) {

        Map<String, Object> Persona = new HashMap<>(); //Las llaves son únicas, los valores pueden ser repetidos.
                                                       // En caso de que se repitan las llaves, sólo se muestra la última ocurrencia
        System.out.println("¿El Map contiene elementos?: " + !Persona.isEmpty());
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

        String Nombre = (String) Persona.get("Nombre");
            System.out.println("Nombre: " + Nombre);
        String Apellido = (String) Persona.get("Apellido");
            System.out.println("Apellido: " + Apellido);

        Map<String, String> DirecciónResidencia = (Map<String, String>)Persona.get("Dirección");
        String País = DirecciónResidencia.get("País");
        String Departamento = DirecciónResidencia.get("Departamento");
        String Ciudad = DirecciónResidencia.get("Ciudad");
        String Barrio = DirecciónResidencia.getOrDefault("Barrio", "La Posada del Viento");
        System.out.println("El país de " + Nombre + " es: " + País +
                " y vive en " + Ciudad + ", " + Departamento);
        System.out.println("El barrio de " + Nombre + " es" + Barrio);


        /*String ValorApellidoPaterno = Persona.remove("Apellido paterno");
            System.out.println("Eliminado: " + ValorApellidoPaterno);*/
        boolean b = Persona.remove("Apellido paterno", "Alimañaña");
        System.out.println("Eliminado: " + b);


        System.out.println("Persona: " + Persona);

        boolean b1 = Persona.containsKey("Apellido paterno");
        System.out.println("¿El Map contiene ahora la llave de apellido paterno?: " + b1);
        boolean b2 = Persona.containsValue("Alimañaña");
        System.out.println("¿El Map contiene ahora el valor de Alimañaña?: " + b2);

        boolean c = Persona.replace("Apellido paterno", "Alimañita", "Alimañaña");
        System.out.println("¿El apellido paterno Alimañita ya existía?: " + c);
        Persona.replace("Apellido paterno", "Alimañaña");
        System.out.println("\nPersona: " + Persona);

        System.out.println("\nSet con las llaves: ");
        Set<String> Llaves = Persona.keySet();
        for(String Llave : Llaves){
            System.out.println(Llave);
        }

        System.out.println("\nColección con los valores: ");
        Collection<Object> Valores = Persona.values();
        for(Object Valor : Valores){
            System.out.println(Valor);
        }

        System.out.println("\nMap con cada par: ");
        for(Map.Entry<String, Object> Par : Persona.entrySet()){
            Object Valor = Par.getValue();
            if(Valor instanceof Map){
                Map<String, String> DirecciónMap = (Map<String, String>) Valor;
                for (Map.Entry<String, Object> ParDir : Persona.entrySet()){
                    System.out.println(ParDir.getKey() + ": " + ParDir.getValue());
                }
            } else {
                System.out.println(Par.getKey() + ": " + Valor);
            }
        }

        System.out.println("\nImpresión simple con cada par: ");
        for(String Llave : Persona.keySet()){
            Object Valor = Persona.get(Llave);
            if(Valor instanceof Map){
                String Nom = Persona.get("Nombre").toString();
                Map<String, String> DirecciónMap = (Map<String, String>) Valor;
                System.out.println(Nom + " vive en " + DirecciónMap.get("País"));
                System.out.println("La ciudad de " + Nom + " es " + DirecciónMap.get("Ciudad") + ", " + DirecciónMap.get("Departamento"));
            } else {
                System.out.println(Llave + ": " + Valor);
            }
        }

        System.out.println("\nImpresión con el método forEach: ");
        Persona.forEach((Llave, Valor) -> System.out.println(Llave + ": " + Valor));

        System.out.println("\nTotal : " + Persona.size());
        System.out.println("¿El Map contiene elementos?: " + !Persona.isEmpty());
    }
}

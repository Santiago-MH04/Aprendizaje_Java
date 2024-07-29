package ClaseSystem;

import java.util.Map;

public class EjemploVariablesDeEntorno {
    public static void main(String[] args) {

        Map<String, String> varEnv = System.getenv();
        System.out.println("Variable de ambiente del sistema = " + varEnv);

        System.out.println("----Listar las variables de entorno del sistema----");
        for(String key : varEnv.keySet()){
            System.out.println(key + " ----> " + varEnv.get(key));
        }

        String NombreUsuario = System.getenv("USERNAME");
        System.out.println("NombreUsuario = " + NombreUsuario);

        String JavaHome = System.getenv("JAVA_HOME");
        System.out.println("JavaHome = " + JavaHome);

        String TempDir = System.getenv("TEMP");
        System.out.println("TempDir = " + TempDir);

        String Path = System.getenv("PATH");
        System.out.println("Path = " + Path);

        String Path2 = varEnv.get("Path");
        System.out.println("Path2 = " + Path2);
    }
}

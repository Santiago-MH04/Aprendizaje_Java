package ClaseSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class EjemploAsignaciónPropiedadesSistema {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            FileInputStream archivo = new FileInputStream("src/ClaseSystem/configurando.properties");
            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada","Mi valor guardado en el objeto properties");
            System.setProperties(p);

            Properties ps = System.getProperties();
            System.out.println("ps.getProperty(...) = " + ps.getProperty("mi.propiedad.personalizada"));
            System.out.println(System.getProperty("configurando.puerto.servidor"));
            System.out.println(System.getProperty("otra"));
            System.out.println(System.getProperty("configurando.texto.ambiente"));
            System.out.println(System.getProperty("configurando.autor.nombre"));
            System.out.println(System.getProperty("configurando.autor.correo"));

            System.out.println();
            ps.list(System.out);

        } catch(Exception e) {
            System.err.println("No existe el archivo: " + e);
        }
    }
}

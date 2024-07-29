package ClaseSystem;

import java.util.Properties;

public class EjemploPropiedadesSistema {
    public static void main(String[] args) {

        String username = System.getProperty("user.name");
        System.out.println("username = " + username);

        String home = System.getProperty("user.home");
        System.out.println("home = " + home);

        String workspace = System.getProperty("user.dir");
        System.out.println("workspace = " + workspace);

        String line_separator = System.getProperty("line.separator");
        String line_separator2 = System.lineSeparator();
        System.out.println("line_separator = " + line_separator2 + "Una nueva línea");

        Properties p = System.getProperties();
        p.list(System.out);
    }
}

package ClasesWrapper;

import java.lang.reflect.Method;

public class EjemploMétodoGetClass {
    public static void main(String[] args) {
        String unTexto = "Hola, ¿qué tal?";
        Class strClass = unTexto.getClass();

            //Aquí se obtienen respectivamente, el nombre del paquete y la clase, la clase, y finalmente el nombre del paquete
        System.out.println("strClass.getName() = " + strClass.getName());
        System.out.println("strClass.getName() = " + strClass.getSimpleName());
        System.out.println("strClass.getName() = " + strClass.getPackageName()+ "\n");

            //Aquí se obtiene el nombre del paquete y la clase precidido de la palabra class
        System.out.println("strClass = " + strClass + "\n");

            //Ahora, listemos todos los métodos de la clase String
        for (Method einMetodische : strClass.getMethods()){
            System.out.println("einMetodische.getName() = " + einMetodische.getName() + "\n");
        }

        Integer einNumber = 25;
        Class numClass = einNumber.getClass();
        Class objClass = numClass.getSuperclass().getSuperclass();
        System.out.println("numClass.getSuperclass().getSuperclass() = " + numClass.getSuperclass());
        System.out.println("numClass.getSuperclass().getSuperclass() = " + objClass + "\n");

            //Ahora, listemos todos los métodos de la clase String
        for (Method unMéthode : objClass.getMethods()){
            System.out.println("einMetodische.getName() = " + unMéthode.getName());
        }
    }
}


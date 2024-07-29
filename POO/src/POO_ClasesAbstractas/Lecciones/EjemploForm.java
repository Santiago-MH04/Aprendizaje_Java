package POO_ClasesAbstractas.Lecciones;

import POO_ClasesAbstractas.Lecciones.Elementos.*;
import POO_ClasesAbstractas.Lecciones.Elementos.Select.*;
import POO_ClasesAbstractas.Lecciones.Validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("usuario");
            username.addValidador(new RequeridoValidador());
        InputForm password = new InputForm("clave", "password");
            password.addValidador(new RequeridoValidador())
                    .addValidador(new LargoValidador(6,12));
        InputForm email = new InputForm("correo", "email");
            email.addValidador(new RequeridoValidador())
                    .addValidador(new EmailValidador());
        InputForm edad = new InputForm("edad", "number");
            edad.addValidador(new NúmeroValidador());

        TextAreaForm experiencia =  new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
            lenguaje.addValidador(new NoNuloValidador());

            lenguaje.addOpción(new Opción("1", "Java"));
            lenguaje.addOpción(new Opción("2", "Python"));
            lenguaje.addOpción(new Opción("3", "JavaScript"));
            lenguaje.addOpción(new Opción("4", "TypeScript").setSelected());
            lenguaje.addOpción(new Opción("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo"){
            @Override
            public String dibujarHTML() {
                return "<input disabled name = '" + this.Nombre + "' value = \"" + this.Valor + "\">";
            }
        };
        saludar.setValor("Hola, ¿qué tal? Este campo está deshabilitado");

        username.setValor("pepito.pérez");
        password.setValor("Contraseña123654789*");
        email.setValor("pepito.perez@correo.com");
        edad.setValor("25");
        experiencia.setValor("... más de 10 años de experiencia...");
        //java.setSelected(true);

        /*List<ElementoForm> elementos = new ArrayList<>();
        elementos.add(username);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);*/

        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);

        for(ElementoForm ef : elementos){
            if(ef instanceof SelectForm){
                System.out.println("\n" + ef.dibujarHTML());
            }else{
                System.out.println(ef.dibujarHTML());
                //System.out.println("<br>");
            }
        }

            /*elementos.forEach(ef ->{
                System.out.println(ef.dibujarHTML());
                //System.out.println("<br>");
            });*/

        elementos.forEach(ef ->{
            if(!ef.esVálido()){
                System.out.println();
                ef.getErrores().forEach(err -> {
                    System.out.println(ef.getNombre() + ": " + err);
                });
            }
            //System.out.println("<br>");
        });

            /*elementos.forEach(ef ->{
                if(!ef.esVálido()){
                    ef.getErrores().forEach(System.out::println);
                }
                //System.out.println("<br>");
            });*/
    }
}

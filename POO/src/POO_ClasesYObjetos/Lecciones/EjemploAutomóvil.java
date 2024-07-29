package POO_ClasesYObjetos.Lecciones;

public class EjemploAutomóvil {
    public static void main(String[] args) {

        Automóvil Toyota = new Automóvil("Toyota","Corolla");
        //Toyota.setFabricante("Toyota");
        //Toyota.setModelo("Corolla");
        //Toyota.setColor("Blanco");
        Motor MotorToyota = new Motor(4.0, TipoMotor.GASOLINA);
            Toyota.setMotor(MotorToyota);

        //POO_ClasesYObjetos.Automóvil Mini = new POO_ClasesYObjetos.Automóvil("Mini", "Superleggera", "Azul", 4.0);
        //Mini.setFabricante("Mini");
        //Mini.setModelo("Superleggera");
        //Mini.setColor("Azul");
        //Mini.setCilindraje(4.0);

        //POO_ClasesYObjetos.Automóvil Nissan = new POO_ClasesYObjetos.Automóvil("Nissan", "March", "Gris", 3.5, 70);
        //POO_ClasesYObjetos.Automóvil Nissan2 = new POO_ClasesYObjetos.Automóvil("Nissan", "March", "Gris", 3.5, 70);

        Automóvil Carro = new Automóvil();

        System.out.println(Toyota.detalle());
        System.out.println();
        //System.out.println(Mini.detalle());
        System.out.println();
        //System.out.println(Nissan.detalle());
        System.out.println();
        //System.out.println("¿Nissan y Nissan2 son iguales?: " + (Nissan == Nissan2));
        //System.out.println("¿Nissan y Nissan2 son iguales con la función equals sobreescrita?: " + Nissan.equals(Nissan2));
        System.out.println();
        //System.out.println(Nissan);
        //System.out.println(Nissan.toString());
        System.out.println();


        /*for (POO_ClasesYObjetos.Automóvil : main(args)){
            System.out.println(POO_ClasesYObjetos.Automóvil.detalle());
            System.out.println();
        }*/

        System.out.println(Toyota.acelerar(4000));
        System.out.println(Toyota.frenar());
        System.out.println();
        //System.out.println(Mini.acelerarFrenar(5000));
        System.out.println();
        //System.out.println(Nissan.acelerarFrenar(1200));
        System.out.println();
        //System.out.println("Rendimiento de combustible del " + Mini.getFabricante() + " " + Mini.getModelo() + " en [km/l] es = " + Mini.calcularRendimiento(300,0.75f));
        //System.out.println("Rendimiento de combustible del " + Toyota.getFabricante() + " " + Toyota.getModelo() + " en [km/l] es = " + Toyota.calcularRendimiento(300,60));
        //System.out.println("Rendimiento de combustible del " + Nissan.getFabricante() + " " + Nissan.getModelo() + " en [km/l] es = " + Nissan.calcularRendimiento(300,80));
    }
}

package POO_Herencia.Actividad.EjemploAlmacénVerdulería;

import POO_Herencia.Actividad.EjemploAlmacénVerdulería.Bambalinas.*;

public class EjemploAlmacénVerdulería {
    public static void main(String[] args) {
            //Invocar dos lácteos
        Lácteo leche = new Lácteo("kumis", 2700, 6, 150);
        Producto queso = new Lácteo();
            queso.setNombre("Queso roquefort");
            queso.setPrecio(25000);
            ((Lácteo)queso).setCantidad(3);
            ((Lácteo)queso).setProteínas(200);

            //Invocar dos frutas
        Fruta manzana = new Fruta("Manzanas", 2500, 4.2);
            manzana.setColor("Rojo");
        Producto naranja = new Fruta("Naranjas",3600,4);
            ((Fruta)naranja).setColor("Amarillo");

            //Invocar dos productos no perecederos
        NoPerecedero pasta = new NoPerecedero("Pastas Doria",2500, 300);
        Producto fríjol = new NoPerecedero();
            fríjol.setNombre("Fríjol blanquillo");
            fríjol.setPrecio(1800);
            ((NoPerecedero)fríjol).setContenido(2);

            //Invocar dos productos de limpieza
        Limpieza lavaloza = new Limpieza();
            lavaloza.setNombre("Lozacrem");
            lavaloza.setPrecio(9900);
            lavaloza.setComponentes("Tensoactivo, fragancia");
            lavaloza.setVolumen(0.98);
        Producto BonBril = new Limpieza("Bon Bril", 7500, "Peróxido, tensoactivo y fragancia", 0.75);

            //Crear un vector con esos productos
        Producto[] Canasta = {leche, queso, manzana, naranja, pasta, fríjol, lavaloza, BonBril};
            //Imprimir el detalle de los productos
        for(Producto pro : Canasta){
            System.out.println(pro);
            System.out.println();
        }
    }
}

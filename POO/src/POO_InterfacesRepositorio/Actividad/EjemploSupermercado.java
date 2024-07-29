package POO_InterfacesRepositorio.Actividad;

public class EjemploSupermercado {
    public static void main(String[] args) {

        CarritoSupermercado<Producto> Compras = new CarritoSupermercado<>();

        BolsaSupermercado<Fruta> Frutas = new BolsaSupermercado<>();
            Frutas.add(new Fruta("Pitaya", 2500d, "Amarillo", 0.350));
            Frutas.add(new Fruta("Manzana", 1300d, "Rojo", 0.3));
            Frutas.add(new Fruta("Gulupa", 6500d, "Violeta", 0.5));
            Frutas.add(new Fruta("Fresa", 5000d, "Rojo", 0.750));
            Frutas.add(new Fruta("Banano", 3500d, "Amarillo", 1.2 ));

        BolsaSupermercado<Lácteo> Lácteos = new BolsaSupermercado<>();
            Lácteos.add(new Lácteo("Yogurt griego", 11500d, 1, 80));
            Lácteos.add(new Lácteo("Leche", 3500d, 2, 45));
            Lácteos.add(new Lácteo("Queso mozzarella", 5000d, 2, 75));
            Lácteos.add(new Lácteo("Alpinito", 700d, 3, 65));
            Lácteos.add(new Lácteo("Crema de leche", 1700d, 1, 15));


            Compras.addBolsa(Frutas);
            Compras.addBolsa(Lácteos);
        System.out.println(CarritoSupermercado.Factura(Compras));
    }
}

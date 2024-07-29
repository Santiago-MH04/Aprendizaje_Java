package POO_InterfacesRepositorio.Lecciones.GenericsClass;

public class EjemploGenéricos {
    public static void main(String[] args) {

        Camión<Animal> TransporteCaballos = new Camión<>(5);
            TransporteCaballos.add(new Animal("Caballo", "Tormenta"));
            TransporteCaballos.add(new Animal("Caballo", "Retruécano"));
            TransporteCaballos.add(new Animal("Caballo", "Blasfemia"));
            TransporteCaballos.add(new Animal("Caballo", "Bucéfalo"));
            TransporteCaballos.add(new Animal("Caballo", "Palomo"));
                /*for(Animal a : TransporteCaballos){
                    System.out.println(a.getNombre() + ". Especie: " + a.getEspecie());
                }*/
        System.out.println("Transporte de animales");
        imprimir(TransporteCaballos);

        Camión<Maquinaria> TransporteMaquinaria = new Camión<>(3);
            TransporteMaquinaria.add(new Maquinaria("Bulldozer"));
            TransporteMaquinaria.add(new Maquinaria("Gruá horquilla"));
            TransporteMaquinaria.add(new Maquinaria("Perforadora"));
                /*for (Maquinaria m : TransporteMaquinaria){
                    //Maquinaria m = (Maquinaria) o;
                    System.out.println(m.getTipo());
                }*/
        System.out.println("\nTransporte de maquinaria");
        imprimir(TransporteMaquinaria);

        Camión<Automóvil> TransporteAuto = new Camión<>(3);
            TransporteAuto.add(new Automóvil("Toyota"));
            TransporteAuto.add(new Automóvil("Mitsubishi"));
            TransporteAuto.add(new Automóvil("Honda"));
                /*for (Automóvil au : TransporteAuto){
                    System.out.println(au.getMarca());
                }*/
        System.out.println("\nTransporte de automóviles");
        imprimir(TransporteAuto);
    }

    public static <T> void imprimir(Camión<T> carga){
        for (T A : carga) {
            if (A instanceof Animal) {
                System.out.println(((Animal)A).getNombre() + ". Especie: " + ((Animal)A).getEspecie());
            } else if (A instanceof  Maquinaria) {
                System.out.println(((Maquinaria)A).getTipo());
            } else if (A instanceof  Automóvil) {
                System.out.println(((Automóvil)A).getMarca());
            }
        }
    }
}

package POO_ClasesYObjetos.Lecciones;

public class EjemploAutomóvilEnum {
    public static void main(String[] args) {

        Motor MotorMini = new Motor(4.0, TipoMotor.GASOLINA);
        Automóvil Mini = new Automóvil("Mini", "Superleggera", Color.AZUL, MotorMini);
            Mini.setTipo(TipoAutomóvil.CONVERTIBLE);
            //Mini.setFabricante("Mini");
            //Mini.setModelo("Superleggera");
            //Mini.setColor(POO_ClasesYObjetos.Color.AZUL);
            //Mini.setCilindraje(4.0);

        Motor MotorNissan = new Motor(2.5, TipoMotor.GASOLINA);
        Estanque EstanqueNissan = new Estanque(70);
        Automóvil Nissan = new Automóvil("Nissan", "March", Color.GRIS, MotorNissan, EstanqueNissan);
            Nissan.setTipo(TipoAutomóvil.HATCHBACK);
        Automóvil Nissan2 = new Automóvil("Nissan", "March", Color.GRIS, MotorNissan, EstanqueNissan);
        Automóvil Carro = new Automóvil();

        System.out.println("POO_ClasesYObjetos.Automóvil.VELOCIDAD_MAX_CARRETERA = " + Automóvil.VELOCIDAD_MAX_CARRETERA);
        System.out.println("POO_ClasesYObjetos.Automóvil.VELOCIDAD_MAX_URBANO = " + Automóvil.VELOCIDAD_MAX_URBANO);
        System.out.println();
        TipoAutomóvil tipo = Nissan.getTipo();
        System.out.println("Tipo automóvil: " + tipo.getNombre());
        System.out.println("Descripción del tipo: " + tipo.getDescripción());

        tipo = Nissan.getTipo();
        switch (tipo) {
            case CONVERTIBLE -> System.out.println("El automóvil es deportivo y descapotable, de dos puertas");
            case COUPÉ -> System.out.println("Es un automóvil pequeño, de dos puertas, típicamente deportivo");
            case FURGÓN -> System.out.println("Es un automóvil utilitario, de transporte de carga pequeña");
            case HATCHBACK -> System.out.println("Es un automóvil compacto, mediano y aspecto dizque deportivo");
            case PICKUP -> System.out.println("Es un automóvil de doble cabina, una camioneta");
            case SEDÁN -> System.out.println("Es un automóvil mediano");
            case STATION_WAGON -> System.out.println("Es un automóvil más grande, con baúl más espacioso");
        }

        System.out.println();
        TipoAutomóvil[] tipos = TipoAutomóvil.values();
        for(TipoAutomóvil TA: tipos){
            System.out.print(TA + " ===> " + TA.name() + ", " +
                    TA.getNombre() + ", " +
                    TA.getDescripción() + ", " +
                    TA.getNúmeroPuertas() + " puertas");
            System.out.println();
        }
    }
}

package POO_ClasesYObjetos.Lecciones;

public class EjemploAutomóvilRelacionesObjetos {
    public static void main(String[] args) {

        Persona conductorToyota = new Persona("Pepito", "Pérez");

        Automóvil Toyota = new Automóvil("Toyota","Corolla");
            //Toyota.setFabricante("Toyota");
            //Toyota.setModelo("Corolla");
            Toyota.setColor(Color.BLANCO);
            Toyota.setMotor(new Motor(2.5, TipoMotor.GASOLINA));
            Toyota.setTipo(TipoAutomóvil.SEDÁN);
            Toyota.setConductor(conductorToyota);
            //Toyota.setRuedas(ruedasTo);
        Rueda[] ruedasTo = new Rueda[5];
            for(int i = 0; i < ruedasTo.length; i++){
                Toyota.addRueda(new Rueda("Pirelli", 16, 7.5));
            }

        Persona conductorMini = new Persona("Queso", "Colín");
        Motor MotorMini = new Motor(4.0, TipoMotor.GASOLINA);
        Automóvil Mini = new Automóvil("Mini", "Superleggera", Color.AZUL, MotorMini);
            Mini.setTipo(TipoAutomóvil.CONVERTIBLE);
            Mini.setConductor(conductorMini);
            //Mini.setRuedas(ruedasMi);
        Rueda[] ruedasMi = new Rueda[10];
        for(int i = 0; i < ruedasMi.length; i++){
            Mini.addRueda(new Rueda("Michelin", 18, 10.5));
        }
            //Mini.setFabricante("Mini");
            //Mini.setModelo("Superleggera");
            //Mini.setColor(POO_ClasesYObjetos.Color.AZUL);
            //Mini.setCilindraje(4.0);

        Persona conductorNissan = new Persona("Manuelitas", "Torombolitas");
        Motor MotorNissan = new Motor(3.5, TipoMotor.GASOLINA);
        Estanque EstanqueNissan = new Estanque(70);
        Automóvil Nissan = new Automóvil("Nissan", "March", Color.GRIS, MotorNissan, EstanqueNissan);
        Nissan.setConductor(conductorNissan);
        Nissan.setTipo(TipoAutomóvil.HATCHBACK);
        Nissan.addRueda(new Rueda("Yokohama", 20, 11.5))
                .addRueda(new Rueda("Yokohama", 20, 11.5))
                .addRueda(new Rueda("Yokohama", 20, 11.5))
                .addRueda(new Rueda("Yokohama", 20, 11.5))
                .addRueda(new Rueda("Yokohama", 20, 11.5));

        Persona conductorNissan2 = new Persona("Elías", "Floriciento");
        Rueda[] ruedasNis2 = {new Rueda("Yokohama", 20, 11.5),
                new Rueda("Yokohama", 20, 11.5),
                new Rueda("Yokohama", 20, 11.5),
                new Rueda("Yokohama", 20, 11.5),
                new Rueda("Yokohama", 20, 11.5),};
        Automóvil Nissan2 = new Automóvil("Nissan", "March", Color.GRIS, MotorNissan, EstanqueNissan, conductorNissan2, ruedasNis2);

        Automóvil Carro = new Automóvil();

        Automóvil.setColorPatente(Color.NARANJA);

        System.out.println(Toyota.detalle());
        System.out.println();
        System.out.println(Mini.detalle());
        System.out.println();
        System.out.println(Nissan.detalle());

        System.out.println(Nissan.calcularRendimiento(300,60));

        /*System.out.println("Conductor Mini: " + Mini.getConductor());
        for (POO_ClasesYObjetos.Rueda r : Mini.getRuedas()){
            System.out.println("Fabricante: " + r.getFabricante() + "Rin [\"]: " + r.getRin() + "Ancho [\"]:" +r.getAncho());
        }*/
    }
}

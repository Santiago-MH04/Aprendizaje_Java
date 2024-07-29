package POO_ClasesYObjetos.Lecciones;

public class EjemploAutomóvilEstático {
    public static void main(String[] args) {

        Automóvil Toyota = new Automóvil("Toyota","Corolla");
            //Toyota.setFabricante("Toyota");
            //Toyota.setModelo("Corolla");
            Toyota.setColor(Color.BLANCO);
            Toyota.setMotor(new Motor(2.5, TipoMotor.GASOLINA));
            Toyota.setTipo(TipoAutomóvil.SEDÁN);

        Motor MotorMini = new Motor(4.0, TipoMotor.GASOLINA);
        Automóvil Mini = new Automóvil("Mini", "Superleggera", Color.AZUL, MotorMini);
        Mini.setTipo(TipoAutomóvil.CONVERTIBLE);
            //Mini.setFabricante("Mini");
            //Mini.setModelo("Superleggera");
            //Mini.setColor(POO_ClasesYObjetos.Color.AZUL);
            //Mini.setCilindraje(4.0);

        Motor MotorNissan = new Motor(3.5, TipoMotor.GASOLINA);
        Estanque EstanqueNissan = new Estanque(70);
        Automóvil Nissan = new Automóvil("Nissan", "March", Color.GRIS, MotorNissan, EstanqueNissan);
            Nissan.setTipo(TipoAutomóvil.HATCHBACK);
        Automóvil Nissan2 = new Automóvil("Nissan", "March", Color.GRIS, MotorNissan, EstanqueNissan);
        Automóvil Carro = new Automóvil();

        Automóvil.setColorPatente(Color.NARANJA);

        System.out.println("POO_ClasesYObjetos.Automóvil.VELOCIDAD_MAX_CARRETERA = " + Automóvil.VELOCIDAD_MAX_CARRETERA);
        System.out.println("POO_ClasesYObjetos.Automóvil.VELOCIDAD_MAX_URBANO = " + Automóvil.VELOCIDAD_MAX_URBANO);
        System.out.println();
        System.out.println(Toyota.detalle());
        System.out.println();
        System.out.println(Mini.detalle());
        System.out.println();
        System.out.println(Nissan.detalle());
        System.out.println();
        System.out.println("POO_ClasesYObjetos.Automóvil.getColorPatente() = " + Automóvil.getColorPatente());
        System.out.println("Rendimiento estático [km/l]= " + Automóvil.calcularRendimientoEstático(300,60));

        System.out.println(Nissan.calcularRendimiento(300,60));
    }
}

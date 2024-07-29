package POO_ClasesYObjetos.Lecciones;

import java.util.Arrays;

public class EjemploAutomóvilArreglo {
    public static void main(String[] args) {

        Persona conductorToyota = new Persona("Pepito", "Pérez");
        Automóvil Toyota = new Automóvil("Toyota","Corolla");
        //Toyota.setFabricante("Toyota");
        //Toyota.setModelo("Corolla");
        Toyota.setColor(Color.BLANCO);
        Toyota.setMotor(new Motor(2.5, TipoMotor.GASOLINA));
        Toyota.setTipo(TipoAutomóvil.SEDÁN);
        Toyota.setConductor(conductorToyota);


        Persona conductorMini = new Persona("Queso", "Colín");
        Motor MotorMini = new Motor(4.0, TipoMotor.GASOLINA);
        Automóvil Mini = new Automóvil("Mini", "Superleggera", Color.AZUL, MotorMini);
            Mini.setTipo(TipoAutomóvil.CONVERTIBLE);
            Mini.setConductor(conductorMini);
            //Mini.setRuedas(ruedasMi);
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

        Persona conductorSuzuki = new Persona("Elías", "Floriciento");
        Motor MotorSuzuki = new Motor(1.6, TipoMotor.DIESEL);
        Estanque EstanqueSuzuki = new Estanque(80);
        Automóvil Suzuki = new Automóvil("Suzuki", "Vitara", Color.GRIS, MotorSuzuki, EstanqueSuzuki);
        Suzuki.setConductor(conductorSuzuki);
        Suzuki.setTipo(TipoAutomóvil.SUV);

        Automóvil Audi = new Automóvil("Audi","A3");
        Audi.setConductor(new Persona("Santiaguito", "Taimadito"));

        Automóvil[] Autos = new Automóvil[5];
            Autos[0]= Toyota;
            Autos[1]= Mini;
            Autos[2]= Nissan;
            Autos[3]= Suzuki;
            Autos[4]= Audi;

        Arrays.sort(Autos); //Cuidadongos con este método, que es bien, pero bien jodido
        for (Automóvil auto : Autos) {
            System.out.println(auto);
        }
    }
}

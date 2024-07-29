package FlujosDeControl;

import javax.swing.*;

public class SentenciaFor {
    public static void main(String[] args) {

        for (int i = 1, j = 10; i < j; i++, j--){
            System.out.println(i + "," + j);
        }

        for (int i = 1; i <= 10; i++){
                //Imprimir sólo números impares
            if (i % 2 == 0){
                continue;
            }
            System.out.println(i);
        }

            //Buscar un elemento en una lista. En este caso, un nombre en una lista
        String[] losNombres = {"Elías", "Flor", "Manuelas", "Santiago", "Queso", "Cocacolo"};
        boolean laBúsqueda = false;

        do {
            String Criterio = JOptionPane.showInputDialog("Ingrese el nombre que desea buscar en la lista. Ejemplo; \"Manuelas\" o \"Elías\":");

            for (int i = 0; i < losNombres.length; i++){
                //laBúsqueda = (losNombres[i] == Criterio) ? true : laBúsqueda;
                if (losNombres[i].equalsIgnoreCase(Criterio)){
                    laBúsqueda = true;
                    break;
                }
            }

            if (laBúsqueda){
                JOptionPane.showMessageDialog(null, Criterio + " ha sido encontrado en esta lista");
            }   else {
                JOptionPane.showMessageDialog(null, Criterio + " no existe en esta lista");
            }
        } while (!laBúsqueda);
    }
}

package POO_ClasesAbstractas.Lecciones.Elementos;

import POO_ClasesAbstractas.Lecciones.Elementos.Select.*;
import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm{
        //Atributos de SelectForm
    private List<Opción> Opciones;

        //Constructores de SelectForm
    public SelectForm(String nombre) {
        super(nombre);
        this.Opciones = new ArrayList<Opción>();
    }
        public SelectForm(String nombre, List<Opción> opciones) {
            super(nombre);
            this.Opciones = opciones;
        }

        //Asignadores de atributos de SelectForm (setter)
        //Lectores de atributos de SelectForm (getter)

        //Métodos de SelectForm
    @Override
    public String dibujarHTML() {
        StringBuilder sb = new StringBuilder("<select ");
        sb.append("name = '")
                .append(this.Nombre)
                .append("'>");
        for(Opción opción: this.Opciones){
            sb.append("\n<option value = '")
                    .append(opción.getValor())
                    .append("'");
            if(opción.isSelected()){
                sb.append(" selected");
                this.Valor = opción.getValor();
            }
            sb.append(">")
                    .append(opción.getNombre())
                    .append("</option>");
        }
        sb.append("</select>");
        return sb.toString();
    }

    public SelectForm addOpción(Opción opción){
        this.Opciones.add(opción);
        return this;
    }
}

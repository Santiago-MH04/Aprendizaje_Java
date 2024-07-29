package POO_ClasesAbstractas.Lecciones.Elementos;

import POO_ClasesAbstractas.Lecciones.Validador.*;
import POO_ClasesAbstractas.Lecciones.Validador.Mensaje.*;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoForm {
        //Atributos de ElementoForm
    protected String Nombre;
    protected String Valor;
    private List<Validador> Validadores;
    private List<String> Errores;

        //Constructores de ElementoForm
    public ElementoForm() {
        this.Validadores = new ArrayList<>();
        this.Errores = new ArrayList<>();
    }
        public ElementoForm(String nombre) {
            this();
            this.Nombre = nombre;
        }

        //Asignadores de atributos (setter)
    public void setValor(String valor) {
        this.Valor = valor;
    }

        //Lectores de atributos (getter)
    public String getNombre() {
        return this.Nombre;
    }
        public List<String> getErrores(){
            return this.Errores;
        }

        //Métodos de ElementoForm
    public ElementoForm addValidador (Validador validador){
        this.Validadores.add(validador);
        return this;
    }
    public boolean esVálido(){
        for(Validador val : this.Validadores){
            if (!val.esVálido(this.Valor)){
                if (val instanceof MensajeMaleable){
                    this.Errores.add(((MensajeMaleable)val).getMensajeFormateado(this.Nombre));
                }else {
                    this.Errores.add(String.format(val.getMensaje(), this.Nombre));
                }
            }
        }
        return (this.Errores.isEmpty());
    }
    public abstract String dibujarHTML();
}

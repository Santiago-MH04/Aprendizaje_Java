package POO_ClasesAbstractas.Lecciones.Validador;

import POO_ClasesAbstractas.Lecciones.Validador.Mensaje.*;

public class LargoValidador extends Validador implements MensajeMaleable {
        //Atributos de LargoValidador
    protected String Mensaje = "El campo %s debe tener mínimo %d y máximo %d caracteres";
    private int min;
    private int max = Integer.MAX_VALUE;

        //Constructores de LargoValidador
    public LargoValidador() {
    }
        public LargoValidador(int min, int max) {
            this.min = min;
            this.max = max;
        }

        //Asignadores de atributos de LargoValidador (setter)
    @Override
    public void setMensaje(String mensaje) {
        this.Mensaje = mensaje;
    }
        public void setMin(int min) {
            this.min = min;
        }
            public void setMax(int max) {
                this.max = max;
            }

        //Lectores de atributos de LargoValidador (getter)
    @Override
    public String getMensaje() {
        return this.Mensaje;
    }
        @Override
        public String getMensajeFormateado(String campo){
            return String.format(this.Mensaje, campo, this.min, this.max);
        }

        //Métodos de LargoValidador
    @Override
    public boolean esVálido(String valor) {
        //this.Mensaje = String.format(this.Mensaje,this.min, this.max);
        if (valor == null){
            return true;
        }
        int tamaño = valor.length();
        return (tamaño >= this.min && tamaño <= this.max);
    }
}

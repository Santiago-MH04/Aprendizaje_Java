package API_Stream.Lecciones.Modelo;

public class Factura {
        //Atributos de Factura
    private String Descripción;
    private Usuario UsuarioFactura;

        //Constructores de Factura
    public Factura(String descripción) {
        this.Descripción = descripción;
    }

        //Asignadores de atributos de Factura (setter)
    public void setDescripción(String descripción) {
        this.Descripción = descripción;
    }
        public void setUsuarioFactura(Usuario usuarioFactura) {
            this.UsuarioFactura = usuarioFactura;
        }

        //Lectores de atributos de Factura (getter)
    public String getDescripción() {
        return this.Descripción;
    }
        public Usuario getUsuarioFactura() {
            return this.UsuarioFactura;
        }

    //Métodos de Factura
}

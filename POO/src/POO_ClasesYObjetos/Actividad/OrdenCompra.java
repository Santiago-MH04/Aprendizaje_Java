package POO_ClasesYObjetos.Actividad;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrdenCompra {
        //Atributos de la clase OrdenCompra
    private int identificador; //Debe ser autoincremental. Servirse de un atributo estático
    private String descripción;
    private LocalDateTime fecha;
    private Cliente cliente;
    private Producto[] productos;
        //Otros atributos necesarios
    private static int inc;
    private int ÍndiceCompra;

        //Constructores de la clase OrdenCompra
    public OrdenCompra(String descripción) {
        this.descripción = descripción;
        this.identificador = ++inc;
        this.productos = new Producto[4];
    }

        //Setters de la clase OrdenCompra
    public String setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        //SimpleDateFormat formato = new SimpleDateFormat("EEEE dd 'de' MMMM, yyyy. HH:mm");
        DateTimeFormatter formatico = DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM, yyyy. HH:mm'h'");
        //String fechaStr = formato.format(this.fecha);
        String fechaStr = formatico.format(fecha);
        return fechaStr;
    }
        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        //Getters de la clase OrdenCompra
    public int getIdentificador() {
        return this.identificador;
    }
        public String getDescripción() {
            return this.descripción;
        }
            public LocalDateTime getFecha() {
                return this.fecha;
            }
                public Cliente getCliente() {
                    return this.cliente;
                }
                    public Producto[] getProductos() {
                        return this.productos;
                    }

    //Métodos de la clase OrdenCompra (*Iniciar la fecha, por favor, que sigue estando vacía
    //*Los productos sólo se pueden añadir usando un método addProducto(Producto producto)
    //*Crear un método que devuelva el total, sumando los precios de los productos)
    public OrdenCompra addProducto(Producto producto){
        if(ÍndiceCompra < this.productos.length) {
            this.productos[ÍndiceCompra++] = producto;
        }
        return this;
    }
    public String detallePrecios(){
        if(this.productos == null){
            return "No hay ningún producto guardado en memoria";
        }else {
            String detalle = "Detalle de precios: \n";
            for (Producto facturable : this.productos) {
                detalle += facturable.getNombre() + ": $" + facturable.getPrecio() + "\t";
            }
            return detalle;
        }
    }
    public int TotalNeto(){
        int neto = 0;
        for (Producto contable : this.productos){
            neto += contable.getPrecio();
        }
        return neto;
    }

    @Override
    public String toString() {
        String Factura = "\nCliente: " + this.cliente +
                "\nIdentificador: " + this.identificador +
                "\nDescripción: " + this.descripción +
                "\n" + detallePrecios() +
                "\nTOTAL: " + TotalNeto();
        return Factura;
    }
}

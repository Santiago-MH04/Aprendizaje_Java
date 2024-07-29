package POO_AppFacturas.Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Factura {
        //Atributos de la clase Factura
    private int Folio;
    private static int ÚltimoFolio;
    private String Descripción;
    public LocalDateTime Fecha;
    private POO_AppFacturas.Modelo.Cliente Cliente;
    private ÍtemFactura[] Ítems;
    private int índiceÍtems; //Para asignar valor a cada objeto ÍtemFactura en Ítems
    public static final int MAX_ÍTEMS = 12; //Para determinar la cantidad de ítems en cada factura

        //Constructores de la clase Factura
    public Factura(String descripción, Cliente cliente) {
        this.Folio = ++ÚltimoFolio;
        this.Descripción = descripción;
        this.Fecha = LocalDateTime.now();
        this.Cliente = cliente;
        this.Ítems = new ÍtemFactura[MAX_ÍTEMS];
    }

        //Asignadores de atributos (setter)
    public void setDescripción(String descripción) {
        this.Descripción = descripción;
    }
        public void setFecha(LocalDateTime fecha) {
            this.Fecha = fecha;
        }
            public void setCliente(Cliente cliente) {
                this.Cliente = cliente;
            }

        //Lectores de atributos (getter)
    public int getFolio() {
        return this.Folio;
    }
        public String getDescripción() {
            return this.Descripción;
        }
            public LocalDateTime getFecha() {
                return this.Fecha;
            }
                public Cliente getCliente() {
                    return this.Cliente;
                }
                    public ÍtemFactura[] getÍtems() {
                        return this.Ítems;
                    }

        //Métodos para Factura
    public void addÍtemFactura(ÍtemFactura ítem){
        if(índiceÍtems < MAX_ÍTEMS) {
            this.Ítems[++índiceÍtems] = ítem;
        }
    }
    public float calcularTotal(){
        float total = 0.0f;
        for (int i = 0; i < índiceÍtems; i++){
            ÍtemFactura ítem = this.Ítems[i];
            total += ítem.calcularImporte();
        }
        return total;
    }
    public String verDetalle(){
        DateTimeFormatter ff = DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM, yyyy. HH:mm'h'");

        StringBuilder sb = new StringBuilder("Factura # :");
        sb.append(this.Folio + ".")
                .append("\tFecha: " + ff.format(this.Fecha))
                .append("\nCliente: ")
                .append(this.Cliente.getNombre())
                .append("\t NIT: ").append(this.Cliente.getNIT())
                .append("\nDescripción: ").append(this.Descripción)
                .append("\n")
                .append("\n#\tNombre\tPrecio [$]\tCantidad\tTotal\n");

        for (ÍtemFactura ítem : this.Ítems){
            if (ítem == null){
                continue;
            }
            sb.append(ítem.toString())
                    .append("\n");
        }
        sb.append("\nTotal neto: ").append(calcularTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return verDetalle();
    }
}

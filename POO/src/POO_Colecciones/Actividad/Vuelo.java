package POO_Colecciones.Actividad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vuelo {
        //Atributos de Vuelo
    private String Matrícula;
    private String Origen;
    private String Destino;
    private LocalDateTime FechaLlegada; //Cambiar a formato fecha una vez se haya leído el archivo
    private Integer Ocupantes;

        //Constructores de Vuelo
    public Vuelo() {
    }

        //Asignadores de atributos de Vuelo (setter)
    public void setMatrícula(String matrícula) {
        this.Matrícula = matrícula;
    }
        public void setOrigen(String origen) {
            this.Origen = origen;
        }
            public void setDestino(String destino) {
                this.Destino = destino;
            }
                public void setFechaLlegada(LocalDateTime fechaLlegada) {
                    this.FechaLlegada = fechaLlegada;
                }
                    public void setOcupantes(Integer ocupantes) {
                        this.Ocupantes = ocupantes;
                    }

        //Lectores de atributos de Vuelo (getter)
    public String getMatrícula() {
        return this.Matrícula;
    }
        public String getOrigen() {
            return this.Origen;
        }
            public String getDestino() {
                return this.Destino;
            }
                public LocalDateTime getFechaLlegada() {
                    return this.FechaLlegada;
                }
                    public Integer getOcupantes() {
                        return this.Ocupantes;
                    }

        //Métodos de Vuelo
    public static LocalDateTime StringtoFecha(String FechaPrueba){
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm'h'");
        LocalDateTime FechaHoraLDT = LocalDateTime.parse(FechaPrueba.toLowerCase(), forma);
        return FechaHoraLDT;
    }
    public String FechaToString(){
        LocalDateTime Data = this.getFechaLlegada();
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm'h'");
        String Fecha = forma.format(Data);
        return Fecha.toLowerCase();
    }

    @Override
    public String toString() {
        return "Matrícula vuelo: " + this.Matrícula + " | " +
                "Origen: " + this.Origen + " | " +
                "Destino: " + this.Destino + " | " +
                "Fecha de llegada: " + this.FechaToString() + " | " +
                "Ocupantes: " + this.Ocupantes + " | ";
    }
}


package JUnitApp.Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
        //Atributos de Banco
    private String Nombre;
    private List<Cuenta> Cuentas;

        //Constructores de Banco
    public Banco() {
        this.Cuentas = new ArrayList<>();
    }

        //Asignadores de atributos de Banco (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
        public void setCuentas(List<Cuenta> cuentas) {
            this.Cuentas = cuentas;
        }

        //Lectores de atributos de Banco (getter)
    public String getNombre() {
        return this.Nombre;
    }
        public List<Cuenta> getCuentas() {
            return this.Cuentas;
        }

        //Métodos de Banco
    public void addCuenta(Cuenta cuenta){
        this.Cuentas.add(cuenta);
        cuenta.setBanco(this);
    }
    public void Transferir(Cuenta Origen, Cuenta Destino, BigDecimal Monto){
        Origen.Débito(Monto);
        Destino.Crédito(Monto);
    }
}

package JUnitApp.Models;

import JUnitApp.Exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {
        //Atributos de Cuenta
    private String Persona;
    private BigDecimal Saldo;
    private Banco Banco;

        //Constructores de Cuenta
    public Cuenta() {
    }
    public Cuenta(String persona, BigDecimal saldo) {
        this.Persona = persona;
        this.Saldo = saldo;
    }
    public Cuenta(String persona, BigDecimal saldo, Banco miBanco) {
        this(persona, saldo);
        this.Banco = miBanco;
    }

        //Asignadores de atributos de Cuenta (setter)
    public void setPersona(String persona) {
        this.Persona = persona;
    }
        public void setSaldo(BigDecimal saldo) {
            this.Saldo = saldo;
        }
            public void setBanco(Banco miBanco) {
                this.Banco = miBanco;
            }

        //Lectores de atributos de Cuenta (getter)
    public String getPersona() {
        return this.Persona;
    }
        public BigDecimal getSaldo() {
            return this.Saldo;
        }
            public Banco getBanco() {
                return this.Banco;
            }

        //Métodos de Cuenta
    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Cuenta)){
            return false;
        }
        Cuenta C = (Cuenta) obj;
        if(this.Persona == null || this.Saldo == null){
            return false;
        }
        return (this.Persona.equals(C.getPersona()) &&
                this.Saldo.equals(C.getSaldo()));
    }
    public void Débito(BigDecimal Monto){
        BigDecimal NuevoSaldo = this.Saldo.subtract(Monto);
        if(NuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new DineroInsuficienteException("Dinero insuficiente en su cuenta");
        }
        this.Saldo = NuevoSaldo;
    }
    public void Crédito(BigDecimal Monto){
        this.Saldo = this.Saldo.add(Monto);
    }
}


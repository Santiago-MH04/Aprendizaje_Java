package POO_Interfaces.Imprenta.Modelo;

public enum Género {
    NOVELA("Novela"),
    ÉPICA("Épica"),
    POESÍA("Poesía"),
    ENSAYO("Ensayo"),
    EDUCACIÓN("Educación");

        //Atributos de Género
    private String nomGénero;

    //Constructores de CLASE
    Género(String nomGénero) {
        this.nomGénero = nomGénero;
    }

    //Asignadores de atributos de CLASE (setter)
        //Lectores de atributos de CLASE (getter)
    public String getNomGénero() {
        return this.nomGénero;
    }

    //Métodos de CLASE

}

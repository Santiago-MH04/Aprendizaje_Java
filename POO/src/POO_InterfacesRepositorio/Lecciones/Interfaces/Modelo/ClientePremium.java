package POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo;

public class ClientePremium extends Cliente implements Comparable<ClientePremium>{
    //Atributos de ClientePremium
        //Constructores de ClientePremium
    public ClientePremium(String nombre, String apellido) {
        super(nombre, apellido);
    }

    //Asignadores de atributos de ClientePremium (setter)
    //Lectores de atributos de ClientePremium (getter)

        //Métodos de ClientePremium
    @Override
    public int compareTo(ClientePremium o) {
        return 0;
    }
}

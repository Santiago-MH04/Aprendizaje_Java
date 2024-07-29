package POO_Hilos.Lecciones.RecursosCompartidos;

public class Panadería {
        //Atributos de Panadería
    private String Pan;
    private boolean Disponible;

    //Constructores de Panadería
    //Asignadores de atributos de Panadería (setter)
    //Lectores de atributos de Panadería (getter)
        //Métodos de Panadería
    public synchronized void Hornear(String masa){
        while (this.Disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.Pan = masa;
        System.out.println("El panadero hornea el " + this.Pan);
        this.Disponible = true;
        notify();
    }

    public synchronized String Consumir(){
        while(!this.Disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El cliente consume el " + this.Pan);
        this.Disponible = false;
        return this.Pan;
    }
}

package APIServlet.Session.Lecciones.Models;

import APIServlet.Session.Lecciones.Configs.Calificadores.MisLogs;
import APIServlet.Session.Lecciones.Configs.Estereotipos.CarritoCompras;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/*@SessionScoped
@Named("carrito")*/
@CarritoCompras
public class Carrito implements Serializable {
        //Atributos de Carrito
    private List<ItemCarrito> Items;
    @Inject //Usar un modificador transient únicamente en los objetos de contexto SessionScoped o ConversationScoped que implementen la interfaz serializable
    @MisLogs/*@Named("misLogs")*/
    private transient Logger Log; //Un objeto Logger no se guarda en la sesión (no es serializable), por ende, se guarda con modificador de acceso transient

        //Constructores de Carrito
    public Carrito() {
        this.Items = new ArrayList<>();
    }

    //Asignadores de atributos de Carrito (setters)
        //Lectores de atributos de Carrito (getters)
    public List<ItemCarrito> getItems() {
        return this.Items;
    }
    @PostConstruct   //Se ejecuta luego de que se haya invocado al constructor
    public void Iniciar(){
        this.Items = new ArrayList<>();
        /*System.out.println("Iniciando el carrito de compras");*/
        this.Log.info("Iniciando el carrito de compras");
    }
    @PreDestroy
    public void Destruir(){ //Esta información se puede apreciar en los logs
        /*System.out.println("Destruyendo el carrito de compras");*/
        this.Log.info("Destruyendo el carrito de compras");
    }

        //Métodos de Carrito
    public void addItemCarrito(ItemCarrito Item){
        if (this.Items.contains(Item)){     //De aquí surge la necesidad de implementar el método equals en ÍtemCarrito
            Optional<ItemCarrito> OptionalItemCarro = this.Items.stream()
                    .filter(ic -> ic.equals(Item))
                    .findAny();
            if (OptionalItemCarro.isPresent()){
                ItemCarrito IC = OptionalItemCarro.get();
                IC.setCantidad(IC.getCantidad() + 1);
            }
        } else {
            this.Items.add(Item);
        }
    }

    /*public void removeÍtemCarrito(String ID){
       Optional<ItemCarrito> ItemCarritoChao = this.hallarProducto(ID);
        ItemCarritoChao.ifPresent(ic -> this.getItems().remove(ItemCarritoChao));
    }*/

    public int getTotal(){
        return this.Items.stream()
                .mapToInt(ItemCarrito::getImporte).sum();
    }

    public Optional<ItemCarrito> hallarProducto(String id){
        return this.Items.stream()
                .filter(ic -> Long.toString(ic.getProducto().getID()).equals(id))
                .findAny();
    }

    public void removeItemCarrito(String ID){
            //Verificar que el ID exista en la lista de productos
        Optional<ItemCarrito> ProductoChao = this.hallarProducto(ID);
            //Remover de la lista en caso de que esté presente
        ProductoChao.ifPresent(ic -> this.getItems().remove(ic));
    }

    public void removerProductos(List<String> IDs){
            //Obtener cada ID de manera individual, y remover ese producto de la lista
        if (IDs != null) {
            IDs.forEach(this::removeItemCarrito); //Todo porque el método removerProducto pertenece a esta clase
        }
    }

    public void ActualizarCantidad(String ID, int Cantidad){
            //Buscar el ÍtemCarrito a actualizar
        Optional<ItemCarrito> Actualizando = this.hallarProducto(ID);
            //Si existe, se le asigna la cantidad especificada por el usuario
        Actualizando.ifPresent(ic -> ic.setCantidad(Cantidad));  //Así se evita un NullPointerException
    }
}

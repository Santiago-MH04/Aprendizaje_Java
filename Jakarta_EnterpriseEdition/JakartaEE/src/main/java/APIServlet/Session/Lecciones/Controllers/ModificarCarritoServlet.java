package APIServlet.Session.Lecciones.Controllers;

import APIServlet.Session.Lecciones.Configs.Calificadores.ProductoServicePrincipal;
import APIServlet.Session.Lecciones.Models.*;
import APIServlet.Session.Lecciones.Service.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

@WebServlet({"/carrito/modificar-session", "/carrito/editar-session"})
public class ModificarCarritoServlet extends HttpServlet {
        //Atributos de ModificarCarritoServlet
    @Inject
    private Carrito Carro;
    @Inject /*@Named("defecto")*/
    @ProductoServicePrincipal
    private ProductoService Service;

    //Constructores de ModificarCarritoServlet
    //Asignadores de atributos de ModificarCarritoServlet (setter)
    //Lectores de atributos de ModificarCarritoServlet (getter)
        //Métodos de ModificarCarritoServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión
        /*Connection Conn = (Connection)req.getAttribute("conn");*/
        /*ProductoService Service = new ProductoServiceJDBCImpl(Conn);*/

        Long ID = Long.parseLong(req.getParameter("id"));    //Se obtiene el ID del producto seleccionado
        Optional<Producto> Productou = this.Service.PorID(ID);

        if (Productou.isPresent()){
            ItemCarrito Item = new ItemCarrito(Productou.get(), 1); //Escrito así, siempre va a estar presente
            /*HttpSession Sesión = req.getSession();*/
                //Usando Listeners, podemos iniciar el carrito en los atributos de la sesión
            /*Carrito Carro = (Carrito)Sesión.getAttribute("carrito");*/
            this.Carro.addItemCarrito(Item);
        }
        resp.sendRedirect(req.getContextPath() + "/carrito/ver");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*HttpSession Sesión = req.getSession();*/
        /*if(Sesión.getAttribute("carrito") != null){*/
            /*Carrito Carro = (Carrito)Sesión.getAttribute("carrito");*/
            this.ActualizarItems(req, this.Carro);
            this.ActualizarCantidades(req, this.Carro);
        /*}*/
        resp.sendRedirect(req.getContextPath() + "/carrito/ver");
    }

    private void ActualizarItems(HttpServletRequest req, Carrito carro) {
            //Actualizar un producto es borrar los seleccionados
            //Se obtienen los valores de todos los elementos cuya selección fue eliminar artículo
        String[] Eliminandos = req.getParameterValues("Eliminar");  //Se obtienen como valor, el ID del producto que se desea eliminar
            //Recorrer el arreglo de eliminandos
        if(Eliminandos != null && Eliminandos.length > 0){
            List<String> IDsChao = Arrays.asList(Eliminandos);
            carro.removerProductos(IDsChao);
        }
    }

    private void ActualizarCantidades(HttpServletRequest req, Carrito carro) {
        Enumeration<String> NombresParámetros = req.getParameterNames();        //Se obtienen indistintamente todos los nombres de los parámetros del formulario
            //Filtrar los que nos interesan, es decir, los que indican cantidades
        while (NombresParámetros.hasMoreElements()){
            String NombreParámetro = NombresParámetros.nextElement();
                //Se filtra si comienza con "canti_"
            if(NombreParámetro.startsWith("canti_")){
                String ID = NombreParámetro.substring(6); //Se remueve "canti_" y se queda con el ID, manejándolo como String, no Long
                String Cantidad = req.getParameter(NombreParámetro);    //Devuelve el valor asociado al parámetro con el nombre del argumento

                if (Cantidad != null){
                    carro.ActualizarCantidad(ID, Integer.parseInt(Cantidad));   //Actualiza la cantidad del ÍtemCarrito
                }
                if (Integer.parseInt(Cantidad) == 0){
                    carro.removeItemCarrito(ID);
                }
            }
        }
    }
}

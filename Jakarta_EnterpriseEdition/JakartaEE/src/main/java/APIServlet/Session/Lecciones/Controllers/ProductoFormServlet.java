package APIServlet.Session.Lecciones.Controllers;

import APIServlet.Session.Lecciones.Configs.Calificadores.ProductoServicePrincipal;
import APIServlet.Session.Lecciones.Models.*;
import APIServlet.Session.Lecciones.Service.ProductoService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/productos/form")
public class ProductoFormServlet extends HttpServlet {
        //Atributos de ProductoFormServlet
    @Inject /*@Named("defecto")*/
    @ProductoServicePrincipal
    private ProductoService Service;

    //Constructores de ProductoFormServlet
    //Asignadores de atributos de ProductoFormServlet (setter)
    //Lectores de atributos de ProductoFormServlet (getter)
        //Métodos de ProductoFormServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener conexión a la base de datos
        /*Connection Conn = (Connection)req.getAttribute("conn");*/
            //Obtener las categorías para el formulario
        /*ProductoService Service = new ProductoServiceJDBCImpl(Conn);*/

        Long ID;
        try {
            ID = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            ID = 0L;
        }
        Producto Prodotto = new Producto();
        Prodotto.setCategoria(new Categoria());
        if (ID > 0){
            Optional<Producto> OP = this.Service.PorID(ID);
            if (OP.isPresent()){
                Prodotto = OP.get();
            }
        }

            //Listar las categorías y obtener el ID de cada producto, en caso de editar
        req.setAttribute("categorias", this.Service.ListarCategoria());
        req.setAttribute("producto", Prodotto);
        req.setAttribute("titulum", req.getAttribute("titulum") + ": formulario de productos");
            //Redirigir al formulario con la vista
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión a la base de datos
        /*Connection Conn = (Connection)req.getAttribute("conn");*/
            //Jugar con el Service
        /*ProductoService Service = new ProductoServiceJDBCImpl(Conn);*/
            //Obtener los parámetros de un producto
        String Nombre = req.getParameter("nombre");

        Long ID;
        try {
            ID = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            ID = 0L;
        }

        Integer Precio;
        try {   //Este manejo de excepciones es atómico
            Precio = Integer.valueOf(req.getParameter("precio"));
        } catch (NumberFormatException e) {
            Precio = 0;
        }

        String SKU = req.getParameter("sku");

        String FechaString = null; //HTML 5 siempre envía las fechas en formato AAAA-MM-DD
        FechaString = req.getParameter("fecha_registro");

        Long CategoríaID;
        try {   //Este manejo de excepciones es atómico
            CategoríaID = Long.valueOf(req.getParameter("categoria"));  //En la vista, el valor del parámetro categoria corresponde a su ID
        } catch (NumberFormatException e) {
            CategoríaID = 0L;
        }

            //Guardar los mensajes de error
        Map<String, String> Errores = new HashMap<>();

        if (Nombre == null || Nombre.isBlank()){
            Errores.put("nombre", "Se requiere un nombre para el producto");
        }
        if (SKU == null || SKU.isBlank()){
            Errores.put("sku", "Se requiere un SKU para el producto");
        } else if (SKU.length() > 10){
            Errores.put("sku", "El SKU para el producto debe ocupar menos de 10 caracteres");
        }
        if (FechaString == null || FechaString.isBlank()){
            Errores.put("fecha_registro", "Se debe asignar una fecha de registro para el producto");
        }
        if (Precio.equals(0)){
            Errores.put("precio", "Se debe asignar un precio al producto");
        }
        if (CategoríaID.equals(0L)){
            Errores.put("categoria", "Es necesario elegir una categoría para el producto");
        }

            //Convertir la fecha a un tipo LocalDate, con su respectivo manejo de excepciones
        LocalDate Fecha;
        try {
            Fecha = LocalDate.parse(FechaString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            Fecha = null;
        }

            //Vamos a empezar a poblar un objeto de tipo producto
        Producto Prod = new Producto();
            Prod.setID(ID);
            Prod.setNombre(Nombre);
            Prod.setSKU(SKU);
            Prod.setPrecio(Precio);
            Prod.setFechaRegistro(Fecha);
        Categoria Cat = new Categoria();
            Cat.setID(CategoríaID);
            Prod.setCategoria(Cat);

        if (Errores.isEmpty()) {
                //Guardar el producto en la base de datos
            this.Service.Guardar(Prod);
                //Redirigir al formulario. Se hace esto por buenas prácticas
            resp.sendRedirect(req.getContextPath() + "/productos-session");
        } else {
            req.setAttribute("erroresP", Errores);
                //Listar las categorías y obtener el ID de cada producto, en caso de editar
            req.setAttribute("categorias", this.Service.ListarCategoria());
            req.setAttribute("producto", Prod);
            req.setAttribute("titulum", req.getAttribute("titulum") + ": formulario de productos");

                //Redirigir al formulario con la vista
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}

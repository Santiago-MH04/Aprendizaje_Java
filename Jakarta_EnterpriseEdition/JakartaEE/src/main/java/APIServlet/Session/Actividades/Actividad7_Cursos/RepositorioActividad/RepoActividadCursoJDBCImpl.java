package APIServlet.Session.Actividades.Actividad7_Cursos.RepositorioActividad;

import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores.LogsAct;
import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores.MySQLConnAct;
import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Estereotipos.Repositoriou;
import APIServlet.Session.Actividades.Actividad7_Cursos.ModelosActividad.Curso;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/*@ApplicationScoped*/
@Repositoriou
public class RepoActividadCursoJDBCImpl implements RepositorioActividad<Curso> {
        //Atributos de RepoActividadCursoJDBCImpl
    @Inject
    @MySQLConnAct
    private Connection ConnAct;
    @Inject
    @LogsAct
    private Logger LogAct;

        //Constructores de RepoActividadCursoJDBCImpl
    public RepoActividadCursoJDBCImpl() {
    }
        /*public RepoActividadCursoJDBCImpl(Connection connAct) {
            this.ConnAct = connAct; //Ya se hace uso del CDI
        }*/
        @PostConstruct
        public void IniciandoAndo(){
            this.LogAct.info("Creando un repositorio de " + this.getClass().getSimpleName() + " conectado a la base de datos");
        }

        @PreDestroy
        public void AcabandoAndo(){
            this.LogAct.info("Destruyendo el repositorio de " + this.getClass().getSimpleName() + " conectado a la base de datos");
        }

        //Asignadores de atributos de RepoActividadCursoJDBCImpl (setter)
    public void setConnAct(Connection connAct) {
        this.ConnAct = connAct;
    }

        //Lectores de atributos de RepoActividadCursoJDBCImpl (getter)
    public Connection getConnAct() {
        return this.ConnAct;
    }

        //Métodos de RepoActividadCursoJDBCImpl
    private static Curso CrearCurso(ResultSet rs) throws SQLException {
        Curso C = new Curso();
                //Poblar el objeto de tipo Curso
            C.setID(rs.getLong("ID"));
            C.setNombre(rs.getString("Nombre"));
            C.setDescripción(rs.getString("Descripción"));
            C.setInstructor(rs.getString("Instructor"));
            C.setLongevidad(rs.getDouble("Duración"));
        return C;
    }

    @Override
    public List<Curso> Listar() throws SQLException {
        List<Curso> Cursos = new ArrayList<>();

            //Obtener la conexión a la base de datos
        try (Statement Stmt = this.ConnAct.createStatement();
             ResultSet RS = Stmt.executeQuery("SELECT c.* FROM cursos as c")) {
                //Recorrer el cursor
            while (RS.next()) {
                Curso Cursinho = CrearCurso(RS);
                    //Añadir el curso a la lista
                Cursos.add(Cursinho);
            }
        }
        return Cursos;
    }

    @Override
    public List<Curso> PorNombre(String Nombre) throws SQLException {
        List<Curso> Cursos = new ArrayList<>();

            //Obtener la conexión a la base de datos
        try (PreparedStatement PS = this.ConnAct.prepareStatement("SELECT * FROM cursos as c WHERE c.Nombre like ?")) {
            PS.setString(1, "%" + Nombre + "%");    //Expresión regular para buscar coincidencias que contengan la palabra mágica
                //Recorrer el cursor
            try (ResultSet RS = PS.executeQuery()){
                while (RS.next()){
                    Curso Cursirijillo = CrearCurso(RS);
                        //Añadir el tal curso a la lista
                    Cursos.add(Cursirijillo);
                }
            }
        }
        return Cursos;
    }

    @Override
    public Curso PorID(Long id) throws SQLException {
        Curso Cursirijillo = null;
            try (PreparedStatement PS = this.ConnAct.prepareStatement("SELECT c.* FROM cursos as c WHERE c.ID = ?")){
                PS.setLong(1, id);
                    //Recorrer el cursor
                try (ResultSet RS = PS.executeQuery()) {
                        //Poblar el objeto de tipo curso
                    if (RS.next()){
                        Cursirijillo = CrearCurso(RS);
                    }
                }
            }
        return Cursirijillo;
    }

    @Override
    public void Guardar(Curso curso) throws SQLException {
            //Pre-preparar la sentencia
        String SQL;
            //Asignar la sentencia en caso de guardar, o modificar
        if (curso.getID() != null && curso.getID() > 0){
            SQL = "UPDATE cursos SET Nombre = ?, Descripción = ?, Instructor = ?, Duración = ? WHERE ID = ?";
        } else {
            SQL = "INSERT INTO cursos (Nombre, Descripción, Instructor, Duración) VALUES (?, ?, ?, ?)";
        }

        try (PreparedStatement PS = this.ConnAct.prepareStatement(SQL)){
                //Asignar los parámetros
            PS.setString(1, curso.getNombre());
            PS.setString(2, curso.getDescripción());
            PS.setString(3, curso.getInstructor());
            PS.setDouble(4, curso.getLongevidad());

            if (curso.getID() != null && curso.getID() > 0){
                PS.setLong(5, curso.getID());
            }
                //Ejecutar la acción
            PS.executeUpdate();
        }
    }

    @Override
    public void Eliminar(Long id) throws SQLException {
        try (PreparedStatement PS = this.ConnAct.prepareStatement("DELETE c.* FROM cursos as c WHERE c.ID = ?")) {
            PS.setLong(1, id);
            PS.executeUpdate();
        }
    }
}

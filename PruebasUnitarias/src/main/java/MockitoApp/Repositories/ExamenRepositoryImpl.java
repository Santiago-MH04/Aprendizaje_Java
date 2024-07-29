package MockitoApp.Repositories;

import MockitoApp.Models.Examen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExamenRepositoryImpl implements ExamenRepository{
    //Atributos de ExamenServiceImpl
    //Constructores de ExamenServiceImpl
    //Asignadores de atributos de ExamenServiceImpl (setter)
    //Lectores de atributos de ExamenServiceImpl (getter)

        //Métodos de ExamenServiceImpl
    @Override
    public List<Examen> findAll() {
        /*return Arrays.asList(new Examen(5L, "matemáticas"),
                             new Examen(6L, "lengua castellana"),
                             new Examen(7L, "Historia"));*/
        return Collections.emptyList();
    }

    @Override
    public Examen guardar(Examen Evaluación) {
        return null;
    }

    //Con Mockito, no se hace necesaria esta clase. Sin embargo, se deja como decoración
}

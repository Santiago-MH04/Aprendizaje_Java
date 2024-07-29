package MockitoApp.Repositories;


import MockitoApp.Models.Examen;

import java.util.List;

public interface ExamenRepository {
        //Métodos de ExamenRepository
    List<Examen> findAll();

    Examen guardar(Examen Evaluación);
}

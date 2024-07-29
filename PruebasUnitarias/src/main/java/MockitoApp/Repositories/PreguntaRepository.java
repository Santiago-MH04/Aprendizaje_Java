package MockitoApp.Repositories;

import java.util.List;

public interface PreguntaRepository {
        //Métodos de PreguntaRepository
    List<String> findPreguntasPorExamenID(Long ID);
    void guardarVarias(List<String> Preguntas);
}

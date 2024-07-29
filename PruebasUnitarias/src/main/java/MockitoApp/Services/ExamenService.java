package MockitoApp.Services;

import MockitoApp.Models.Examen;

import java.util.Optional;

public interface ExamenService {
        //Métodos de ExamenService
    Optional<Examen> findExamenPorNombre(String Nombre);
    Examen findExamenPorNombreConPreguntas(String Nombre);

    Examen guardar(Examen Quiz);
}

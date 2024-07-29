package MockitoApp.Services;

import MockitoApp.Models.Examen;
import MockitoApp.Repositories.ExamenRepository;
import MockitoApp.Repositories.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{
        //Atributos de ExamenServiceImpl
    private ExamenRepository repoExámenes;
    private PreguntaRepository repoPregunta;

        //Constructores de ExamenServiceImpl
    public ExamenServiceImpl(ExamenRepository repoExámenes) {
        this.repoExámenes = repoExámenes;
    }
    public ExamenServiceImpl(ExamenRepository repoExámenes, PreguntaRepository repoPregunta) {
        this(repoExámenes);
        this.repoPregunta = repoPregunta;
    }
    //Asignadores de atributos de ExamenServiceImpl (setter)
    //Lectores de atributos de ExamenServiceImpl (getter)
        //Métodos de ExamenServiceImpl
    @Override
    public Optional<Examen> findExamenPorNombre(String Nombre) {
        Optional<Examen> ExamenOptional =  repoExámenes.findAll().stream()
                .filter(e -> e.getNombre().contains(Nombre))
                .findFirst();
        /*Examen Quiz = null;
        if(ExamenOptional.isPresent()){
            Quiz = ExamenOptional.orElseThrow();
        }*/
        return ExamenOptional;
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String Nombre) {
        Optional<Examen> ExamenOptional = findExamenPorNombre(Nombre);
        Examen Quiz = null;
        if(ExamenOptional.isPresent()){
            Quiz = ExamenOptional.orElseThrow();
            List<String> Preguntas = repoPregunta.findPreguntasPorExamenID(Quiz.getID());
            Quiz.setPreguntas(Preguntas);
        }
        return Quiz;
    }

    @Override
    public Examen guardar(Examen Quiz) {
        if(!Quiz.getPreguntas().isEmpty()){
            repoPregunta.guardarVarias(Quiz.getPreguntas());
        }
        return repoExámenes.guardar(Quiz);
    }
}

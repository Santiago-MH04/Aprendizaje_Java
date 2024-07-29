package MockitoApp;

/*import org.Santiago.Mockito.Ejemplos.Models.Examen;
import org.Santiago.Mockito.Ejemplos.Repositories.ExamenRepository;
import org.Santiago.Mockito.Ejemplos.Repositories.ExamenRepositoryImpl;
import org.Santiago.Mockito.Ejemplos.Repositories.PreguntaRepository;*/

import MockitoApp.Models.Examen;
import MockitoApp.Repositories.ExamenRepository;
import MockitoApp.Repositories.PreguntaRepository;
import MockitoApp.Services.ExamenServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //Esta anotación hace lo mismo que el método MockitoAnnotations.openMocks(this)
class ExamenServiceImplTest {
        //Atributos de ExamenServiceImplTest
            //Mocks
    @Mock
    ExamenRepository Repository;
    @Mock
    PreguntaRepository preguntaRepository;
            //Services
        //ExamenService Service;
    @InjectMocks
    ExamenServiceImpl Service;  //Debe ser del tipo concreto, pues la interfaz no se inyecta

        //Métodos de ExamenServiceImplTest
            //Ciclo de vida de las pruebas
    @BeforeEach
    void setUp() {  //De creación manual o del contexto de inyección de dependencias de Mockito
        //ExamenRepository Repository = new ExamenRepositoryImpl();             //Se vale simular usando Mockito, mayor robustez
        //ExamenRepository Repository = Mockito.mock(ExamenRepository.class);   //Importación explícita
        /*this.Repository = mock(ExamenRepository.class);         //Importación estática
        this.preguntaRepository = mock(PreguntaRepository.class);
        this.Service = new ExamenServiceImpl(Repository, preguntaRepository);*/

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findExamenPorNombre() {
            //Pruebas usando Mockito
        when(Repository.findAll()).thenReturn(Datos.EXÁMENES); //Se simula, y se implementa Datos
                                                               // en el método findAll()
                                                               // cuando suceda
        Optional<Examen> Evaluación = Service.findExamenPorNombre("matemáticas");

            //Pruebas
        assertNotNull(Evaluación);
        assertTrue(Evaluación.isPresent());
        Long IDRealidad = Evaluación.orElseThrow().getID();
        Long IDExpectativa = 5L;
        assertEquals(IDExpectativa, IDRealidad);
        String nombreExpectativa = "matemáticas";
        String nombreRealidad = Evaluación.get().getNombre();
        assertEquals(nombreExpectativa, nombreRealidad);
    }

    @Test
    void findExamenPorNombreListaVacía() {
            //Pruebas usando Mockito
        List<Examen> Datos = Collections.emptyList();

        when(Repository.findAll()).thenReturn(Datos); //Se simula, y se implementa Datos
                                                      // en el método findAll()
                                                      // cuando suceda
        Optional<Examen> Evaluación = Service.findExamenPorNombre("matemáticas");
            //Pruebas
        assertFalse(Evaluación.isPresent());
    }

    @Test
    void pruebaPreguntasExamen() {
        when(Repository.findAll()).thenReturn(Datos.EXÁMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen Evaluación = Service.findExamenPorNombreConPreguntas("matemáticas");

        int Expectativa = 3;
        int Realidad = Evaluación.getPreguntas().size();
        assertEquals(Expectativa, Realidad);
        assertTrue(Evaluación.getPreguntas().contains("aritmética"));
    }

    @Test
    void pruebaPreguntasExamenVerify() {
        when(Repository.findAll()).thenReturn(Datos.EXÁMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen Evaluación = Service.findExamenPorNombreConPreguntas("matemáticas");

        int Expectativa = 3;
        int Realidad = Evaluación.getPreguntas().size();
        assertEquals(Expectativa, Realidad);
        assertTrue(Evaluación.getPreguntas().contains("aritmética"));
        verify(Repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(anyLong());
    }

    @Test
    void pruebaNoExisteExamenVerify() {
        when(Repository.findAll()).thenReturn(Collections.emptyList());
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen Evaluación = Service.findExamenPorNombreConPreguntas("matemáticas");

        assertNull(Evaluación);     //Debería pasar la prueba, está entregando una lista vacía
        verify(Repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(anyLong()); //Y este es el que debería fallar
    }

    @Test
    void PruebaGuardarExamen() {    //Se programa impulsado al desarrollo (Behaviour Development Driven, o BDD)
            //Given
        Examen nuevoQuiz = Datos.EXAMEN;
            nuevoQuiz.setPreguntas(Datos.PREGUNTAS);

        when(Repository.guardar(any(Examen.class))).then(new Answer<Examen>(){
                //Atributos de la implementación anónima
            Long secuencia = 8L;

            @Override
            public Examen answer(InvocationOnMock invocationOnMock) throws Throwable {
                Examen examen = invocationOnMock.getArgument(0);
                examen.setID(secuencia++);
                return examen;
            }
        });
            //When
        Examen miQuiz = Service.guardar(nuevoQuiz);
            //Then
        assertNotNull(miQuiz.getID());
        assertEquals(8L, miQuiz.getID());
        assertEquals("Física",miQuiz.getNombre());

        verify(Repository).guardar(any(Examen.class));
        verify(preguntaRepository).guardarVarias(anyList());
    }
}
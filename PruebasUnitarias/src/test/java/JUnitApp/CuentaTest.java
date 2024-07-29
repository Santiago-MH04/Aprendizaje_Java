package JUnitApp;

import JUnitApp.Exceptions.DineroInsuficienteException;
import JUnitApp.Models.Banco;
import JUnitApp.Models.Cuenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //Así, se genera una única instancia de la prueba,
                                                // y los métodos con @BeforeAll y @AfterAll ya pueden
                                                // ser no estáticos. Práctica no recomendada
public class CuentaTest {
        //Atributos de CuentaTest
    Cuenta cuenta;
    TestInfo InfoPrueba;
    TestReporter ReporPrueba;

        //Métodos de CuentaTest
    @BeforeAll  //Pertenece a la clase CuentaTest, y no a las instancias, por ser estático. Se ejecuta antes de la creación de la instancia
    /*static*/ void beforeAll() {
        System.out.println("Iniciando el conjunto de pruebas");
    }

    @BeforeEach //Esto sirve para reutilizar código, que da miedo
    void InitMétodosTest(TestInfo infoPrueba, TestReporter reporPrueba){
        this.cuenta = new Cuenta("Pepito Pérez", new BigDecimal("8888.777765"));
        this.InfoPrueba = infoPrueba;
        this.ReporPrueba = reporPrueba;

        System.out.println("Iniciando método de prueba");
        reporPrueba.publishEntry("Ejecutando -" + infoPrueba.getDisplayName() + "- " + infoPrueba.getTestMethod().orElse(null).getName() +
                " bajo las etiquetas " + infoPrueba.getTags());
    }

    @AfterEach
    void FiniMétodosTest() {
        System.out.println("Finalizando la ejecución del método de prueba");
    }

    @AfterAll
        /*static*/ void afterAll() {
        System.out.println("Finalizando el conjunto de pruebas");
    }

    @Tag("Cuenta")  //Una clase puede tener varias etiquetas, y estas anotaciones son tremendamente útiles
    @Nested
    @DisplayName("Pruebas de los atributos de la cuenta")
    class PruebasCuentaNombreMonto{
        //Métodos de PruebasCuentaNombreMonto
        @Test
        @DisplayName("Nombre")
        void PruebaNombreCuenta() { //Probar que la persona funcione a toda máquina
            ReporPrueba.publishEntry(InfoPrueba.getTags().toString());  //Todos los reportes van de tipo String, con timeStamp incluido
            if(InfoPrueba.getTags().contains("Cuenta")){
                System.out.println("Verificando una que otra cosita de la cuenta");
            }

            String Expectativa = "Pepito Pérez";
            String Realidad = cuenta.getPersona();
            assertNotNull(Realidad, () -> "La cuenta no puede ser nula");   //Con la expresión lambda, se deja un futuro, más eficiente

            //Assertions.assertEquals(Expectativa, Realidad);   //Importando la clase Assertions
            assertEquals(Expectativa, Realidad,         //Importando el método estático de la clase Assertions
                    () -> "El nombre del titular de la cuenta no es el esperado");
            assertTrue(Expectativa.equals(Realidad),
                    () -> "El nombre esperado y el real deden ser iguales"); //Un tris modificado, personalizado
        }

        @Test
        @Disabled //Así me aseguro, por ejemplo, que esta prueba no se ejecuta
        @DisplayName("Saldo (no nulo, y mayor que cero)")
        void PruebaSaldoCuenta() {
            //Cuenta cuenta = new Cuenta();
            //this.cuenta = new Cuenta("Quesocolo", new BigDecimal("1000.12345"));
            assertNotNull(cuenta.getSaldo());

            BigDecimal Expectativa = new BigDecimal("1000.12345");
            BigDecimal Realidad = cuenta.getSaldo();

            //Assertions.assertEquals(Expectativa, Realidad);       //Importando la clase Assertions
            assertEquals(1000.12345, Realidad.doubleValue());  //Importando el método estático de la clase Assertions
            assertFalse(Realidad.compareTo(BigDecimal.ZERO) < 0);   //El saldo debe ser mayor o igual que cero
            assertTrue(Realidad.compareTo(BigDecimal.ZERO) > 0);    //El saldo debe ser mayor o igual que cero
        }

        @Test
        @DisplayName("Referencia")
        void PruebaReferenciaCuenta() {
            //this.cuenta = new Cuenta("Pepito Pérez", new BigDecimal("8888.777765"));
            Cuenta cuenta2 = new Cuenta("Pepito Pérez", new BigDecimal("8888.777765"));

            //assertNotEquals(cuenta2, cuenta);
            assertEquals(cuenta2, cuenta);  //El método equals hace magia
        }
    }

    @Tag("Operación")
    @Nested
    class PruebasOperacionesCuenta{
            //Métodos de PruebasOperacionesCuenta
        @Test
        void PruebaDébitoCuenta() {
            cuenta = new Cuenta("Pepa Pombo", new BigDecimal("1000.12345"));
            cuenta.Débito(new BigDecimal(100));

            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());                //Para devolver la parte entera del BigDecimal
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());   //Para comparar decimales del BigDecimal
        }

        @RepeatedTest(value = 5, name = "Repetición # {currentRepetition}/{totalRepetitions}")    //Así, se pueden repetir pruebas.
            // Indicado para aquellas sujetas a aleatoriedad
        void PruebaCréditoCuenta(RepetitionInfo Info) {
            if(Info.getCurrentRepetition() == 4){
                System.out.println("Bienvenido a la " + Info.getCurrentRepetition() + "° repetición");
            }
            cuenta = new Cuenta("Pepa Pombo", new BigDecimal("1000.12345"));
            cuenta.Crédito(new BigDecimal(100));

            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
        }

        @Tag("Operación")
        @Tag("Error")
        @Test
        void PruebaDineroInsuficienteException() {
            //fail();
            cuenta = new Cuenta("Pepa Pombo", new BigDecimal("1000.12345"));
            Exception Excepción = assertThrows(DineroInsuficienteException.class, () -> {
                cuenta.Débito(new BigDecimal(1500));
            });
            String Realidad = Excepción.getMessage();
            String Expectativa = "Dinero insuficiente en su cuenta";

            assertEquals(Expectativa, Realidad);
        }

        @Test
        void PruebaTransferirDineroCuentas() {
            Cuenta Origen = new Cuenta("Pepito Pérez", new BigDecimal("2500"));
            Cuenta Destino = new Cuenta("Fulanito de Tal", new BigDecimal("1500.8989"));

            Banco Banquito = new Banco();
            Banquito.setNombre("MeGustaElDinero");
            Banquito.Transferir(Origen, Destino, new BigDecimal("500"));

                //Comparación unitaria de la prueba
            assertEquals("2000", Origen.getSaldo().toPlainString());
            assertEquals("2000.8989", Destino.getSaldo().toPlainString());
        }

        @Tag("Cuenta")
        @Tag("Banco")
        @Test
        @DisplayName("Probando relaciones entre el banco y las cuentas usando el método assertAll()")
        void PruebaRelaciónBancoCuentas() {
            Cuenta Origen = new Cuenta("Pepito Pérez", new BigDecimal("2500"));
            Cuenta Destino = new Cuenta("Fulanito de Tal", new BigDecimal("1500.8989"));

            Banco Banquito = new Banco();
            Banquito.setNombre("Banco McPato");
            Banquito.addCuenta(Origen);
            Banquito.addCuenta(Destino);

            Banquito.Transferir(Origen, Destino, new BigDecimal("500"));

                //Pruebas desacopladas (expresiones lambda del tipo supplier)
            String BancoExpectativa = "Banco McPato";
            String BancoRealidad = Origen.getBanco().getNombre();
            String TitularExpectativa = "Pepito Pérez";
            assertAll(
                        /*Comparación unitaria de la prueba*/
                    () -> {assertEquals("2000", Origen.getSaldo().toPlainString());},
                    () -> {assertEquals("2000.8989", Destino.getSaldo().toPlainString());},
                        /*¿Qué relación habrá entre el banco y las cuentas*/
                    ()-> {assertEquals(BancoExpectativa, BancoRealidad);},
                    () -> {assertEquals(TitularExpectativa, Banquito.getCuentas().stream()
                            .filter(c -> c.getPersona().equals(TitularExpectativa))
                            .findFirst()
                            .get().getPersona());},
                    () -> {assertTrue(Banquito.getCuentas().stream()
                            .anyMatch(c -> c.getPersona().equals(TitularExpectativa)));},
                        /*¿Cuántas cuentas tendrá el banco?*/
                    () -> {assertEquals(2, Banquito.getCuentas().size());}
            );
        }
    }

    @Tag("Parametrizadas")
    @Nested
    class PruebasParametrizadas{
        @ParameterizedTest(name = "Repetición #{index} con valor {0} - {argumentsWithNames}")   //{0} y {argumentsWithNames} dan el valor actual ejecutado en la parametrización
        @ValueSource(strings = {"100", "200", "500", "800", "1000"})
        void PruebaDébitoCuentaParametrizadoValueSource(String Monto) {    //El argumento es del mismo tipo de los parámetros
            cuenta = new Cuenta("Pepa Pombo", new BigDecimal("1000.12345"));
            cuenta.Débito(new BigDecimal(Monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Repetición #{index} con valor {argumentsWithNames}")
        @CsvSource({"1, 100", "2, 200", "3, 500", "4, 800", "5, 1000"}) //Par índice-valor separado con comas
        void PruebaDébitoCuentaParametrizadoCSVSource(String Index, String Monto) {    //El argumento es del mismo tipo de los parámetros
            System.out.println(Index + ": " + Monto);   //Para verificar la prueba
            cuenta = new Cuenta("Pepa Pombo", new BigDecimal("1000.12345"));
            cuenta.Débito(new BigDecimal(Monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Repetición #{index} con valor {argumentsWithNames}")
        @CsvSource({"200, 100, Queso, Queso", "250, 200, Cocacolo, Cocacolo",
                "499, 500, Manuela, Manuelas", "700, 800, Flor, Floooor",
                "5000, 1000, Iván Elías, "})
        void PruebaDébitoCuentaParametrizadoCSVSource2(String Saldo, String Monto, String Expectativa, String Realidad) {    //El argumento es del mismo tipo de los parámetros
            System.out.println("Saldo(" + Saldo + ") -> Monto(" + Monto + ")");   //Para verificar la prueba
            cuenta.setPersona(Realidad);
            String NomReal = cuenta.getPersona();
            cuenta.setSaldo(new BigDecimal(Saldo));
            cuenta.Débito(new BigDecimal(Monto));

            boolean NombresCompara = NomReal.equals(Expectativa);
            assumingThat(NombresCompara, () ->{
                assertNotNull(cuenta.getSaldo());
                assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
            });
        }

        @ParameterizedTest(name = "Repetición #{index} con valor {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        void PruebaDébitoCuentaParametrizadoCSVFileSource(String Monto) {    //El argumento es del mismo tipo de los parámetros
            cuenta = new Cuenta("Pepa Pombo", new BigDecimal("1000.12345"));
            cuenta.Débito(new BigDecimal(Monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "Repetición #{index} con valor {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.csv")
        void PruebaDébitoCuentaParametrizadoCSVFileSource2(String Saldo, String Monto, String Expectativa, String Realidad) {    //El argumento es del mismo tipo de los parámetros
            System.out.println("Saldo(" + Saldo + ") -> Monto(" + Monto + ")");   //Para verificar la prueba
            cuenta.setPersona(Realidad);
            String NomReal = cuenta.getPersona();
            cuenta.setSaldo(new BigDecimal(Saldo));
            cuenta.Débito(new BigDecimal(Monto));

            boolean NombresCompara = NomReal.equals(Expectativa);
            assumingThat(NombresCompara, () ->{
                assertNotNull(cuenta.getSaldo());
                assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
            });
        }

        @ParameterizedTest(name = "Repetición #{index} con valor {argumentsWithNames}")
        @MethodSource("montoLista") //Una prueba así con @MethodSource debe ir siempre en la raíz del proyecto
        void PruebaDébitoCuentaParametrizadoMethodSource(String Monto) {    //El argumento es del mismo tipo de los parámetros
            cuenta = new Cuenta("Pepa Pombo", new BigDecimal("1000.12345"));
            cuenta.Débito(new BigDecimal(Monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
        private static List<String> montoLista(){
            return Arrays.asList("100", "200", "500", "800", "1000");
        }
    }

    @Nested
    class PruebasSistemaOperativo{
            //Métodos de PruebasSistemaOperativo
        @Test
        @EnabledOnOs(OS.WINDOWS)
        void PruebaSóloWindows() {
        }
        @Test
        @DisabledOnOs(OS.WINDOWS)
        void PruebaNoWindows() {
        }

        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})    //Esta vaina es atómica (sólo pasa al ejecutar la clase)
        void PruebaSóloLinuxMac() {
        }
    }

    @Nested
    class PruebasVersiónJava{
            //Métodos de PruebasVersiónJava
        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void PruebaSóloJDK8() {
        }

        @Test
        @DisabledOnJre(JRE.JAVA_19) //Que no se ejecute en Java 19
        void PruebaNoJDK19() {
        }

        @Test
        @DisabledOnJre(JRE.JAVA_22) //Que no se ejecute en Java 22
        void PruebaNoJDK22() {
        }
    }

    @Nested
    class PruebasPropiedadesSistema{
            //Métodos de PruebasPropiedadesSistema
        @Test
        void PruebaImprimirPropiedades() {
            Properties PropiedadesSistema = System.getProperties();
            PropiedadesSistema.forEach((k, v) -> System.out.println(k + ": " + v));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = ".*19.*")    //Se puede dejar la literal, o,
                                                                                // como en este caso, usando una expresión regular
        void PruebaVersiónJava() {
        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
        void PruebaSólo64bits() {
        }

        @Test
        @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
        void PruebaSólo32bits() {
        }

        @Test
        @EnabledIfSystemProperty(named = "user.name", matches = "Santiago")
        void PruebaUsuarioSistema() {
        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void PruebaDesarrollo() {   //Cuidadito Mike Wazowski, y configurar esas variables de entorno
        }
    }

    @Nested
    class PruebasVariablesEntorno{
            //Métodos de PruebasVariablesEntorno
        @Test
        void PruebaImprimirVariablesEntorno() {
            Map<String, String> PropiedadesEntorno = System.getenv();
            PropiedadesEntorno.forEach((k, v) -> System.out.println(k + ": " + v));
        }
        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-19.*") //Por si se rompe la cadena de la ruta
        void PruebaJavaHome() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void PruebaProcesadores() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENTORNO", matches = "DEV")
        void PruebaEnt() {
        }
        @Test
        @DisabledIfEnvironmentVariable(named = "ENTORNO", matches = "PROD")
        void PruebaEntProd() {
        }
    }

    @Nested
    @Tag("Configuraciones")
    class PruebasPropiedadesSistemaEditadas{
            //Métodos de EdiciónConfiguraciones
        @Test
        void PruebaSaldoCuentaDev() {
            boolean esDev = "dev".equals(System.getProperty("ENV"));
            assertNotNull(cuenta.getSaldo());
            Assumptions.assumeTrue(esDev);  //Importando la clase Assumptions
            //assumeTrue(esDev);        //Importando el método estático de la clase Assumptions

            BigDecimal Expectativa = new BigDecimal("1000.12345");
            BigDecimal Realidad = cuenta.getSaldo();

            assertEquals(8888.777765, Realidad.doubleValue());
            assertFalse(Realidad.compareTo(BigDecimal.ZERO) < 0);   //El saldo debe ser mayor o igual que cero
            assertTrue(Realidad.compareTo(BigDecimal.ZERO) > 0);    //El saldo debe ser mayor o igual que cero
        }

        @Test
        void PruebaSaldoCuentaDev2() {      //Para ejecutar porciones de la prueba con la suposición
            boolean esDev = "dev".equals(System.getProperty("ENV"));
            assumingThat(esDev, () -> {     //Así, se ejecutan bloques de la prueba
                assertNotNull(cuenta.getSaldo());

                BigDecimal Expectativa = new BigDecimal("1000.12345");
                BigDecimal Realidad = cuenta.getSaldo();

                assertEquals(8888.777765, Realidad.doubleValue());
                assertFalse(Realidad.compareTo(BigDecimal.ZERO) < 0);   //El saldo debe ser mayor o igual que cero
                assertTrue(Realidad.compareTo(BigDecimal.ZERO) > 0);    //El saldo debe ser mayor o igual que cero
            });
        }
    }

    @Nested
    @Tag("TimeOut")
    class PruebasTimeOut{
        @Test
        @Timeout(5) //Este argumento siempre es un número entero (por defecto en segundos)
        void PruebaTimeOut() throws InterruptedException {
            TimeUnit.SECONDS.sleep(6);
        }

        @Test
        @Timeout(value = 500, unit = TimeUnit.MILLISECONDS) //Este argumento siempre es un número entero
        void PruebaTimeOut2() throws InterruptedException {
            TimeUnit.SECONDS.sleep(6);
        }

        @Test
        void PruebasTimeOutAssertions() {
            assertTimeout(Duration.ofSeconds(5), () -> {
                TimeUnit.MILLISECONDS.sleep(5500);
            });
        }
    }
}
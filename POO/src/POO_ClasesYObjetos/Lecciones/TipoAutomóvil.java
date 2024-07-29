package POO_ClasesYObjetos.Lecciones;

public enum TipoAutomóvil {
    SEDÁN("Sedán","Carro mediano", 4),
    STATION_WAGON("Station Wagon", "Carro grande", 5),
    COUPÉ("Coupé", "Carro pequeño", 2),
    HATCHBACK("Hatchback", "Carro compacto", 5),
    PICKUP("Pick up", "Camioneta", 4),
    CONVERTIBLE("Convertible", "Carro deportivo", 2),
    FURGÓN("Furgón", "Carro utilitario", 2),
    SUV("SUV", "Todoterreno deportivo", 5);

        //Atributos del enumerador
    private final String nombre;
    private final String descripción;
    private final int númeroPuertas;

        //Constructor de los atributos
    TipoAutomóvil(String nombre, String descripción, int númeroPuertas) {
        this.nombre = nombre;
        this.descripción = descripción;
        this.númeroPuertas = númeroPuertas;
    }

        //Lectura de los atributos con el getter
    public String getNombre() {
        return nombre;
    }
        public String getDescripción() {
            return descripción;
        }
            public int getNúmeroPuertas() {
            return númeroPuertas;
        }
}

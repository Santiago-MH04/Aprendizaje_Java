package POO_ClasesYObjetos.Lecciones;

public class Automóvil implements Comparable <Automóvil>{
        //Los atributos de la clase automóvil son:
    private int ID;
    private String Fabricante;
    private String Modelo;
    private Color color = Color.GRIS;
    private Motor motor;
    private Estanque estanque;
    private Persona conductor;
    private Rueda[] ruedas;
    private int índiceRuedas;

    private static Color ColorPatente = Color.NARANJA;
    private TipoAutomóvil tipo;
    private static int capacidadEstanqueEstático = 50;
    private static int últimoID;


    public static final Integer VELOCIDAD_MAX_CARRETERA = 120;
    public static final int VELOCIDAD_MAX_URBANO = 60;

    public static final String COLOR_AMARILLO = "Amarillo";
    public static final String COLOR_AZUL = "Azul";
    public static final String COLOR_ROJO = "Rojo";
    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_GRIS = "Gris";


        //Sobrecarga del constructor
            //Constructor del objeto vacío
    public Automóvil(){
        this.ID = ++últimoID;
        this.ruedas = new Rueda[5];
    }
        //Constructor del objeto con 2 parámetros
    public Automóvil(String fabricante, String modelo){
        this();
        this.Fabricante = fabricante;
        this.Modelo = modelo;
    }
        //Constructor del objeto con 3 parámetros
    public Automóvil(String fabricante, String modelo, Color color){
        this(fabricante, modelo);
        this.color = color;
    }
        //Constructor del objeto con 4 parámetros
    public Automóvil(String fabricante, String modelo, Color color, Motor motor) {
        this(fabricante, modelo, color);
        this.motor = motor;
    }
        //Constructor del objeto con 5 parámetros
    public Automóvil(String fabricante, String modelo, Color color, Motor motor, Estanque estanque) {
        this(fabricante, modelo, color, motor);
        this.estanque = estanque;
    }
        //Sobrecarga del constructor con los atributos que hemos creado
    public Automóvil(String fabricante, String modelo, Color color, Motor motor, Estanque estanque, Persona conductor, Rueda[] ruedas) {
        this(fabricante, modelo, color, motor, estanque);
        this.conductor = conductor;
        this.ruedas = ruedas;
    }

        //Métodos para leer y asignar los atributos
    public String getFabricante(){
        return this.Fabricante;
    }
        public String getModelo(){return this.Modelo;}
            public Color getColor(){
                return this.color;
            }
            public Motor getCilindraje(){ return this.motor;}
                public Estanque getCapacidadEstanque(){
                    if(estanque == null){
                        this.estanque = new Estanque();
                    }
                    return this.estanque;
                }
                    public static Color getColorPatente(){return ColorPatente;}

                        public static int getCapacidadEstanqueEstático() { return capacidadEstanqueEstático; }
                            public int getID() {return this.ID;}
                                public TipoAutomóvil getTipo() { return tipo;}
                                    public Motor getMotor() {return motor;}
                                        public Persona getConductor() {return conductor;}
                                            public Rueda[] getRuedas() {return ruedas;}

        //Métodos para asignar valor a los atributos
    public void setFabricante(String fabricante){
        this.Fabricante = fabricante;
    }
        public void setModelo(String modelo){
            this.Modelo = modelo;
        }
            public void setColor(Color color){
                this.color = color;
            }
                public void setCapacidadEstanque(int capacidadEstanque){
                    this.estanque = estanque;
                }
                    public static void setColorPatente(Color colorPatente){
                        Automóvil.ColorPatente = colorPatente;
                    }
                        public static void setCapacidadEstanqueEstático(int capacidadEstanqueEstático) {
                            Automóvil.capacidadEstanqueEstático = capacidadEstanqueEstático;
                        }
                            public void setID(int ID) {
                                this.ID = ID;
                            }
                                public void setTipo(TipoAutomóvil tipo) {
                                    this.tipo = tipo;
                                }
                                    public void setMotor(Motor motor) {
                                        this.motor = motor;
                                    }
                                        public void setConductor(Persona conductor) {
                                            this.conductor = conductor;
                                        }
                                            public void setRuedas(Rueda[] ruedas) {
                                                this.ruedas = ruedas;
                                            }

        //Métodos de la clase Automóvil
    public Automóvil addRueda(Rueda rueda){
        if(índiceRuedas < this.ruedas.length){
            this.ruedas[índiceRuedas++] = rueda;
        }
        return this;
    }

    public String detalle(){
        //This hace referencia al objeto que se modifica con este método, es súper útil, aunque también se puede omitir (cuidadongos con eso)
        String unDetalle = "Fabricante = " + this.Fabricante +
                "\nModelo = " + this.Modelo;
        if(this.getTipo() != null){
            unDetalle += "\nTipo = " + this.getTipo().getDescripción() ;
        }
        unDetalle += "\nPOO_ClasesYObjetos.Color = " + this.color;
        if(this.motor != null){
            unDetalle += "\nCilindraje = " + this.motor.getCilindraje() ;
        }
        unDetalle += "\nPOO_ClasesYObjetos.Color Patente = " + Automóvil.ColorPatente +
                "\nID automóvil = " + this.ID;
        if(this.getConductor() != null){
            unDetalle += "\nConductor: " + this.getConductor();
        }
        if(getRuedas() != null){
            unDetalle += "\nRuedas del automóvil " + this.getFabricante() + " " + this.getModelo() + ":";
        }
        for (Rueda r : this.getRuedas()){
            unDetalle += "\n" + "Fabricante: " + r.getFabricante() + "; rin [\"]: " + r.getRin() + "; ancho [\"]: " +r.getAncho();
        }
        return unDetalle;
    }

    public String acelerar (int rpm){
        return "El automóvil " + this.Fabricante + " " + this.Modelo + " acelera a " + rpm + " rpm";
    }

    public String frenar(){
        return "El automóvil " + this.Fabricante + " " + this.Modelo + " está frenando";
    }

    public String acelerarFrenar (int rpm){
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }

    public float calcularRendimiento (int km, float porcentajeCombustible){
        return km/(this.getCapacidadEstanque().getCapacidad()*porcentajeCombustible);
    }

    public float calcularRendimiento (int km, int porcentajeCombustible){
        return km/(this.getCapacidadEstanque().getCapacidad()*(porcentajeCombustible/100f));
    }

    public static float calcularRendimientoEstático (int km, int porcentajeCombustible){
        return km/(Automóvil.capacidadEstanqueEstático*(porcentajeCombustible/100f));
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Automóvil)){
            return false;
        }

        Automóvil a = (Automóvil)obj;
        return (this.Fabricante != null && this.Modelo != null &&
                this.Fabricante.equals(a.getFabricante()) &&
                this.Modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {
        return this.ID + ": " + this.Fabricante + " " + this.Modelo;
                /*"POO_ClasesYObjetos.Automóvil{" +
                "Fabricante:'" + this.Fabricante + '\'' +
                ", Modelo:'" + this.Modelo + '\'' +
                ", POO_ClasesYObjetos.Color:'" + this.color + '\'' +
                ", Cilindraje:" + this.motor +
                ", capacidadEstanque:" + this.estanque +
                ", ID:" + this.ID +
                '}';*/
    }
    @Override
    public int compareTo(Automóvil A) {
        return this.Fabricante.compareTo(A.Fabricante);
    }
}

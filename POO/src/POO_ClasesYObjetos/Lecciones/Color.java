package POO_ClasesYObjetos.Lecciones;

public enum Color {
    AMARILLO("Amarillo"),
    AZUL("Azul"),
    ROJO("Rojo"),
    GRIS("Rojo"),
    BLANCO("Blanco"),
    NARANJA("Naranja");

        //Atributo para personalizar el color
    private final String color;

        //Constructor para el atributo color
    Color(String color) {
        this.color = color;
    }

        //Getter para el atributo color
    public String getColor() {
        return color;
    }

        //Método para el atributo color (para que muestre los colores con la primera letra mayúscula, el resto minúsculas)
    @Override
    public String toString() {
        return this.color;
    }
}

package ClasesWrapper;

public class WrapperInteger {
    public static void main(String[] args) {
            //Convertir un primitivo a un objeto de referencia
        int unPrimitivo = 12345;
        Integer intObjeto1 = Integer.valueOf(unPrimitivo);
        Integer intObjeto2 = unPrimitivo;
        System.out.println("intObjeto1 = " + intObjeto1);

            //Convertir un objeto de referencia a primitivo
        int intPrmitivo1 = intObjeto1;
        int intPrimitivo2 = intObjeto1.intValue();
        System.out.println("intPrimitivo2 = " + intPrimitivo2);

        String strNúmero = "89000";
        Integer intNúmero = Integer.valueOf(strNúmero);
        System.out.println("intNúmero = " + intNúmero);

        Short srtUnPrimitivo = intObjeto1.shortValue();
        System.out.println("srtUnPrimitivo = " + srtUnPrimitivo);

        Byte bytUnPrimitivo = intObjeto1.byteValue();
        System.out.println("bytUnPrimitivo = " + bytUnPrimitivo);

        long longReferencia = intObjeto1.longValue();
        System.out.println("longReferencia = " + longReferencia);
    }
}

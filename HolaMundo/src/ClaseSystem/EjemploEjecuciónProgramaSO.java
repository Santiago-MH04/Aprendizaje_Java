package ClaseSystem;

public class EjemploEjecuciónProgramaSO {
    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();
        Process miProceso;

        try{
            if (System.getProperty("os.name").toLowerCase().startsWith("windows")){
                miProceso = rt.exec("notepad");
            } else if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
                miProceso = rt.exec("textedit");
            } else if (System.getProperty("os.name").toLowerCase().contains("nux") || System.getProperty("os.name").toLowerCase().contains("nix")) {
                miProceso = rt.exec("gedit");
            } else {
                miProceso = rt.exec("gedit");
            }
            miProceso.waitFor();
        } catch (Exception e){
            System.err.println("El comando es desconocido " + e.getMessage());
            System.exit(1);
        }
        System.out.println("El editor se ha cerrado");
    }
}

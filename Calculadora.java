public class Calculadora {

    /**
     * Evalua una expresion matemática
     * 
     * @param expresion Representación como string de la expresión matemática a
     *                  evaluar
     * @return
     */
    public static Racional evaluarExpresion(String expresion) {
        // TODO completar
        return null;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usar java Calculadora <expresion>");
            System.out.println("Ej: java Calculadora '+ 1R2 2R3'");
        } else {
            System.out.println(evaluarExpresion(args[0]));
        }
    }
}

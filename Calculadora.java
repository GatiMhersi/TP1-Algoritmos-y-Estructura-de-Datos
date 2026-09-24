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

        /**
         * Flujo de ejecucion:
         * 1. Verificacion de simbolos en la expresion
         * 2. Creacion de la pila
         * 3. Guardado de la expresion pasado como parametro separando por " "(el espacio)
         * 4. Comenzamos iteracion
         * 5. revisamos si el elemento actual No es un operador
         *      si no lo es, convertimos a racional y apilamos
         * 6. si el elemento es un operador
         *      desapilamos 2, hacemos operacion correspondiente al operador y volvemos a apilar
         * 7. iteramos Hasta que no nos queden mas valores en el arreglo que guardaba las partes de la expresion separadas por coma
         * 8. revisamos que el balance este correcto, que implica que no habia mas numeros que los que deberia
         * 9. retornamos elemento que quedo en la pila, que deberia ser el ultimo
         * 
         * */

        //Validamos que no se hayan metido simbolos que no Correspondan
        if (!expresion.matches("[+\\-*/0-9R ]+")) {
            throw new IllegalArgumentException("La expresión contiene caracteres no permitidos.");
        }

        //Creacion de pila que guardara numeros Racionales
        Pila<Racional> numeros = new PilaDoblementeEnlazada<>();  


        //Guardamos en un arreglo todos los valores(operadores y numeros en formato string), separandolo por espacios
        //Balance es utilizado para verificar que los valores esten 
        //en el orden correcto y al final que la pila solo guarda un operador
        String[] arregloExpresion = expresion.split(" ");
        int balance = 0;
        //Comenzamos a iterar, de atras para adelante, sobre el arreglo
        for(int i = arregloExpresion.length - 1; i >= 0; i--){

            //elem representa el elemento sobre el que se esta trabajando en el for
            String elem = arregloExpresion[i];


            //Caso en el que elem no sea un operador(es decir, es un numero, que puede ser entero o racional)
            if(!"+-*/".contains(elem)){
                balance++; // Un número aumenta la cantidad de elementos en 1

                //Creamos el objeto para guardar elem ya convertido en un objeto Racional
                Racional numeroRacionalActual;

                //Caso en el que elem es un NUMERO RACIONAL
                /**
                 * elem es un string, como todo string tiene 
                 * el metodo contains, que devuelve true si 
                 * el simbolo ingresado como argumento esta en la cadena
                 * */
                 if(elem.contains("R")){

                    //Separacion de enteros dentro del numero racional
                    /**
                     * el metodo split retorna un arreglo donde todos 
                     * los elementos del arreglo guardados estan 
                     * separado por el simbolo que le pasas como paramtro
                     * */
                     String[] arregloRacionalActual= elem.split("R");

                    //se asigna a numeroRacional, el nuevo numero Racional
                    /**
                     * La clase Integer, tiene un metodo llamado parseInt,
                     * que se encarga de convertir un conjunto de caracteres
                     * en su correspondiente entero, toma como argumento
                     * el string a convertir, en este caso un string
                     * */
                     numeroRacionalActual = new RacionalConEnteros(Integer.parseInt(arregloRacionalActual[0]), Integer.parseInt(arregloRacionalActual[1]));

                //Caso en el que elem es un Numero entero (debemos convertirlo a racional)
                 }else{
                    /**asignamos un nuevo Racional, a numeroRacionalActual,
                     * que guarda como numerador el elem, convertido a int, 
                     * y como denominador un 1
                     * */
                     numeroRacionalActual = new RacionalConEnteros(Integer.parseInt(elem), 1);
                 }

                //Apilar numeroRacional en la pila de numeros
                 numeros.apilar(numeroRacionalActual);

            //Caso que elem sea un operador u otro Valor
             }else{
                balance--; // Un operador reduce la cantidad de elementos en 1

                //Creacion de objetos auxiliares, para operar
                Racional a,b ;

                //Revisamos que tipo de operador es elem
                switch(elem){

                    //Cuando es suma
                case "+":

                        //desapilamos y guardamos en a, obtenemos tope y le sumamos a
                        //no altera la cuenta porque la suma es conmutativa
                        //no necesitamos apilar porque estamos trabajando directamente en el objeto de la pila
                    a = numeros.desapilar();
                    b = numeros.tope();
                    b.suma(a);
                    break;

                    //Cuando es Resta
                case "-":

                        //Desapilamos, guardamos en a
                        //Desapilamos, guardamos en b
                        //operamos sobre a que guarda el numero que esta mas cerca del operador
                        //apilamos a ya modificado
                        /**
                         * Es necesario desapilar ambos y apilar el 
                         * resultado de ambos porque no podemos 
                         * trabajar desde el tope(operando mas lejano al operador)
                         * */
                         a = numeros.desapilar();
                         b = numeros.desapilar();
                         a.suma(b.neg());
                         numeros.apilar(a);
                         break;

                    //Cuando es multiplicacion
                     case "*":

                        //Desapilamos, guaramos en a
                        //obtenemos tope, lo asignamos a b
                        //operamos sobre b
                        /**
                         * No es necesario desapilar ambos porque 
                         * la multiplicacion es conmutativa y no 
                         * es necesario saber cual operando esta mas cerca del operador
                         * */
                         a = numeros.desapilar();
                         b = numeros.tope();
                         b.mult(a);
                         break;

                    //Cuando es Division
                     case "/":

                        //Desapilamos, guardamos en a
                        //Desapilamos, guardamos en b
                        //operamos sobre a(operando mas cercano al operador)
                        //apilamos a ya operado
                        a = numeros.desapilar();
                        b = numeros.desapilar();
                        a.div(b);
                        numeros.apilar(a);
                        break;

                    }


                }
            }

        // Al terminar, solo debe quedar exactamente 1 resultado (balance == 1)
        if (balance != 1) {
            throw new IllegalArgumentException("Expresión inválida: sobran números en la expresión.");
        }


        /**
         * Retornamos Resultante, es decir, 
         * el ultimo valor que quedo en la pila, 
         * luego de iterar sobre toda la expresion valor por valor
         * */
         return numeros.desapilar();

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

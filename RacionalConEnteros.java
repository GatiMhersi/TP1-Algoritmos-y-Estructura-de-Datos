public class RacionalConEnteros implements Racional{
	private int numerador;
	private int denominador;

	/**
	 *  Hola profe, le escribo por una duda sobre la interfaz Racional. 
	 * Si yo implemento mi clase RacionalConEnteros, en el método suma(Racional r) 
	 * no tengo forma de leer el valor de r a través de la interfaz. 
	 * Si en un futuro existiera otra clase que implemente la interfaz 
	 * (por ejemplo, un RacionalConComa que guarde un 0.5), no sabría cómo sumarlo. 
	 * ¿La idea es que asumamos que el argumento r siempre va a ser de nuestra 
	 * misma clase y trabajemos directamente con sus variables privadas? 
	 * */
	 	

	/**
     * Operacion para suma racionales
     * Suma a la instancia actual el racional r.
     */
	 public void suma(Racional r){
        //  0.  (2 / 3) + (3 / 2)
        //  ↓   Multiplicar denominadores para tener denominador comun
        //  ↓   Multiplicar numeradores con numerador contrario
        //  1.  (4 / 6) + (9 / 6)
        //  ↓   Sumar numeradores por tener igual denominador
        //  ↓   se mantiene el denominador
        //  2.  (13 / 6)


        r.numerador *= denominador;
        denominador *= r.denominado;
        numerador = (numerador * r.denominador) + r.numerador;
        

	 }

    /**
     * Operacion para multiplicacion de racionales
     * Multiplica la instancia actual con el racional r.
     */
    public void mult(Racional r);{

        numerador *= r.numerador;
        denominador *= r.denominador;

    }

    /**
     * Representa la resta unaria.
     * 
     * operacion para resta de racionales: A-B = A+B.neg()
     * 
     * Ej (2/4).neg() == -2/4
     * (-2/4).neg() == 2/4
     */
    public void neg(){

        numerador *= -1;

    }

    /**
     * Operacion para dividir racionales
     * Divide la instancia actual por el racional r
     * Ej: r1.div(r2) == r1/r2
     */
    public void div(Racional r){
        if (r.numerador == 0) throw new IllegalArgumentException("Para dividir, tu numerador no puede ser cero");

        numerado *= r.denominador;
        denominador *= r.numerador;

    }

    /**
     * Invariante de representacion, chequea que el denominador sea diferente de 0
     */
    public boolean repOk(){
        return !(denominador==0);
    }

    /**
     * Retorna una representacion del racional de la forma 
     * "numerador/denominador"
     */
    public String toString(){
        return numerador + "/" + denominador;
    }

}
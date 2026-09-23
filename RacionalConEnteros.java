public class RacionalConEnteros implements Racional{
	private int numerador;
	private int denominador;

    public RacionalConEnteros(){
        numerador = 0;
        denominador = 1;
    }
	 	

	/**
     * Operacion para suma racionales
     * Suma a la instancia actual el racional r.
     */
	 public void suma(Racional r){
        if(r.denominador == 0) throw new IllegalArgumentException("Denominador es cero");
        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");
        //  0.  (2 / 3) + (3 / 2)
        //  ↓   Multiplicar denominadores para tener denominador comun
        //  ↓   Multiplicar numeradores con denominador contrario
        //  1.  (4 / 6) + (9 / 6)
        //  ↓   Sumar numeradores por tener igual denominador
        //  ↓   se mantiene el denominador
        //  2.  (13 / 6)

        r.numerador = denominador * r.numerador;
        numerador = r.denominador * numerador;
        numerador = r.numerador + numerador;
        denominador = r.denominador * denominador;

        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");
        
	 }

    /**
     * Operacion para multiplicacion de racionales
     * Multiplica la instancia actual con el racional r.
     */
    public void mult(Racional r);{
        if(r.denominador) throw new IllegalArgumentException("Denominador es cero");
        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");

        numerador = numerador * r.numerador;
        denominador = denominador * r.denominador;

        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");
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
        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");

        numerador = numerador * (-1);

        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");
    }

    /**
     * Operacion para dividir racionales
     * Divide la instancia actual por el racional r
     * Ej: r1.div(r2) == r1/r2
     */
    public void div(Racional r){
        if (r.denominador == 0) throw new IllegalArgumentException("Denominador es cero");
        if (r.numerador == 0) throw new IllegalArgumentException("Denominador Final Cero");
        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");


        numerado = numerador * r.denominador;
        denominador = denominador * r.numerador;

        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");
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
        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");
        return numerador + "/" + denominador;
        if(!RepOk()) throw new IllegalStateException("No se cumple invariante de clase");
    }

}
public class RacionalConEnteros implements Racional{
	private int numerador;
	private int denominador;

    public RacionalConEnteros(){
        numerador = 0;
        denominador = 1;
    }

    public RacionalConEnteros(int numerador, int denominador){
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero al crear un Racional.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }
	 	

	/**
     * Operacion para suma racionales
     * Suma a la instancia actual el racional r.
     */
	 public void suma(Racional r){
        RacionalConEnteros numeroNuevo = (RacionalConEnteros) r;
        if(numeroNuevo.denominador == 0) throw new IllegalArgumentException("Denominador es cero");
        if(!repOk()) throw new IllegalStateException("No se cumple invariante de clase");
        
        this.numerador = (numeroNuevo.numerador * this.denominador) + (this.numerador * numeroNuevo.denominador);
        this.denominador = numeroNuevo.denominador * this.denominador;


        if(!repOk()) throw new IllegalStateException("No se cumple invariante de clase");
        
	 }

    /**
     * Operacion para multiplicacion de racionales
     * Multiplica la instancia actual con el racional r.
     */
    public void mult(Racional r){
        RacionalConEnteros numeroNuevo = (RacionalConEnteros) r;
        if(numeroNuevo.denominador == 0) throw new IllegalArgumentException("Denominador es cero");
        if(!repOk()) throw new IllegalStateException("No se cumple invariante de clase");
        
        numerador = numerador * numeroNuevo.numerador;
        denominador = denominador * numeroNuevo.denominador;

        if(!repOk()) throw new IllegalStateException("No se cumple invariante de clase");
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
        if(!repOk()) throw new IllegalStateException("No se cumple invariante de clase");

        numerador = numerador * (-1);

        if(!repOk()) throw new IllegalStateException("No se cumple invariante de clase");
    }

    /**
     * Operacion para dividir racionales
     * Divide la instancia actual por el racional r
     * Ej: r1.div(r2) == r1/r2
     */
    public void div(Racional r){
        RacionalConEnteros numeroNuevo = (RacionalConEnteros) r;
        if (numeroNuevo.denominador == 0) throw new IllegalArgumentException("Denominador es cero");
        if (numeroNuevo.numerador == 0) throw new IllegalArgumentException("Denominador Final Cero");
        if(!repOk()) throw new IllegalStateException("No se cumple invariante de clase");


        this.numerador = this.numerador * numeroNuevo.denominador;
        this.denominador = this.denominador * numeroNuevo.numerador;

        if(!repOk()) throw new IllegalStateException("No se cumple invariante de clase");
    }

    /**
     * Invariante de representacion, chequea que el denominador sea diferente de 0
     */
    public boolean repOk(){
        return denominador != 0;
    }

    /**
     * Retorna una representacion del racional de la forma 
     * "numerador/denominador"
     */
    public String toString(){
        if (!repOk()) throw new IllegalStateException("No se cumple invariante de clase");

        return numerador + "R" + denominador;

    }

}
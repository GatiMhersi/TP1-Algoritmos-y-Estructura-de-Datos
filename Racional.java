/**
 * Una interface simple de los racionales
 * La idea principal es que un racional es un par compuesto
 * por numerador/denominador, el denominador debe ser diferente 0
 * 
 * NOTA: RECORDAR que todas las operaciones modifican la instancia actual.
 * r1.suma(r2) el resultado queda guardado en la instancia r1
 */
public interface Racional {
    /**
     * Operacion para suma racionales
     * Suma a la instancia actual el racional r.
     */
    public void suma(Racional r);

    /**
     * Operacion para multiplicacion de racionales
     * Multiplica la instancia actual con el racional r.
     */
    public void mult(Racional r);

    /**
     * Representa la resta unaria.
     * 
     * operacion para resta de racionales: A-B = A+B.neg()
     * 
     * Ej (2/4).neg() == -2/4
     * (-2/4).neg() == 2/4
     */
    public void neg();

    /**
     * Operacion para dividir racionales
     * Divide la instancia actual por el racional r
     * Ej: r1.div(r2) == r1/r2
     */
    public void div(Racional r);

    /**
     * Invariante de representacion, chequea que el denominador sea diferente de 0
     */
    public boolean repOk();

    /**
     * Retorna una representacion del racional de la forma 
     * "numerador/denominador"
     */
    public String toString();
}

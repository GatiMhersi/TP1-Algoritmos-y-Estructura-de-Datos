public interface Pila<T> {

    /**
     * Retorna el tope de la pila, si ésta no es vacía.
     * 
     * @return tope de la pila
     * @throws IllegalStateException si la pila está vacía
     * @see #esVacia()
     */
    public T tope() throws IllegalStateException;

    /**
     * Permite evaluar si la pila no tiene elementos.
     * 
     * @return true sii la pila no tiene elementos
     */
    public boolean esVacia();

    /**
     * Apila un elemento en el tope de la pila.
     * 
     * @param elem el elemento a apilar
     * @throws IllegalStateException si la pila está llena
     * @return true sii el elemento pudo ser apilado
     */
    public void apilar(T elem) throws IllegalStateException;

    /**
     * Desapila el tope de la pila, y retorna el elemento desapilado, si ésta no es
     * vacía.
     * 
     * @return tope de la pila
     * @throws IllegalStateException si la pila está vacía
     * @see #esVacia()
     */
    public T desapilar() throws IllegalStateException;

    /**
     * Imprime por la salida estandar los elementos almacenados en la pila, usando
     * una estrategia LIFO.
     * Es decir, primero se muestra el último elemento ingresado (tope).
     */
    public void imprimir();
}
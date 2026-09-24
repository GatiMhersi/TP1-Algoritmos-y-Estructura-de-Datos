public class NodoPila<T> {

    private NodoPila<T> prev;
    private T item;
    private NodoPila<T> next;

    /**
     * Construye un nuevo nodo
     * 
     * @param prev el nodo previo del nuevo nodo
     * @param item el item o valor a guardar en el nuevo nodo
     * @param next el nodo siguiente del nuevo nodo
     */
    public NodoPila(NodoPila<T> prev, T item, NodoPila<T> next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }

    /**
     * Un getter para el prev
     * 
     * @return el nodo previo
     */
    public NodoPila<T> getPrev() {
        return this.prev;
    }

    /**
     * Un getter para el item
     * 
     * @return el item asociado al nodo
     */
    public T getItem() {
        return this.item;
    }

    /**
     * Un getter para el next
     * 
     * @return el sucesor del nodo
     */
    public NodoPila<T> getNext() {
        return this.next;
    }

    /**
     * Un setter para el prev
     * 
     * @param prev el nodo previo
     */
    public void setPrev(NodoPila<T> prev) {
        this.prev = prev;
    }

    /**
     * Un setter para el item
     * 
     * @param item el item a ser agregado al nodo
     */
    public void setItem(T item) {
        this.item = item;
    }

    /**
     * Un setter para el next
     * 
     * @param next el siguiente del nodo
     */
    public void setNext(NodoPila<T> next) {
        this.next = next;
    }
}
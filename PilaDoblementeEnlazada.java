public class PilaDoblementeEnlazada<T> implements Pila<T> {

    private NodoPila<T> inicio;
    private NodoPila<T> fin;

    PilaDoblementeEnlazada() {
        this.inicio = null;
        this.fin = null;
    }

    @Override
    public boolean esVacia() {
        return this.inicio == null && this.fin == null;
    }

    @Override
    public T tope() throws IllegalStateException {
        // TODO Implementar este método y eliminar la línea siguiente
        if (esVacia()){
            throw new IllegalStateException("La pila esta vacia");
        }
        return fin.getItem();
    }

    @Override
    public void apilar(T elem) throws IllegalStateException {
        // TODO Implementar este método y eliminar la línea siguiente
        NodoPila<T> nuevo = new NodoPila<T>(fin, elem, null);
        if (esVacia()) {
            this.inicio = nuevo;
        } else {
            fin.setNext(nuevo);
        }
        this.fin = nuevo;
    }

    @Override
    public T desapilar() throws IllegalStateException {
        // TODO Implementar este método y eliminar la línea siguiente
        if (esVacia()){
            throw new IllegalStateException("La pila esta vacia");
        }
        T item = this.fin.getItem();
        fin = fin.getPrev();
        if (fin == null) {
            inicio = null;
        } else {
            fin.setNext(null);
        }
        return item;
    }

    @Override
    public void imprimir() {
        imprimirDesde(fin);
    }
 
    private void imprimirDesde(NodoPila<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getItem());
            imprimirDesde(nodo.getPrev());
        }
    }
 
}
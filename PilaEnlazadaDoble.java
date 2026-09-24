public class PilaEnlazadaDoble<T> implements Pila<T> {

    private NodoPila<T> inicio;
    private NodoPila<T> fin;

    public PilaEnlazadaDoble() {
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
        if(esVacia()) throw new IllegalStateException("Pila Vacia");
        return fin.getItem();
    }

    @Override
    public void apilar(T elem) throws IllegalStateException {
        // TODO Implementar este método y eliminar la línea siguiente
        NodoPila nuevo;

        if(esVacia()){
            nuevo = new NodoPila<T>(null, elem, null);
            inicio = nuevo;
            fin = nuevo;
        }else{
            nuevo = new NodoPila(fin, elem, null);
            fin.setNext(nuevo);    
        }

    }

    @Override
    public T desapilar() throws IllegalStateException {
        // TODO Implementar este método y eliminar la línea siguiente
        if(esVacia()) throw new IllegalStateException("Pila Vacia");

        T item = this.fin.getItem();

        if(inicio == fin){
            this.fin = null;
            this.inicio = null;
        }else{
            this.fin.getPrev().setNext(null);
            this.fin = this.fin.getPrev();    
        }
        
        return item;
    }

    @Override
    public void imprimir() {
        // TODO Implementar este método y eliminar la línea siguiente
        NodoPila<T> aux = this.fin;
        while(aux == null){
            System.out.println(aux.getItem());
            aux = aux.getPrev();
        }


    }

}
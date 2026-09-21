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
        return fin.getItem();
        throw new UnsupportedOperationException("Unimplemented method 'tope'");
    }

    @Override
    public void apilar(T elem) throws IllegalStateException {
        // TODO Implementar este método y eliminar la línea siguiente
        NodoPila nuevo = new NodoPila(fin, elem, null);
        fin.setNext(nuevo);
        throw new UnsupportedOperationException("Unimplemented method 'apilar'");
    }

    @Override
    public T desapilar() throws IllegalStateException {
        // TODO Implementar este método y eliminar la línea siguiente
        this.fin.getPrev.setNext(null);
        this.fin = this.fin.getPrev;
        throw new UnsupportedOperationException("Unimplemented method 'desapilar'");
    }

    @Override
    public void imprimir() {
        // TODO Implementar este método y eliminar la línea siguiente

        private void recursividad(NodoPila<T> nuevo){
            if(nuevo.getPrev() != null){
                System.out.println(nuevo.getItem());
                recursividad(nuevo.getPrev());
            }
        }

        recursividad(fin);
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }

}
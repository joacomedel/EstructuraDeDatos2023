package estructuras.jerarquicas.dinamicas;


public class NodoArbol {
    private Object elem;
    private NodoArbol hijoIzq = null;
    private NodoArbol hijoDer = null;
    public NodoArbol (Object elem,NodoArbol izq,NodoArbol der){
        this.elem = elem;
        this.hijoIzq = izq;
        this.hijoDer = der;
    }
    public NodoArbol (Object elem){
        this.elem = elem;
    }
    public NodoArbol getDer() {
        return hijoDer;
    }
    public Object getElem() {
        return elem;
    }
    public NodoArbol getIzq() {
        return hijoIzq;
    }
    public void setDer(NodoArbol der) {
        this.hijoDer = der;
    }
    public void setElem(Object elem) {
        this.elem = elem;
    }
    public void setIzq(NodoArbol izq) {
        this.hijoIzq = izq;
    }
}

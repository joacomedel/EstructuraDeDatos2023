package estructuras.jerarquicas.dinamicas;

public class NodoGen {
    private Object elem;
    private NodoGen hijoIzq = null;
    private NodoGen herDer = null;
    public NodoGen(Object elem, NodoGen izq , NodoGen der){
        this.elem = elem;
        this.hijoIzq = izq;
        this.herDer = der;
    }
    public NodoGen(Object elem){
        this.elem = elem;
    }
    public Object getElem() {
        return elem;
    }
    public NodoGen getDer() {
        return herDer;
    }
    public NodoGen getIzq() {
        return hijoIzq;
    }
    public void setElem(Object elem) {
        this.elem = elem;
    }
    public void setDer(NodoGen herDer) {
        this.herDer = herDer;
    }
    public void setIzq(NodoGen hijoIzq) {
        this.hijoIzq = hijoIzq;
    }
}

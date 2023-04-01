package estructuras.lineales.dinamicas;

public class Nodo {
    private Object elem;
    private Nodo enlace = null;
    public Nodo(Object elem,Nodo nodo) {
        this.elem = elem;
        this.enlace = nodo;
    }
    public Nodo(Object elem) {
        this.elem = elem;
    }
    public Object getElem() {
        return elem;
    }
    public Nodo getEnlace() {
        return enlace;
    }
    public void setElem(Object elem) {
        this.elem = elem;
    }
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
}

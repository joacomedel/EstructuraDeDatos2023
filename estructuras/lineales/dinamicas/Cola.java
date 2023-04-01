package estructuras.lineales.dinamicas;



public class Cola {
    private Nodo frente;
    private Nodo fin;
    public boolean poner(Object obj) {
        if (obj != null) {
            if (frente == null) {
                frente = new Nodo(obj);
                fin = frente;
            }else{
                fin.setEnlace(new Nodo(obj));
                fin = fin.getEnlace();
            }
        }
        return true;
    }
    public boolean sacar(){
        boolean retorna = frente != null;
        if (retorna) {
            frente = frente.getEnlace();
            if (frente == null) {
                fin = null;
            }
        }
        return retorna;
    }
    public Object obtenerFrente(){
        Object obj = null;
        if (frente != null) {
            obj = frente.getElem();
        }
        return obj;
    }
    public boolean esVacia(){
        return frente == null;
    }
    public void vaciar(){
        frente = null;
        fin = null;
    }
    public Cola clone(){
        Cola cola = new Cola();
        if (frente != null){
            cola.frente = new Nodo(frente.getElem());
            cola.fin = cola.frente;
            cloneAux(frente.getEnlace(),cola);
        }
        return cola;
    }
    public void cloneAux(Nodo nodo,Cola cola){
        if (nodo != null) {
            cola.fin.setEnlace(new Nodo(nodo.getElem()));
            cola.fin = cola.fin.getEnlace();
            cloneAux(nodo.getEnlace(), cola);
        }
    }
    public String toString() {
        String cadena = "[|";
        Nodo temp = this.frente;
        while (temp != null) {
            cadena = cadena + temp.getElem() + "|";
            temp = temp.getEnlace();
        }
        cadena = cadena + "]";
        return cadena;
    }
    
}

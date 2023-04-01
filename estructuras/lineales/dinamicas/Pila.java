package estructuras.lineales.dinamicas;

public class Pila {
    private Nodo tope;
    
    public boolean apilar(Object obj) {
        tope = new Nodo(obj,tope);
        return true;
    }
    public boolean desapilar(){
        boolean retorna = tope != null; 
        if (retorna) {
            tope = tope.getEnlace();
        }
        return retorna;
    }
    public Object obtenerTope(){
        Object obj = null;
        if (tope != null) {
            obj = tope.getElem();
        }
        return obj;
    }
    public boolean esVacia(){
        return tope == null;
    }
    public void vaciar(){
        tope = null;
    }
    public Pila clone(){
        Pila pila = new Pila();
        cloneAux(tope,pila);
        return pila;
    }
    private void cloneAux(Nodo nodo,Pila pila){
        if (nodo != null) {
            cloneAux(nodo.getEnlace(), pila);
            pila.tope = new Nodo(nodo.getElem(),pila.tope);
        }
    }
    public String toString () {
        String cadena;
        cadena = "]";
        Nodo nodoTemp = this.tope;
        while (nodoTemp !=null) {
            cadena = nodoTemp.getElem() + "|" + cadena  ; 
            nodoTemp = nodoTemp.getEnlace();
        }
        cadena = "[|"+cadena;
        return cadena;
      }
}

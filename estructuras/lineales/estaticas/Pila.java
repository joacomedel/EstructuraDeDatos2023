package estructuras.lineales.estaticas;
public class Pila {
    private final int tamanio = 10;
    private Object arreglo[] = new Object[tamanio];
    private int tope = -1;
    public boolean apilar(Object object) {
        boolean retorna = tope < tamanio-1;
        if (retorna) {
            tope++;
            arreglo[tope] = object; 
        }
        return retorna;
    }
    public boolean desapilar(){
        boolean retorna = tope > -1;
        if (retorna) {
            arreglo[tope] = null;
            tope--;
        }
        return retorna;
    }  
    public Object obtenerTope(){
        Object retorna = null;
        if (tope > -1) {
            retorna = arreglo[tope];
        }
        return retorna;
    }
    public boolean esVacia(){
        return tope == -1;
    }
    public void vaciar(){
        arreglo = new Object[tamanio-1];
        tope = -1;
    }
    public Pila clone(){
        Pila pila = new Pila();
        for (int i = 0; i < tamanio; i++) {
            pila.arreglo[i] = this.arreglo[i];
            pila.tope = this.tope;
        }
        return pila;
    }
    public String toString() {
        String cadena;
        cadena = "(|";
        int i =  0;
        while (i <= this.tope) {
            cadena = cadena + this.arreglo[i] + "|";
            i++;
        }
        cadena = cadena + ")";
        return cadena;
    }
}

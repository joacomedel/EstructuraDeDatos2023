package estructuras.lineales.estaticas;


public class Cola {
    private final int tamanio = 10;
    private Object arreglo[] = new Object[tamanio];
    private int frente = 0;
    private int fin = 0;
    
    public boolean poner(Object obj){
        boolean retorna = (fin + 1) % tamanio != frente;
        if (retorna) {
            arreglo[fin] = obj;
            fin = (fin+1) % tamanio;
        }
        return retorna;
    }
    public boolean sacar(){
        boolean retorna = frente != fin;
        if(retorna){
            arreglo[frente] = null;
            frente = (frente+1) % tamanio;
        }
        return retorna;
    }
    public Object obtenerFrente(){
        return arreglo[frente];
    }
    public boolean esVacia(){
        return fin == frente;
    }
    public void vaciar(){
        arreglo = new Object[tamanio];
        frente = 0;
        fin = 0;
    }
    public Cola clone(){
        Cola cola = new Cola();
        for (int i = frente; i != fin; i = (i+1) % tamanio) {
            cola.arreglo[i] = this.arreglo[i];
        }
        cola.frente = frente;
        cola.fin = fin;
        return cola;
    }
    public String toString() {
        String cadena ="[|";
        for (int i = frente; i != fin; i = (i+1) % tamanio) {
            cadena = cadena + this.arreglo[i] + "|";
        }
        cadena = cadena + "]";
        return cadena;
    }
}   

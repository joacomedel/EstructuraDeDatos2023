package estructuras.jerarquicas.dinamicas;

import estructuras.lineales.dinamicas.Cola;
import estructuras.lineales.dinamicas.Lista;

public class ArbolBin {
    private NodoArbol raiz;

    public ArbolBin() {

    }

    public boolean insertar(Object elem, Object objPadre, char posc) {
        boolean retorna = false;
        if (raiz == null) {
            retorna = true;
            raiz = new NodoArbol(elem);
        } else {
            NodoArbol padre = obtenerNodo(raiz, objPadre);
            if (padre != null) {
                if (posc == 'I' && padre.getIzq() == null) {
                    padre.setIzq(new NodoArbol(elem));
                    retorna = true;
                } else if(posc == 'D' && padre.getDer() == null) {
                    padre.setDer(new NodoArbol(elem));
                    retorna = true;
                }
            }
        }
        return retorna;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public int altura() {
        return buscarAltura(raiz, -1);
    }

    private int buscarAltura(NodoArbol nodo, int nivelNodo) {
        int alturaMaxima = -1;
        int altMaximaSubArboles;
        if (nodo != null) {
            nivelNodo++;
            // La altura maxima entre subArboles Derecho y Izquierdo
            altMaximaSubArboles = Math.max(buscarAltura(nodo.getIzq(), nivelNodo),
                    buscarAltura(nodo.getDer(), nivelNodo));
            if (alturaMaxima < altMaximaSubArboles) {
                alturaMaxima = altMaximaSubArboles;
            } else if (alturaMaxima < nivelNodo)
                alturaMaxima = nivelNodo;
        }
        return alturaMaxima;
    }

    public int nivel(Object obj){
        int retorna = -1;
        retorna = nivelAux(raiz, obj);
        return retorna;
    }
    private int nivelAux(NodoArbol nodo, Object obj) {
        int retorna = -1;
        if (nodo != null) {
            if (obj.equals(nodo.getElem())) {
                retorna = 0;
            } else {
                retorna = nivelAux(nodo.getIzq(), obj);
                if (retorna == -1) {
                    retorna = nivelAux(nodo.getDer(), obj);
                }
                if (retorna != -1) {
                    retorna++;
                }

            }
        }
        return retorna;
    }
    public Object padre(Object obj){
        Object retorna = null;
        if (this.raiz != null  && !this.raiz.getElem().equals(obj)) {
            retorna = padreAux(this.raiz , obj);
        }
        return retorna;
    }
    private Object padreAux(NodoArbol nodo , Object obj){
        Object retorna = null;
        boolean encontro = false;
        if (nodo.getIzq()!=null) {
            encontro = nodo.getIzq().getElem().equals(obj);
            if (encontro) {
                retorna = nodo.getElem();
            }else{
                retorna = padreAux(nodo.getIzq(), obj);
            }
        }
        if (retorna == null) {
            if (nodo.getDer()!=null) {
                encontro = nodo.getDer().getElem().equals(obj);
                if (encontro) {
                    retorna = nodo.getElem();
                }else{
                    retorna = padreAux(nodo.getDer(), obj);
                }
            }
        }
        return retorna;
    }
    public void vaciar() {
        raiz = null;
    }

    public ArbolBin clone() {
        ArbolBin arbol = new ArbolBin();
        if (raiz != null) {
            arbol.raiz = new NodoArbol(raiz.getElem());
            cloneAux(arbol.raiz, this.raiz);
        }
        return arbol;
    }

    private void cloneAux(NodoArbol nodoClon, NodoArbol nodoArbol) {
        if (nodoArbol.getIzq() != null) {
            nodoClon.setIzq(new NodoArbol(nodoArbol.getIzq().getElem()));
            cloneAux(nodoClon.getIzq(), nodoArbol.getIzq());
        }
        if (nodoArbol.getDer() != null) {
            nodoClon.setDer(new NodoArbol(nodoArbol.getDer().getElem()));
            cloneAux(nodoClon.getDer(), nodoArbol.getDer());
        }
    }

    public Lista listarPreorden() {
        Lista lista = new Lista();
        listarPreOrdenAux(this.raiz, lista);
        return lista;
    }

    private void listarPreOrdenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            lista.insertar(nodo.getElem(), lista.longitud());
            listarPreOrdenAux(nodo.getIzq(), lista);
            listarPreOrdenAux(nodo.getDer(), lista);
        }
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        listarPosordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            listarPosordenAux(nodo.getIzq(), lista);
            listarPosordenAux(nodo.getDer(), lista);
            lista.insertar(nodo.getElem(), lista.longitud());
        }
    }

    public Lista listarInorden() {
        Lista lista = new Lista();
        listarInordenAux(this.raiz, lista);
        return lista;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            listarInordenAux(nodo.getIzq(), lista);
            lista.insertar(nodo.getElem(), lista.longitud());
            listarInordenAux(nodo.getDer(), lista);
        }
    }

    public Lista listarPorNiveles() {
        Lista lista = new Lista();
        Cola cola = new Cola();
        cola.poner(this.raiz);
        NodoArbol nodo = new NodoArbol(null);
        while (!cola.esVacia()) {
            nodo = (NodoArbol) cola.obtenerFrente();
            cola.sacar();
            lista.insertar(nodo.getElem(), lista.longitud());
            if (nodo.getIzq() != null)
                cola.poner(nodo.getIzq());
            if (nodo.getDer() != null)
                cola.poner(nodo.getDer());
        }
        return lista;
    }

    private NodoArbol obtenerNodo(NodoArbol nodo, Object obj) {
        NodoArbol retorna = null;
        if (nodo != null) {
            if (obj.equals(nodo.getElem())) {
                retorna = nodo;
            } else {
                retorna = obtenerNodo(nodo.getIzq(), obj);
                if (retorna == null) {
                    retorna = obtenerNodo(nodo.getDer(), obj);
                }
            }
        }
        return retorna;
    }
    public String toString() {
        String cadena = "";
        if (!this.esVacio()) {
            cadena = stringAux(this.raiz, "");
        }
        return cadena;
    }
    private String stringAux(NodoArbol nodo, String cadena) {
        String izq = " ";
        String der = " ";
        Boolean izqExis = nodo.getIzq() != null;
        Boolean derExis = nodo.getDer() != null;
        if (izqExis)
            izq = nodo.getIzq().getElem() + "";
        if (derExis)
            der = nodo.getDer().getElem() + "";

        cadena = cadena + "[" + nodo.getElem() + "]" + ":" + "[" + izq + "]" + "[" + der + "]" + "\n";

        if (izqExis)
            cadena = stringAux(nodo.getIzq(), cadena);
        if (derExis)
            cadena = stringAux(nodo.getDer(), cadena);
        return cadena;
    }
}

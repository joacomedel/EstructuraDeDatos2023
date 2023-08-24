package estructuras.lineales.dinamicas;

public class Lista {
    private Nodo cabecera;
    private int longitud = 0;

    public boolean insertar(Object obj, int posc) {
        boolean retorna = posc >= 0 && posc <= longitud; // Si la posicion es valida entra en el if , sino devuelve
                                                         // false
        if (retorna) {
            if (cabecera == null) {
                cabecera = new Nodo(obj);
            } else {
                if (posc == 0) {
                    cabecera = new Nodo(obj, cabecera);
                    //Si cabecera es null no genera problemas
                } else {
                    Nodo temp = cabecera;
                    for (int i = 1; i < posc; i++) {
                        temp = temp.getEnlace();
                    }
                    temp.setEnlace(new Nodo(obj,temp.getEnlace()));
                }
            }
            longitud++;
        }
        return retorna;
    }

    public boolean eliminar(int posc) {
        boolean retorna = posc >= 0 && posc < longitud+1 && cabecera != null; // Si la posicion es valida entra en el if ,                                                                  // sino devuelve false
        if (retorna) {
            if (posc == 0) {
                cabecera = cabecera.getEnlace();
            } else {
                Nodo temp = cabecera;
                for (int i = 1; i < posc; i++) {
                    temp = temp.getEnlace();
                }
                temp.setEnlace(temp.getEnlace().getEnlace());
            }
            longitud--;
        }
        return retorna;
    }
    public Object recuperar(int posc){
        Object obj = null;
        if (posc >= 0 && posc < longitud) {
            Nodo temp = cabecera;
            for (int i = 1; i <= posc; i++) {
                temp = temp.getEnlace();
            }
            obj = temp.getElem();
        }
        return obj;
    }
    public int localizar(Object obj){
        int retorna= -1;
        int i = 1;
        Nodo temp = cabecera;
        while (retorna == -1 && i < longitud+1){
            if(temp.getElem().equals(obj))
            retorna = i;

            i++;
            temp = temp.getEnlace();
        }
        return retorna;
    }
    public boolean esVacia(){
        return longitud <= 0;
    }
    public void vaciar(){
        cabecera = null;
        longitud = 0;
    }
    public Lista clone(){
        Lista lista = new Lista();
        cloneAux(cabecera,lista);
        lista.longitud = this.longitud;
        return lista;
    }
    private void cloneAux(Nodo nodo,Lista lista){
        if (nodo != null) {
            cloneAux(nodo.getEnlace(), lista);
            lista.cabecera = new Nodo(nodo.getElem(),lista.cabecera);
        }
    }
    public String toString() {
        String cadena = "[|";
        Nodo temp = cabecera;
        while (temp != null) {
            cadena = cadena + temp.getElem() + "|";
            temp = temp.getEnlace();
        }
        cadena = cadena + "]";
        return cadena;
    }
    public int longitud(){
        return longitud;
    }
}

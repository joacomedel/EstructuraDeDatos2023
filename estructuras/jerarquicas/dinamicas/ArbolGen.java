package estructuras.jerarquicas.dinamicas;

public class ArbolGen {
    private NodoGen raiz = null;

    public boolean insertar(Object elem, Object objPadre) {
        boolean retorna = false;
        if (raiz == null) {
            retorna = true;
            raiz = new NodoGen(elem);
        }else{
            
        }
        return retorna;
    }
}

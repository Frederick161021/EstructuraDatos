package Recursividad;

public class NodoB {
    int numero;
    NodoB derecha;
    NodoB izquierda;
    
    public NodoB(int n){
        numero = n;
        derecha = null;
        izquierda = null;
    }
    
    public NodoB(int n, NodoB i, NodoB d){
        numero = n;
        izquierda = i;
        derecha = d;
    }
}

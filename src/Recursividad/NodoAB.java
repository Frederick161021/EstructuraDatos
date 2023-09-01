package Recursividad;

public class NodoAB {
    int numero;
    String nombre;
    NodoAB derecha;
    NodoAB izquierda;
    
public NodoAB(int N, String n){
    numero = N;
    nombre = n;
    derecha = null;
    izquierda = null;
}

public NodoAB(int N, String n,NodoAB i, NodoAB d){
    numero = N;
    nombre = n;
    izquierda = i;
    derecha = d;
}
}

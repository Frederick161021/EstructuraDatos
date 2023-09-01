package Recursividad;

public class NodoLCDE {
    int exponente;
    String nombre;
    NodoLCDE siguiente, anterior;
    
    public NodoLCDE(int e, String n, NodoLCDE a, NodoLCDE s){
        exponente = e;
        nombre = n;
        anterior = a;
        siguiente = s;
    }
}

package Recursividad;

public class Nodo {
    int dato;
    String dato2;
    char dato3;
    Nodo derecha;
    Nodo izquierda;
    
public Nodo(int d1, String d2, char d3){
    dato = d1;
    dato2 = d2;
    dato3 = d3;
    derecha = null;
    izquierda = null;
}

public Nodo (int d1, String d2, char d3,Nodo i, Nodo d){
    dato = d1;
    dato2 = d2;
    dato3 = d3;
    izquierda = i;
    derecha = d;
}
}

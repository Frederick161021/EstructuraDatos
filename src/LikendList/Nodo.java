package LikendList;

public class Nodo {
    int dato, dato2;
    char dato3;
    Nodo siguiente, anterior;
    
public Nodo(int d, int d2, char d3){
    dato = d;
    dato2 = d2;
    dato3 = d3;
    siguiente = null;
    anterior = null;
}

public Nodo (int d, int d2, char d3,Nodo a, Nodo n){
    dato = d;
    dato2 = d2;
    dato3 = d3;
    anterior = a;
    siguiente = n;
}
}

package Ordinario;

public class Arbol {
public int numero;//Numero enteros (short,long,int)
public String nombre;//String son cadenas de Char "Gabriela"
public Arbol derecha = null, izquierda = null; 

public Arbol(int numero, String nombre){
    this.numero = numero;
    this.nombre = nombre;
}

public Arbol(int numero, String nombre, Arbol izquierdo, Arbol derecho){
    this.numero = numero;
    this.nombre = nombre;
    this.izquierda = izquierdo;
    this.derecha = derecho;
}
}

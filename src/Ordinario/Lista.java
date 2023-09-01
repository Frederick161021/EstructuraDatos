package Ordinario;

public class Lista {
    public int dato;
    public String nombre;
    public Lista prev = null, next = null;
    
    public Lista (int dato, String nombre){
        this.dato = dato;
        this.nombre = nombre;
    }
    
    public Lista (int dato, String nombre, Lista prev, Lista next){
        this.dato = dato;
        this.nombre = nombre;
        this.prev = prev;
        this.next = next;
    }
}

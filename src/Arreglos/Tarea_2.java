package Arreglos;
import java.util.Scanner;
import java.util.Arrays;

public class Tarea_2 {
    static int arreglo [];
    static int arreglo2 [];
    static int arreglo3 [];
    static String Datos="";
    
    static Scanner s = new Scanner(System.in);
    
    static public void Arreglo1 (int Tamaño){
        arreglo = new int [Tamaño];
        for (int i = 0; i < Tamaño; i++) {
            arreglo[i] = (int)(Math.random()*200);
        }
    }
    
    static public void Arreglo2 (int Tamaño){
        arreglo2 = new int [Tamaño];
        for (int i = 0; i < Tamaño; i++) {
            arreglo2[i] = (int)(Math.random()*500);
        }
    }
    
    static public void Arreglo3 (int Tamaño){
        arreglo3 = arreglo.clone();
    }
    
    static public void Imprimir (int nArreglo){
        if (nArreglo==1) {
            Datos+="\nLos Valores del Primer Arreglo son:";
            for (int i = 0; i < arreglo.length; i++) {
                Datos+="\n"+arreglo[i];
            }   
        }
        if (nArreglo==2) {
            Datos+="\nLos Valores del Segundo Arreglo son:";
            for (int i = 0; i < arreglo.length; i++) {
                Datos+="\n"+arreglo2[i];
            }
        }
        
        if (nArreglo==3) {
           Datos+="\nLos Valores del Tercer Arreglo son:";
           for (int i = 0; i < arreglo.length; i++) {
               Datos+="\n"+arreglo3[i];
            } 
        }
    }
    
    static public void Busqueda(int nArreglo,int numero){
        int resultado=0, resultado2=0, resultado3=0; 
        if (nArreglo==1) {
            resultado2=Arrays.binarySearch(arreglo2, numero);
            resultado3=Arrays.binarySearch(arreglo3, numero);
        }
        if (nArreglo==2) {
            resultado=Arrays.binarySearch(arreglo, numero);
            resultado3=Arrays.binarySearch(arreglo3, numero);
        }
        if (nArreglo==3) {
            resultado=Arrays.binarySearch(arreglo, numero);
            resultado2=Arrays.binarySearch(arreglo2, numero);
        }
        if (numero<4) {
        if (resultado<=0) {
            Datos+="\nDel el arreglo numero 2"+nArreglo+" no hay ningun numero igual a "+numero+" en el arreglo numero uno";
        } else{
            Datos+="\nEL  numero "+numero+" del arraglo "+nArreglo+" esta en el arreglo 1";
        }
        if (resultado2<=0) {
            Datos+="\nDel el arreglo numero "+nArreglo+" no hay ningun numero igual a "+numero+" en el arreglo numero dos";
        } else{
            Datos+="\nEL  numero "+numero+" del arraglo "+nArreglo+" esta en el arreglo 2";
        }
        if (resultado3<=0) {
            Datos+="\nDel el arreglo numero "+nArreglo+" no hay ningun numero igual a "+numero+" en el arreglo numero tres";
        } else{
            Datos+="\nEL  numero "+numero+" del arraglo "+nArreglo+" esta en el arreglo 3";
        }}
    }
    
    public static void main(String[] args) {
        System.out.println("Digite el Tamaño de los Arreglos:");
        int Tamaño = s.nextInt();
        Arreglo1(Tamaño);
        Arreglo2(Tamaño);
        Arreglo3(Tamaño);
        Imprimir(1);
        Imprimir(2);
        Datos+="\n-------------------------------------------\nLos arreglos uno y tres depues de la clonacion:";
        Imprimir (3);
        Imprimir(1);
        Datos+="¿Los arrelgos uno y tres son iguales? = "+Arrays.equals(arreglo, arreglo3);
        arreglo3[(int) Math.random()*arreglo3.length]=16;
        Imprimir(3);
        Datos+="¿Los arrelgos uno y tres son iguales? = "+Arrays.equals(arreglo, arreglo3)
                +"\n-------------------------------------------\n Depues de la Igualacion del arreglo dos y tres";
        arreglo2=arreglo3;
        Imprimir(2);
        Imprimir(3);
        Datos+="\n Los arreglos tres y uno son igualados: "+arreglo3.equals(arreglo2);
        arreglo3[(int) Math.random()*arreglo3.length]=25;
        Imprimir(1);
        Imprimir(3);
        Datos+="\n Los arreglos tres y uno son igualados: "+arreglo3.equals(arreglo2);
        Datos+="\n-------------------------------------------\nOrdenar arrelos uno y tres:";
        Arrays.sort(arreglo);
        Arrays.sort(arreglo3);
        Imprimir(1);
        Imprimir(3);
        Datos+="\n-------------------------------------------\n";
        Imprimir(2);
        Datos+="\n-------------------------------------------\n Buscar datos en otros arreglos:";
        int numero=arreglo[(int) Math.random()*arreglo3.length];
        int numero2=arreglo2[(int) Math.random()*arreglo3.length];
        int numero3=arreglo3[(int) Math.random()*arreglo3.length];
        Busqueda(1,numero);
        Busqueda(2,numero2);
        Busqueda(3,numero3);
         Datos+="\n-------------------------------------------\n La longitud de los arreglos es:";
         Datos+="\nLa longitud del arreglo 1 es igual a: "+arreglo.length;
         Datos+="\nLa longitud del arreglo 2 es igual a: "+arreglo2.length;
         Datos+="\nLa longitud del arreglo 3 es igual a: "+arreglo3.length;
        System.out.println(Datos);
    }
    
}
//Erick Toledo
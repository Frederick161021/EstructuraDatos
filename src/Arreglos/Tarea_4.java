package Arreglos;
import java.util.Scanner;
import java.util.Arrays;
public class Tarea_4 {
    static int Arreglo[][];
    static int Arreglo2[][];
    static int Arreglo3[][];
    static int Arreglo4[][];
    static Scanner s = new Scanner(System.in);
    
    static public void setArreglos(int filas, int columnas){
        Arreglo = new int[filas][columnas];
        Arreglo2 = new int[filas][columnas];
        Arreglo3 = new int[filas][columnas];
        Arreglo4 = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Arreglo[i][j] = (int)(Math.random()*500);
                Arreglo2[i][j] = (int)(Math.random()*200);
                Arreglo3[i][j] = Arreglo[i][j]*Arreglo2[i][j];
            }
        }
        Arreglo4=Arreglo2;
    }
    
    static public void Imprimir (int nArreglo, int filas, int columnas){
        String imprimir = "";
        switch (nArreglo){
            case 1:
                imprimir += "------------El Primer Arreglo es:------------\n";
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        imprimir += Arreglo[i][j]+"_";
                    }imprimir += "\n";
                }break;
            case 2:
                imprimir += "------------El Segundo Arreglo es:------------\n";
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        imprimir += Arreglo2[i][j]+"_";
                    } imprimir += "\n";
                }break;
            case 3:
                imprimir += "------------El Tercer Arreglo es:------------\n";
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        imprimir += Arreglo3[i][j]+"_";
                        Arreglo3[i][j] = Arreglo[i][j]-Arreglo2[i][j];
                    }imprimir += "\n";
                }break;
            case 4:
                imprimir += "------------El Cuarto Arreglo es:------------\n";
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        imprimir += Arreglo4[i][j]+"_";
                    }imprimir += "\n";
                }break;        
        }
        
        System.out.println(imprimir);
    }
    
    static public void Promedio (int filas, int columnas){
        int  j=0;
        double Suma = 0,Promedio = 0, totalPromedio = 0;
                System.out.println("------------El Promedio del Primer Arreglo es:------------\n");
                for (int i = 0; i < filas; i++) {
                    for (j=0; j < columnas; j++) {
                        Suma += Arreglo[i][j];
                    }
                    Promedio = Suma/columnas; 
                    totalPromedio += Promedio;
                    Suma=0;
                    System.out.println("El Promedio de la Fila "+(i+1)+" es de: "+Promedio);
                }totalPromedio = totalPromedio/filas; 
                System.out.println("El Promedio Total del arreglo 1 es de: "+totalPromedio);
                totalPromedio =0; Promedio =0;
                
                
                System.out.println("------------El Promedio del Segundo Arreglo es:------------\n");
                for (int i = 0; i < filas; i++) {
                    for (j = 0; j < columnas; j++) {
                        Suma += Arreglo2[i][j];
                    }
                    Promedio = Suma/columnas;
                    totalPromedio += Promedio;
                    Suma=0;
                    System.out.println("El Promedio de la Fila "+(i+1)+" es de: "+Promedio);
                }Promedio = totalPromedio/filas;
                System.out.println("El Promedio Total del arreglo 2 es de: "+totalPromedio);
                totalPromedio =0; Promedio =0; 
                
                
                System.out.println("------------El Promedio del Tercer Arreglo es:------------\n");
                for (int i = 0; i < filas; i++) {
                    for (j = 0; j < columnas; j++) {
                        Suma += Arreglo3[i][j];
                        Arreglo3[i][j] = Arreglo[i][j]-Arreglo2[i][j];
                    }
                    Promedio = Suma/columnas;
                    totalPromedio += Promedio;
                    Suma=0;
                    System.out.println("El Promedio de la Fila "+(i+1)+" es de: "+Promedio);
                }Promedio = totalPromedio/filas;
                System.out.println("El Promedio Total del arreglo 3 es de: "+totalPromedio);
                totalPromedio =0; Promedio =0;
        }

    public static void main(String[] args) {
        System.out.println("Digite el Numero de Filas del Arreglo:");
        int filas = s.nextInt();
        System.out.println("Digite el Nummero de Columnas del Arreglo:");
        int columnas = s.nextInt();
        setArreglos(filas,columnas);
        Imprimir(1,filas,columnas);
        Imprimir(2,filas,columnas);
        Imprimir(3,filas,columnas);
        Imprimir(1,filas,columnas);
        Imprimir(2,filas,columnas);
        Imprimir(3,filas,columnas);
        Promedio(filas,columnas);
        Imprimir(2,filas,columnas);
        Imprimir(4,filas,columnas);
        System.out.println("El arreglo 2 y el Arreglo 4 son iguales?"+Arrays.equals(Arreglo4, Arreglo2));
        System.out.println("------------Modificar una Fila del Arreglo 4------------");
        int fila = (int)(Math.random()*filas-1);
        for (int i = 0; i < columnas; i++) {
            Arreglo4[fila][i] = (int)(Math.random()*300);
        }
        Imprimir(2,filas,columnas);
        Imprimir(4,filas,columnas);
        System.out.println("El arreglo 2 y el Arreglo 4 son iguales?"+Arrays.equals(Arreglo4, Arreglo2));
    }
}
//Erick Toledo
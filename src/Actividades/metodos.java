package Actividades;
import java.util.*;
import java.util.Arrays;
public class metodos {

    public static void main(String[] args) {

System.out.println("Cantidad de datos que tendrán los arreglos?");
Scanner s = new Scanner(System.in);
int n = s.nextInt();

int arreglo [] = new int [n];
int arreglo2 [] = new int [n];
int arreglo3 [] = new int [n];

for(int ii = 0;ii<n;ii++){
    arreglo[ii] = (int)(Math.random()*500);
}

//arreglo2=arreglo.clone();

for(int ii = 0;ii<n;ii++){
    arreglo2[ii] = (int)(Math.random()*1000);
}

System.out.println("Datos del arreglo 1 antes de las operaciones:");

for(int ii = 0;ii<n;ii++){
    System.out.println(+arreglo[ii]);
}

System.out.println("Datos del arreglo 2 antes de las operaciones:");

for(int ii = 0;ii<n;ii++){
    System.out.println(+arreglo2[ii]);
}

arreglo3= arreglo.clone();
System.out.println("Datos del arreglo 3 antes de las operaciones:");
for(int ii = 0;ii<n;ii++){
    System.out.println(+arreglo3[ii]);
}
// arreglo3=arreglo;

arreglo3[6] = 700;

// arreglo2=arreglo;

arreglo2 [5] = 5000;

System.out.println("\nArreglo1 pos 6 = "+arreglo[6]);

System.out.println("\nArreglo2 pos 6 = "+arreglo2[6]);

System.out.println("\nArreglo3 pos 6 = "+arreglo3[6]);
}
}

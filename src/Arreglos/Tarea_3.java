package Arreglos;

public class Tarea_3 {
    static int arreglo[];
    
    static public String Ordenar(){
        int dato=0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if (arreglo[i]<arreglo[j]) {
                    dato=arreglo[i];
                    arreglo[i]=arreglo[j];
                    arreglo[j]=dato;
                    j=0;
                }
            }
        }
        String Arrg="";
        for (int i = 0; i < arreglo.length; i++) {
            Arrg+="\n"+arreglo[i];
        }
        return Arrg;
    }
    static public double Promedio(){
        int suma=0;
        for (int i = 0; i < arreglo.length; i++) {
            suma+=arreglo[i];
        }
        double promedio = suma/arreglo.length;
        return promedio;
    }
    
    static public String Media(){
        String media="";
        int num=arreglo.length/2;
        if (arreglo.length%2==0){
            media="\n La media del arreglo es "+arreglo[num]+ " y "+arreglo[num-1];
        }else{
            media="La Media del arreglo es de: "+arreglo[num];
        }
        return media;
    }
    
    static public String Moda(){
        int mNumRepeticiones= 0, moda= 0;
        for(int i=0; i<arreglo.length; i++){
            int numRepeticiones= 0;
            for(int j=0; j<arreglo.length; j++)
            {
                if(arreglo[i]==arreglo[j]){
                    numRepeticiones++;
                }   
            if(numRepeticiones>mNumRepeticiones)
            {
                moda= arreglo[i];
                mNumRepeticiones= numRepeticiones;
            }  
        }
    }   
        return "La Moda del arreglo es el numero: "+moda;
    }

    public static void main(String[] args) {
        arreglo = new int [(int) (Math.random()*20+2)];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i]=(int) (Math.random()*20+1);
            System.out.println(arreglo[i]);
        }
        System.out.println("\n------------------------\n"+"Oden de menor a mayor del arreglo:\n"+Ordenar());
        System.out.println("\n------------------------\n"+"El numero menor del arreglo es: "+arreglo[0]);
        System.out.println("\n------------------------\n"+"El numero mayor del arreglo es: "+arreglo[arreglo.length-1]);
        System.out.println("\n------------------------\n"+"El Promedio del arreglo es de: "+Promedio());
        System.out.println("\n------------------------\n"+Media());
        System.out.println("\n------------------------\n"+Moda());
    }
    
}

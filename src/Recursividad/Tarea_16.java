package Recursividad;
import javax.swing.JOptionPane;

public class Tarea_16 {
    private static int n = 0, factorial = 0, fibonacci = 0;
    
    public static int Factorial(int n){
        if (n > 1) {
            factorial = n * Factorial(n-1);
        }
        else{
            factorial =1;
        }
        return factorial;
    }
    
    public static int Fibonacci(int n){
        if (n > 1) {
            fibonacci = Fibonacci(n-1) + Fibonacci(n-2);
        }
        if (n == 1) {
            fibonacci = 1;
        }
        if(n == 0){
            fibonacci = 0;
        }
        return fibonacci;
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "------------------------------Menu------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Factorial\n2.- Fibonacci\n3.-Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(seleccion){
            case 1:
                n = Integer.parseInt(JOptionPane.showInputDialog("Digite el Numero que desea saber su Factorial:"));
                JOptionPane.showMessageDialog(null,"El factorial del numero "+n+" es: "+Factorial(n));
                break;
            case 2:
                n = Integer.parseInt(JOptionPane.showInputDialog("Digite el Numero que desea saber su Fibonanci:"));
                JOptionPane.showMessageDialog(null, "El fibonacci del numero "+n+" es: "+Fibonacci(n));
                break;
            case 3:System.exit(0);break; 
        }      
        }
        while(seleccion != 3);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido del Menu de Opciones");
            Menu();
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}
//Erick Toledo
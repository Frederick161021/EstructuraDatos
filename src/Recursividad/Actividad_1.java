package Recursividad;
import javax.swing.JOptionPane;

public class Actividad_1 {
    private static int suma = 0;
    public static int suma(int n){
        if (n>=10) {
            suma = (n%10)+ suma(n/10);
        }else{
            suma = n%10;
        }
        return suma;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero que quiere sumar sus digitos:"));
        JOptionPane.showMessageDialog(null, "La suma de sus digitos es igual a: "+suma(n));
    }
    
}

package Clases;
import javax.swing.JOptionPane;

public class Calculadora_Edad {
    static int diaNacio,mesNacio,añoNacio,diaActual,mesActual,añoActual;


    public static void main(String[] args) {
        
        String DiaN = JOptionPane.showInputDialog("Digite el día que Nacio:");
        diaNacio = Integer.parseInt(DiaN);
        String MesN = JOptionPane.showInputDialog("Digite el mes que Nacio:");
        mesNacio = Integer.parseInt(MesN);
        String AñoN = JOptionPane.showInputDialog("Digite el año que Nacio:");
        añoNacio = Integer.parseInt(AñoN);
        
        String DiaA = JOptionPane.showInputDialog("Digite el día de Hoy:");
        diaActual = Integer.parseInt(DiaA);
        String MesA = JOptionPane.showInputDialog("Digite el mes de Hoy:");
        mesActual = Integer.parseInt(MesA);
        String AñoA = JOptionPane.showInputDialog("Digite el año de Hoy:");
        añoActual = Integer.parseInt(AñoA);
        
        Edad edad = new Edad(diaNacio,mesNacio,añoNacio,diaActual,mesActual,añoActual);
        JOptionPane.showMessageDialog(null, edad.toString());
    }
    
}

package Recursividad;
import javax.swing.JOptionPane;
import java.util.Stack;

public class Actividad_2 {
    public static int nAros = 0;
    public static Stack<Integer> torre1;
    public static Stack<Integer> torre2;
    public static Stack<Integer> torre3;
    
    public static void nAros(){
        try{
            nAros = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de aros que dese que contenga la torre 1:"));
            for (int i = nAros; i > 0; i--) {
                torre1.add(i);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Digite un numero valido");
        }
    }
    
    public static void Imprimir(){
        if (nAros != 0) {
            String prnt = "";
            Stack<Integer> temp = new Stack <>();
            prnt += "La torre uno:\n";
            if (torre1.empty()) {
                prnt += "La torre uno esta vacia!\n";
            }
            else{
                temp.clear();
                while(!torre1.empty()){
                    temp.add(torre1.peek());
                    torre1.pop();
                }
                while(!temp.isEmpty()){
                    prnt += temp.peek()+"\n";
                    torre1.push(temp.peek());
                    temp.pop();
                }
            }
            
            prnt += "La torre dos:\n";
            if (torre2.empty()) {
                prnt += "La torre dos esta vacia!\n";
            }
            else{
                temp.clear();
                while(!torre2.empty()){
                    temp.add(torre2.peek());
                    torre2.pop();
                }
                while(!temp.isEmpty()){
                    prnt += temp.peek()+"\n";
                    torre2.push(temp.peek());
                    temp.pop();
                }
            }
            prnt += "La torre tres:\n";
            if (torre3.empty()) {
                prnt += "La torre tres esta vacia!\n";
            }
            else{
                temp.clear();
                while(!torre3.empty()){
                    temp.add(torre3.peek());
                    torre3.pop();
                }
                while(!temp.isEmpty()){
                    prnt += temp.peek()+"\n";
                    torre3.push(temp.peek());
                    temp.pop();
                }
            }
            JOptionPane.showMessageDialog(null, prnt);
        }
        else{
            JOptionPane.showMessageDialog(null, "Primero tienes que indicar el numero de aros!");
        }
    }
    
    public static void Hanoi(int n, Stack <Integer> t1, Stack <Integer> t2, Stack <Integer> t3){
        if(n==1){
           t3.push(t1.peek());
           t1.pop();
        }else{
           Hanoi(n-1, t1, t3, t2);
           t3.push(t1.peek());
           t1.pop();
           Hanoi(n-1, t2, t1, t3);
        }
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "----------------------------------------Menu----------------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.-Ingrese el numero de aros \n2.- Pasar los aros a la torre 3\n"
                +"3.- Imprimir las Torres\n4.- Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(seleccion){
            case 1:nAros();break;
            case 2:Hanoi(nAros,torre1,torre2,torre3);break;
            case 3:Imprimir();break;  
            case 4:System.exit(0);break;  
        }
        }
        while(seleccion != 4);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido del Menu de Opciones");
            Menu();
        }
    }
    
    public static void main(String[] args) {
        torre1 = new Stack<>();
        torre2 = new Stack<>();
        torre3 = new Stack<>();
        Menu();
    }
    
}

package Pilas;
import java.util.Stack;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Tarea_12 {
    private static Stack<Character> pila;
    private static LinkedList<Character> cola;
    private static String posfijo = "";
    private static int aux = 0;
    private static boolean existe = false;
    
    public static void nOperacion(){
        if (existe) {
            pila.clear();
            cola.clear();
            posfijo = "";
        }
        String  operacion = JOptionPane.showInputDialog("Digite la operacion que quiere convertir de Infijo a Posfijo:");
        for (int i = 0; i < operacion.length(); i++) {
            cola.add(operacion.charAt(i));
        }
        conversion();
    }
    
    public static void conversion(){
        existe = true;
        do{ 
           switch(cola.getFirst()){
               case '(':
                   pila.push(cola.getFirst());
                   cola.poll();
                   aux = 0;
                   break;
               case ')':System.out.println("");
                   while(pila.peek() != '('){
                       posfijo += pila.peek();
                       pila.pop();
                   }
                   pila.pop();
                   if (pila.size() == 0) {
                       aux = 0;
                   }else{
                       aux = pila.peek();
                   }
                   cola.poll();
                   break;
               case '^':jerarquia(4); cola.poll();break;
               case '*':jerarquia(3); cola.poll();break;
               case '/':jerarquia(3);cola.poll();break;
               case '+':jerarquia(2);cola.poll();break;
               case '-':jerarquia(2);cola.poll();break;
               case '&':jerarquia(0);cola.poll();break;
               default: posfijo += cola.getFirst(); cola.poll();break;
           }
        }while(cola.size() != 0);
        if (cola.size() == 0) {
            while(pila.size() != 0){
                posfijo += pila.peek();
                pila.pop();
            }
        }
    }
    
    public static void jerarquia(int j){
        if (j <= aux) {
            posfijo += pila.peek();
            pila.pop();
            pila.push(cola.getFirst());
            aux = j;
        }
        else{
            pila.push(cola.getFirst());
            aux=j;
        }
    }

    
    public static void Imprimir(){
        if (existe) {
            JOptionPane.showMessageDialog(null, posfijo);
        }
        else{
            JOptionPane.showMessageDialog(null, "Primero tienes que digitar una operacion!");
        }
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "----------------------------------------Menu----------------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.-Convertir una Operacion de Infijo a Posfijo \n2.- Imprimir Operacion en Posfijo\n"
                +"3.- Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(seleccion){
            case 1:nOperacion();break;
            case 2:Imprimir();break;
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
        pila = new Stack<>();
        cola = new LinkedList<>();
        Menu();
    }
    
}

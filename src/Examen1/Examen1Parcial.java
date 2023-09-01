//Erick Ivan Toledo Galeana
//Matricula: 19017291
//Estructura de Datos
package Examen1;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Examen1Parcial {
    private static LinkedList<Integer> cola;
    private static LinkedList<Integer> Lista;
    private static Stack<Integer> pila;
    
    public static void nClientesCola(){
        try{
            int nDatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos clientes desea agregar a la cola?"));
                for (int i = 0; i < nDatos; i++) {
                cola.add(Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de cliente que sera almacenado:")));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            nClientesCola();
        }
    }
    
    public static void eClienteCola(){
        int seleccion = 0;
        try{
                    seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quiere eleminar el primer elemento de la cola?\n1.- SI\n2.- NO"));
                    switch(seleccion){
                        case 1:
                            if (cola.getFirst() != null) {
                                pila.push(cola.getFirst());
                                cola.poll();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola!");
                                Menu();
                            }
                            break;
                        case 2: Menu();break;
                        default: seleccion = 1/0; break;
                    }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            eClienteCola();
        }
    }
    
    public static void eClientePila(){
        int seleccion = 0,x = 0;
        int cliente = 0, topPila = 0;
        if (pila.size() != 0) {
        try{
                cliente = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del cliente que desea eleminar de la Pila: "));
                    seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quere eleminar el Cliente "+cliente+" de la pila?\n1.- SI\n2.- NO"));
                    switch(seleccion){
                        case 1:
                            LinkedList <Integer> lTemp = new LinkedList <>();
                            if (pila.peek().equals(cliente)) {
                                pila.pop();
                            }else {
                                topPila = pila.peek();
                                do{
                                    lTemp.add(pila.peek());
                                    pila.pop();
                                }while(pila.peek().equals(cliente) == false );
                                Lista.add(pila.peek());
                                pila.pop();
                                    do {
                                    pila.push(lTemp.getLast());
                                    lTemp.pollLast();
                                } while (lTemp.pollLast() != null);
                            } 
                            break;
                        case 2: Menu();break;
                        default:  x = 1/0; break;
                    }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar una Opcion Valida");
            eClientePila();
        }
        }else{
            JOptionPane.showMessageDialog(null,"Primero Debe de Borrar un Elemento de la Cola!");
            Menu();
                    }
    }
    
    public static void ImprimirCola(){
        if (cola.size() != 0) {
            JOptionPane.showMessageDialog(null, "Los datos de la cola son:\n"+cola);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola");
        }
    }
    
    public static void ImprimirPila(){
        if (pila.size() != 0) {
            JOptionPane.showMessageDialog(null, "Los datos de la pila son:\n"+pila);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Pila");
        } 
    }
    
    public static void ImprimirLinkedList(){
        if (Lista.size() != 0) {
            JOptionPane.showMessageDialog(null, "Los datos de la Lista son:\n"+Lista);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Lista");
        }
    }
    
    public static void ImprimirElementos(){
        JOptionPane.showMessageDialog(null, "La cantidad de elementos llenos de la cola es de: "+cola.size()
                +"\nLa cantidad de elementos llenos de la pila es de: "+pila.size()
                +"\nLa cantidad de elementos llenos del LinkedList es de: "+Lista.size());
    }
    
    public static void ImprimirPrimerCola(){
        if (cola.size() != 0) {
            JOptionPane.showMessageDialog(null, "El primer elemento de la cola es:\n"+cola.getFirst());
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola");
        } 
    }
    
    public static void ImprimirUltimoCola(){
        if (cola.size() != 0) {
            JOptionPane.showMessageDialog(null, "El primer elemento de la cola es:\n"+cola.getLast());
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola");
        } 
    }
    
    public static void ImprimirUltimoPila(){
        if (pila.size() != 0) {
            JOptionPane.showMessageDialog(null, "El ultimo elemento de la Pila es:\n"+pila.lastElement());
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Pila");
        } 
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "----------------------------------------Menu----------------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Llegada de clientes a COLA \n2.- Borrar un cliente de la lista de Cola\n"
                +"3.- Borrar un cliente de Pila\n4.- Imprimir Cola\n"
                +"5.- Imprimir Pila\n6.- Imprimir Linkedlist\n7.- Imprimir la cantidad de elementos de la Cola, Pila y del Linkedlist\n"
                +"8.- Imprimir Primer elemento de la Cola\n 9.-Imprimir el ultimo elemento de la Cola\n "
                +"10.-Imprimir el ultimo elemento de la Pila\n11.-Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(seleccion){
            case 1:nClientesCola();break;
            case 2:eClienteCola();break;
            case 3:eClientePila();break;
            case 4:ImprimirCola();break;
            case 5:ImprimirPila();break;
            case 6:ImprimirLinkedList();break;
            case 7:ImprimirElementos();break;
            case 8:ImprimirPrimerCola();break;
            case 9:ImprimirUltimoCola();break;
            case 10:ImprimirUltimoPila();break;
            case 11:System.exit(0);break;  
        }
        }while(seleccion != 11);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido del Menu de Opciones");
            Menu();
        }
    }

    public static void main(String[] args) {
        pila = new Stack<>();
        cola = new LinkedList<>();
        Lista = new LinkedList <>();
        Menu();
    }
    }
//Erick Toledo.

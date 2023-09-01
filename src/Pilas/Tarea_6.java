package Pilas;
import javax.swing.JOptionPane;
import java.util.Stack;
public class Tarea_6 {

    private static Stack<Integer> pila;
    private static boolean existe = false;  
    
    public static void crearPila(){
        pila = new Stack<>(); 
        existe = true;
    }
    
    public static boolean pilaLlena(){
        boolean llena = true;
        if (pila.empty()) {
            llena = false;
        }
         return llena;
    }
    
    public static void nElementoPila(){
        try{
            int nDatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos desea agregar a la pila?"));
            if (nDatos <= (Integer.MAX_VALUE-(pila.size()))) {
                nDatos += pila.size();
                for (int i = pila.size(); i < nDatos; i++) {
                pila.push(Integer.parseInt(JOptionPane.showInputDialog("Digite el nuevo dato que sera almacenado:")));
            }
            }else{
                nDatos = 1/0;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            nElementoPila();
        }
    }
    
    public static void eElementoPila(){
        int seleccion = 0, posicion = 0;
        try{
                posicion = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion del dato que desea eleminar de la pila: "));
                if (posicion <= pila.size()) {
                    seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quere eleminar el dato numero "+posicion+" de la pila?\n1.- SI\n2.- NO"));
                    switch(seleccion){
                        case 1:
                            if (posicion == pila.size()) {
                                pila.pop();
                            }else {
                                Stack <Integer> respaldo = new Stack <>();
                                int reacomodo = (pila.size()-posicion);
                                for (int i = 0; i <= reacomodo; i++) {
                                    if (i < reacomodo) {
                                        respaldo.push(pila.peek());
                                    }
                                    pila.pop();
                                }
                                for (int j = 0; j < reacomodo; j++) {
                                    pila.push(respaldo.peek());
                                    respaldo.pop();
                                }
                            }
                            break;
                        case 2: Menu();break;
                        default: posicion = 1/0; break;
                    }
                }else{
                    posicion = 1/0;
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            eElementoPila();
        }
    }
    
    public static void Imprimir(){
        if (pila.size() != 0) {
            JOptionPane.showMessageDialog(null, "Los datos de la pila son:\n"+pila);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Pila");
        }
        
    }
    
    public static void imprimirElementos(){
        JOptionPane.showMessageDialog(null, "La cantidad de elementos llenos de la pila es de: "+pila.size()+"\nY la cantidad de elementos que puede almacenar es de: "+Integer.MAX_VALUE);
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "----------------------------------------Menu----------------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Crear pila\n2.- La pila esta llena?\n"
                +"3.- Insertar un nuevo elemento a la pila\n4.- Borrar un elemento de la pila\n"
                +"5.- Imprimir pila\n6.- Imprimir cantidad de elementos que contiene la pila\n"
                +"7.- Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        if(existe == true){
        switch(seleccion){
            case 1:crearPila();break;
            case 2:JOptionPane.showMessageDialog(null, "La pila esta llena? = "+pilaLlena());break;
            case 3:nElementoPila();break;
            case 4:eElementoPila();break;
            case 5:Imprimir();break;
            case 6:imprimirElementos();break;
            case 7:System.exit(0);break;  
        }
        }else{
            switch(seleccion){
            case 1:crearPila();break;
            case 7:System.exit(0);
            default:JOptionPane.showMessageDialog(null, "Opcion Invalida, Primero Debes de Crear una Pila!");break;
        }
        }
        }
        while(seleccion != 7);
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
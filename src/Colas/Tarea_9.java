package Colas;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Tarea_9 {
    private static LinkedList<Integer> cola;
    private static boolean existe = false;  
    
    public static void crearcola(){
        if (existe) {
            cola.clear();
        }
        cola = new LinkedList<>(); 
        existe = true;
    }
    
    public static boolean colaVacia(){
        return cola.isEmpty();
    }
    
    public static void nElementoCola(){
        try{
            int nDatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos desea agregar a la cola?"));
                for (int i = 0; i < nDatos; i++) {
                cola.add(Integer.parseInt(JOptionPane.showInputDialog("Digite el nuevo dato que sera almacenado:")));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            nElementoCola();
        }
    }
    
    public static void eElementoCola(){
        int seleccion = 0;
        try{
                    seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quiere eleminar el primer elemento de la cola?\n1.- SI\n2.- NO"));
                    switch(seleccion){
                        case 1:
                            if (cola.pollFirst() == null) {
                                JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola!");
                            }
                            break;
                        case 2: Menu();break;
                        default: seleccion = 1/0; break;
                    }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            eElementoCola();
        }
    }
    
    public static void Imprimir(){
        if (!colaVacia()) {
            JOptionPane.showMessageDialog(null, "Los datos de la cola son:\n"+cola);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola");
        } 
    }
    
    public static void ImprimirPrimerE(){
        if (!colaVacia()) {
            JOptionPane.showMessageDialog(null, "El primer elemento de la cola es:\n"+cola.getFirst());
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola");
        } 
    }
    
    public static void ImprimirUltimoE(){
        if (!colaVacia()) {
            JOptionPane.showMessageDialog(null, "El primer elemento de la cola es:\n"+cola.getLast());
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola");
        } 
    }
    
    public static void imprimirElementos(){
        JOptionPane.showMessageDialog(null, "La cantidad de elementos llenos de la pila es de: "+cola.size());
    }
    
    public static String buscarElemento(){ 
        String resultado = "";
        try{
            int elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite el elemento que quiere bucar:"));
            resultado = "El elemento "+elemento+" no existe en la cola";
            if (cola.contains(elemento)) {
                resultado = "El elemento "+elemento+" existe en la cola";
            } 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Digite un valor valido!");
        }
        return resultado;
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "----------------------------------------Menu----------------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Crear pila (La ultima cola se eleminara automaticamente)\n2.- La cola esta vacia?\n"
                +"3.- Insertar un nuevo elemento a la cola\n4.- Borrar un elemento de la cola\n"
                +"5.- Imprimir cola\n6.- Imprimir el primer elemento de la cola\n"
                +"7.- Imprimir el ultimo elemento de la cola\n8.- Imprimir la cantidad de elementos que contiene la cola\n"
                +"9.- Buscar un valor en la cola\n10.- Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        if(existe == true){
        switch(seleccion){
            case 1:crearcola();break;
            case 2:JOptionPane.showMessageDialog(null, "La cola esta vacia? = "+colaVacia());break;
            case 3:nElementoCola();break;
            case 4:eElementoCola();break;
            case 5:Imprimir();break;
            case 6:ImprimirPrimerE();break;
            case 7:ImprimirUltimoE();break;
            case 8:imprimirElementos();break;
            case 9:JOptionPane.showMessageDialog(null,buscarElemento());;break;
            case 10:System.exit(0);break;  
        }
        }else{
            switch(seleccion){
            case 1:crearcola();break;
            case 10:System.exit(0);
            default:JOptionPane.showMessageDialog(null, "Opcion Invalida, Primero Debes de Crear una Cola!");break;
        }
        }
        }
        while(seleccion != 10);
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
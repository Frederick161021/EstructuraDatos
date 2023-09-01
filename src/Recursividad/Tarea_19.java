package Recursividad;
import javax.swing.JOptionPane;
import java.util.LinkedList;

public class Tarea_19 {
    private static LinkedList<Integer> cola, pila;
    private static NodoB nNodo, raiz;
    private static String prnt;
    private static int numero, contadorNodos, profundidad, I, D;
    
    public static void nNodo(){
        try{
            int numNodos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de nodos que quiera agregar"));
            for (int i = 0; i < numNodos; i++) {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del nodo:"));
                nNodo = new NodoB(numero);
                if (contadorNodos == 0) {
                    raiz = nNodo;
                    contadorNodos++;
                    profundidad++;
                }
                else {
                    Arbol(raiz);
                    contadorNodos++;
                }
            }
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, "Digite una opcion valida!!");
        }
    }
    
    public static void Arbol(NodoB r){
        if (numero < r.numero) {
            if (r.izquierda == null) {
                r.izquierda = nNodo; 
            }
            else{
                Arbol(r.izquierda);
            }
        }
        else{
            if (r.derecha == null) {
                r.derecha = nNodo; 
            }
            else{
                Arbol(r.derecha);
            }
        }
    }
    
    public static void Recorridos(){
        int seleccion = 0;
        try{
        do{
            String menu = "------------------------------Menu------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Preorder\n2.- Postorder\n"
                +"3.- Inorder\n4.- Regresar al menu\n";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(seleccion){
            case 1:
                prnt = "";
                preOrder(raiz);
                JOptionPane.showMessageDialog(null, prnt);
                break;
            case 2:
                prnt = "";
                posOrder(raiz);
                JOptionPane.showMessageDialog(null, prnt);
                break;
            case 3:
                prnt = "";
                inOrder(raiz);
                JOptionPane.showMessageDialog(null, prnt);
                break;
            case 4:Menu();break;
        }      
        }
        while(seleccion != 4);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido del Menu de Opciones");
            Recorridos();
        }
    }
    
    public static void preOrder(NodoB r){
        if (r != null) {
            prnt += r.numero+"\n";
            preOrder(r.izquierda);
            preOrder(r.derecha);
        }
    }
    
    public static void posOrder(NodoB r){
        if (r != null) {
            posOrder(r.izquierda);
            posOrder(r.derecha);
            prnt += r.numero+"\n";
        }
    }
    
    public static void inOrder(NodoB r){
        if (r != null) {
            inOrder(r.izquierda);
            prnt += r.numero+"\n";
            inOrder(r.derecha);
        }
    }
    
    public static void profundidadAB(NodoB r){
        if (r.izquierda != null) {
            I++;
            profundidadAB(r.izquierda);
        }
        if (r.derecha != null) {
            D++;
            profundidadAB(r.derecha);
        }
    }
    
    public static void Cola(NodoB r){
        if (r != null) {
            Cola(r.izquierda);
            cola.add(r.numero);
            Cola(r.derecha);
        }
    }
    
    public static void eCola(){
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
            eCola();
        }
    }
    
    public static void ImprimirCola(){
        if (!cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los datos de la cola son:\n"+cola);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola");
        } 
    }
    
    public static void Pila(){
        try{
            int nDatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos desea agregar a la pila?"));
            for (int i = 0; i < nDatos; i++) {
                pila.push(Integer.parseInt(JOptionPane.showInputDialog("Digite el nuevo dato que sera almacenado:")));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            Pila();
        }
    }
    
    public static void ePila(){
        int seleccion = 0;
        try{
            seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quiere eleminar el primer elemento de la pila?\n1.- SI\n2.- NO"));
            switch(seleccion){
                case 1:
                    if (pila.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Pila!");
                    }
                    else{
                        pila.pop();
                    }
                    break;
                case 2: Menu();break;
                default: seleccion = 1/0; break;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            ePila();
        }
    }
    
    public static void ImprimirPila(){
        if (pila.size() != 0) {
            JOptionPane.showMessageDialog(null, "Los datos de la pila son:\n"+pila);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Pila");
        }
    }
    
    public static void exportarDatos(){
        do{
            nNodo = new NodoB(pila.peek());
            numero = pila.peek();
            Arbol(raiz);
            contadorNodos++;
            pila.pop();
        }
        while(pila.size() != 0);
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "------------------------------Menu------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Dar de alta nodo en el árbol binario (AB)\n"
                +"2.- Recorridos del AB\n"
                +"3.- Cantidad de nodos del AB\n"
                +"4.- Profundidad del AB\n"
                +"5.- Pasar los datos del AB a una cola\n"
                +"6.- Eliminar el primer elemento de la cola\n"
                +"7.- Imprimir cola\n"
                +"8.- Tamaño de la cola\n"
                +"9.- Dar de alta un elemento en la pila\n"
                +"10.- Dar de baja el ultimo elemento en la pila\n"
                +"11.- Imprimir pila\n"
                +"12.- Pasar los datos de la pila al AB (Se eliminaran los datos de la pila)\n"
                +"13.-Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(seleccion){
            case 1:nNodo();break;
            case 2:Recorridos();break;
            case 3:JOptionPane.showMessageDialog(null, "El numero de nodos del arbol es de: "+contadorNodos);break;
            case 4:
                profundidadAB(raiz);
                if (I >= D) {
                    profundidad = 1+I;
                }
                else{
                    profundidad = 1+D;
                }
                JOptionPane.showMessageDialog(null,"La profundidad del árbol binario es de: "+profundidad);
                break;
            case 5:Cola(raiz);JOptionPane.showMessageDialog(null, "Los datos fueron exportados exitosamente!!");break;
            case 6:eCola();break;
            case 7:ImprimirCola();break;
            case 8:JOptionPane.showMessageDialog(null, "El tamaño de la cola es de: "+cola.size());break;
            case 9:Pila();break;
            case 10:ePila();break;
            case 11:ImprimirPila();break;
            case 12:exportarDatos();break;
            case 13:System.exit(0);break; 
        }      
        }
        while(seleccion != 13);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido del Menu de Opciones!!");
            Menu();
        }
    }
    
    public static void main(String[] args) {
        cola = new LinkedList<>();
        pila = new LinkedList<>();
        Menu();
    }
    
}
//Erick Toledo
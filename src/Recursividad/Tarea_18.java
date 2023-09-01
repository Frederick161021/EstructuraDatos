package Recursividad;
import javax.swing.JOptionPane;
import java.util.LinkedList;

public class Tarea_18 {
    private static NodoLCDE inicio, fin, temp, temp2, nNodoLCDE;
    private static NodoAB nNodoAB, raiz, aux, aux2;
    private static LinkedList<Integer> cola;
    private static LinkedList<NodoAB> lista;
    private static int cont = 0, dato = 0,numero = 0,contadorNodos = 0, profundidad = 0,I = 0,D = 0;
    private static String nombre = "", prnt = "";
    private static boolean existe = false;
    
    public static void crearLCDE(){
        if (!existe) {
            int e = Integer.parseInt(JOptionPane.showInputDialog("Digite el exponenete del nodo:"));
            String n = JOptionPane.showInputDialog("Digite el nombre del nodo:");
            nNodoLCDE = new NodoLCDE(e,n,inicio,inicio);
            inicio = nNodoLCDE;
            fin = nNodoLCDE;
            existe = true;
            cont = 1;
        }
        else{
            JOptionPane.showMessageDialog(null, "El primer nodo de la LCDE ya existe!!");
        }
    }
    
    public static void nNodoAB(){
        try{
            int numNodos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de nodos que quiera agregar"));
            for (int i = 0; i < numNodos; i++) {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del nodo:"));
                nombre = JOptionPane.showInputDialog("Digite el nombre del nodo:");
                nNodoAB = new NodoAB(numero, nombre);
                if (contadorNodos == 0) {
                    raiz = nNodoAB;
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
    
    public static void Arbol(NodoAB r){
        if (numero < r.numero) {
            if (r.izquierda == null) {
                r.izquierda = nNodoAB; 
            }
            else{
                Arbol(r.izquierda);
            }
        }
        else{
            if (r.derecha == null) {
                r.derecha = nNodoAB; 
            }
            else{
                Arbol(r.derecha);
            }
        }
    }
    
    public static void nNodoLCDE(){
        try{
            if (existe) {
                int nDatos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos Articulos desea agregar a la LCDE?"));
                for (int i = 0; i < nDatos; i++) {
                    int exponente = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del nodo:"));
                    String nombre = JOptionPane.showInputDialog("Digite el nombre del nodo:");
                    if (exponente < inicio.exponente) {
                        nNodoLCDE = new NodoLCDE(exponente,nombre,fin,inicio);
                        inicio = nNodoLCDE;
                    }
                    else{
                        temp =inicio;
                        temp2 = inicio;
                        do{
                            temp2 = temp;
                            temp = temp.siguiente;
                        }while(exponente > temp.exponente && temp.siguiente != inicio); 
                        nNodoLCDE = new NodoLCDE(exponente,nombre,temp2,temp);
                        temp2.siguiente = nNodoLCDE;
                        temp.anterior = nNodoLCDE;
                        if (temp == inicio) {
                            fin = nNodoLCDE;
                        }
                    }
                cont++;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Primero debes de crear la LCDE!!");
                Menu();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar una Opción Valida!!");
            Menu();
        }
    }
    
    public static void ABaCola(NodoAB r){
        if (r != null) {
            ABaCola(r.izquierda);
            cola.add(r.numero);
            ABaCola(r.derecha);
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
    
    public static void preOrder(NodoAB r){
        if (r != null) {
            prnt += r.numero+" / "+r.nombre+"\n";
            preOrder(r.izquierda);
            preOrder(r.derecha);
        }
    }
    
    public static void posOrder(NodoAB r){
        if (r != null) {
            posOrder(r.izquierda);
            posOrder(r.derecha);
            prnt += r.numero+" / "+r.nombre+"\n";
        }
    }
    
    public static void inOrder(NodoAB r){
        if (r != null) {
            inOrder(r.izquierda);
            prnt += r.numero+" / "+r.nombre+"\n";
            inOrder(r.derecha);
        }
    }
    
    public static void ImprimirLCDE(){
        String imprimir = "";
        temp = inicio;
        do{
            imprimir += temp.exponente+" / "+temp.nombre+"\n";
            temp = temp.siguiente;
        }while(temp != null);;
        JOptionPane.showMessageDialog(null, imprimir);
    }
    
    public static void ImprimirCola(){
        if (!cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los datos de la cola son:\n"+cola);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Cola!!");
        } 
    }
    
    public static void profundidadAB(NodoAB r){
        if (r.izquierda != null) {
            I++;
            profundidadAB(r.izquierda);
        }
        if (r.derecha != null) {
            D++;
            profundidadAB(r.derecha);
        }
    }
    
    public static void datosLCDE(){
        infoAB(raiz);
        listaAB(raiz);
        do{
            aux = raiz;
            int n = lista.getFirst().numero;
            while(aux.numero != n){
                if (n < aux.numero) {
                    aux2 = aux;
                    aux = aux.izquierda;
                }else{
                    aux2 = aux; 
                    aux = aux.derecha;
                }
            }
            if (aux2.derecha == aux) {
                aux2.derecha = null;
            }
            else{
                aux2.izquierda = null;
            }
            aux = null;
            lista.poll();
        }while(!lista.isEmpty());
        raiz = null;
    }
    
    public static void infoAB(NodoAB d){
        if (d != null) {
        infoAB(d.izquierda);;
        if (d.numero < inicio.exponente) {
            nNodoLCDE = new NodoLCDE(d.numero,d.nombre,fin,inicio);
            inicio = nNodoLCDE;
        }
        else{
            temp =inicio;
            temp2 = inicio;
            do{
                temp2 = temp;
                temp = temp.siguiente;
            }while(d.numero > temp.exponente && temp.siguiente != inicio);
            nNodoLCDE = new NodoLCDE(d.numero,d.nombre,temp2,temp);
            temp2.siguiente = nNodoLCDE;
            temp.anterior = nNodoLCDE;
            if (temp == inicio) {
                fin = nNodoLCDE;
            }
        }
        infoAB(d.derecha);
        }
    }
    
    public static void listaAB(NodoAB r){
        if (r != null) {
            listaAB(r.izquierda);
            listaAB(r.derecha);
            lista.add(r);
        }
    }
    
    public static void datosAB(){
        temp = inicio;
        do{
            nNodoAB = new NodoAB(temp.exponente,temp.nombre);
            numero = temp.exponente;
            Arbol(raiz);
            contadorNodos++;
            temp = temp.siguiente;
            inicio = null;
            inicio =temp;
        }
        while(temp != null);
        cont = 0;
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "------------------------------Menu------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Crear lista circular doblemente encadenada (LCDE) \n"
                +"2.- Dar de alta nodo en el árbol binario (AB)\n"
                +"3.- Dar de alta un nodo en la LCDE\n"
                +"4.- Pasar los datos del AB de Numero a una cola \n"
                +"5.- Recorridos del AB\n6.- Imprimir datos de la LCDE\n"
                +"7.- Imprimir cola\n8.- Cantidad de nodos de la LCDE\n"
                +"9.- Cantidad de nodos del AB\n10.- Altura del AB\n"
                +"11.- Pasar los datos del AB a la LCDE (se eliminaran los datos del AB)\n"
                +"12.- Pasar los datos del la LCDE al AB(se eliminaran los datos de la LCDE)\n"
                +"13.-Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(seleccion){
            case 1:crearLCDE();break;
            case 2:nNodoAB();break;
            case 3:nNodoLCDE();break;
            case 4:cola.clear();ABaCola(raiz);break;
            case 5:Recorridos();break;
            case 6:if(cont !=0){ImprimirLCDE();}else{JOptionPane.showMessageDialog(null,"La LCDE no existe!!");}break;
            case 7:ImprimirCola();break;
            case 8:JOptionPane.showMessageDialog(null, "La cantidad de nodos de la LCDE es de: "+cont);break;
            case 9:JOptionPane.showMessageDialog(null, "El numero de nodos del arbol es de: "+contadorNodos);break;
            case 10:
                profundidadAB(raiz);
                if (I >= D) {
                    profundidad = 1+I;
                }
                else{
                    profundidad = 1+D;
                }
                JOptionPane.showMessageDialog(null,"La profundidad del árbol binario es de: "+profundidad);
                break;
            case 11:datosLCDE();break;
            case 12:datosAB();break;
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
        lista = new LinkedList<>();
        Menu();
    }   
}
//Erick Ivan Toledo Galeanan
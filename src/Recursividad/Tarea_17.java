package Recursividad;
import javax.swing.JOptionPane;

public class Tarea_17 {
    private static int numero = 0,contadorNodos = 0, profundidad = 0,I = 0,D = 0;
    private static String nombre = "", prnt = "";
    private static char estatus;
    private static Nodo nNodo, raiz, aux, aux2;
    
    public static void Arbol(Nodo r){
        if (numero < r.dato) {
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
    
    public static void nNodo(){
        try{
            int numNodos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de nodos que quiera agregar"));
            for (int i = 0; i < numNodos; i++) {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del nodo:"));
                nombre = JOptionPane.showInputDialog("Digite el nombre del nodo:");
                estatus = JOptionPane.showInputDialog("Digite el caracter del nodo:").charAt(0);
                nNodo = new Nodo(numero, nombre, estatus);
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
    
    public static void bEstatus(int n){
        aux = raiz;
        while(aux.dato != n){
            if (n < aux.dato) {
                aux = aux.izquierda;
            }else{
                aux = aux.derecha;
            }
            if (aux == null) {
                JOptionPane.showMessageDialog(null, "El nodo que se quiere dar de baja no existe!!");
                Menu();
            }
        }
        if (aux.dato3 != 'B') {
            aux.dato3 = 'B';
            JOptionPane.showMessageDialog(null, "El nodo se dio de baja: \n"+aux.dato+" / "+aux.dato2+" / "+aux.dato3);
            
        }
    }
    
    public static void Eleminar(Nodo p, Nodo e, boolean derecha){
        contadorNodos--;
        if (e.derecha == null && e.izquierda == null) {
            if (derecha) {
                p.derecha = null;
            }
            else{
                p.izquierda = null;
            }
            e = null;
            Menu();
        }
        else{
            if (e.derecha != null && e.izquierda != null) {
                if (derecha) {
                    aux = e.izquierda;
                    aux2 = aux;
                    while(aux.derecha != null){
                        aux2 = aux;
                        aux = aux.derecha;
                    }
                    if (aux.izquierda != null) {
                        aux2.derecha = aux.izquierda;
                    }
                    aux.derecha = e.derecha;
                    if (e.izquierda != aux) {
                        aux.izquierda = e.izquierda;
                    }
                    p.derecha = aux;
                    e = null;
                    Menu();
                }
                else{
                    aux = e.derecha;
                    aux2 = aux;
                    while(aux.izquierda != null){
                        aux2 = aux;
                        aux = aux.izquierda;
                    }
                    if (aux.derecha != null ) {
                            aux2.izquierda = aux.derecha;
                    }
                    aux.izquierda = e.izquierda;
                    if (e.derecha != aux) {
                        aux.derecha = e.derecha;
                    }
                    p.izquierda = aux;
                    e = null;
                    Menu();
                }
            }
            else{
                if (e.derecha != null) {
                    if (derecha) {
                        p.derecha = e.derecha;
                        e = null;
                        Menu();
                    }
                    else{
                        p.izquierda = e.derecha;
                        e = null;
                        Menu();
                    }
                }
                else {
                    if (derecha) {
                        p.derecha = e.izquierda;
                        e = null;
                        Menu();
                    }
                    else{
                        p.izquierda = e.izquierda;
                        e = null;
                        Menu();
                    }
                }
            }
        }
    }
    
    public static void eNodo(int n){
        aux = raiz;
        boolean hijoD = false;
        while(aux.dato != n){
            if (n < aux.dato) {
                hijoD = false;
                aux2 = aux;
                aux = aux.izquierda;
            }else{
                hijoD = true;
                aux2 = aux;
                aux = aux.derecha;
            }
            if (aux == null) {
                JOptionPane.showMessageDialog(null, "El nodo que se quiere eleminar no existe!!");
                Menu();
            }
        }
        Eleminar(aux2, aux, hijoD);
    }
    
    public static void Buscar(int n){  
        aux = raiz;
        while(aux.dato != n){
            if (n < aux.dato) {
                aux = aux.izquierda;
            }else{
                aux = aux.derecha;
            }
            if (aux == null) {
                JOptionPane.showMessageDialog(null, "El nodo que desea buscar no existe!!");
                Menu();
            }
        }
        if (aux.dato3 == 'B') {
            JOptionPane.showMessageDialog(null, "El nodo deseeado no esta dado de alta!!\n" + aux.dato+" / "+aux.dato2+" / "+aux.dato3);
            Menu();
        }
        else{
            JOptionPane.showMessageDialog(null, "El nodo deseeado esta dado de alta!!\n" +aux.dato+" / "+aux.dato2+" / "+aux.dato3);
            Menu();
        }
    }
    
    public static void preOrder(Nodo r){
        if (r != null) {
            prnt += r.dato+" / "+r.dato2+" / "+r.dato3+"\n";
            preOrder(r.izquierda);
            preOrder(r.derecha);
        }
    }
    
    public static void posOrder(Nodo r){
        if (r != null) {
            posOrder(r.izquierda);
            posOrder(r.derecha);
            prnt += r.dato+" / "+r.dato2+" / "+r.dato3+"\n";
        }
    }
    
    public static void inOrder(Nodo r){
        if (r != null) {
            inOrder(r.izquierda);
            prnt += r.dato+" / "+r.dato2+" / "+r.dato3+"\n";
            inOrder(r.derecha);
        }
    }
    
    public static void profundidad(Nodo r){
        if (r.izquierda != null) {
            I++;
            profundidad(r.izquierda);
        }
        if (r.derecha != null) {
            D++;
            profundidad(r.derecha);
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
    
    public static void Menu()
    {
        int seleccion = 0;
        try{
        do{
            String menu = "------------------------------Menu------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Insertar nuevos nodos \n2.- Dar de baja un nodo por estatus\n"
                +"3.- Eliminar nodo\n4.- Saber si un nodo esta dado de alta\n"
                +"5.- Cantidad de nodos del árbol binario\n6.- Profundidad del árbol binario\n"
                +"7.- Recorridos\n8.- Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(seleccion){
            case 1:nNodo();break;
            case 2:
                int e = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del nodo que desea dar de baja:"));
                bEstatus(e);
                break;
            case 3:
                int n = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del nodo que desea eleminar:"));
                if (n != raiz.dato) {
                    eNodo(n);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se puede eleminar la raiz del arbol binario!!");
                }
                break;
            case 4:
                int d = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del nodo que desea buscar: "));
                Buscar(d);
                break;
            case 5:JOptionPane.showMessageDialog(null, "El numero de nodos del arbol es de: "+contadorNodos);break;
            case 6:
                profundidad(raiz);
                if (I >= D) {
                    profundidad = 1+I;
                }
                else{
                    profundidad = 1+D;
                }
                JOptionPane.showMessageDialog(null,"La profundidad del árbol binario es de: "+profundidad);
                break;
            case 7:Recorridos();break;
            case 8:System.exit(0);break; 
        }      
        }
        while(seleccion != 8);
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
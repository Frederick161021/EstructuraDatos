package Ordinario;
import javax.swing.JOptionPane;
import java.util.LinkedList;

public class Examen {
    private static LinkedList<Integer> pila;
    private static Arbol nNodo, raiz, aux, aux2;
    private static Lista inicio, fin, temp, temp2, nNodoLista;
    private static String imprimir, nombre;
    private static int numero, contadorNodos, profundidad, I, D, suma = 0, fibonacci = 0;

    public static void Crear(){
        pila = new LinkedList<>();
        nNodo = new Arbol(0,null);
        nNodoLista = new Lista(0, null);
        JOptionPane.showMessageDialog(null,"Ya se han creado los elementos!!");
    }

    public static void nArbol(){
            int numNodos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de nodos que quiera agregar"));
            for (int i = 0; i < numNodos; i++) {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del nodo:"));
                nombre = JOptionPane.showInputDialog("Digite el nombre del nodo:");
                nNodo = new Arbol(numero,nombre);
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

    public static void Arbol(Arbol r){
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

    public static void nLista(Arbol r){
        if (r != null) {
            nLista(r.izquierda);
            Lista(r.numero,r.nombre);
            nLista(r.derecha);
        }
    }

    public static void Lista(int d, String n){
        if (inicio == null) {
            nNodoLista = new Lista(d,n);
            inicio = nNodoLista;
            fin = nNodoLista;
        }
        else{
            nNodoLista = new Lista(d,n,fin,inicio);
            fin.next = nNodoLista;
            inicio.prev = nNodoLista;
            fin = nNodoLista;
        }
    }

    public static void nPila(Arbol r){
        if (r != null) {
            nPila(r.izquierda);
            pila.push(r.numero);
            nPila(r.derecha);
        }
    }

    public static void PreOrder(Arbol r){
        if (r != null) {
            imprimir += r.numero+" / "+r.nombre+"\n";
            PreOrder(r.izquierda);
            PreOrder(r.derecha);
        }
    }

    public static void PosOrder(Arbol r){
        if (r != null) {
            PreOrder(r.izquierda);
            PreOrder(r.derecha);
            imprimir += r.numero+" / "+r.nombre+"\n";
        }
    }

    public static void InOrder(Arbol r){
        if (r != null) {
            PreOrder(r.izquierda);
            imprimir += r.numero+" / "+r.nombre+"\n";
            PreOrder(r.derecha);
        }
    }

    public static void bDato(int d){
        aux = raiz;
        while(aux.numero != d){
            if (d < aux.numero) {
                aux = aux.izquierda;
            }else{
                aux = aux.derecha;
            }
            if (aux == null) {
                JOptionPane.showMessageDialog(null, "El dato que se quiere buscar no existe!!");
                Menu();
            }
        }
        JOptionPane.showMessageDialog(null, "El nodo del arbol es: \n Numero: "+aux.numero+"\n Nombre: "+aux.nombre);
    }

    public static void Profundidad(Arbol r){
        if (r.izquierda != null) {
            I++;
            Profundidad(r.izquierda);
        }
        if (r.derecha != null) {
            D++;
            Profundidad(r.derecha);
        }
    }

    public static void eNodoLista(){
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el dato del Nodo que desea eleminar:"));
        if (dato == inicio.dato) {//
            inicio = inicio.next;
            inicio.prev = fin;
            fin.next = inicio;
        }
        else{
            temp =inicio;
            temp2 = inicio;
            boolean existe = true;
            while(dato != temp.dato || existe){
                temp2 = temp;
                temp = temp.next;
                if (temp == inicio) {
                    existe = false;
                }
            }
            temp.next.prev = temp2;
            temp2.next = temp.next;
        }
    }

    public static void ImprimirLista(){
        boolean fLista = false;
        temp = inicio;
        temp2 = inicio;
        while(!fLista){
            temp2 = temp;
            temp = temp.next;
            imprimir += "Numero: "+temp2.dato+"Nombre: "+temp2.nombre+"\n";
            if (temp == inicio) {
                 fLista = true;
            }
        }
        JOptionPane.showMessageDialog(null, imprimir);
    }

    public static int Fibonacci(int n){
        if (n >= 2) {
            fibonacci = Fibonacci(n-1) + Fibonacci(n-2);
        }
        if (n == 1) {
            fibonacci = 1;
        }
        if(n == 0){
            fibonacci = 0;
        }
        return fibonacci;
    }

    public static int recursividadImpar(int n){
        if (n>=10) {
            suma = (n%10)+ recursividadImpar(n/10);
        }else{
            suma = n%10;
        }
        return suma;
    }

    public static void Menu(){
        int seleccion;
        do{
        seleccion = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n"
                +"1.- Crear Arbol y Listas nulas\n"
                +"2.- Insertar un dato en el Arbol\n"
                +"3.- Copiar los datos del Arbol a Lista\n"
                +"4.- Copiar los datos del Arbol a Pila\n"
                +"5.- Imprimir Arbol en PreOrder\n"
                +"6.- Imprimir Arbol en PosOrder\n"
                +"7.- Imprimir Arbol en InOrder\n"
                +"8.- Consultar dato en Arbol\n"
                +"9.- Nodos totales del Arbol\n"
                +"10.- Profundidad del Arbol\n"
                +"11.- Eleminar un dato de la Lista\n"
                +"12.- Imprimir Lista\n"
                +"13.- Imprimir Pila\n"
                +"14.- Recusividad Par\n"
                +"15.- Recusividad Impar\n"
                +"16.- Salir del Programa"));
        switch(seleccion){
            case 1:Crear();break;
            case 2:nArbol();break;
            case 3:nLista(raiz);break;
            case 4:nPila(raiz);break;
            case 5:imprimir = "";PreOrder(raiz);JOptionPane.showMessageDialog(null, imprimir);break;
            case 6:imprimir = "";PosOrder(raiz);JOptionPane.showMessageDialog(null, imprimir);break;
            case 7:imprimir = "";InOrder(raiz);JOptionPane.showMessageDialog(null, imprimir);
            break;
            case 8:int d = Integer.parseInt(JOptionPane.showInputDialog("Digite el dato del nodo que desea buscar:"));bDato(d);break;
            case 9:JOptionPane.showMessageDialog(null, "El numero de nodos del arbol es de: "+contadorNodos);break;
            case 10:
                Profundidad(raiz);
                if (I >= D) {
                    profundidad = 1+I;
                }
                else{
                    profundidad = 1+D;
                }
                JOptionPane.showMessageDialog(null,"La profundidad del árbol binario es de: "+profundidad);
                break;
            case 11:eNodoLista();break;
            case 12:imprimir = "";ImprimirLista();break;
            case 13:JOptionPane.showMessageDialog(null, "Los datos de la pila son:\n"+pila);break;
            case 14:
                 int num = Integer.parseInt(JOptionPane.showInputDialog("Digite el Numero que desea saber su Fibonanci:"));
                JOptionPane.showMessageDialog(null, "El fibonacci del numero "+num+" es: "+Fibonacci(num));
                break;
            case 15:
                int n = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero que quiere sumar sus digitos:"));
                JOptionPane.showMessageDialog(null, "La suma de sus digitos es igual a: "+recursividadImpar(n));
                break;
            case 16:System.exit(0);break;
            default:JOptionPane.showMessageDialog(null,"Elija un numero valido!!");break;
        }
        }while(seleccion != 16);
    }

    public static void main(String[] args) {
        Menu();
    }

}

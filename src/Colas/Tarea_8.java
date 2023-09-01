package Colas;
import javax.swing.JOptionPane;

public class Tarea_8 {
   private static int[] Cola;
    private static int inicio = 0, fin = 0;
    private static boolean existe = false;  
    
    public static void crearCola(){
        int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño maximo que desee que tenga la cola\n(La cola anterior sera eleminada automaticamente)"));
        Cola = new int[tamaño+1]; 
        if (tamaño > 100) {
            JOptionPane.showMessageDialog(null, "El tamaño deseado es muy grande\n Favor de digitar un tamaño menor o igual a  100 ");
        }     inicio = 0; fin = 0;
        existe = true;
    }
    
    public static boolean colaVacia(){
        boolean vacia = false;
        if (fin == inicio) {
            vacia = true;
        }
         return vacia;
    }
    
    public static boolean colaLlena(){
        boolean llena = false;
        if (Cola.length-(fin+1) == 0 && fin != inicio) {
            llena = true;
        }
         return llena;
    }
    
    public static void nElementoCola(){
        try{
            int nDatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos desea agregar a la cola?"));
            if (nDatos != 0) {
            if (!colaLlena()) {
                Cola[fin] = 0;
                for (int i = fin+1; i <= nDatos+fin; i++) { 
                    Cola[i]=Integer.parseInt(JOptionPane.showInputDialog("Digite el nuevo dato que sera almacenado:"));
            }fin += nDatos;
            }else{
                nDatos = 1/0;
            }}else{
                Menu();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            nElementoCola();
        }
    }
    
    public static void eElementoPila(){
        int seleccion = 0;
        try{
            seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quiere eleminar el Primer dato de la Cola?\n1.- SI\n2.- NO"));
            switch(seleccion){
                case 1:inicio+=1;break;
                case 2: Menu();break;
                default: seleccion = 1/0; break;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            eElementoPila();
        }
    }
    
    public static void Imprimir(){
        if (inicio != fin) {
            String Datos = "Los datos de la pila son:\n";
            for (int i = inicio+1; i <= fin; i++) {
                if (i == fin) {
                    Datos += Cola[i];
                }else{
                    Datos += Cola[i]+",";
                }
            }
            JOptionPane.showMessageDialog(null, Datos);
        }else{
            JOptionPane.showMessageDialog(null, "La Cola esta Vacia");
        }
        
    }
    
    public static void imprimirPrimerE(){
        JOptionPane.showMessageDialog(null, "El primer elemento de la cola es: "+Cola[inicio+1]);
    }
    
    public static void imprimirUltimoE(){
        JOptionPane.showMessageDialog(null, "El ultimo elemento de la cola es: "+Cola[fin]);
    }
        
    public static void imprimirElementos(){
        int tElementos = Cola.length-1;
        JOptionPane.showMessageDialog(null, "La cantidad de elementos llenos de la cola es de: "+fin+"\nY la cantidad de elementos que puede almacenar es de: "+tElementos);
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "----------------------------------------Menu----------------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Crear cola\n2.- La cola esta vacia?\n3.- La cola esta llena?\n"
                +"4.- Insertar un nuevo elemento a la cola\n5.- Borrar un elemento de la cola\n"
                +"6.- Imprimir cola\n7.- Imprimir primer elemento de la cola\n"
                +"8.-Imprimir segundo elemento de la cola\n9.-Imprimir cantidad de elementos que contiene la cola\n"
                +"10.- Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        if(existe == true){
        switch(seleccion){
            case 1:crearCola();break;
            case 2:JOptionPane.showMessageDialog(null, "La cola esta vacia? = "+colaVacia());break;
            case 3:JOptionPane.showMessageDialog(null, "La cola esta llena? = "+colaLlena());break;
            case 4:nElementoCola();break;
            case 5:eElementoPila();break;
            case 6:Imprimir();break;
            case 7:imprimirPrimerE();break;
            case 8:imprimirUltimoE();break;
            case 9:imprimirElementos();break;
            case 10:System.exit(0);break;  
        }
        }else{
            switch(seleccion){
            case 1:crearCola();break;
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
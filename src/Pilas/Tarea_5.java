package Pilas;
import javax.swing.JOptionPane;

public class Tarea_5 {
    private static int pila[];
    private static int top = -1;
    private static boolean existe = false;  
    
    public static void crearPila(){
        int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño que desee que tenga la pila\n(La pila anterior sera eleminada automaticamente)"));
        pila = new int[tamaño]; 
        if (tamaño > 30) {
            JOptionPane.showMessageDialog(null, "El tamaño deseado es muy grande\n Favor de digitar un tamaño menor o igual a  30 ");
        }     
        top = -1;
        existe = true;
    }
    
    public static boolean pilaLlena(){
        boolean llena = false;
        if (pila.length == top+1) {
            llena = true;
        }
         return llena;
    }
    
    public static void nElementoPila(){
        try{
            int nDatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos desea agregar a la pila?"));
            if (pilaLlena() != true && nDatos <= (pila.length-(top+1))) {
                nDatos += top+1;
                for (int i = top+1; i < nDatos; i++) {
                pila[i]=Integer.parseInt(JOptionPane.showInputDialog("Digite el nuevo dato que sera almacenado:"));
                top += 1;
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
                if (posicion <= top+1) {
                    seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quere eleminar el dato numero "+posicion+" de la pila?\n1.- SI\n2.- NO"));
                    switch(seleccion){
                        case 1:
                            if (posicion == top+1) {
                                pila[posicion]=0;
                            }else {
                                int reacomodo = (top+1)-posicion;
                                for (int i = posicion-1; i <= reacomodo; i++) {
                                    pila[i] = pila[i+1];
                                }
                                pila[top] = 0;
                            }
                            top -=1;
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
        if (top != -1) {
            String Datos = "Los datos de la pila son:\n";
            for (int i = 0; i < top+1; i++) {
                if (i < top) {
                    Datos += pila[i]+",";
                }else{
                    Datos += pila[i];
                }
            }
            JOptionPane.showMessageDialog(null, Datos);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la Pila");
        }
        
    }
    
    public static void imprimirElementos(){
        int cElementos = top+1;
        JOptionPane.showMessageDialog(null, "La cantidad de elementos llenos de la pila es de: "+cElementos+"\nY la cantidad de elementos que puede almacenar es de: "+pila.length);
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
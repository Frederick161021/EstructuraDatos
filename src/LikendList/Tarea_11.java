package LikendList;
import javax.swing.JOptionPane;

public class Tarea_11 {
    private static Nodo inicio, temp, temp2, nNodo;
    private static int cont = 0, d1 = 0;
    private static boolean existe = false;  
    
    public static void crearLES(){
        inicio = null;
        existe = true;
    }
    
    public static boolean LESVacia(){
        return inicio==null;
    }
    
    public static void nElementoLES(){
        try{
            int nDatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos desea agregar a la cola?"));
                for (int i = 0; i < nDatos; i++) {
                    int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el Primer dato del nodo(int):"));
                    int dato2 = Integer.parseInt(JOptionPane.showInputDialog("Digite el Segundo dato del nodo(int):"));
                    char dato3 = JOptionPane.showInputDialog("Digite el Tercer dato del nodo(Char):").charAt(0);
                    if (LESVacia()) {
                        nNodo = new Nodo(dato,dato2,dato3);
                        inicio = nNodo; 
                    }
                    else{
                        temp = null;
                        temp2 = inicio;
                        while (dato > temp2.dato) {
                            temp = temp2;
                            temp2 = temp2.siguiente;
                        }
                        nNodo = new Nodo(dato,dato2,dato3,temp,temp2);
                        if (temp2 == inicio) {
                            inicio = nNodo;
                        }else{
                            temp.siguiente = nNodo;
                        }
                    }
                    cont++;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar una Opción Valida");
            nElementoLES();
        }
    }
    
    public static void eElementoLES(){
        int seleccion = 0;
        try{
            d1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el primer dato del elemento que desea eleminar:"));
            seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quiere eleminar el elemento de la LES?\n1.- SI\n2.- NO"));
            switch(seleccion){
                case 1:
                    if (LESVacia()) {
                        JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la LES!");
                    }else{
                        temp = inicio; 
                        while (temp.dato != d1 && temp != null) {
                            temp = temp.siguiente;
                        }
                        
                        if (temp == inicio) {
                            inicio = temp.siguiente;
                            cont--;
                            Menu();
                        }
                        if (temp.siguiente == null) {
                            temp2 = temp.anterior;
                            temp2.siguiente = null; 
                        }
                        else{
                            temp2 = temp.anterior;
                            temp2.siguiente = temp.siguiente;
                            temp2 = temp.siguiente;
                            temp2.anterior = temp.anterior;
                        }
                        cont--;
                    }
                    break;
                case 2: Menu();break;
                default: seleccion = 1/0; break;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            eElementoLES();
        }
    }
    
    public static void Imprimir(){
        String imprimir = "";
        temp2 = inicio;
        temp = temp2.siguiente; 
        while(temp2 != null){
            imprimir +=temp2.dato+"/"+temp2.dato2+"/"+temp2.dato3+"\n";
            temp2 = temp2.siguiente;
        }
        JOptionPane.showMessageDialog(null, imprimir);
    }
    
    public static void ImprimirPrimerE(){
        try{
            String prtn = "";
            d1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el primer dato del elemento que desea buscar:"));
            if (LESVacia()) {
                        JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la LES!");
                    }else{
                        temp = inicio; 
                        while(temp != null){
                            while (temp.dato < d1) {
                                temp = temp.siguiente;   
                            }
                            prtn += temp.dato+"/"+temp.dato2+"/"+temp.dato3+"\n";
                            temp = temp.siguiente;
                        }
                        JOptionPane.showMessageDialog(null, prtn);
                    }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            Menu();
        }
    }
    
    public static String ImprimirCElementos(){
        return "La Cantidad de Elementos es de: "+cont*3+"\n La Cantidad de Nodos es de: "+cont;
    }
    
    public static String Imprimir1Elemento(){ 
        return"EL Primer Elemento de la LES es:  "+inicio.dato+"/"+inicio.dato2+"/"+inicio.dato3;
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "----------------------------------------Menu----------------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Crear LES (La ultima LES se eleminara automaticamente)\n2.- La LES esta vacia?\n"
                +"3.- Insertar un nuevo elemento\n4.- Borrar un elemento\n"
                +"5.- Imprimir LES\n6.- Buscar un valor en la LES con el primer dato\n"
                +"7.- Imprimir el primer elemento de la LES\n8.- Imprimir la cantidad de elementos que contiene la LES\n"
                +"9.- Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        if(existe == true){
        switch(seleccion){
            case 1:crearLES();break;
            case 2:JOptionPane.showMessageDialog(null, "La LES esta vacia? = "+LESVacia());break;
            case 3:nElementoLES();break;
            case 4:eElementoLES();break;
            case 5:Imprimir();break;
            case 6:ImprimirPrimerE();break;
            case 7:JOptionPane.showMessageDialog(null,Imprimir1Elemento());break;
            case 8:JOptionPane.showMessageDialog(null,ImprimirCElementos());break;
            case 9:System.exit(0);break;  
        }
        }else{
            switch(seleccion){
            case 1:crearLES();break;
            case 9:System.exit(0);
            default:JOptionPane.showMessageDialog(null, "Opcion Invalida, Primero Debes de Crear una LES!");break;
        }
        }
        }
        while(seleccion != 9);
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

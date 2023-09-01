package LikendList;
import javax.swing.JOptionPane;

public class Tarea_14 {
    private static Nodo2 inicio, fin, temp, temp2, nNodo;
    private static int cont = 0, dato = 0;
    private static boolean existe = false;  
    
    public static void crearLES(){
        inicio = null;
        fin = null;
        existe = true;
    }
    
    public static void nElementoLESC(){
        try{
            int nDatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos Articulos desea agregar a la LESC?"));
            for (int i = 0; i < nDatos; i++) {
                int nArt = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del articulo:"));
                int depto = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del departamento:"));
                String nombre = JOptionPane.showInputDialog("Digite el nombre del Articulo:");
                int existencia = Integer.parseInt(JOptionPane.showInputDialog("Digite la existencia del articulo:"));
                float precio = Float.parseFloat(JOptionPane.showInputDialog("Digite el precio del articulo:"));
                if (inicio == null) {
                    nNodo = new Nodo2(nArt,depto,nombre,existencia,precio, inicio);
                    inicio = nNodo;
                    fin = nNodo;
                }
                else{
                    if (nArt < inicio.dato) {
                        nNodo = new Nodo2(nArt,depto,nombre,existencia,precio, inicio);
                        inicio = nNodo;
                    }
                    else{
                        temp =inicio;
                        temp2 = inicio;
                        while(nArt > temp.dato && temp.siguiente != null){
                            temp2 = temp;
                            temp = temp.siguiente;
                        } 
                        nNodo = new Nodo2(nArt,depto,nombre,existencia,precio, temp);
                        temp2.siguiente = nNodo;
                        if (temp == inicio) {
                            fin = nNodo;
                        }
                    }
                }
                cont++;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar una Opción Valida");
            nElementoLESC();
        }
    }
    
    public static void eElementoLESC(){
        int seleccion = 0;
        try{
            if (inicio == null) {
                JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la LESC!");
            }
            else{
                dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del articulo que desea eleminar:"));
                seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quieres eleminar el elemento de la LESC?\n1.- SI\n2.- NO"));
                switch(seleccion){
                    case 1:
                        if (dato == inicio.dato) {
                            inicio = inicio.siguiente;
                            fin.siguiente = inicio;
                        }
                        else{
                            temp =inicio;
                            temp2 = inicio;
                            while(dato != temp.dato && temp.siguiente != null){
                                temp2 = temp;
                                temp = temp.siguiente;
                            }
                            temp2.siguiente = temp.siguiente;
                            if (temp == inicio) {
                                fin = temp2;
                            }
                        }
                        cont--;
                    break;
                    case 2: Menu();break;
                    default: seleccion = 1/0; break;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            eElementoLESC();
        }
    }
    
    public static void ImprimirDepto(){
        try{
            String prtn = "";
            if (inicio == null) {
                JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la LESC!");
            }
            else{
                dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el departamento que desea buscar:"));
                temp = inicio;
                do{
                    if (temp.dato2 == dato) {
                        prtn += temp.dato+"/"+temp.dato2+"/"+temp.dato3+"/"+temp.dato4+"/"+temp.dato5+"\n";
                    }
                    temp = temp.siguiente;
                }while(temp != inicio);
                JOptionPane.showMessageDialog(null, prtn);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido");
            Menu();
        }
    }
    
    public static void Imprimir(){
        String imprimir = "";
        temp = inicio;
        do{
            imprimir += temp.dato+"/"+temp.dato2+"/"+temp.dato3+"/"+temp.dato4+"/"+temp.dato5+"\n";
            temp = temp.siguiente;
        }while(temp != inicio);
        JOptionPane.showMessageDialog(null, imprimir);
    }
    
    public static String ImprimirCElementos(){
        return "La Cantidad de Elementos es de: "+cont*5+"\n La Cantidad de Nodos es de: "+cont;
    }
    
    public static String ImprimirElementosPrecio(){
        String prnt = "";
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "Primero Debe de Llenar la LESC!");
        }
        else{
            temp = inicio;
            dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el precio que desea buscar:"));
            do{
                if (temp.dato5 <= dato) {
                    prnt += temp.dato+"/"+temp.dato2+"/"+temp.dato3+"/"+temp.dato4+"/"+temp.dato5+"\n";
                }
                temp = temp.siguiente;
            }while(temp != inicio);
        }
        return"Los elementos de LESC con un valor de "+dato+" o menor son:\n"+prnt;
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "----------------------------------------Menu----------------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Crear LESC (La ultima LESC se eleminara automaticamente)\n2.- Insertar un nuevo articulo\n3.- Borrar un articulo\n"
                +"4.- Imprimir un Departamento\n5.- Imprimir la LESC\n"
                +"6.- Imprimir la cantidad de elementos que contiene la LESC\n7.- Imprimir articulos de un departamento de precio menor o igual\n"
                +"8.- Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        if(existe == true){
        switch(seleccion){
            case 1:crearLES();break;
            case 2:nElementoLESC();break;
            case 3:eElementoLESC();break;
            case 4:ImprimirDepto();break;
            case 5:Imprimir();break;
            case 6:JOptionPane.showMessageDialog(null,ImprimirCElementos());break;
            case 7:JOptionPane.showMessageDialog(null,ImprimirElementosPrecio());break;
            case 8:System.exit(0);break;  
        }
        }else{
            switch(seleccion){
            case 1:crearLES();break;
            case 8:System.exit(0);
            default:JOptionPane.showMessageDialog(null, "Opcion Invalida, Primero Debes de Crear una LES!");break;
        }
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
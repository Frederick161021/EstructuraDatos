package Pilas;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Tarea_7 {
    private static Stack <String> placas;  
    
    public static void autoNuevo(){
        try{
            int nDatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos autos desea estacionar?"));
                nDatos += placas.size();
                for (int i = placas.size(); i < nDatos; i++) {
                String placa = (JOptionPane.showInputDialog("Digite las placas del auto por estacionar:")); 
                        placas.push(placa);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar una Placa Valida");
            autoNuevo();
        }
    }
    
    public static void autoEleminar(){
        int seleccion = 0,x = 0;
        String eAuto = "", topPlaca = "";
        if (placas.size() != 0) {
        try{
                eAuto = JOptionPane.showInputDialog("Digite la placa del auto que desea eleminar del estacionamiento: ");
                    seleccion = Integer.parseInt(JOptionPane.showInputDialog("Estas seguro de quere eleminar el auto "+eAuto+" del estacionamiento?\n1.- SI\n2.- NO"));
                    switch(seleccion){
                        case 1:
                            if (placas.peek().equalsIgnoreCase(eAuto)) {
                                placas.pop();
                            }else {
                                Stack <String> placasTemp = new Stack <>();
                                topPlaca = placas.peek();
                                do{
                                    placasTemp.push(placas.peek());
                                    placas.pop();
                                }while(placas.peek().equalsIgnoreCase(eAuto) == false );
                                placas.pop();
                                    do {
                                    placas.push(placasTemp.peek());
                                    placasTemp.pop();
                                } while (topPlaca == placas.peek());
                                    placas.push(placasTemp.peek());
                                    Menu();
                            } 
                            break;
                        case 2: Menu();break;
                        default:  x = 1/0; break;
                    }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar una Placa Valida");
            autoEleminar();
        }
        }else{
            JOptionPane.showMessageDialog(null,"Primero Debe de Estacionar un Auto!");
            Menu();
                    }
    }
    
    public static void Imprimir(){
        if (placas.size() != 0) {
            JOptionPane.showMessageDialog(null, "Las placas de los autos estacionados son:\n"+placas);
        }else{
            JOptionPane.showMessageDialog(null, "Primero Debe de Estacionar un Auto!");
        }
        
    }
    
    public static void imprimirElementos(){
        JOptionPane.showMessageDialog(null, "La cantidad de autos estacionados es de: "+placas.size()+"\nY la placa del ultimo auto estacinado es: "+placas.peek());
    }
    
    public static void Menu(){
        int seleccion = 0;
        try{
        do{
            String menu = "----------------------------------------Menu----------------------------------------\n"
                +"Digite el Numero que Desee que el Codigo Ejecute:\n"
                +"1.- Estacionar un nuevo auto\n2.- Quitar un auto del estacionamiento\n"
                +"3.- Imprimir el estacionamiento\n4.- Imprimir cantidad de elementos que contiene la pila y el elemento en el tope\n"
                +"5.- Salir del Programa";
        seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(seleccion){
            case 1:autoNuevo();break;
            case 2:autoEleminar();break;
            case 3:Imprimir();break;
            case 4:imprimirElementos();break;
            case 5:System.exit(0);break;  
        }
        }
        while(seleccion != 5);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "------------------------------Opcion Invalida------------------------------\nFavor de Digitar un Numero Valido del Menu de Opciones");
            Menu();
        }
    }

    public static void main(String[] args) {
        placas = new Stack<>();
        Menu();
    }
}
//Erick Toledo
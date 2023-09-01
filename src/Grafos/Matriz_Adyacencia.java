package Grafos;
import javax.swing.JOptionPane;

public class Matriz_Adyacencia {
    private  int maxVertices = 0;
    private int numVertices = 0;
    private boolean dirigido;
    private boolean [][] matriz;
    
    public Matriz_Adyacencia(int maxVertices, int numVertices, boolean dirigido, boolean [][] matriz){
        this.maxVertices = maxVertices;
        this.numVertices = numVertices;
        this.dirigido = dirigido;
        this.matriz = new boolean[maxVertices][maxVertices];
    }
    
    public int getMaxVertices(){
        return maxVertices; 
    }
    
    public int getNumVertices(){
        return numVertices; 
    }
    
    public boolean getDirigido(){
        return dirigido;
    }
    
    public void insertarVertice(){
        if (numVertices == maxVertices) {
            JOptionPane.showMessageDialog(null, "Se supera el numero de nodos!!");
        }else{
            for (int i = 0; i < numVertices; i++) {
                matriz [i][numVertices] = false;
                matriz [numVertices][i] = false;
            }
            numVertices++;
        }
    }
    
    public void insertarArista(int a, int b){
        if ((a<numVertices)&&(a>=0)&&(b<numVertices)&&(b>=0)) {
            matriz [a][b] = true;
            if (!dirigido) {
                matriz [a][b] =true;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los vertices no estan en el grafo!!");
        }
    }
    
    public void eleminarArista(int a, int b){
        if ((a<numVertices)&&(a>=0)&&(b<numVertices)&&(b>=0)) {
            matriz [a][b] = false;
            if (!dirigido) {
                matriz [a][b] = false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Las aristas no estan en el grafo!!");
        }
    }
    
    public boolean existeArista(int a, int b){
        if ((a<numVertices)&&(a>=0)&&(b<numVertices)&&(b>=0)) {
            return matriz [a][b];
        }else{
            return false;
        }
    }
    
    public int grado(int a){
        int resultado = 0;
        if ((a<numVertices)&&(a>=0)){
            for (int i = 0; i < numVertices; i++) {
                if (matriz[i][a] = true) {
                    resultado++;
                }
            }
        }
        return resultado;
    }
    
    public int columna(int a){
        int resultado = 0;
        if ((a<numVertices)&&(a>=0)){
            for (int i = 0; i < numVertices; i++) {
                if (matriz[i][a] = true) {
                    resultado++;
                }
            }
        }
        return resultado;
    }
    
    public int fila(int a){
        int resultado = 0;
        if ((a<numVertices)&&(a>=0)){
            for (int f = 0; f < numVertices; f++) {
                if (matriz[a][f] = true) {
                    resultado++;
                }
            }
        }
        return resultado;
    }
    
    public int incidencia(int a){
        int resultado = 0;
        if ((a<numVertices)&&(a>=0)){
            if (!dirigido) {
                resultado = columna(a);
            }else{
                resultado = columna(a)+fila(a);
            }
        }
        return resultado;
    }
    
    public int tamaño (int a){
        int resultado = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matriz [i][j]) {
                    if (dirigido || 1 >= j) {
                       resultado++; 
                    }
                }
            }
        }
        return resultado;
    }
    
    public void mostrar(){
        String m="";
        JOptionPane.showMessageDialog(null, "Nuestra matriz tiene: "+numVertices+" vertices");
        if (dirigido) {
          JOptionPane.showMessageDialog(null, "El grafo es dirigido");
        }else{
            JOptionPane.showMessageDialog(null, "El grafo es no dirigido");
        }
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matriz[i][j]) {
                    m += "1";
                }else{
                    m += "0";
                }
            }
        }
        JOptionPane.showMessageDialog(null, m);
    }
}

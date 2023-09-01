package Clases;

public class Edad {
   static Fecha fecha1;
   static Fecha fecha2;
   private int diaNacio;
   private int mesNacio;
   private int añoNacio;
   private int diaActual;
   private int mesActual;
   private int añoActual;
   private int EdadAños;
   private int EdadMes;

    public int getEdadAños() {
        return EdadAños;
    }

    public void setEdadAños(int EdadAños) {
        this.EdadAños = EdadAños;
    }

    public int getEdadMes() {
        return EdadMes;
    }

    public void setEdadMes(int EdadMes) {
        this.EdadMes = EdadMes;
    }

    public int getDiaNacio() {
        return diaNacio;
    }

    public void setDiaNacio(int diaNacio) {
        this.diaNacio = diaNacio;
    }

    public int getMesNacio() {
        return mesNacio;
    }

    public void setMesNacio(int mesNacio) {
        this.mesNacio = mesNacio;
    }

    public int getAñoNacio() {
        return añoNacio;
    }

    public void setAñoNacio(int añoNacio) {
        this.añoNacio = añoNacio;
    }

    public int getDiaActual() {
        return diaActual;
    }

    public void setDiaActual(int diaActual) {
        this.diaActual = diaActual;
    }

    public int getMesActual() {
        return mesActual;
    }

    public void setMesActual(int mesActual) {
        this.mesActual = mesActual;
    }

    public int getAñoActual() {
        return añoActual;
    }

    public void setAñoActual(int añoActual) {
        this.añoActual = añoActual;
    }

   public Edad(int diaNacio, int mesNacio, int añoNacio, int diaActual, int mesActual, int añoActual){
       fecha1 = new Fecha(diaNacio,mesNacio,añoNacio);        
        System.out.println(fecha1.toString());
        
        fecha2 = new Fecha(diaActual,mesActual,añoActual);        
        System.out.println(fecha2.toString());
        
        setDiaNacio(diaNacio);
        setMesNacio(mesNacio);
        setAñoNacio(añoNacio);
        setDiaActual(diaActual);
        setMesActual(mesActual);
        setAñoActual(añoActual);
   }
   public int edadAños(){
       EdadAños = getAñoActual()-getAñoNacio();
       if (mesNacio>mesActual){
           EdadAños=getEdadAños()-1;
       }
       return EdadAños;
   }
   public int edadMeses(){
       if (mesNacio<=mesActual) {
         EdadMes = getMesActual()-getMesNacio();  
       }
       if (mesNacio>mesActual){
           EdadMes = 12-(getMesNacio()-getMesActual()); 
       }
       return EdadMes;
   }
   public String toString(){
       
       return "La Persona que nacio el  "+fecha1.toString()+"  Actualmente  ("+fecha2.toString()+")  tiene una edad de "+edadAños()+"  Años con  "+edadMeses()+"  Meses";
   }
}

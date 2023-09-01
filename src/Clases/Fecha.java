package Clases;

public class Fecha {
    private int dia;
    private int mes; 
    private int año;
    
public Fecha(){}

public Fecha (int d, int m, int a){
    setdia(d);
    setmes(m);
    setaño(a);
}

public void setdia(int d){
    this.dia=d;
}
public void setmes(int m){
    this.mes=m;
}
public void setaño(int a){
    this.año=a;
}

public int getdia(){
    return dia;
}
public int getmes(){
    return mes;
}
public int getaño(){
    return año;
}

public String toString (){
    return dia+"/"+mes+"/"+año;
}
}
//Erick Ivan Toledo 
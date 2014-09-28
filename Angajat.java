import java.io.*;
public class Angajat implements Serializable{
    String nume;
    double salariu;
    
    public Angajat(String nume, double salariu){
        this.nume = nume;
        this.salariu = salariu;
    }
    
    public String toString(){
        return nume+" "+salariu;
    }
}

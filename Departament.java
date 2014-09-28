import java.util.*;
public class Departament implements java.io.Serializable{
    private ArrayList<Angajat> angajati = new ArrayList<>();
    private static Departament singleton = null;
    
    private Departament(){
    }
    
    public static Departament getInstance(){
        if(singleton == null){
            singleton = new Departament();
        }
        
        return singleton;
    }
    
    public void adaugaAngajat(Angajat a){
        angajati.add(a);
    }
    
    public void stergeAngajat(Angajat a){
        angajati.remove(a);
    }
    
    public ArrayList<Angajat> getAngajati(){
        return this.angajati;
    }
}

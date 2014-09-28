import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class MainFrame extends JFrame{
    private JMenuBar mb = new JMenuBar();
    private JMenu m1 = new JMenu("Optiuni");
    private JMenuItem mi1 = new JMenuItem("Adauga angajat");
    private JMenuItem mi2 = new JMenuItem("Salveaza departament");
    
    private DefaultListModel<Angajat> model = new DefaultListModel<>();
    private JList<Angajat> list = new JList<>(model);
    private JScrollPane jsp = new JScrollPane(list);
    
    public MainFrame(){
        super("Angajati");
        
        setJMenuBar(mb);
        mb.add(m1);
        m1.add(mi1);
        m1.add(mi2);
        
        mi1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    new AdaugaAngajat(MainFrame.this);
                }
            }
        );
        mi2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    JFileChooser chooser = new JFileChooser();
                    int r = chooser.showSaveDialog(null);
                    if(r == JFileChooser.APPROVE_OPTION){
                        File f = chooser.getSelectedFile();
                        try{
                            ObjectOutputStream out = new ObjectOutputStream(
                                new FileOutputStream(f)
                            );
                            out.writeObject(Departament.getInstance());
                            out.close();
                        }catch(Exception e){
                        }
                    }
                }
            }
        );
        
        add(jsp);
        
        list.addMouseListener(
            new MouseAdapter(){
                public void mouseClicked(MouseEvent ev){
                    if(ev.getClickCount() == 2){
                        Angajat a = list.getSelectedValue();
                        Departament.getInstance().stergeAngajat(a);
                        afisareAngajati();
                    }
                }
            }
        );
        
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void afisareAngajati(){
        model.clear();
        ArrayList<Angajat> angajati = Departament.getInstance().getAngajati();
        for(Angajat a: angajati){
            model.addElement(a);
        }
    }
    
    public static void main(String [] args){
        new MainFrame();
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdaugaAngajat extends JFrame{
    private JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    private JLabel e1 = new JLabel("NUME: ");
    private JLabel e2 = new JLabel("SALARIU: ");
    
    private JTextField t1 = new JTextField(10);
    private JTextField t2 = new JTextField(10);
    
    private JButton b = new JButton("ADAUGA ANGAJAT");
    
    public AdaugaAngajat(final MainFrame f){
        super("Adauga angajat");
        setLayout(new GridLayout(3,1));
        add(p1);
        add(p2);
        add(p3);
        
        p1.add(e1);p1.add(t1);
        p2.add(e2);p2.add(t2);
        p3.add(b);
        
        b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    String nume = t1.getText();
                    double salariu = Double.parseDouble(t2.getText());
                    Departament.getInstance().adaugaAngajat(new Angajat(nume,salariu));
                    f.afisareAngajati();
                    dispose();
                }
            }
        );
        
        pack();
        setResizable(false);
        setLocationRelativeTo(f);
        setVisible(true);
    }
}

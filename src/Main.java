
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame {

    public Main() {
        
        initUI();
    }
    
    private void initUI() {

        add(new Board());

        setTitle("Abacus");
        setSize(700, 300);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) { 
            Main m = new Main();
            m.setVisible(true);
    }
}
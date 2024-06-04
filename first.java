import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

/**
 * first
 */
public class first {

     public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setVisible(true);
        window.setSize(500,500);
        window.setTitle("First");
        window.setLayout(null);
        JLabel text = new JLabel("Welcome");
        text.setFont(new FontUIResource("DIGIFACE", 0, 50));
        text.setBounds(10,10,400,100);
        window.add(text);
        }
}
// hello

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login implements ActionListener {
    private JFrame window;
    private JPanel containerH, containerC,containerF;
    private JLabel title, nameText, passwordText,details;
    private JTextField nameInput, passwordInput;
    private JButton submit,clear;
    private ArrayList<User>users=new ArrayList<>();
    private final String PATH ="list";

    login() {
        // !Window Setup
        // This code snippet is creating a new JFrame window for a login screen. It sets
        // the window to be
        // visible, focusable, and sets its size and title. The window will be displayed
        // at position (10, 10)
        // with a width of 500 pixels and a height of 500 pixels. The title of the
        // window will be set to "Data
        // Manager".
        window = new JFrame();
        window.setFocusable(true);
        window.setBounds(10, 10, 600, 600);
        window.setLayout(new BorderLayout());
        window.setTitle("Data Manager");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //!Header
        containerH = new JPanel();
        containerH.setBackground(Color.white);
        containerH.setVisible(true);
        title = new JLabel("Authentication");
        title.setFont(new Font("DIGIFACE", 0, 28));
        containerH.add(title);
        window.add(containerH, BorderLayout.NORTH);

        // Setting containers
        containerC = new JPanel();
        containerC.setFocusable(true);
        containerC.setVisible(true);
        containerC.setLayout(new GridLayout(10, 2,0,10));

        //! setting inputs
        // Name
        nameText = new JLabel("Name");
        containerC.add(nameText);
        setFontDefault(nameText);
        nameInput = new JTextField();
        containerC.add(nameInput);

        // Password
        passwordText = new JLabel("Password");
        setFontDefault(passwordText);
        containerC.add(passwordText);
        passwordInput = new JTextField();
        containerC.add(passwordInput);

        // setting buttons
        submit = new JButton();
        setFontDefault(submit);
        submit.setText("LOG IN  / SIGN IN");
        submit.addActionListener(this);
        containerC.add(submit);
        clear = new JButton();
        setFontDefault(clear);
        clear.setText("CLEAR");
        clear.addActionListener(this);
        containerC.add(clear);

        window.add(containerC, BorderLayout.CENTER);

        //!Footer
        containerF = new JPanel();
        containerF.setBackground(Color.RED);
        containerF.setVisible(true);
        details = new JLabel("This is a secure data vault brought to you by BCA students GDC DODA");
        setFontDefault(details);
        containerF.add(details);
        window.add(containerF, BorderLayout.SOUTH);

        //!rendering the window
        window.setVisible(true);
        //!loading saved files
        load();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("LOG IN  / SIGN IN")){
            User newUser=new User(nameInput.getText(), passwordInput.getText());
            //Name Check 
            boolean flag=false;
            User found=null;
            for (User u : users) {
               if(newUser.matchName(u)){
                show("User Found");
                flag = true;
                found=u;
                break;
               }
            }
            if (flag){
            //Password Check
            if (newUser.matchPassword(found)) {
                new intract(newUser.getName());
                window.dispose();
                return;
            }else{
                //password problem
                clearInput(passwordInput);
                show("Password does not Match!");
             }
            }else{
                //new user
                users.add(newUser);
                save();
                clearInput(passwordInput);
                show("Your details have been saved");
            }
           
        }else if(e.getActionCommand().equals("CLEAR")){
            clearInput(nameInput);
            clearInput(passwordInput);
        }
        
    }
 

    @SuppressWarnings("unchecked")
    void load(){
         //loading Users
         File f= new File(PATH);
         if(f.exists()){
         //loading from storage
         try{
         FileInputStream fIn = new FileInputStream(PATH);
         ObjectInputStream oIN = new ObjectInputStream(fIn);
         users=(ArrayList<User>)oIN.readObject();
         oIN.close();
         fIn.close();
         }catch(Exception ex){
             System.err.println("x");
             ex.printStackTrace();
         }finally{
             for (User u : users) {
                 System.out.println(u.getDetails());
             }
         }
         }
    }
    void show(String x){
        JOptionPane.showMessageDialog(window,x,"INFO",JOptionPane.INFORMATION_MESSAGE);
    }
    void save(){
       //Saving User
       try{
       FileOutputStream fOut = new FileOutputStream(PATH);
       ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        oOut.writeObject(users);
        oOut.close();
        fOut.close();
       }catch(Exception ex){
        System.err.println("yy");
           ex.printStackTrace();
       }  
    }
    void setFontDefault(JComponent x){
        x.setFont(new Font("DIGIFACE", 0, 16));
    }
    void clearInput(JTextField x) {
        x.setText("");
    }

}

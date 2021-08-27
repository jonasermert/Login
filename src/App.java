import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class App implements ActionListener, KeyListener{

    private JFrame jFrame;
    private Container contentPane;

    private JLabel lbluser;
    private JLabel lblPassword;
    private JTextField tfUser;
    private JPasswordField pwfPassword;
    private JButton btnLogin;
    private JButton btnReset;
    private JCheckBox cbShowPassword;
    private JCheckBox cbHidePassword;

    private final String USERNAME = "jermert";
    private final String PASSWORD = "ultrasicheresPasswort123";

    public App(){
        initUI();

        createMenu();

        createComponents();

        setLayoutManager();

        addComponentsToContentPane();

        setLocationOfComponents();
    }

    private void initUI(){
        jFrame = new JFrame("Login");
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = jFrame.getContentPane();
        jFrame.setVisible(true);
    }

    private void createMenu(){
        JMenuBar bar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu sourceMenu = new JMenu("Source");

        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(sourceMenu);

        jFrame.setJMenuBar(bar);

        JMenuItem exitItem = new JMenuItem("Beenden", new ImageIcon("src/images/xmark.png"));
        exitItem.addActionListener(e -> {
            System.exit(0);
        });
        exitItem.setMnemonic(KeyEvent.VK_E);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.ALT_MASK));

        fileMenu.add(exitItem);
    }

    private void createComponents() {
        lbluser = new JLabel("Username: ");
        lblPassword = new JLabel("Passwort: ");

        tfUser = new JTextField();
        pwfPassword = new JPasswordField();
        pwfPassword.addKeyListener(this);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        btnReset = new JButton("Reset");
        btnReset.addActionListener(this);

        cbShowPassword = new JCheckBox("Passwort anzeigen");
        cbShowPassword.addActionListener(this);
        cbHidePassword = new JCheckBox("Passwort verbergen");
    }

    private void addComponentsToContentPane() {
        contentPane.add(lbluser);
        contentPane.add(lblPassword);
        contentPane.add(tfUser);
        contentPane.add(pwfPassword);
//		contentPane.add(cbHidePassword);
        contentPane.add(cbShowPassword);
        contentPane.add(btnLogin);
        contentPane.add(btnReset);
    }

    private void setLayoutManager() {
//		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 30, 30);
//		GridLayout layout = new GridLayout(4, 2, 30, 30);

        contentPane.setLayout(null);
    }

    private void setLocationOfComponents() {
        lbluser.setBounds(50, 150, 100, 30);
        lblPassword.setBounds(50, 220, 100, 30);
        tfUser.setBounds(150, 150, 150, 30);
        pwfPassword.setBounds(150, 220, 150, 30);
        cbShowPassword.setBounds(150, 250, 150, 30);
        btnLogin.setBounds(50, 300, 100, 30);
        btnReset.setBounds(200, 300, 100, 30);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnLogin){
            String userSting = tfUser.getText();
            char[] chars = pwfPassword.getPassword();
            String passwordString = new String(chars);

            if(usernamString.equalsIgnoreCase(userSting)
                    && passwordFieldString.equalsIgnoreCase(passwordString)){
                System.out.println("Login erfolgreich!");
                createDialog("Login erfolgreich!");
            } else {
                System.out.println("Username oder Passwort falsch!");
                createDialog("Username oder Passwort falsch!");
            }
        }

        if(e.getSource() == btnReset){
            tfUser.setText("");
            pwfPassword.setText("");
        }

        if(e.getSource() == cbShowPassword){
            if(cbShowPassword.isSelected()){
                pwfPassword.setEchoChar((char)0);
            } else {
                pwfPassword.setEchoChar('*');
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("Zum Login!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    private void createDialog(String message){
        JOptionPane.showMessageDialog(jFrame, message);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new App();
            }
        });
    }

}
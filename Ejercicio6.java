import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


public class Ejercicio6 {
    public static void main(String[] args) {


        JFrame frame = new JFrame();

        JLabel titulo = new JLabel("Welcome", SwingConstants.LEFT);
        titulo.setFont(new Font("Source Code Pro Light", Font.BOLD, 24));

        JLabel nombre = new JLabel("Nombre");
        JTextField campoNombre = new JTextField(10);

        JLabel contra = new JLabel("Contraseña");
        JPasswordField campoContrasena = new JPasswordField();

        JButton iniciarSesion = new JButton("Iniciar sesión");

        JToggleButton cambiarColor = new JToggleButton("COLOR");
        cambiarColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cambiarColor.isSelected()) {
                    frame.getContentPane().setBackground(Color.GREEN);
                } else {
                    frame.getContentPane().setBackground(Color.BLUE);
                }
            }
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));
        frame.getContentPane().setBackground(Color.PINK);

        frame.add(titulo);
        frame.add(new JLabel());
        frame.add(nombre);
        frame.add(campoNombre);
        frame.add(contra);
        frame.add(campoContrasena);
        frame.add(new JLabel());
        frame.add(iniciarSesion);
        frame.add(cambiarColor);

        campoContrasena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion.doClick();
            }
        });

        campoNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion.doClick();
            }
        });

        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreIngresado = campoNombre.getText();
                char[] contrasenaIngresada = campoContrasena.getPassword();
                String contrasenaString = new String(contrasenaIngresada);

                if (nombreIngresado.equals("usuario") && contrasenaString.equals("contrasena")) {
                    Sesion_Ejercicio6 ventana = new Sesion_Ejercicio6(nombreIngresado);
                    ventana.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Nombre de usuario o contraseña incorrectos");
                }

                campoNombre.setText("");
                campoContrasena.setText("");
            }
        });


        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/Imagen_Ejercicio2.png")));

        frame.setVisible(true);
    }
}

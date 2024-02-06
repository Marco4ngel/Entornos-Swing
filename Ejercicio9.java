import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio9 {

    public static void confirmacion(JFrame frame) {
        int opcion = JOptionPane.showConfirmDialog(frame, "¿Seguro que quieres cerrar la ventana?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JLabel titulo = new JLabel("Bienvenido", SwingConstants.LEFT);
        titulo.setFont(new Font("Source Code Pro Light", Font.BOLD, 24));

        JLabel nombre = new JLabel("Nombre");
        JTextField campoNombre = new JTextField(10);

        JLabel contra = new JLabel("Contraseña");
        JPasswordField campoContrasena = new JPasswordField();

        JButton iniciarSesion = new JButton("Iniciar sesión");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));
        frame.getContentPane().setBackground(Color.PINK);

        frame.add(titulo);
        frame.add(new JLabel());
        frame.add(nombre);
        frame.add(campoNombre);
        frame.add(contra);
        frame.add(campoContrasena);
        frame.add(new JLabel());
        frame.add(iniciarSesion);

        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreIngresado = campoNombre.getText();
                char[] contrasenaIngresada = campoContrasena.getPassword();
                String contrasenaString = new String(contrasenaIngresada);

                if (nombreIngresado.equals("usuario") && contrasenaString.equals("contrasena")) {
                    JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso");
                } else {
                    JOptionPane.showMessageDialog(frame, "Nombre de usuario o contraseña incorrectos");
                }

                campoNombre.setText("");
                campoContrasena.setText("");
            }
        });

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/Imagen_Ejercicio2.png")));

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmacion(frame);
            }
        });
    }
}

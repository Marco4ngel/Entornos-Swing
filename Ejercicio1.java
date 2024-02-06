import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JLabel titulo = new JLabel("Wellcome", SwingConstants.LEFT);
        titulo.setFont(new Font("Source Code Pro Light", Font.BOLD, 24));

        JLabel nombre = new JLabel("Nombre");
        JTextField campoNombre = new JTextField(10);

        JLabel contra = new JLabel("Contraseña");
        JPasswordField campoContrasena = new JPasswordField();

        JLabel vacio = new JLabel();JLabel vacio1 = new JLabel();
        JButton iniciarSesion = new JButton("Iniciar sesión");


        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));
        frame.setVisible(true);

        campoNombre.setSize(90, 10);
        campoContrasena.setSize(90, 10);

        frame.add(titulo);
        frame.add(vacio);
        frame.add(nombre);
        frame.add(campoNombre);
        frame.add(contra);
        frame.add(campoContrasena);
        frame.add(vacio1);
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

        frame.setVisible(true);
    }
}
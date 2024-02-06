import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Sesion_Ejercicio6 extends JFrame {
    public Sesion_Ejercicio6(String username) {
        setTitle("Sesión de " + username);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana, no toda la aplicación
        setLocationRelativeTo(null);

        // Contenido de la nueva ventana
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Source Code Pro", Font.BOLD, 24));

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acciones cuando se presiona el botón de salida
                dispose(); // Cierra la ventana de sesión
                // Abre la ventana de inicio de sesión
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(welcomeLabel, BorderLayout.CENTER);
        panel.add(logoutButton, BorderLayout.SOUTH);

        add(panel);
    }
}
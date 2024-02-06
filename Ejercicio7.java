import javax.swing.*;
import javax.swing.text.MaskFormatter; // Agregar esta importación
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ejercicio7 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calcular Edad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("Introduce tu fecha de nacimiento (dd-mm-yyyy):");
        JFormattedTextField campoFechaNacimiento = new JFormattedTextField(createFormatter("##-##-####"));
        JButton calcularButton = new JButton("Calcular Edad");

        frame.add(label);
        frame.add(campoFechaNacimiento);
        frame.add(calcularButton);

        calcularButton.addActionListener(e -> {
            String fechaNacimientoString = campoFechaNacimiento.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date fechaNacimiento = sdf.parse(fechaNacimientoString);
                int edad = calcularEdad(fechaNacimiento);
                JOptionPane.showMessageDialog(frame, "Tu edad es: " + edad + " años");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(frame, "Formato de fecha incorrecto. Introduce dd-mm-yyyy");
            }
        });

        frame.setVisible(true);
    }

    private static int calcularEdad(Date fechaNacimiento) {
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(fechaNacimiento);
        Calendar ahora = Calendar.getInstance();

        int diferencia = ahora.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);
        if (ahora.get(Calendar.MONTH) < fechaNacimientoCal.get(Calendar.MONTH) || (ahora.get(Calendar.MONTH) == fechaNacimientoCal.get(Calendar.MONTH) && ahora.get(Calendar.DAY_OF_MONTH) < fechaNacimientoCal.get(Calendar.DAY_OF_MONTH))) {
            diferencia--;
        }
        return diferencia;
    }

    private static MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }
}

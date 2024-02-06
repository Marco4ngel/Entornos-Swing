import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JSlider Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JLabel valueLabel = new JLabel("Numero: " + slider.getValue());
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueLabel.setText("Numero: " + slider.getValue());
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(slider, BorderLayout.NORTH);
        panel.add(valueLabel, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

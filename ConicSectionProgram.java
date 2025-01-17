package src;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConicSectionProgram extends JFrame {

    public ConicSectionProgram() {
        setTitle("Cónicas");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Seleccione la cónica que desea trabajar:");
        label.setBounds(10, 10, 280, 25);
        panel.add(label);

        String[] options = {"Parábola"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(10, 40, 160, 25);
        panel.add(comboBox);

        JButton button = new JButton("Aceptar");
        button.setBounds(10, 80, 100, 25);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parabola parabola = new Parabola();

                parabola.inputParameters();
                if (parabola.validateParameters()) {
                    parabola.calculateProperties();
                    parabola.displayProperties();
                    ConicSectionChart.displayChart(parabola);
                } else {
                    JOptionPane.showMessageDialog(null, "Los parámetros ingresados son inválidos.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConicSectionProgram().setVisible(true);
            }
        });
    }
}

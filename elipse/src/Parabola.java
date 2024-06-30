import javax.swing.*;

public class Parabola {
    private double h, k, p;

    public void inputParameters() {
        JTextField hField = new JTextField();
        JTextField kField = new JTextField();
        JTextField pField = new JTextField();
        Object[] message = {
            "Vértice h:", hField,
            "Vértice k:", kField,
            "Coeficiente p:", pField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese los parámetros de la parábola", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            h = Double.parseDouble(hField.getText());
            k = Double.parseDouble(kField.getText());
            p = Double.parseDouble(pField.getText());
        }
    }

    public boolean validateParameters() {
        return p != 0;
    }

    public void calculateProperties() {
        // La ecuación de la parábola es (x-h)^2 = 4p(y-k)
        double focalLength = p;
        double directrix = k - p;

        String properties = String.format(
            "Vértice: (%.2f, %.2f)%nFocal Length: %.2f%nDirectriz: y = %.2f",
            h, k, focalLength, directrix
        );

        JOptionPane.showMessageDialog(null, properties, "Propiedades de la Parábola", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayProperties() {
        JOptionPane.showMessageDialog(null, "Parábola con vértice (" + h + ", " + k + ") y coeficiente " + p);
    }

    public String getType() {
        return "Parábola";
    }

    public double getH() {
        return h;
    }

    public double getK() {
        return k;
    }

    public double getP() {
        return p;
    }
}

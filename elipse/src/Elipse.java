import javax.swing.*;

public class Elipse {
    private double a, b, p;

    public void inputParameters() {
        JTextField aField = new JTextField();
        JTextField bField = new JTextField();
        JTextField pField = new JTextField();
        Object[] message = {
            "Vértice a:", aField,
            "Vértice b:", bField,
            "Coeficiente p:", pField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese los parámetros de la elipse", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            a = Double.parseDouble(aField.getText());
            b = Double.parseDouble(bField.getText());
            p = Double.parseDouble(pField.getText());
        }
    }

    public boolean validateParameters() {
        return p != 0;
    }

    public void calculateProperties() {
        // La ecuación de la elipse es (x^2)/a + (y^2)/b = p
        double focalLength = p;
        double directrix = b - p;

        String properties = String.format(
            "Vértice: (%.2f, %.2f)%nFocal Length: %.2f%nDirectriz: y = %.2f",
            a, b, focalLength, directrix
        );

        JOptionPane.showMessageDialog(null, properties, "Propiedades de la Elipse", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayProperties() {
        JOptionPane.showMessageDialog(null, "Elipse con vértice (" + a + ", " + b + ") y coeficiente " + p);
    }

    public String getType() {
        return "Elipse";
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getP() {
        return p;
    }
}

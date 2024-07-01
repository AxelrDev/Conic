import javax.swing.*;

public class Elipse {
    private double a, b;

    public void inputParameters() {
        JTextField aField = new JTextField();
        JTextField bField = new JTextField();
        Object[] message = {
            "Vértice a:", aField,
            "Vértice b:", bField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese los parámetros de la elipse", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            a = Double.parseDouble(aField.getText());
            b = Double.parseDouble(bField.getText());
        }
    }

    public boolean validateParameters() {
        return (a != b);
    }

    public void calculateProperties() {
        // La ecuación de la elipse es (x^2)/a + (y^2)/b = 1
        double focalLength = 1;
        double directrix = b - 1;

        String properties = String.format(
            "Vértice: (%.2f, %.2f)%nFocal Length: %.2f%nDirectriz: y = %.2f",
            a, b, focalLength, directrix
        );

        JOptionPane.showMessageDialog(null, properties, "Propiedades de la Elipse", JOptionPane.INFORMATION_MESSAGE);
    }

    public void calculateCuadratic() {
        // La ecuación cuadratica de la elipse se obtiene multiplicando ambos lados por el mcm de los denominadores
        double denominatorX = Math.pow(getA(), 2);
        double denominatorY = Math.pow(getB(), 2);
        Mcm min_cm = new Mcm();
        double mcm = min_cm.calculateMCM(denominatorX, denominatorY);
        double coeficientX = mcm / denominatorX;
        double coeficientY = mcm / denominatorY;

        String properties = String.format(
            "Cuadratica: %.0fx^2 + %.0fy^2 - %.0f = 0%n",
            coeficientX, coeficientY, mcm
        );

        JOptionPane.showMessageDialog(null, properties, "Propiedades de la Elipse", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayProperties() {
        JOptionPane.showMessageDialog(null, "Elipse con vértice (" + a + ", " + b + ") y coeficiente " + 1);
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
}

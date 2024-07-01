import javax.swing.*;

/**
 * @class Elipse
 * @brief Representa una elipse con sus propiedades y métodos para calcular y mostrar sus parámetros.
 */
public class Elipse {
    private double a, b;

    /**
     * @brief Solicita al usuario los parámetros de la elipse mediante un cuadro de diálogo.
     */
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

    /**
     * @brief Valida los parámetros de la elipse. Verifica que a y b no sean iguales.
     * @return true si a y b son diferentes, false en caso contrario.
     */
    public boolean validateParameters() {
        return (a != b);
    }

    /**
     * @brief Calcula y muestra la forma cuadrática de la elipse y su matriz asociada en cuadros de diálogo.
     */
    public void calculateCuadratic() {
        double denominatorX = Math.pow(getA(), 2);
        double denominatorY = Math.pow(getB(), 2);
        Mcm min_cm = new Mcm();
        double mcm = min_cm.calculateMCM(denominatorX, denominatorY);
        double coeficientX = mcm / denominatorX;
        double coeficientY = mcm / denominatorY;

        String forma_cuadratica = String.format(
            "Cuadratica: %.0fx^2 + %.0fy^2 - %.0f = 0%n",
            coeficientX, coeficientY, mcm
        );
        String matriz_cuadratica = String.format(
            "Matriz de la forma cuadratica:\n     x   y  \n_______\nx |  %-3.0f 0   \ny |  0    %-3.0f ",
            coeficientX, coeficientY
        );
        JOptionPane.showMessageDialog(null, forma_cuadratica, "Propiedades de la Elipse", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, matriz_cuadratica, "Propiedades de la Elipse", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * @brief Muestra las propiedades básicas de la elipse en un cuadro de diálogo.
     */
    public void displayProperties() {
        JOptionPane.showMessageDialog(null, "Elipse con limites (" + a + " y " + b + ") y constante " + 1);
    }

    /**
     * @brief Devuelve el tipo de esta figura geométrica.
     * @return El tipo de la figura (en este caso, "Elipse").
     */
    public String getType() {
        return "Elipse";
    }

    /**
     * @brief Obtiene el valor del vértice a.
     * @return El valor del vértice a.
     */
    public double getA() {
        return a;
    }

    /**
     * @brief Obtiene el valor del vértice b.
     * @return El valor del vértice b.
     */
    public double getB() {
        return b;
    }
}

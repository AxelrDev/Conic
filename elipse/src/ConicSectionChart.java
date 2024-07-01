import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

/**
 * @class ConicSectionChart
 * @brief Clase para generar y mostrar gráficos de secciones cónicas (parábola y elipse).
 */
public class ConicSectionChart {

    /**
     * @brief Muestra un gráfico de una parábola.
     * @param parabola La instancia de la parábola a graficar.
     */
    public static void displayChart(Parabola parabola) {
        XYSeries series = new XYSeries(parabola.getType());
        
        double h = parabola.getH();
        double k = parabola.getK();
        double p = parabola.getP();

        // Generar puntos para la parábola
        for (double x = h - 10; x <= h + 10; x += 0.1) {
            double y = (1 / (4 * p)) * Math.pow(x - h, 2) + k;
            series.add(x, y);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                parabola.getType(),    // Título del gráfico
                "X",                   // Etiqueta del eje X
                "Y",                   // Etiqueta del eje Y
                dataset,               // Dataset de los datos
                PlotOrientation.VERTICAL,  // Orientación del gráfico
                true,                  // Mostrar leyenda
                true,                  // Mostrar tooltips
                false                  // Mostrar URLs
        );

        // Configurar y mostrar la ventana del gráfico
        JFrame frame = new JFrame("Gráfica de la Parábola");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * @brief Muestra un gráfico de una elipse.
     * @param elipse La instancia de la elipse a graficar.
     */
    public static void displayChart(Elipse elipse) {
        XYSeries series = new XYSeries(elipse.getType());
        
        double a = elipse.getA();
        double b = elipse.getB();
  
        // Generar puntos para la elipse
        for (double i = -1000; i <= 1000; i += 0.01) {
            double y1 = Math.sqrt((1 - (Math.pow(i, 2) / Math.pow(a, 2))) * Math.pow(b, 2));
            double y2 = y1 * -1;  // Punto simétrico respecto al eje X
            series.add(i, y1);
            series.add(i, y2);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                elipse.getType(),      // Título del gráfico
                "X",                   // Etiqueta del eje X
                "Y",                   // Etiqueta del eje Y
                dataset,               // Dataset de los datos
                PlotOrientation.VERTICAL,  // Orientación del gráfico
                true,                  // Mostrar leyenda
                true,                  // Mostrar tooltips
                false                  // Mostrar URLs
        );

        // Configurar y mostrar la ventana del gráfico
        JFrame frame = new JFrame("Gráfica de la Elipse");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

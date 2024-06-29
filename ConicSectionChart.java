package src;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class ConicSectionChart {

    public static void displayChart(Parabola parabola) {
        XYSeries series = new XYSeries(parabola.getType());
        
        double h = parabola.getH();
        double k = parabola.getK();
        double p = parabola.getP();

        for (double x = h - 10; x <= h + 10; x += 0.1) {
            double y = (1 / (4 * p)) * Math.pow(x - h, 2) + k;
            series.add(x, y);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                parabola.getType(),
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        JFrame frame = new JFrame("Gráfica de la Parábola");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

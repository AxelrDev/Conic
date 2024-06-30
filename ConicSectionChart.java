package Conic;
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
    public static void displayChart(Elipse elipse) {
        XYSeries series = new XYSeries(elipse.getType());
        
        
        double a = elipse.getA();
        double b = elipse.getB();
        double p = elipse.getP();
  
        double y1 = 0;
        double y2 = 0;
        
        for(double i = -1000; i<=1000; i = i+0.01){
           y1 =  Math.sqrt((p-(Math.pow(i, 2)/Math.pow(a, 2))) * Math.pow(b, 2));
           //y2 =  Math.sqrt((p-(Math.pow(i, 2)/Math.pow(a, 2))) * Math.pow(b, 2));
           y2 = y1 *-1;
           series.add(i, y1);
           series.add(i, y2);
        }
        //for(int i = -10000; i<=10000; ++i){
          //x = -1* Math.sqrt((p-(Math.pow(i, 2)/Math.pow(a, 2))) * Math.pow(b, 2));

        //  series.add(i, x);
       //}

        //for(int i = -100; i<=100; ++i){
        //  x =  Math.sqrt((p+(Math.pow(i, 2)/Math.pow(b, 2))) * Math.pow(a, 2));
        //  series.add(x, i);
        //}


        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                elipse.getType(),
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        JFrame frame = new JFrame("Gráfica de la Elipse");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

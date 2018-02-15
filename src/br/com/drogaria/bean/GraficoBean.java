package br.com.drogaria.bean;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean (name = "MBGrafico")
public class GraficoBean implements Serializable {
 
    private BarChartModel animatedModel2;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    private void createAnimatedModels() {

        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Fabricantes x Produtos");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries fab = new ChartSeries();
        fab.setLabel("Fabricantes");
        fab.set("2018", 40);

        ChartSeries prod = new ChartSeries();
        prod.setLabel("Produtos");
        prod.set("2018", 60);

        model.addSeries(fab);
        model.addSeries(prod);
         
        return model;
    }

    
}
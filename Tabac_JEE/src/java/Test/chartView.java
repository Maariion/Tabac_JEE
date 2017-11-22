/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class chartView implements Serializable {
 
    private LineChartModel animatedModel;
    private Utilisateur uti;
    private UtilisateurDao dao = new UtilisateurDao();
    
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    public LineChartModel getAnimatedModel() {
        return animatedModel;
    }
    private void createAnimatedModels() {
        animatedModel = initLinearModel();
        animatedModel.setTitle("Line Chart");
        animatedModel.setAnimate(true);
        animatedModel.setLegendPosition("se");
        Axis yAxis = animatedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10); 
    }
    
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        
        model.addSeries(series1);
        return model;
    }
    
}


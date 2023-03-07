/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Sirine
 */
public class ChartFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
//    private BarChart<String,Double> chart;
//
//    private CategoryAxis xAxis;
//
//    private NumberAxis yAxis;
//    // Define the data for the chart
//    private ObservableList<XYChart.Data<String, Double>> data = FXCollections.observableArrayList();
//
//    private Button calculateButton;
//    @FXML
//    private PieChart pieChart;
//    @FXML
//    private ComboBox<?> combo1;
//    @FXML
//    private TextField mater;
//    
//    void handleCalculate(ActionEvent event) {
//    // Get the recycled weight for each type from the database and update the data
//    MateriauxService service = new MateriauxService();
//    data.get(0).setYValue(service.TauxRecyclage("Metal"));
//    data.get(1).setYValue(service.TauxRecyclage("Plastique"));
//    data.get(2).setYValue(service.TauxRecyclage("verre"));
//}
//
//@Override
//public void initialize(URL url, ResourceBundle rb) {
//    // Set up the chart
//    xAxis.setLabel("Type");
//    yAxis.setLabel("Poids recyclés");
//    chart.setTitle("Poids recyclé par type");
//
//    // Add the data to the chart
//    data.add(new XYChart.Data<>("Metal", 50.0));
//    data.add(new XYChart.Data<>("Plastique", 30.0));
//    data.add(new XYChart.Data<>("verre", 20.0));
//    XYChart.Series<String, Double> series = new XYChart.Series<>(data);
//    chart.getData().add(series);
//
//    // Set up the calculate button
//    calculateButton.setOnAction(this::handleCalculate);
//}
    // private ComboBox<String> combo1;
     @FXML
    private PieChart pieChart;
    private double poidsRecycle;
    private double poidsNonRecycle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
         // remove the pieChart initialization code
}

public void setData(double poidsRecycle, double poidsNonRecycle) {
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Poids recyclé", poidsRecycle),
        new PieChart.Data("Poids non recyclé", poidsNonRecycle)
    );
    pieChart.setData(pieChartData);
}}
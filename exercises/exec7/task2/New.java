package exec7.task2;


import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class New extends Application {

    /*Main method*/
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes"})
	@Override
    public void start(Stage primaryStage) throws IOException {
    	
    	//scene and title
        Scene scene = new Scene(new Group(), 550, 480);
        primaryStage.setTitle("Grades");
        
        //instantiate TextFields
        TextField gradeTxt = new TextField ();
        
        //instantiate text fields
        Text errorText = new Text();
        
        Text avgText = new Text();
        	avgText.setText("Average: ");
        	
        Text counterText = new Text();
        	counterText.setText("Count: ");

        //instantiate buttons
        Button addBtn=new Button("Insert");
        
        //instantiate gridpane, setVgap,Hgap,padding and add children
        GridPane grid = new GridPane();
       
        //instantiate table
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart barChart = new BarChart(xAxis, yAxis);
        
        barChart.setTitle("Grades");
        xAxis.setLabel("Arvosana");
        yAxis.setLabel("M‰‰r‰");
        barChart.setLegendVisible(false);
        barChart.setAnimated(false);
        
        final int[] values = {0, 0, 0, 0, 0, 0};
        final String[] names = {"0", "1", "2", "3", "4", "5"};
        
 
        
        XYChart.Series<String, Number> series1 = new Series<>();
        
        for(int i = 0; i < names.length; i++) {
            series1.getData().add(new Data<>(names[i], values[i]));
        }
        
       	barChart.getData().add(series1);
        
        //instantiate gridpane, setVgap,Hgap,padding and add buttons,textboxes,texts
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.add(new Label("Insert grade (Between 0 and 5):"), 0, 0);
        grid.add(gradeTxt, 1, 0);
        grid.add(addBtn, 2, 0);
        grid.add(errorText, 3, 0);
        grid.add(avgText, 0, 13);
        grid.add(counterText, 1, 13);
        grid.add(barChart, 0, 2, 5, 10);
        
        //Action when "Add" button is clicked
        addBtn.setOnMouseClicked((MouseEvent event) -> {
        	
        	
        	if(isParsable(gradeTxt.getText())) {
        		
        		int grade = Integer.parseInt(gradeTxt.getText());
        		

	        	if (grade>=0 && grade<=5) {
	        		
	        		values[grade] = values[grade]+1;
	        		
	        		int count = 0;
	        		double avg = 0;
	        		
	        		for(int i = 0; i < names.length; i++) {
	                    series1.getData().add(new Data<>(names[i], values[i]));
	                    
	                 
	                    count = count+values[i];
	                    
	                    avg = avg+ (Double.parseDouble(names[i])*values[i]);

	                }
	        		
	        		double average = avg / count;
	        		
	        		
	        		counterText.setText("Count: "+count);
	        		avgText.setText("Average: "+ Math.round(average*100.0)/100.0);
	        		errorText.setText("Added!");
	        	} else {
	        		errorText.setText("Not between 0, 5");	
	        	}
        	} else {
        		errorText.setText("Not an integer");
        	}
        	gradeTxt.clear();
        });
        
        
        //add gridpane to group
        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        
        //set scene and show stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
	public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
	}
}
package exec7.task1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ikkuna extends Application {

    /*Main method*/
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) {

        //set scene and title
        Scene scene = new Scene(new Group(), 330, 110);
        stage.setTitle("Ohms law");

        //instantiate TextFields
        TextField voltageTxt = new TextField ();
        TextField resistanceTxt = new TextField ();
        TextField currentTxt = new TextField ();

        //instantiate buttons
        Button calcBtn=new Button("Calculate");
        Button clearBtn=new Button("Clear");

        //instantiate gridpane, setVgap,Hgap,padding and add children
        GridPane grid = new GridPane();
        
        //instantiate gridpane, setVgap,Hgap,padding and add buttons
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.add(new Label("Voltage (U): "), 0, 0);
        grid.add(voltageTxt, 1, 0);
        
        grid.add(new Label("Resistance (R): "), 0, 1);
        grid.add(resistanceTxt, 1, 1);
        
        grid.add(new Label("Current (I): "), 0, 2);
        grid.add(currentTxt, 1, 2);

        grid.add(calcBtn, 2, 0);
        grid.add(clearBtn, 2, 2);

  
        
        calcBtn.setOnMouseClicked((MouseEvent event) -> {
        			
        	Calculation calc = new Calculation(voltageTxt.getText(),resistanceTxt.getText(),currentTxt.getText());
        	
        	if(voltageTxt.getText().isEmpty()) {
 
        		voltageTxt.setText(calc.voltage());
        		
        	}else if(currentTxt.getText().isEmpty()) {

        		currentTxt.setText(calc.current());
        		
        	}else{

        		resistanceTxt.setText(calc.resistance());
        	}
        });
        
        clearBtn.setOnMouseClicked((MouseEvent event) -> {
        	
        	voltageTxt.setText("");
        	currentTxt.setText("");
        	resistanceTxt.setText("");
        });
        

        //add gridpane to group
        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        //set scene and show stage
        stage.setScene(scene);
        stage.show();
    }
}
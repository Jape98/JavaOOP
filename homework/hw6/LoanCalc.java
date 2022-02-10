package hw6;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalc extends Application {

    /*Main method*/
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes", "resource"})
	@Override
    public void start(Stage primaryStage) throws IOException {
    	
    	//scene and title
        Scene scene = new Scene(new Group(), 900, 450);
        primaryStage.setTitle("Loan calculator");
        
        //instantiate TextFields
        TextField amountTxt = new TextField ();
        TextField irateTxt = new TextField ();
        TextField periodTxt = new TextField ();
        
        //instantiate buttons
        Button calcBtn=new Button("Calculate");
        Button clearBtn=new Button("Clear");
        
        //instantiate gridpane, setVgap,Hgap,padding and add children
        GridPane grid = new GridPane();
       
        //instantiate table
        TableView table = new TableView();
        table.setEditable(true);
        
        //instantiate gridpane, setVgap,Hgap,padding and add buttons
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.add(new Label("Loan amoutn (ä): "), 0, 0);
        grid.add(amountTxt, 1, 0);
        
        grid.add(new Label("Interest rate: "), 2, 0);
        grid.add(irateTxt, 3, 0);
        
        grid.add(new Label("Period (Years): "), 4, 0);
        grid.add(periodTxt, 5, 0);

        grid.add(calcBtn, 6, 0);
        grid.add(clearBtn, 7, 0);
        grid.add(table, 0, 1, 8, 10);
        
        //instantiate table colum names, values and width
        TableColumn yearCol = new TableColumn("Year");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        yearCol.setMinWidth(110);
        
        TableColumn repayCol = new TableColumn("Repayment");
        repayCol.setCellValueFactory(new PropertyValueFactory<>("repayment"));
        repayCol.setMinWidth(190);
        
        TableColumn interestCol = new TableColumn("Interest");
        interestCol.setCellValueFactory(new PropertyValueFactory<>("interest"));
        interestCol.setMinWidth(190);
        
        TableColumn installmentCol = new TableColumn("Installment");
        installmentCol.setCellValueFactory(new PropertyValueFactory<>("installment"));
        installmentCol.setMinWidth(190);
        
        TableColumn remainingCol = new TableColumn("Remaining");
        remainingCol.setCellValueFactory(new PropertyValueFactory<>("remaining"));
        remainingCol.setMinWidth(190);
        
        //add columns to table
        table.getColumns().addAll(yearCol, repayCol, interestCol, installmentCol, remainingCol);
        
        //Create new file to write
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Jape\\Desktop\\workspace\\Calculator\\homework\\hw6\\file.txt"));
        
        //Action when "Calculate" button is clicked
        calcBtn.setOnMouseClicked((MouseEvent event) -> {
        	

        	Loan Loan =new Loan(amountTxt.getText(),irateTxt.getText(),periodTxt.getText());
        	
        	//Print input into the file
        	pw.println(Loan.toString());
        	
        	for(int i = 1; i-1 < Integer.parseInt(periodTxt.getText()); i++) {
        		
        	
        	LoanRow looploan = new LoanRow(	i,
        										Loan.GetRepayment(),
        										(Loan.GetInterestRate()/100)*(Loan.getAmount()-(Loan.GetRepayment()*(i-1))),
        										(Loan.GetInterestRate()/100)*(Loan.getAmount()-(Loan.GetRepayment()*(i-1)))+Loan.GetRepayment(),
        										Loan.getAmount()-(Loan.GetRepayment()*i));
        	//add looploan to table
        	table.getItems().add(looploan);
        	
        	//print current looploan to txt
        	pw.println(looploan.toString());
        	}
        	pw.close();
        });
        
        //Clear button clears whole table on click
        clearBtn.setOnMouseClicked((MouseEvent event) -> {
        	table.getItems().clear();
        
        });
        
        //add gridpane to group
        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        
        //set scene and show stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
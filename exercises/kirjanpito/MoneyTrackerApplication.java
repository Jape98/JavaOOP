package kirjanpito;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MoneyTrackerApplication extends Application {
	
	//Arraylist for table rows. This will be serialized and deserialized into
	private ArrayList<ExpenditureRow> tableList = new ArrayList<>();
	
	//caregories array list to string array for barchart to read the categories
	private XYChart.Series<String, Number> series1 = new Series<>();
	//set arraycategoriesn and values as public to barchart can be updated all the times
	private String[] arrayCategories = {"Food & drink", "Clothes", "Housing","Car","Hobbies","Pets","Other"};
	private double[] arrayValues = {0,0,0,0,0,0,0};
	
	//create new date and set current date as default.
	private Date date = new Date();
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
	
	//textFields and comboBoxes in same order they appear in GUI
	private final TextField dateField = new TextField(formatter.format(date));
	private final ComboBox<String> categoryCmb = new ComboBox<>();
	private final TextField descField = new TextField();
	private final TextField priceField = new TextField();
	private final TextField searchField = new TextField();

	
	//mainpanel as golbal variable becuase changes are made using methods in this class.
	private final BorderPane mainpanel = new BorderPane();
	
	//tableview
	private final TableView<ExpenditureRow> table = new TableView<ExpenditureRow>();
		
	//barchart and axis
	private final CategoryAxis xAxis = new CategoryAxis();
	private final NumberAxis yAxis = new NumberAxis();
	private final BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
	
	//file chooser for open and save methods
	private final FileChooser fileChooser = new FileChooser();

	// Exceptions
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) { 
			
		//methods to execute before anything else happens
		initAxis();


		//Controls for creating new order
		GridPane grid1 = new GridPane();
		grid1.setAlignment(Pos.CENTER);
		grid1.setHgap(10); //Horizontal space between columns
		grid1.setVgap(10); //Vertical space between rows
		grid1.setPadding(new Insets(25, 25, 25, 25));

		// Labels in column 0, text fields, buttons and comboboxes in colun 1
		Label label1 = new Label("Date:");
		grid1.add(label1, 0, 1);
		grid1.add(dateField, 1, 1);

		Label label2 = new Label("Category:");
		grid1.add(label2, 0, 2);
		grid1.add(categoryCmb, 1, 2);
		categoryCmb.getItems().addAll("Food & drink", "Clothes", "Housing","Car","Hobbies","Pets","Other");
		categoryCmb.getSelectionModel().selectFirst();
		
		Label label3 = new Label("Amount:");
		grid1.add(label3, 0, 3);
		grid1.add(priceField, 1, 3);
		
		Label label4 = new Label("Description:");
		grid1.add(label4, 0, 4);
		grid1.add(descField, 1, 4);

		Button addBtn = new Button("Add to table");
		grid1.add(addBtn, 1, 5);
		addBtn.setMaxWidth(100);
		
		Button tableBtn = new Button("View table");
		grid1.add(tableBtn, 1, 9);
		tableBtn.setMaxWidth(100);
		
		Button chartBtn = new Button("View bar chart");
		grid1.add(chartBtn, 1, 10);
		chartBtn.setMaxWidth(100);
		
		//search button is in column 0
		Button searchBtn = new Button("Search by date");
		grid1.add(searchBtn, 0, 14);
		searchBtn.setMaxWidth(100);
		grid1.add(searchField, 1, 14);
		
		//instantiate bar chart
		barChart.setTitle("Expenditures/Category");
        xAxis.setLabel("Category");
        yAxis.setLabel("Expenditures");
        barChart.setLegendVisible(false);
        barChart.setAnimated(false);
		
		//instantiate table column names, values and width
		@SuppressWarnings("rawtypes")
		TableColumn dateCol = new TableColumn("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        dateCol.setResizable(false);
        
		@SuppressWarnings("rawtypes")
		TableColumn yearCol = new TableColumn("Category");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        yearCol.prefWidthProperty().bind(table.widthProperty().multiply(0.283));
        yearCol.setResizable(false);
        
        @SuppressWarnings("rawtypes")
		TableColumn repayCol = new TableColumn("Amount");
        repayCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        repayCol.prefWidthProperty().bind(table.widthProperty().multiply(0.283));
        repayCol.setResizable(false);
        
        @SuppressWarnings("rawtypes")
		TableColumn interestCol = new TableColumn("Description");
        interestCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        interestCol.prefWidthProperty().bind(table.widthProperty().multiply(0.283));
        interestCol.setResizable(false);
        
        //Add columns to table.
		table.getColumns().addAll(dateCol, yearCol, repayCol, interestCol);
		
		//Create menubar and File menu
		MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);
        
        MenuItem startNew = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem saveAs = new MenuItem("Save As");
        MenuItem exit = new MenuItem("Exit");
        menuFile.getItems().addAll(startNew, open, saveAs, new SeparatorMenuItem(),  exit);
		mainpanel.setTop(menuBar);
	        
		//application default size
		Scene scene = new Scene(mainpanel, 900, 600);
		
		//Grid1 left on borderpane
		mainpanel.setLeft(grid1);
		
		//TabView/BarChart center of borderpane
		table.setEditable(false);
		//Show table by default
		mainpanel.setCenter(table);
		
		//set scene name and
		primaryStage.setTitle("Where's my money?");		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Event handlers for "file" dropdown menu-------------------------
		startNew.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				newTable(e);
			}
		});
		
		/* Event handlers for serialize buttons commented out
		open.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				 File file = fileChooser.showOpenDialog(primaryStage);
                 if (file != null) {
                    readOrdersFromFile(file);
                 }
			}
		});
		saveAs.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				 File file = fileChooser.showSaveDialog(primaryStage);
                 if (file != null) {
                    saveOrdersToFile(file);
                 }
			}
		});
		*/
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				Platform.exit();
			}
		});

		//Event handlers for buttons-----------------------------------
		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				addTableRow(e);
			}
		});
		tableBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				viewTable(e);
			}
		});
		chartBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				viewBarChart(e);
			}
		});
		searchBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				search(e);
			}
		});
	}
	
	public void initAxis() {

        for(int i = 0; i < arrayCategories.length; i++) {
            series1.getData().add(new Data<>(arrayCategories[i], arrayValues[i]));
        }
       	barChart.getData().add(series1); 	
	}

	//Adds new line to table and barChart.
	private void addTableRow(ActionEvent e) {
		try {
		String category = categoryCmb.getValue();
		Paivamaara date = new Paivamaara(dateField.getText());
		double price=Double.parseDouble(priceField.getText());
		String desc = descField.getText();
		
		//make new row object and add it to the arraylist
		ExpenditureRow tableRow = new ExpenditureRow(date,category,price,desc);
		tableList.add(tableRow);
		
		//add current row to tableView
		table.getItems().add(tableRow);
		
		//set textFields as null after adding
		descField.setText(null);
		priceField.setText(null);
		
		//Add new value to barChart
		for(int i = 0; i < arrayCategories.length; i++) {
			
			if(arrayCategories[i].equals(categoryCmb.getValue())) {
				
				arrayValues[i] = arrayValues[i] + price;
				
			    series1.getData().add(new Data<>(arrayCategories[i], arrayValues[i]));	
			}
		}
		
		} catch(Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Invalid input");
			alert.setContentText("Check input values");
			alert.setContentText("Use point instead of comma as decimal separator");
			alert.showAndWait();
			return;
		}
	}
	//Serialize and reserialize methods, not in working order yet
	
	/*
	//Writes orders to file 
	private void saveOrdersToFile(File file) {
		System.out.println(file.getAbsolutePath());
		
		try (ObjectOutputStream file_out
	             = new ObjectOutputStream(new FileOutputStream(file))){
	            file_out.writeObject(tablelist);
	            System.out.println("ArrayList is serialized");
	        }
	}
	
	//Reads orders from file
	@SuppressWarnings("unchecked")
	private void readOrdersFromFile(File file) {
        try (ObjectInputStream file_in = new ObjectInputStream(new FileInputStream(file))){
        
                tablelist = (ArrayList<ExpenditureRow>)file_in.readObject();
        }
     }

	}
	*/	
	private void viewBarChart(ActionEvent e) {
		mainpanel.setCenter(barChart);
	}
	
	private void viewTable(ActionEvent e) {
		mainpanel.setCenter(table);
	}
	
	private void addToBarchart() {

		/*Tähän oli tulossa metodi jolla lisätään olemassaolevat arvot deserialisoidusta tiedostosta, mutta huonasin
		 * että tämä koko ohjelma on tähän asti tehty ihan päin per-- honkia, joten nostan valkoisen lipun tässä kohtaa
		 * ajan puutteen vuoksi. EI olisi saanut jättää tätä tehtävää tämän vuoden puolelle vaan kuinka kävikään*/
	}
	//Clears table, barchart, gui controls
	private void newTable(ActionEvent e) {
		descField.setText(null);
		priceField.setText(null);
		searchField.setText(null);
		tableList.clear();
		for ( int i = 0; i<table.getItems().size(); i++) {
	        table.getItems().clear(); 
	    }
		table.refresh();
		for(int i = 0; i < arrayCategories.length; i++) {
			arrayValues[i]=0;
			series1.getData().add(new Data<>(arrayCategories[i], arrayValues[i]));
		}
		
	}
	//Date filter that is not functional
	private void search(ActionEvent e) {
		//tableList.stream().filter((date)->date.getDate().equals(dateField.getText())).forEach(System.out::println);
	}

	public static void main(String[] args) {
		launch(args);
	}

}

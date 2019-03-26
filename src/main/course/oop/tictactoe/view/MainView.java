package main.course.oop.tictactoe.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import util.TwoDArray;

public class MainView {
	private BorderPane root;
	private Scene scene; 
    private TwoDArray twoDArr;
	private Text statusNode;
    private final int windowWidth = 800;
    private final int windowHeight = 600;
	
	public MainView() {
		this.root = new BorderPane();
		this.scene = new Scene(root, windowWidth, windowHeight);		
		this.statusNode = new Text("no status");
		this.root.setTop(this.buildSetupPane());
	}
	
	public Scene getMainScene() {
		return this.scene;
	}

	public GridPane buildSetupPane() {
	    Text sizeLabel = new Text("Number of players:");  
        TextField sizeTextField = new TextField();

        Button button1 = new Button("Submit"); 
        button1.getStyleClass().add("orangeButton");
        Line line = new Line();
        
        line.setStartX(0.0f); 
        line.setStartY(0.0f);         
        line.setEndX((float) windowWidth); 
        line.setEndY(0.0f);
        
        //Creating the mouse event handler 
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
           @Override 
           public void handle(MouseEvent e) { 
               String numPlayers = sizeTextField.getText();
               buildNameInputPane(numPlayers);
           } 
        };  
        //Registering the event filter 
        button1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);   

        //Creating a Grid Pane 
        GridPane gridPane = new GridPane();    
        
        //Setting size for the pane 
        gridPane.setMinSize(windowWidth, (int) windowHeight/4); 
        
        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        
        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER); 
        
        gridPane.add(sizeLabel, 0, 0); 
        
        gridPane.add(sizeTextField, 0, 1); 
        
        gridPane.add(button1, 2, 1); 
        gridPane.add(line, 0, 2, 3, 1); 
              
        return gridPane;
	}
	
	public void buildNameInputPane(String numPlayersString) {
		String text = "";
		try {
			int numPlayers =Integer.parseInt(numPlayersString);
	        System.out.println("Hello World " + numPlayers);
			root.setTop(enter2PlayerNames());
		}catch(NumberFormatException nfe) {
			text = "Please enter integer values!";
		}
	}
	
	public GridPane enter1PlayerName() {
	    Text p1nameLabel = new Text("Player 1 name:");  
	    Text p1markerLabel = new Text("Player 1 marker");       
        TextField p1nameField = new TextField();
        TextField p1markerField = new TextField();   
        
        Button button1 = new Button("Submit"); 
        button1.getStyleClass().add("orangeButton");
        Line line = new Line();
        
        
        line.setStartX(0.0f); 
        line.setStartY(0.0f);         
        line.setEndX((float) windowWidth); 
        line.setEndY(0.0f);
        
        //Creating the mouse event handler 
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
           @Override 
           public void handle(MouseEvent e) { 
               String size = p1nameField.getText();
               String defaultVal = p1markerField.getText();

               System.out.println(size + defaultVal);
           } 
        };  
        //Registering the event filter 
        button1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);   

        //Creating a Grid Pane 
        GridPane gridPane = new GridPane();    
        
        //Setting size for the pane 
        gridPane.setMinSize(windowWidth, (int) windowHeight/4); 
        
        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        
        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER); 
        
        gridPane.add(p1nameLabel, 0, 0); 
        gridPane.add(p1markerLabel, 1, 0); 
        
        gridPane.add(p1nameField, 0, 1); 
        
        gridPane.add(p1markerField, 1, 1);
        gridPane.add(button1, 2, 1); 
        gridPane.add(line, 0, 2, 3, 1); 
              
        return gridPane;
	}
	
	public GridPane enter2PlayerNames() {
	    Text p1nameLabel = new Text("Player 1 name:");  
	    Text p1markerLabel = new Text("Player 1 marker");       
        TextField p1nameField = new TextField();
        TextField p1markerField = new TextField();   
        
        Text p2nameLabel = new Text("Player 2 name:");  
	    Text p2markerLabel = new Text("Player 2 marker");       
        TextField p2nameField = new TextField();
        TextField p2markerField = new TextField();   
        
        Button button1 = new Button("Submit"); 
        button1.getStyleClass().add("orangeButton");
        Line line = new Line();
        
        
        line.setStartX(0.0f); 
        line.setStartY(0.0f);         
        line.setEndX((float) windowWidth); 
        line.setEndY(0.0f);
        
        //Creating the mouse event handler 
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
           @Override 
           public void handle(MouseEvent e) { 
               String size = p1nameField.getText();
               String defaultVal = p1markerField.getText();

               System.out.println(size + defaultVal);
           } 
        };  
        //Registering the event filter 
        button1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);   

        //Creating a Grid Pane 
        GridPane gridPane = new GridPane();    
        
        //Setting size for the pane 
        gridPane.setMinSize(windowWidth, (int) windowHeight/4); 
        
        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        
        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER); 
        
        gridPane.add(p1nameLabel, 0, 0); 
        gridPane.add(p1markerLabel, 1, 0); 
        gridPane.add(p1nameField, 0, 1); 
        gridPane.add(p1markerField, 1, 1);
        
        gridPane.add(p2nameLabel, 0, 2); 
        gridPane.add(p2markerLabel, 1, 2); 
        gridPane.add(p2nameField, 0, 3); 
        gridPane.add(p2markerField, 1, 3);
        
        gridPane.add(button1, 2, 3); 
        gridPane.add(line, 0, 4, 3, 1); 
              
        return gridPane;
	}
	


}

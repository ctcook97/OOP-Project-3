package course.oop.tictactoe.view;

import java.io.File;

import course.oop.main.GUI_Driver;
import course.oop.player.PlayerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;

public class MainView {
	private BorderPane root;
	private Scene scene; 
	private Text statusNode;
    private final int windowWidth = 800;
    private final int windowHeight = 600;
    
    GUI_Driver driver;
    
	public MainView() {
		driver = new GUI_Driver();
		

		this.root = new BorderPane();
		this.scene = new Scene(root, windowWidth, windowHeight);		
		this.statusNode = new Text("no status");
		this.root.setTop(this.buildSetupPane());
	}
	
	public Scene getMainScene() {
		return this.scene;
	}

	public GridPane buildSetupPane() {
	    Text numPlayersLabel = new Text("Number of Players:");  
	    Text timeoutLabel = new Text("Timeout in Seconds:");       
        TextField numPlayersField = new TextField();
        TextField timeoutField = new TextField();   
        
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
               String numPlayers = numPlayersField.getText();
               String timeout = timeoutField.getText();
               buildNameInputPane(numPlayers);
           } 
        };  

        button1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  
        GridPane gridPane = new GridPane(); 
        gridPane.setMinSize(windowWidth, (int) windowHeight/4); 
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        gridPane.setAlignment(Pos.CENTER); 
        
        gridPane.add(numPlayersLabel, 0, 0); 
        gridPane.add(timeoutLabel, 1, 0); 
        gridPane.add(numPlayersField, 0, 1); 
        gridPane.add(timeoutField, 1, 1);
        gridPane.add(button1, 2, 1); 
        gridPane.add(line, 0, 2, 3, 1); 
              
        return gridPane;
	}

	public void buildNameInputPane(String numPlayersString) {
		String text = "";
		try {
			int numPlayers =Integer.parseInt(numPlayersString);
	        if(numPlayers == 1) {
	        	root.setTop(enter1PlayerName());
	        }
	        if(numPlayers == 2) {
	        	root.setTop(enter2PlayerNames());
	        }
		}catch(NumberFormatException nfe) {
			text = "Please enter integer values!";
		}
	}
	
	public GridPane enter1PlayerName() {
	    Text p1nameLabel = new Text("Player 1 name:");  
	    Text p1markerLabel = new Text("Player 1 marker:");       
        TextField p1nameField = new TextField();
        TextField p1markerField = new TextField();   
        
        Button button1 = new Button("Submit"); 
        button1.getStyleClass().add("orangeButton");
        Line line = new Line();
        
        line.setStartX(0.0f); 
        line.setStartY(0.0f);         
        line.setEndX((float) windowWidth); 
        line.setEndY(0.0f);
        
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
           @Override 
           public void handle(MouseEvent e) { 
               String name = p1nameField.getText();
               String mark = p1markerField.getText();

               if (name.length() > 0 && mark.length() > 0){
            	   driver.createPlayer(name,mark,1);
                   driver.start(1,0); //Change to timeout and start should go in gameView()
                   root.setTop(gameView(true));
               }
           } 
        };  
        button1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);   
        
        Text listLabel = new Text("Previous players. To use, type their name and marker");
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = PlayerList.getObservableList();
        list.setItems(items);
        root.setCenter(listLabel);
        root.setBottom(list);
        
        
        GridPane gridPane = new GridPane();   
        gridPane.setMinSize(windowWidth, (int) windowHeight/4); 
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5); 
        gridPane.setHgap(5);
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
        
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
           @Override 
           public void handle(MouseEvent e) { 
               String p1name = p1nameField.getText();
               String p1mark = p1markerField.getText();
               String p2name = p2nameField.getText();
               String p2mark = p2markerField.getText();

               if(p1name.length() > 0 && p1mark.length() > 0 && p2name.length() > 0 && p2mark.length() > 0) {
            	   driver.createPlayer(p1name,p1mark,1);
            	   driver.createPlayer(p2name,p2mark,2);
                   driver.start(2,0); //Change to timeout
                   root.setTop(gameView(false));
               }
           } 
        };  
        button1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
        
        Text listLabel = new Text("Previous players. To use, type their name and marker");
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = PlayerList.getObservableList();
        list.setItems(items);
        root.setCenter(listLabel);
        root.setBottom(list);
        
        GridPane gridPane = new GridPane();  
        gridPane.setMinSize(windowWidth, (int) windowHeight/4); 
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
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

	
	public GridPane gameView(boolean onePlayer) {     
		root.setCenter(null);
		Text bottomText = new Text(driver.turnMessage());
		bottomText.getStyleClass().add("bottomText");
		
        Button[][] squares = new Button[3][3];
        for(int i = 0; i < 3; ++i) {
        	for (int j = 0; j < 3; ++j) {
        		squares[i][j] = new Button("");
        		squares[i][j].setMinWidth(150);
        		squares[i][j].setMinHeight(150);
        		squares[i][j].setMaxWidth(150);
        		squares[i][j].setMaxHeight(150);
        		squares[i][j].getStyleClass().add("orangeButton");
        	}
        }
        
        Button quitButton = new Button("Quit");
        
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
           @Override 
           public void handle(MouseEvent e) { 
        	   Button temp = (Button) e.getSource();
        	   for(int i = 0; i < 3; ++i) {
        		   for(int j = 0; j < 3; ++j) {
        			   if(squares[i][j] == temp) {
        				   bottomText.setText(driver.userMove(i, j));
        				   squares[i][j].setText(driver.getSquare(i, j));
        				   if(bottomText.getText().contentEquals("Computer's move")) {
        					   String s = driver.computerMove();
        					   int loc = Integer.parseInt(s.substring(0,1));
        					   squares[loc/3][loc%3].setText("COM");
        					   bottomText.setText(s.substring(1));
        				   }
        			   }
        		   }
               }
        	   if (driver.isGameOver()){
        		   String musicFile = "app-5.mp3";
        		   Media sound = new Media(new File(musicFile).toURI().toString());
        		   MediaPlayer mediaPlayer = new MediaPlayer(sound);
        		   mediaPlayer.play();
        	   }
           } 
        };  
        for(int i = 0; i < 3; ++i) {
        	for(int j = 0; j < 3; ++j) {
        		squares[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
        	}
        }
        
        EventHandler<MouseEvent> quitHandler = new EventHandler<MouseEvent>() { 
            @Override 
            public void handle(MouseEvent e) { 
            	System.exit(0);
            } 
         };  
         quitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, quitHandler);

        GridPane gridPane = new GridPane();    
        gridPane.setMinSize(windowWidth, (int) windowHeight/4); 
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        gridPane.setAlignment(Pos.CENTER); 
        
        for(int i = 0; i < 3; ++i) {
        	for(int j = 0; j < 3; ++j) {
        		gridPane.add(squares[i][j], j, i);
        	}
        }
        
        root.setBottom(bottomText);
        root.setRight(quitButton);
              
        return gridPane;
	}
}
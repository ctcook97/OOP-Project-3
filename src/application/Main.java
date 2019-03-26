package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import main.course.oop.tictactoe.view.MainView;
import main.course.oop.tictactoe.view.MainView2;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			MainView mView = new MainView();
			Scene scene = mView.getMainScene();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setTitle("Cameron Cook: Tic Tac Toe");

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package Game;

import Scene.HomeScene;
import Scene.LoadingScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainGame extends Application{
	public static Stage mainStage;

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		mainStage.setScene(new LoadingScreen());
		mainStage.setMaximized(true);
		mainStage.show();
		
	}

}
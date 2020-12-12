package Pane;

import Game.MainGame;
import Scene.HomeScene;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LoadingPane extends BorderPane { 

public LoadingPane() { 

// Setting the title font and creating the image for a loading symbol 

Font font1 = Font.font("Hanging Letters", 80); 

Font font2 = Font.font("Hanging Letters", 30); 

Font font3 = Font.font("ObelixPro", 80);

Font font4 = Font.font("ObelixPro", 30);

Text title = new Text("Test Driver"); 

title.setFont(font3); 

title.setFill(Color.ORANGERED); 

title.setStroke(Color.BLACK); 

Image loadImg = new Image("Images/LoadingSymbol.png"); 

ImageView loadingSymbol = new ImageView(loadImg); 

loadingSymbol.setFitHeight(70); 

loadingSymbol.setFitWidth(70); 

Text loadMsg = new Text("Loading Game Data..."); 

loadMsg.setFill(Color.BLACK); 

loadMsg.setStroke(Color.BLACK); 

loadMsg.setFont(font4); 

VBox content = new VBox(); 

content.getChildren().addAll(title, loadingSymbol, loadMsg); 

content.setAlignment(Pos.CENTER); 

content.setPadding(new Insets(10, 10, 10, 10)); 

content.setSpacing(5); 

Background rootBackground = new Background(new BackgroundFill(Color.GREY, new CornerRadii(0), new Insets(0,0,0,0))); 

 
 

RotateTransition rot = new RotateTransition(Duration.seconds(1), loadingSymbol); 

rot.setFromAngle(0); 

rot.setToAngle(360); 

rot.setCycleCount(3); 

// After 3 cycles of the loading symbol rotating change the screen to the home screen 

rot.setOnFinished(e-> { 

MainGame.mainStage.setScene(new HomeScene()); 
MainGame.mainStage.setMaximized(true);

}); 

// Set a scale transition to add more life to the page 

ScaleTransition scale = new ScaleTransition(Duration.seconds(2), title); 

scale.setByX(0.2); 

scale.setByY(0.2); 

scale.setCycleCount(Timeline.INDEFINITE); 

scale.setAutoReverse(true); 

// Set up a Parallel Transition to stack 'rot' and 'scale' 

ParallelTransition animation = new ParallelTransition(rot, scale); 

animation.play(); 

this.setBackground(rootBackground); 

this.setCenter(content); 

} 

} 
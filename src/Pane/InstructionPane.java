package Pane;

import Game.MainGame;
import Scene.HomeScene;
import Scene.InstructionScene;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class InstructionPane extends BorderPane{
	
	public InstructionPane() {
		Font font1 = Font.font("Hanging Letters", 120);
		VBox titleBox = new VBox();
		Text title1 = new Text("Instructions");
		titleBox.getChildren().add(title1);
		titleBox.setAlignment(Pos.CENTER);
		title1.setFont(font1);
		title1.setFill(Color.ORANGERED);
		title1.setStroke(Color.BLACK);
		this.setTop(titleBox);
		
		Font font2 = Font.font("Letters for Learners", 24);
		VBox text = new VBox();
		Text instructions = new Text("A way to make practicing for your G1 test fun! A racing "
				+ "game that all depends on your knowledge of the road. This game will ask you "
				+ "questions based off of Canada’s G1 test questions straight from g1.ca. "
				+ "You will be competing against other cars that will move ahead automatically. "
				+ "On the other hand, you will be asked true or false/multiple choice questions "
				+ "on the screen, if you get the answer correct, your car will move up 1 space."
				+ " Get the answer wrong, and an X will pop up. Make sure not to press a button more than once"
				+ " as it will still count for getting the question wrong. "
				+ "if you get 5 wrong, then it's game over.");
		instructions.setWrappingWidth(500);
		text.getChildren().add(instructions);
		text.setAlignment(Pos.CENTER);
		instructions.setFont(font2);
		instructions.setStroke(Color.WHITE);
		this.setCenter(text);
		
		Background background = new Background(new BackgroundFill(Color.GREY, new CornerRadii(0), new Insets(0,0,0,0)));
		this.setBackground(background);
		
		Background background1 = new Background(new BackgroundFill(Color.ORANGERED, new CornerRadii(10),new Insets(2,2,2,2)));
		Border border1 = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));
		Font font3 = Font.font("ObelixPro", 32);
		
		Text backButton = new Text("Go Back");
		backButton.setFont(font3);
		backButton.setFill(Color.WHITE);
		backButton.setStroke(Color.BLACK);
		VBox backButtonBox = new VBox();
		backButtonBox.getChildren().add(backButton);
		backButtonBox.setMaxHeight(120);
		backButtonBox.setMaxWidth(350);
		backButtonBox.setAlignment(Pos.BASELINE_CENTER);
		backButtonBox.setSpacing(25);
		backButtonBox.setBackground(background1);
		backButtonBox.setBorder(border1);
		this.setBottom(backButtonBox);
		
		TranslateTransition translate = 
				new TranslateTransition(Duration.seconds(1), titleBox);
		translate.setFromX(0);
		translate.setFromY(-500);
		translate.setToX(0);
		translate.setToY(0);
		
		TranslateTransition translate2 = 
				new TranslateTransition(Duration.millis(200), titleBox);
		translate2.setFromX(0);
		translate2.setFromY(0);
		translate2.setToX(0);
		translate2.setToY(-10);
		
		TranslateTransition translate3 = 
				new TranslateTransition(Duration.millis(225), titleBox);
		translate3.setFromX(0);
		translate3.setFromY(-10);
		translate3.setToX(0);
		translate3.setToY(0);
		
		SequentialTransition titleSequential = new SequentialTransition();
		titleSequential.getChildren().addAll(translate, translate2, translate3);
		titleSequential.play();
		
		ScaleTransition scale = 
				new ScaleTransition(Duration.millis(1000), text);
		scale.setByX(0.2);
	     scale.setByY(0.2);
	     scale.setCycleCount(Timeline.INDEFINITE);
	     scale.setAutoReverse(true);
	 
	     scale.play();
	     
	     Background background2 = new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(10),new Insets(2,2,2,2)));
		 Border border2 = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));
	     
	     backButtonBox.setOnMouseMoved(e -> {
				backButtonBox.setBackground(background2);
				backButtonBox.setBorder(border2);
			});
			
			backButtonBox.setOnMouseExited(e -> {
				backButtonBox.setBackground(background1);
				backButtonBox.setBorder(border1);
			});
			
			backButtonBox.setOnMouseClicked(e ->{
				MainGame.mainStage.setScene(new HomeScene());
				MainGame.mainStage.setMaximized(true);
			});
		
	}
	

}

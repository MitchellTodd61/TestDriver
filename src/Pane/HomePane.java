package Pane;

import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;

import Game.MainGame;
import Scene.GameScene;
import Scene.InstructionScene;

public class HomePane extends BorderPane {

	MediaPlayer mediaPlayer = null;
	Media background = null;

	public HomePane() {
/**
 * Creating the background music media player
 * setting autoplay to true
 * setting the cycle count to indefinite
 */
		background = new Media(new File("Music/bensound-betterdays.mp3").toURI().toString());
		mediaPlayer = new MediaPlayer(background);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

//Creating the first font/title/VBox to hold the title and setting its attributes 

		Font font1 = Font.font("Hanging Letters", 120);

		VBox titleBox = new VBox();

		Text title1 = new Text("Test Driver");

		titleBox.getChildren().add(title1);

		titleBox.setAlignment(Pos.CENTER);

		title1.setFont(font1);

		title1.setFill(Color.ORANGERED);

		title1.setStroke(Color.BLACK);

//Creating the second font/group members/and setting its attributes 

		Font font2 = Font.font("Letters for Learners", 18);

		HBox memberBox = new HBox();

		Text members = new Text("Group: Mitchell Lang, Mitchel Todd, Jaxon Arquette");

		memberBox.getChildren().add(members);

		memberBox.setAlignment(Pos.BOTTOM_CENTER);

		members.setFont(font2);

		Background rootBackground = new Background(
				new BackgroundFill(Color.GREY, new CornerRadii(0), new Insets(0, 0, 0, 0)));

//setting the top/bottom/background of the project 

		this.setTop(titleBox);

		this.setBottom(memberBox);

		this.setBackground(rootBackground);

//creating the background for the buttons, borders and a third font 

		Background background1 = new Background(
				new BackgroundFill(Color.ORANGERED, new CornerRadii(10), new Insets(2, 2, 2, 2)));

		Background hoverBackground = new Background(
				new BackgroundFill(Color.rgb(255, 100, 0), new CornerRadii(10), new Insets(2, 2, 2, 2)));

		Border border1 = new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));

		Font font3 = Font.font("ObelixPro", 32);

//creating the first button  

		Text gameButton = new Text("Play Game");

		gameButton.setFont(font3);

		gameButton.setFill(Color.WHITE);

//gameButton.setStroke(Color.BLACK); 

		VBox gameButtonBox = new VBox();

		gameButtonBox.getChildren().add(gameButton);

		gameButtonBox.setMaxHeight(120);

		gameButtonBox.setMaxWidth(350);

		gameButtonBox.setAlignment(Pos.CENTER);

		gameButtonBox.setSpacing(25);

		gameButtonBox.setBackground(background1);

		gameButtonBox.setBorder(border1);

//creating the second button 

		Text instButton = new Text("Instructions");

		instButton.setFont(font3);

		instButton.setFill(Color.WHITE);

//instButton.setStroke(Color.BLACK); 

		VBox instButtonBox = new VBox();

		instButtonBox.getChildren().add(instButton);

		instButtonBox.setMaxHeight(120);

		instButtonBox.setMaxWidth(350);

		instButtonBox.setAlignment(Pos.CENTER);

		instButtonBox.setSpacing(25);

		instButtonBox.setBackground(background1);

		instButtonBox.setBorder(border1);

//Creating the third button 

		Text exitButton = new Text("Exit Game");

		exitButton.setFont(font3);

		exitButton.setFill(Color.WHITE);

//exitButton.setStroke(Color.BLACK); 

		VBox exitButtonBox = new VBox();

		exitButtonBox.getChildren().add(exitButton);

		exitButtonBox.setMaxHeight(120);

		exitButtonBox.setMaxWidth(350);

		exitButtonBox.setAlignment(Pos.CENTER);

		exitButtonBox.setSpacing(25);

		exitButtonBox.setBackground(background1);

		exitButtonBox.setBorder(border1);

//Creating the buttonBox 

		VBox buttonBox = new VBox();

		buttonBox.getChildren().addAll(gameButtonBox, instButtonBox, exitButtonBox);

		buttonBox.setAlignment(Pos.CENTER);

		buttonBox.setSpacing(25);

		buttonBox.setMaxHeight(200);

		buttonBox.setMaxWidth(400);

//Setting the button Box in the center 

		this.setCenter(buttonBox);

//3 translations in a sequential transition to make it seem like its bouncing 

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

		Background background2 = new Background(
				new BackgroundFill(Color.GREY, new CornerRadii(10), new Insets(2, 2, 2, 2)));

		Border border2 = new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));

//Exit Button hover 

		exitButtonBox.setOnMouseEntered(e -> {

			exitButtonBox.setBackground(hoverBackground);

			exitButtonBox.setBorder(border2);

		});

		exitButtonBox.setOnMouseExited(e -> {

			exitButtonBox.setBackground(background1);

			exitButtonBox.setBorder(border1);

		});

		exitButtonBox.setOnMouseClicked(e -> {

			System.exit(0);
			mediaPlayer.stop();

		});

//instruction page button hover and click 

		instButtonBox.setOnMouseEntered(e -> {

			instButtonBox.setBackground(hoverBackground);

			instButtonBox.setBorder(border2);

		});

		instButtonBox.setOnMouseExited(e -> {

			instButtonBox.setBackground(background1);

			instButtonBox.setBorder(border1);

		});

		instButtonBox.setOnMouseClicked(e -> {

			MainGame.mainStage.setScene(new InstructionScene());
			MainGame.mainStage.setMaximized(true);
			mediaPlayer.stop();

		});

//Game page button hover and click 

		gameButtonBox.setOnMouseEntered(e -> {

			gameButtonBox.setBackground(hoverBackground);

			gameButtonBox.setBorder(border2);

		});

		gameButtonBox.setOnMouseExited(e -> {

			gameButtonBox.setBackground(background1);

			gameButtonBox.setBorder(border1);

		});

		gameButtonBox.setOnMouseClicked(e -> {

			MainGame.mainStage.setScene(new GameScene());
			
			mediaPlayer.stop();

		});

	}

} 
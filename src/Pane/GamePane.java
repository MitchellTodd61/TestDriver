package Pane;

import java.io.File;
import java.util.Timer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.*;

import Game.MainGame;
import Scene.GameScene;
import Scene.HomeScene;
import Scene.InstructionScene;
import Scene.LoserScene;
import Scene.WinnerScene;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GamePane extends BorderPane {

	String[] ansArray = {"60 Metres", 
			"Advanced Green light for left turns",
			"A substantial fine and 4 demerit points",
			"Pedestrians crossing with the light",
			"Continue straight and exit at the next ramp",
			"Between half an hour before sunset to half hour after sunset and when you can’t see clearly",
			"Slow down and yield the right of way if necessary",
			"Within 60m",
			"three meters",
			"Giving proper signal and looking to make sure it is safe" 	
			};
	String[] qArray = {"When lights are required, drivers must switch from high-beam lights to low beams when following another vehicle within how many metres:  ",
			"When a red signal light with a green arrow is shown at an intersection, it means: ",
			"Drivers who don't follow the stopping requirements at a school crossing may receive:",
			"Which of the following has the right-of-way over all others at an intersection when the signal light is green?",
			"If you miss an expressway exit, what should you do?", 
			"When does the law require the headlights on vehicles to be turned on?",
			"When approaching a construction area, drivers should",
			"Drivers must switch from high-beam lights to low beams when following another vehicle",
			"How close to a fire hydrant may you legally park?",
			"Never change lanes in traffic without:"
			};
	
	
	private boolean menuOpen = false;
	MediaPlayer mediaPlayer = null;
	MediaPlayer mp1 = null;
	MediaPlayer mp2 = null;
	MediaPlayer mp3 = null;
	MediaPlayer mpPlayer = null;
	Media background = null;
	Media car1 = null;
	Media car2 = null;
	Media car3 = null;
	Media playerCar = null;
	int count = 0;
	Text text1 = new Text("");
	Button b1 = new Button("");
	Button b2 = new Button("");
	Button b3 = new Button("");
	Image RedCar = new Image("Images/RedCar.png");
	ImageView redCar = new ImageView(RedCar);
	TranslateTransition redTranslate;
	Image X = new Image("Images/X.png");
	ImageView XView = new ImageView(X);
	VBox XBox = new VBox();
			
	TranslateTransition redTranslate2 = 
			new TranslateTransition(Duration.seconds(1), redCar);
	TranslateTransition redTranslate3 = 
			new TranslateTransition(Duration.seconds(1), redCar);
	TranslateTransition redTranslate4 = 
			new TranslateTransition(Duration.seconds(1), redCar);
	TranslateTransition redTranslate5 = 
			new TranslateTransition(Duration.seconds(1), redCar);
	TranslateTransition redTranslate6 = 
			new TranslateTransition(Duration.seconds(1), redCar);
	TranslateTransition redTranslate7 = 
			new TranslateTransition(Duration.seconds(1), redCar);
	TranslateTransition redTranslate8 = 
			new TranslateTransition(Duration.seconds(1), redCar);
	TranslateTransition redTranslate9 = 
			new TranslateTransition(Duration.seconds(1), redCar);
	TranslateTransition redTranslate10 = 
			new TranslateTransition(Duration.seconds(1), redCar);
	FadeTransition fade1;
	FadeTransition fade2;
	SequentialTransition fadeS = new SequentialTransition();

    
	
	public GamePane() {
        
		
		/**
		 * Creating mediaplayer for background music
		 * setting autoplay to true
		 * setting loop to indefinite
		 * setting volume to .5
		 */
		
		background = new Media(new File("Music/bensound-badass.mp3").toURI().toString());
		mediaPlayer = new MediaPlayer(background);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.setVolume(.5);
		
		car1 = new Media(new File("Music/car.mp3").toURI().toString());
		mp1 = new MediaPlayer(car1);
		mp1.setStartTime(Duration.UNKNOWN);
		mp1.setAutoPlay(true);
		mp1.setCycleCount(3);
		
		

		/*---------------------------------- 
		
		*  Default 
		
		*  - Fonts 
		
		*  - Backgrounds 
		
		*  - Borders 
		
		*----------------------------------   
		
		*/

		Background rootBackground = new Background(
				new BackgroundFill(Color.BLACK, new CornerRadii(0), new Insets(0, 0, 0, 0)));

		Background fgBackground = new Background(
				new BackgroundFill(Color.FORESTGREEN, new CornerRadii(0), new Insets(0, 0, 0, 0))); // Foreground
																									// Background

		Background sky = new Background(
				new BackgroundFill(Color.LIGHTSKYBLUE, new CornerRadii(0), new Insets(0, 0, 0, 0)));

		Border border1 = new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));

		Font font1 = Font.font("Hanging Letters", 15);
		Font font2 = Font.font("Jonah", 15);
		Font font3 = Font.font("ObelixPro", 20);
		/*---------------------------------- 
		
		*  Set up the title box 
		
		*  A VBox Positioned at the top  
		
		*  Filled with a preset image that we make 
		
		*----------------------------------   
		
		*/

		/**
		 * Creating the grass image/imageview
		 * creating the finish line
		 * creating the cloud in the sky
		 * creating the X that pops up when the user gets the question wrong
		 */
		Image grass = new Image("Images/grass6.png");
		ImageView grassView = new ImageView(grass);
		VBox grassBox = new VBox();
		grassBox.getChildren().add(grassView);
		grassView.setFitHeight(175);
		grassView.setFitWidth(1500);
		this.setBottom(grassBox);
		
		Image flag = new Image("Images/flag.png");
		ImageView flagView = new ImageView(flag);
		VBox flagBox = new VBox();
		flagBox.getChildren().add(flagView);
		flagBox.setAlignment(Pos.CENTER_RIGHT);
		flagView.setLayoutX(1350);
		flagView.setLayoutY(0);
		flagView.setFitWidth(250);
		flagView.setFitHeight(280);
		this.setRight(flagBox);
		
		
		Image clouds2 = new Image("Images/cloud1.png");
		ImageView cloudsView2 = new ImageView(clouds2);
		VBox cloudBox2 = new VBox();
		cloudBox2.getChildren().add(cloudsView2);
		cloudsView2.setFitWidth(200);
		cloudsView2.setFitHeight(150);
		cloudsView2.setLayoutX(1100);
		cloudsView2.setLayoutY(400);
		cloudBox2.setAlignment(Pos.TOP_LEFT);
		
		XView.setFitWidth(60);
		XView.setFitHeight(60);
		XView.setLayoutX(1300);
		XView.setLayoutY(400);
		XBox.getChildren().add(XView);
		XBox.setAlignment(Pos.CENTER);
		
		
		

		VBox titleBox = new VBox();

		titleBox.setBackground(sky);

//Back Button - Top Right of screen
		Background background1 = new Background(
				new BackgroundFill(Color.GREY, new CornerRadii(10), new Insets(2, 2, 2, 2)));

		Background hoverBackground = new Background(
				new BackgroundFill(Color.rgb(255, 100, 0), new CornerRadii(10), new Insets(2, 2, 2, 2)));

		Border border2 = new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));

		
		Text backButton = new Text("Back");
		backButton.setFont(font3);
		backButton.setFill(Color.WHITE);

		VBox backButtonBox = new VBox();
		backButtonBox.getChildren().add(backButton);
		backButtonBox.setMaxHeight(50);

		backButtonBox.setMaxWidth(50);

		backButtonBox.setAlignment(Pos.CENTER);

		backButtonBox.setPadding(new Insets(5, 5, 5, 5));

		backButtonBox.setBackground(background1);

		backButtonBox.setBorder(border1);

		backButtonBox.setAlignment(Pos.TOP_RIGHT);


		/*---------------------------------- 
		
		*  Set up the Question Box 
		
		*  A VBox Positioned at center 
		
		*  to store two HBoxes 
		
		*  VBox 1 - Question Box 
		
		*  VBox 2 - Timer until stall 
		
		*----------------------------------   
		
		*/
		
		//setting the default text to be the first question

		
		text1.setText(qArray[0]);
		
		text1.setFont(font2);

		text1.setFill(Color.BLACK);

		//setting the button text to be the first answer and random answers plus calling
		//the functions for the questions
		b1.setText(ansArray[0]);
		b1.setOnMouseClicked(e -> que1());
		
		
		b2.setText(ansArray[5]);
		b2.setOnMouseClicked(e -> wrongAnswer());
		
		b3.setText(ansArray[8]);
		b3.setOnMouseClicked(e -> wrongAnswer());

		VBox qBox = new VBox();

		qBox.getChildren().addAll(text1, b1, b2, b3);

		qBox.setAlignment(Pos.CENTER);

		qBox.setSpacing(10);
		
		

		

//timerBox.setBackground(rootBackground); 

		VBox top = new VBox();

		top.getChildren().addAll(cloudBox2, titleBox, qBox, backButtonBox);
		top.getChildren().add(XBox);
		top.setBackground(sky);

		this.setTop(top);

		/*---------------------------------- 
		
		*  Set up the Game Field Box 
		
		*  A VBox Positioned Center  
		
		*  5 HBoxes: 
		
		*  4 players and lanes 
		
		*  1 lane on the bottom for foreground image  
		
		*----------------------------------   
		
		*/

		VBox center = new VBox();

//center.setSpacing(5); 

		center.setBackground(sky);

		center.setMinHeight(250);

// Players, will be images of cars 

		Image RedCar = new Image("Images/RedCar.png");

		ImageView redCar = new ImageView(RedCar);

		redCar.setFitHeight(70);

		redCar.setFitWidth(70);

		Image BlueCar = new Image("Images/BlueCar.png");

		ImageView blueCar = new ImageView(BlueCar);

		blueCar.setFitHeight(70);

		blueCar.setFitWidth(70);

		Image GreyCar = new Image("Images/GreyCar.png");

		ImageView greyCar = new ImageView(GreyCar);

		greyCar.setFitHeight(70);

		greyCar.setFitWidth(70);

		Image YellowCar = new Image("Images/YellowCar.png");

		ImageView yellowCar = new ImageView(YellowCar);

		yellowCar.setFitHeight(70);

		yellowCar.setFitWidth(70);
		
		/*
		 * 
		 * Lane Set Ups,
		 * 
		 * A lot of reworking will be done
		 * 
		 * on this portion of the pane
		 * 
		 */

		VBox lane1 = new VBox();

		lane1.getChildren().add(redCar);

		lane1.setBackground(rootBackground);

//lane1.setMinHeight(70); 

//lane1.setMinWidth(800); 

		VBox lane2 = new VBox();

		lane2.getChildren().add(blueCar);

		lane2.setBackground(rootBackground);

//lane2.setMinHeight(70); 

//lane2.setMinWidth(800); 

		VBox lane3 = new VBox();

		lane3.getChildren().add(yellowCar);

		lane3.setBackground(rootBackground);

//lane3.setMinHeight(70); 

//lane3.setMinWidth(800); 

		VBox lane4 = new VBox();

		lane4.getChildren().add(greyCar);

		lane4.setBackground(rootBackground);

//lane4.setMinHeight(70); 

//lane4.setMinWidth(800); 

		VBox lanes = new VBox();

		lanes.getChildren().addAll(lane1, lane2, lane3, lane4);

//lanes.setMinHeight(500); 

		center.getChildren().addAll(lanes);

		center.setBackground(fgBackground);

		this.setCenter(center);

		/*---------------------------------------------- 
		
		* Game Mechanics 
		
		* -------------- 
		
		* 1.) Mouse Functions 
		
		* i.) Hover Action 
		
		* ii.) Button Click Action 
		
		* 2.) Question Generation 
		
		* 3.) Score Tracking 
		
		*   
		
		* --------------------------------------------- 
		
		*/


//back button mechanics
		backButtonBox.setOnMouseEntered(e -> {
			
			backButtonBox.setBackground(hoverBackground);
			backButtonBox.setBorder(border2);
		});

		backButtonBox.setOnMouseExited(e -> {
			backButtonBox.setBackground(background1);
			backButtonBox.setBorder(border1);
		});

		backButtonBox.setOnMouseClicked(e -> {

			MainGame.mainStage.setScene(new HomeScene());
			MainGame.mainStage.setMaximized(true);
			mp1.stop();
			mediaPlayer.stop();

		});
		
		
		/**
		 * AI Cars moving on a random duration
		 * Broken up into 10 
		 * 1 translate each section
		 * Different cars have different speeds
		 */
		
		TranslateTransition yellowStall =
				new TranslateTransition(Duration.seconds(5), yellowCar);
		yellowStall.setFromX(0);
		yellowStall.setToX(0);
		yellowCar.setLayoutX(0);
		
		//Yellow Car transitions
		TranslateTransition yellowTranslate = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate.setFromX(0);
		yellowTranslate.setToX(135);
		yellowCar.setLayoutX(0);
		
		
		TranslateTransition yellowTranslate2 = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate2.setFromX(135);
		yellowTranslate2.setToX(270);
		yellowCar.setLayoutX(0);
		
		TranslateTransition yellowTranslate3 = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate3.setFromX(270);
		yellowTranslate3.setToX(405);
		yellowCar.setLayoutX(0);
		
		TranslateTransition yellowTranslate4 = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate4.setFromX(405);
		yellowTranslate4.setToX(540);
		yellowCar.setLayoutX(0);
		
		TranslateTransition yellowTranslate5 = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate5.setFromX(540);
		yellowTranslate5.setToX(675);
		yellowCar.setLayoutX(0);
		
		TranslateTransition yellowTranslate6 = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate6.setFromX(675);
		yellowTranslate6.setToX(810);
		yellowCar.setLayoutX(0);
		
		TranslateTransition yellowTranslate7 = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate7.setFromX(810);
		yellowTranslate7.setToX(945);
		yellowCar.setLayoutX(0);
		
		TranslateTransition yellowTranslate8 = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate8.setFromX(945);
		yellowTranslate8.setToX(1080);
		yellowCar.setLayoutX(0);
		
		TranslateTransition yellowTranslate9 = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate9.setFromX(1080);
		yellowTranslate9.setToX(1215);
		yellowCar.setLayoutX(0);
		
		TranslateTransition yellowTranslate10 = 
				new TranslateTransition(Duration.seconds(2), yellowCar);
		yellowTranslate10.setFromX(1215);
		yellowTranslate10.setToX(1350);
		yellowCar.setLayoutX(0);
		yellowCar.setLayoutX(0);
		SequentialTransition yellowCarAnimation = new SequentialTransition();
		

		yellowCarAnimation.getChildren().addAll(yellowStall, yellowTranslate, yellowTranslate2, yellowTranslate3, yellowTranslate4, yellowTranslate5, yellowTranslate6,yellowTranslate7, yellowTranslate8, yellowTranslate9, yellowTranslate10);
		yellowCarAnimation.play();
		/**
		 * Creating a timer that opens a JFrame after 45 seconds(the last car)
		 * this lets the user know that they have lost(can still continue)
		 */
		JFrame frame = new JFrame("Loser!");
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	JOptionPane.showMessageDialog(frame, "You finished last!");
		           
		               
		            }
		        }, 
		        45000 
		);
		
		
		//Blue Car Transitions
		
		TranslateTransition blueStall =
				new TranslateTransition(Duration.seconds(5), blueCar);
		blueStall.setFromX(0);
		blueStall.setToX(0);
		
		TranslateTransition blueTranslate = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate.setFromX(0);
		blueTranslate.setToX(135);
		
		
		TranslateTransition blueTranslate2 = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate2.setFromX(135);
		blueTranslate2.setToX(270);
		
		
		TranslateTransition blueTranslate3 = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate3.setFromX(270);
		blueTranslate3.setToX(405);
		
		TranslateTransition blueTranslate4 = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate4.setFromX(405);
		blueTranslate4.setToX(540);
		
		TranslateTransition blueTranslate5 = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate5.setFromX(540);
		blueTranslate5.setToX(675);
		
		TranslateTransition blueTranslate6 = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate6.setFromX(675);
		blueTranslate6.setToX(810);
		
		TranslateTransition blueTranslate7 = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate7.setFromX(810);
		blueTranslate7.setToX(945);
		
		TranslateTransition blueTranslate8 = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate8.setFromX(945);
		blueTranslate8.setToX(1080);
		
		TranslateTransition blueTranslate9 = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate9.setFromX(1080);
		blueTranslate9.setToX(1215);
		
		TranslateTransition blueTranslate10 = 
				new TranslateTransition(Duration.seconds(3), blueCar);
		blueTranslate10.setFromX(1215);
		blueTranslate10.setToX(1350);
		
		SequentialTransition blueCarAnimation = new SequentialTransition();

		blueCarAnimation.getChildren().addAll(blueStall, blueTranslate,blueTranslate2, blueTranslate3, blueTranslate4, blueTranslate5, blueTranslate6,blueTranslate7, blueTranslate8, blueTranslate9, blueTranslate10);

		blueCarAnimation.play();
		
		
		
		//Grey Car Transitions
		
		TranslateTransition greyStall =
				new TranslateTransition(Duration.seconds(5), greyCar);
		greyStall.setFromX(0);
		greyStall.setToX(0);
		
		TranslateTransition greyTranslate = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate.setFromX(0);
		greyTranslate.setToX(135);
		
		
		TranslateTransition greyTranslate2 = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate2.setFromX(135);
		greyTranslate2.setToX(270);
		
		
		TranslateTransition greyTranslate3 = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate3.setFromX(270);
		greyTranslate3.setToX(405);
		
		TranslateTransition greyTranslate4 = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate4.setFromX(405);
		greyTranslate4.setToX(540);
		
		TranslateTransition greyTranslate5 = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate5.setFromX(540);
		greyTranslate5.setToX(675);
		
		TranslateTransition greyTranslate6 = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate6.setFromX(675);
		greyTranslate6.setToX(810);
		
		TranslateTransition greyTranslate7 = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate7.setFromX(810);
		greyTranslate7.setToX(945);
		
		TranslateTransition greyTranslate8 = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate8.setFromX(945);
		greyTranslate8.setToX(1080);
		
		TranslateTransition greyTranslate9 = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate9.setFromX(1080);
		greyTranslate9.setToX(1215);
		
		TranslateTransition greyTranslate10 = 
				new TranslateTransition(Duration.seconds(4), greyCar);
		greyTranslate10.setFromX(1215);
		greyTranslate10.setToX(1350);
		
		SequentialTransition greyCarAnimation = new SequentialTransition();

		greyCarAnimation.getChildren().addAll(greyStall, greyTranslate, greyTranslate2, greyTranslate3, greyTranslate4, greyTranslate5, greyTranslate6,greyTranslate7, greyTranslate8, greyTranslate9, greyTranslate10);

		greyCarAnimation.play();
		
		/**
		 * Creating the transitions for the users car to move
		 * creating the fade transitions for the X to show the user they got a question wrong
		 */
		redTranslate = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate.setToX(135);
		redTranslate2 = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate2.setToX(270);
		redTranslate3 = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate3.setToX(405);
		redTranslate4 = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate4.setToX(540);
		redTranslate5 = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate5.setToX(675);
		redTranslate6 = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate6.setToX(810);
		redTranslate7 = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate7.setToX(945);
		redTranslate8 = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate8.setToX(1080);
		redTranslate9 = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate9.setToX(1215);
		redTranslate10 = new TranslateTransition(Duration.seconds(1), redCar);
		redTranslate10.setToX(1350);
		
		FadeTransition fade3 = new FadeTransition(Duration.millis(1), XView);
		fade3.setFromValue(1);
		fade3.setToValue(0);
		fade3.setCycleCount(1);
		fade3.play();
		fade1 = new FadeTransition(Duration.seconds(1), XView );
		fade2 = new FadeTransition(Duration.seconds(1), XView);
		fade1.setFromValue(0);
	    fade1.setToValue(1);
	    fade2.setFromValue(1);
	    fade2.setToValue(0);
	    fadeS.getChildren().addAll(fade1, fade2);
		
		/**
		 * Creating seperate functions for every question
		 * these functions call to each other and link from question to question
		 * allowing the user to get the question right, or wrong
		 * aswell moves the car if the user gets the question right
		 * wrongAnswer function for when the user gets the answer wrong.
		 */
	
		}
	public void wrongAnswer() {
		fadeS.play();
		count++;
		if(count == 5) {
			MainGame.mainStage.setScene(new LoserScene());
			MainGame.mainStage.setMaximized(true);
			mp1.stop();
			mediaPlayer.stop();
		}
		
		
	}
	public void que1() {
		text1.setText(qArray[1]);
		b1.setText(ansArray[4]);
		b2.setText(ansArray[9]);
		b3.setText(ansArray[1]);
		redTranslate.play();
		b1.setOnMouseClicked(e -> wrongAnswer());
		b2.setOnMouseClicked(e -> wrongAnswer());
		b3.setOnMouseClicked(e -> que2());
	}
	public void que2() {
		text1.setText(qArray[2]);
		b1.setText(ansArray[3]);
		b2.setText(ansArray[2]);
		b3.setText(ansArray[6]);
		redTranslate2.play();
		b1.setOnMouseClicked(e -> wrongAnswer());
		b2.setOnMouseClicked(e -> que3());
		b3.setOnMouseClicked(e -> wrongAnswer());
	}
	public void que3() {
		text1.setText(qArray[3]);
		b1.setText(ansArray[3]);
		b2.setText(ansArray[1]);
		b3.setText(ansArray[7]);
		b1.setOnMouseClicked(e -> que4());
		b2.setOnMouseClicked(e -> wrongAnswer());
		b3.setOnMouseClicked(e -> wrongAnswer());
		redTranslate3.play();
	}
	public void que4() {
		text1.setText(qArray[4]);
		b1.setText(ansArray[1]);
		b2.setText(ansArray[2]);
		b3.setText(ansArray[4]);
		b1.setOnMouseClicked(e -> wrongAnswer());
		b2.setOnMouseClicked(e -> wrongAnswer());
		b3.setOnMouseClicked(e -> que5());
		redTranslate4.play();
	}
	public void que5() {
		text1.setText(qArray[5]);
		b1.setText(ansArray[9]);
		b2.setText(ansArray[5]);
		b3.setText(ansArray[2]);
		b1.setOnMouseClicked(e -> wrongAnswer());
		b2.setOnMouseClicked(e -> que6());
		b3.setOnMouseClicked(e -> wrongAnswer());
		redTranslate5.play();
	}
	public void que6() {
		text1.setText(qArray[6]);
		b1.setText(ansArray[6]);
		b2.setText(ansArray[4]);
		b3.setText(ansArray[1]);
		b1.setOnMouseClicked(e -> que7());
		b2.setOnMouseClicked(e -> wrongAnswer());
		b3.setOnMouseClicked(e -> wrongAnswer());
		redTranslate6.play();
	}
	public void que7() {
		text1.setText(qArray[7]);
		b1.setText(ansArray[5]);
		b2.setText(ansArray[5]);
		b3.setText(ansArray[7]);
		b1.setOnMouseClicked(e -> wrongAnswer());
		b2.setOnMouseClicked(e -> wrongAnswer());
		b3.setOnMouseClicked(e -> que8());
		redTranslate7.play();
	}
	public void que8() {
		text1.setText(qArray[8]);
		b1.setText(ansArray[2]);
		b2.setText(ansArray[8]);
		b3.setText(ansArray[9]);
		b1.setOnMouseClicked(e -> wrongAnswer());
		b2.setOnMouseClicked(e -> que9());
		b3.setOnMouseClicked(e -> wrongAnswer());
		redTranslate8.play();
	}
	public void que9() {
		text1.setText(qArray[9]);
		b1.setText(ansArray[9]);
		b2.setText(ansArray[7]);
		b3.setText(ansArray[2]);
		b1.setOnMouseClicked(e -> winGame());
		b2.setOnMouseClicked(e -> wrongAnswer());
		b3.setOnMouseClicked(e -> wrongAnswer());
		redTranslate9.play();
	}
	public void winGame() {
		text1.setText("WINNER");
		redTranslate10.play();
		MainGame.mainStage.setScene(new WinnerScene());
		MainGame.mainStage.setMaximized(true);
		mp1.stop();
		mediaPlayer.stop();
		
		
	}
	
	
	
} 

	


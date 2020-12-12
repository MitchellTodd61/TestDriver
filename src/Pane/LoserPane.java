package Pane;

import Game.MainGame;
import Scene.HomeScene;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoserPane extends BorderPane{
	
	public LoserPane() {
		HBox descBox = new HBox();
		Text descText = new Text("YOU'VE LOST, PRESS THE CLOSE BUTTON TO CLOSE THE PROGRAM");
		descText.setFill(Color.WHITE);
		Background Background = new Background(
				new BackgroundFill(Color.ORANGE, new CornerRadii(0), new Insets(0, 0, 0, 0)));
		Font font2 = Font.font("ObelixPro", 24);
		
		
		descText.setFont(font2);
		descBox.getChildren().add(descText);
		descBox.setAlignment(Pos.CENTER);
		this.setCenter(descBox);
		this.setBackground(Background);
		
		Background background1 = new Background(
				new BackgroundFill(Color.GREY, new CornerRadii(10), new Insets(2, 2, 2, 2)));

		Background hoverBackground = new Background(
				new BackgroundFill(Color.rgb(255, 100, 0), new CornerRadii(10), new Insets(2, 2, 2, 2)));

		Border border2 = new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));

		Font font3 = Font.font("ObelixPro", 20);
		
		Border border1 = new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2)));

		
		Text exitButton = new Text("Exit");
		exitButton.setFont(font3);
		exitButton.setFill(Color.WHITE);

		VBox exitButtonBox = new VBox();
		exitButtonBox.getChildren().add(exitButton);
		exitButtonBox.setMaxHeight(50);

		exitButtonBox.setMaxWidth(50);

		exitButtonBox.setAlignment(Pos.CENTER);

		exitButtonBox.setPadding(new Insets(5, 5, 5, 5));

		exitButtonBox.setBackground(background1);

		exitButtonBox.setBorder(border1);

		exitButtonBox.setAlignment(Pos.TOP_RIGHT);
		this.setTop(exitButtonBox);
		
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
		

		});
	}


}

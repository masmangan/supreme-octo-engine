package simple;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 
 * @author marco
 *
 */
public class RioGrandeApp extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Rio Grande");

		Label dateLabel = new Label("4000 K");

		Label populationLabel = new Label("8/12 (+0,2)");

		Label foodLabel = new Label("+4,8");

		Label workLabel = new Label("0 +1,6");

		Label cultureLabel = new Label("0 +1,6");

		Label threatLabel = new Label("0 +1,6");

		Button statusButton = new Button("Info");
		statusButton.setOnAction((ActionEvent e) -> {
			System.out.println("Information panel");
		});

		Button settlement = new Button("Settlement");
		Button techs = new Button("Techs");
		Button buildings = new Button("Buildings");
		Button evolution = new Button("Evolution");
		Button help = new Button("Help");
		Button menu = new Button("Menu");
		Label turn = new Label("Turn 1");
		Button endTurn = new Button("End Turn");
		endTurn.setOnAction((ActionEvent e) -> {
			System.out.println("End turn...");
		});

		BorderPane borderPane = new BorderPane();
		HBox toolbar = new HBox(dateLabel, populationLabel, foodLabel, workLabel, cultureLabel, threatLabel,
				statusButton);
		HBox statusbar = new HBox(settlement, techs, buildings, evolution, help, menu, turn, endTurn);
		Node appContent = new StackPane();
		borderPane.setTop(toolbar);
		borderPane.setCenter(appContent);
		borderPane.setBottom(statusbar);

		Slider slider = new Slider();
		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(40);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(50);
		slider.setMinorTickCount(5);
		slider.setBlockIncrement(10);

		Scene scene = new Scene(borderPane, 640, 480);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
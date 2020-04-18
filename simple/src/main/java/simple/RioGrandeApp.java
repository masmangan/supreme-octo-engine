package simple;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author marco.mangan@gmail.com
 *
 */
public class RioGrandeApp extends Application {

	private RioGrandeAppData data = new RioGrandeAppData();

	@Override
	public void start(Stage stage) {
		stage.setTitle("Rio Grande");

		Label dateLabel = new Label("" + data.getDate() + " K Years B. C.");
		Label populationLabel = new Label(
				" " + data.getPopulation() + "/" + data.getPopulationMax() + " (" + data.getPopulationRate() + ")");

		Label foodLabel = new Label("" + data.getFood());

		Label workLabel = new Label("" + data.getWork() + "(" + data.getWorkRate() + ")");

		Label cultureLabel = new Label("" + data.getCulture() + " " + data.getCultureRate());

		Label threatLabel = new Label("" + data.getThreat() + "% ");

		Button statusButton = new Button("+");
		statusButton.setOnAction((ActionEvent e) -> {
			System.out.println("Information panel");
		});

		Button settlementButton = new Button("Settlement");
		settlementButton.setOnAction((ActionEvent e) -> {
			System.out.println("Settlement panel");
		});
		Button techsButton = new Button("Techs");
		techsButton.setOnAction((ActionEvent e) -> {
			System.out.println("Techs panel");
		});
		Button buildingsButton = new Button("Buildings");
		buildingsButton.setOnAction((ActionEvent e) -> {
			System.out.println("Buildings panel");
		});
		Button evolutionButton = new Button("Evolution");
		evolutionButton.setOnAction((ActionEvent e) -> {
			System.out.println("Evolution panel");
		});
		Button helpButton = new Button("Help");

		helpButton.setOnAction((ActionEvent e) -> {
			System.out.println("Help panel");
		});
		Button menuButton = new Button("Menu");
		menuButton.setOnAction((ActionEvent e) -> {
			System.out.println("Menu panel");
		});
		Label turnLabel = new Label("Turn " + data.getTurn());

		Button endTurn = new Button("End Turn");
		endTurn.setOnAction((ActionEvent e) -> {
			System.out.println("End turn...");
			data.tick();
			turnLabel.setText("Turn " + data.getTurn());
			dateLabel.setText("" + data.getDate() + " K Years B. C.");

		});

		Slider gatheringSlider = new Slider();
		gatheringSlider.setMin(0);
		gatheringSlider.setMax(100);
		gatheringSlider.setValue(40);
		gatheringSlider.setShowTickLabels(true);
		gatheringSlider.setShowTickMarks(true);
		gatheringSlider.setMajorTickUnit(50);
		gatheringSlider.setMinorTickCount(5);
		gatheringSlider.setBlockIncrement(10);

		Slider farmingSlider = new Slider();
		farmingSlider.setMin(0);
		farmingSlider.setMax(100);
		farmingSlider.setValue(40);
		farmingSlider.setShowTickLabels(true);
		farmingSlider.setShowTickMarks(true);
		farmingSlider.setMajorTickUnit(50);
		farmingSlider.setMinorTickCount(5);
		farmingSlider.setBlockIncrement(10);

		Slider workingSlider = new Slider();
		workingSlider.setMin(0);
		workingSlider.setMax(100);
		workingSlider.setValue(40);
		workingSlider.setShowTickLabels(true);
		workingSlider.setShowTickMarks(true);
		workingSlider.setMajorTickUnit(50);
		workingSlider.setMinorTickCount(5);
		workingSlider.setBlockIncrement(10);

		Slider worshipingSlider = new Slider();
		worshipingSlider.setMin(0);
		worshipingSlider.setMax(100);
		worshipingSlider.setValue(40);
		worshipingSlider.setShowTickLabels(true);
		worshipingSlider.setShowTickMarks(true);
		worshipingSlider.setMajorTickUnit(50);
		worshipingSlider.setMinorTickCount(5);
		worshipingSlider.setBlockIncrement(10);

		Slider huntingSlider = new Slider();
		huntingSlider.setMin(0);
		huntingSlider.setMax(100);
		huntingSlider.setValue(40);
		huntingSlider.setShowTickLabels(true);
		huntingSlider.setShowTickMarks(true);
		huntingSlider.setMajorTickUnit(50);
		huntingSlider.setMinorTickCount(5);
		huntingSlider.setBlockIncrement(10);

		Slider fishingSlider = new Slider();
		fishingSlider.setMin(0);
		fishingSlider.setMax(100);
		fishingSlider.setValue(40);
		fishingSlider.setShowTickLabels(true);
		fishingSlider.setShowTickMarks(true);
		fishingSlider.setMajorTickUnit(50);
		fishingSlider.setMinorTickCount(5);
		fishingSlider.setBlockIncrement(10);

		BorderPane borderPane = new BorderPane();
		HBox headerHBox = new HBox(dateLabel, populationLabel, foodLabel, workLabel, cultureLabel, threatLabel,
				statusButton);
		HBox footerHBox = new HBox(settlementButton, techsButton, buildingsButton, evolutionButton, helpButton,
				menuButton, turnLabel, endTurn);
		Node appContent = new VBox(gatheringSlider, huntingSlider, workingSlider, worshipingSlider, farmingSlider,
				fishingSlider);
		borderPane.setTop(headerHBox);
		borderPane.setCenter(appContent);
		borderPane.setBottom(footerHBox);

		Scene scene = new Scene(borderPane, 640, 480);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
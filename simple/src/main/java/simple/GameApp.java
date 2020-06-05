/*
 * Copyright (c) 2020. All rights reserved.
 */

package simple;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The <code>GameData</code> class
 * 
 * @author marco.mangan@gmail.com
 *
 */
public final class GameApp extends Application {
	/** Helper for debugging and diagnosing */
	private static final Logger LOGGER = Logger.getLogger(GameApp.class.getName());

	/** Application data */
	private GameData data = new GameData();

	/** Current game date with finer scale for later dates */
	private Label dateLabel;

	/** */
	private Label populationLabel;
	
	/** */
	private Label turnLabel;
	
	/** */
	private Label foodLabel;
	
	/** */
	private Label workLabel;
	
	/** */
	private Label cultureLabel;
	
	/** */
	private Label threatLabel;
	
	/** */
	private Button endTurn;

	/**
	 *
	 */
	@Override
	public void start(Stage stage) {
		stage.setTitle("Bonze Age Clone");

		dateLabel = new Label();
		populationLabel = new Label();
		foodLabel = new Label();
		workLabel = new Label();
		cultureLabel = new Label();
		threatLabel = new Label();

		// java.util.List<BackgroundFill> oldFill = endTurn.getBackground().
		// System.out.println(oldFill);
		// Background buttonBackground = new Background(new
		// BackgroundFill(Color.ANTIQUEWHITE,
		// CornerRadii.EMPTY,
		// Insets.EMPTY));

		Button foo = new Button();
		Background buttonBackground = new Background(
				new BackgroundFill(Color.ANTIQUEWHITE, new CornerRadii(10), foo.getInsets()));

		Button statusButton = new Button("+");
		statusButton.setOnAction((ActionEvent e) -> {
			System.out.println("Information panel");
		});

		Button settlementButton = new Button("Settlement");
		settlementButton.setBackground(buttonBackground);
		settlementButton.setOnAction((ActionEvent e) -> {
			System.out.println("Settlement panel");
		});
		Button techsButton = new Button("Techs");
		techsButton.setBackground(buttonBackground);
		techsButton.setOnAction((ActionEvent e) -> {
			System.out.println("Techs panel");
		});
		Button buildingsButton = new Button("Buildings");
		buildingsButton.setBackground(buttonBackground);

		buildingsButton.setOnAction((ActionEvent e) -> {
			System.out.println("Buildings panel");
		});
		Button evolutionButton = new Button("Evolution");
		evolutionButton.setBackground(buttonBackground);

		evolutionButton.setOnAction((ActionEvent e) -> {
			System.out.println("Evolution panel");
		});
		Button helpButton = new Button("Help");
		helpButton.setBackground(buttonBackground);
		helpButton.setOnAction((ActionEvent e) -> {
			System.out.println("Help panel");
		});
		Button menuButton = new Button("Menu");
		menuButton.setBackground(buttonBackground);

		menuButton.setOnAction((ActionEvent e) -> {
			System.out.println("Menu panel");
		});
		turnLabel = new Label("Turn " + data.getTurn());
		turnLabel.setMinWidth(70);

		endTurn = new Button("End Turn");

		endTurn.setBackground(buttonBackground);
		// endTurn.setStyle("-fx-background-color: #faebd7; ");
		// #faebd7 Color Hex Antique White
		endTurn.setOnAction(e -> {
			System.out.println("End turn...");
			data.tick();
			updateViewFromModel();
		});

		updateViewFromModel();

		Slider gatheringSlider = new Slider();
		gatheringSlider.setMin(0);
		gatheringSlider.setMax(data.getForestWorkersMax());
		gatheringSlider.setValue(data.getForestWorkers());
		gatheringSlider.setShowTickLabels(true);
		gatheringSlider.setShowTickMarks(true);
		gatheringSlider.setMajorTickUnit(1);
		gatheringSlider.setMinorTickCount(0);
		gatheringSlider.setBlockIncrement(1);
		gatheringSlider.setSnapToTicks(true);
		gatheringSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				System.out.println("Gathering slider" + old_val + " " + new_val);
				data.setForestWorkers(new_val.intValue());
				gatheringSlider.setValue(new_val.intValue());
			}
		});

//		Slider farmingSlider = new Slider();
//		farmingSlider.setMin(0);
//		farmingSlider.setMax(data.getForestWorkersMax());
//		farmingSlider.setValue(data.getForestWorkers());
//		//farmingSlider.setShowTickLabels(true);
//		//farmingSlider.setShowTickMarks(true);
//		//farmingSlider.setMajorTickUnit(50);
//		//farmingSlider.setMinorTickCount(5);
//		//farmingSlider.setBlockIncrement(10);
//
//		Slider workingSlider = new Slider();
//		workingSlider.setMin(0);
//		workingSlider.setMax(100);
//		workingSlider.setValue(40);
//		workingSlider.setShowTickLabels(true);
//		workingSlider.setShowTickMarks(true);
//		workingSlider.setMajorTickUnit(50);
//		workingSlider.setMinorTickCount(5);
//		workingSlider.setBlockIncrement(10);
//
//		Slider worshipingSlider = new Slider();
//		worshipingSlider.setMin(0);
//		worshipingSlider.setMax(100);
//		worshipingSlider.setValue(40);
//		worshipingSlider.setShowTickLabels(true);
//		worshipingSlider.setShowTickMarks(true);
//		worshipingSlider.setMajorTickUnit(50);
//		worshipingSlider.setMinorTickCount(5);
//		worshipingSlider.setBlockIncrement(10);
//
//		Slider huntingSlider = new Slider();
//		huntingSlider.setMin(0);
//		huntingSlider.setMax(100);
//		huntingSlider.setValue(40);
//		huntingSlider.setShowTickLabels(true);
//		huntingSlider.setShowTickMarks(true);
//		huntingSlider.setMajorTickUnit(50);
//		huntingSlider.setMinorTickCount(5);
//		huntingSlider.setBlockIncrement(10);
//
//		Slider fishingSlider = new Slider();
//		fishingSlider.setMin(0);
//		fishingSlider.setMax(12);
//		fishingSlider.setValue(0);
//		fishingSlider.setShowTickLabels(true);
//		fishingSlider.setShowTickMarks(true);
//		fishingSlider.setMajorTickUnit(50);
//		fishingSlider.setMinorTickCount(5);
//		fishingSlider.setBlockIncrement(10);

		BorderPane borderPane = new BorderPane();
		HBox headerHBox = new HBox(dateLabel, populationLabel, foodLabel, workLabel, cultureLabel, threatLabel,
				statusButton);
		HBox.setMargin(dateLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(populationLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(foodLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(workLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(cultureLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(threatLabel, new Insets(10, 10, 10, 10));
		HBox.setMargin(statusButton, new Insets(10, 10, 10, 10));

		HBox footerHBox = new HBox(settlementButton, techsButton, buildingsButton, evolutionButton, helpButton,
				menuButton, turnLabel, endTurn);

		HBox.setMargin(settlementButton, new Insets(10, 10, 10, 10));
		HBox.setMargin(techsButton, new Insets(10, 10, 10, 10));
		HBox.setMargin(buildingsButton, new Insets(10, 10, 10, 10));
		HBox.setMargin(evolutionButton, new Insets(10, 10, 10, 10));
		HBox.setMargin(helpButton, new Insets(10, 10, 10, 10));
		HBox.setMargin(menuButton, new Insets(10, 10, 10, 10));
		HBox.setMargin(turnLabel, new Insets(10, 20, 10, 10));
		HBox.setMargin(endTurn, new Insets(10, 10, 10, 10));

//		Node appContent = new VBox(gatheringSlider, huntingSlider, workingSlider, worshipingSlider, farmingSlider,
//				fishingSlider);
		Node settlementPane = new HBox(gatheringSlider);
		//Node techsPane = new HBox();

		Node panes = new StackPane(settlementPane);
		borderPane.setTop(headerHBox);
		borderPane.setCenter(panes);
		borderPane.setBottom(footerHBox);

		Scene scene = new Scene(borderPane, 480 * 16 / 9, 480);
		// stage.getIcons().add(new
		// Image(GameApp.class.getResourceAsStream("file:game.png")));
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * 
	 */
	private void updateViewFromModel() {
		if (data.getCurrentPopulation() <= 0) {
			endTurn.setDisable(true);
		}
		final DecimalFormat turnFormat = new DecimalFormat("Turn ###0");
		// turnLabel.setText("Turn " + data.getTurn());
		turnLabel.setText(turnFormat.format(data.getTurn()));
		if (data.getDate() <= -4 * 1000) {
			dateLabel.setText("" + -data.getDate() / 1000 + " K Years B. C.");
		} else {
			dateLabel.setText("" + -data.getDate() + " Years B. C.");
		}

		final DecimalFormat decimalFormat = new DecimalFormat("0.#");
		populationLabel.setText(String.format("Pop.: %s/%d (%s)", decimalFormat.format(data.getCurrentPopulation()),
				data.getMaximumPopulation(), decimalFormat.format(data.getPopulationDelta())));

		foodLabel.setText(String.format("Food: %.1f", data.getFood()));

		workLabel.setText("" + data.getWork() + "(" + data.getWorkRate() + ")");

		cultureLabel.setText("" + data.getCulture() + " " + data.getCultureRate());

		threatLabel.setText("" + data.getThreat() + "% ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.setLevel(Level.ALL);
		LOGGER.info("Starting application: " + LOGGER.getName());
		launch();
		LOGGER.info("Starting application: " + LOGGER.getName());

	}

}
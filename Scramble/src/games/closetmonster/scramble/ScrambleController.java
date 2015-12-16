package games.closetmonster.scramble;

import games.closetmonster.scramble.controller.LetterSelector;
import games.closetmonster.scramble.dictionary.Dictionary;
import games.closetmonster.scramble.model.Board;
import games.closetmonster.scramble.model.FormedWord;
import games.closetmonster.scramble.model.Letter;
import games.closetmonster.scramble.model.LetterTileFactory;
import games.closetmonster.scramble.model.ScoreTotal;
import games.closetmonster.scramble.model.Tile;
import games.closetmonster.scramble.view.ImageFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 * @author Jonathan Radliff
 *
 */
public class ScrambleController {

	@FXML
	private GridPane gridPane;

	@FXML
	private Pane pane;

	@FXML
	private Path path;

	@FXML
	private Label scoreShown = new Label("0");

	@FXML
	private Label scoreValue = new Label("0");

	@FXML
	private Label scoreMultiplier = new Label("x 0");

	@FXML
	private Label scoreEarned = new Label("0");

	@FXML
	private Label scoreRating = new Label("Good!");

	@FXML
	private Label wordShown = new Label("");

	private LetterSelector letterSelector = new LetterSelector();
	private FormedWord formedWord = new FormedWord();
	private ScoreTotal scoreTotal = new ScoreTotal();

	private Board board;

	public ScrambleController() {
		// TODO Race conditions cause errors when this is called on start-up.
		// initialize();
	}

	public void onActionAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About Scramble!");
		alert.setHeaderText(null);
		alert.setContentText("Scramble!™ version 0.01\nCopyright © 2015 Jonathan Radliff. All rights reserved.\nThis version is a prototype.");
		alert.showAndWait();
	}

	public void onActionExit() {
		Platform.exit();
	}

	public void onActionNewGame() {
		// TODO Create game class? Different modes can extend from game.
		initialize();
	}

	public void onActionScramble() {
		board.scramble();
		updateGridPane();
	}

	private void initialize() {
		board = new Board(8, 8, new LetterTileFactory());
		scoreShown.textProperty().bind(scoreTotal.scoreProperty().asString());
		wordShown.textProperty().bind(formedWord.wordProperty());
		updateGridPane();
	}

	private void updateGridPane() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				Tile tile = board.getTile(x, y);
				ImageView imageView = new ImageView(ImageFactory.getImage(tile
						.getLetter()));
				imageView.setFitWidth(45);
				imageView.setFitHeight(45);
				imageView.setOnMouseDragOver(this::onMouseDragOver);
				imageView.setOnMouseDragExited(this::onMouseDragExited);
				imageView.setOnMouseDragReleased(this::onMouseDragReleased);
				gridPane.add(imageView, x, y);
			}
		}
	}

	private boolean isInBounds(double x, double y) {
		boolean validX = (x >= 5 && x < 43);
		boolean validY = (y >= 5 && y < 43);
		return validX && validY;
	}

	/*
	 * Begin mouse actions
	 */

	public void onDragDetected(MouseEvent event) {
		pane.startFullDrag();
	}

	public void onMouseDragOver(MouseDragEvent event) {
		ImageView imageView = (ImageView) event.getSource();
		boolean selected = letterSelector.attemptToSelect(imageView);
		// TODO This should be an event triggered by binding selectedLetters
		// property (ObservableList).
		if (selected) {
			int x = GridPane.getColumnIndex(imageView);
			int y = GridPane.getRowIndex(imageView);
			Tile tile = board.getTile(x, y);
			Letter letter = tile.getLetter();
			formedWord.setWord(formedWord.getWord() + letter);
			imageView.setImage(ImageFactory.getSelectedImage(letter));
		}
	}

	public void onMouseDragExited(MouseDragEvent event) {

	}

	public void onMouseDragReleased(MouseDragEvent event) {
		System.out.println("Your word: " + formedWord.getWord());
		if (Dictionary.isWord(formedWord.getWord())) {
			System.out.println("IT'S A WORD!");
			int scoreValue = 0;
			int scoreMultiplier = 100;
			int scoreEarned = 0;
			String scoreRating = "Good!";
			for (ImageView imageView : letterSelector.getSelectedLetters()) {
				int x = GridPane.getColumnIndex(imageView);
				int y = GridPane.getRowIndex(imageView);
				// TODO FIX THIS!!
				scoreValue += board.getTile(x, y).getScoreValue();
				board.clearTile(x, y);
			}
			scoreEarned = scoreValue * scoreMultiplier;
			if (scoreEarned >= 1000) {
				scoreRating = "Great!";
			}
			this.scoreValue.setText(String.valueOf(scoreValue));
			this.scoreMultiplier.setText("x " + String.valueOf(scoreMultiplier));
			this.scoreEarned.setText(String.valueOf(scoreEarned));
			this.scoreRating.setText(String.valueOf(scoreRating));
			scoreTotal.add(scoreEarned);
		} else {
			System.out.println("NOT A WORD.");
		}
		letterSelector.clearSelection();
		formedWord.setWord("");
		updateGridPane();
	}

	/**
	 * A listener for user mouse or touch interaction that starts the streamer
	 * animation and helps pass mouse events to underlying nodes.
	 * 
	 * This method listens for a mouse pressed event from the top-most node in
	 * the hierarchy on which graphics are drawn. Once it detects such an event,
	 * it sets mouse transparent on the node to true so that nodes underneath in
	 * the hierarchy can receive mouse events. It relies on another listener to
	 * determine when to set mouse transparent on the node back to false.
	 * 
	 * @param event
	 *            the mouse pressed event that triggered this method
	 */
	public void onMousePressed(MouseEvent event) {
		pane.setMouseTransparent(true);
		path.getElements().add(new MoveTo(event.getX(), event.getY()));
	}

	/**
	 * A listener for dragging interaction that continues animating the streamer
	 * animation based upon cursor movement.
	 * 
	 * @param event
	 *            the mouse dragged event that triggered this method
	 */
	public void onMouseDragged(MouseEvent event) {
		path.getElements().add(new LineTo(event.getX(), event.getY()));
	}

	/**
	 * A listener for user mouse or touch interaction that clears the streamer
	 * animation and sets mouse transparent on the graphics node back to false.
	 * 
	 * @param event
	 *            the mouse released event that triggered this method
	 */
	public void onMouseReleased(MouseEvent event) {
		pane.setMouseTransparent(false);
		path.getElements().clear();
	}

}

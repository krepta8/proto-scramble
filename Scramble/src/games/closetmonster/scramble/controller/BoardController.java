/**
 * 
 */
package games.closetmonster.scramble.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
public class BoardController {

	@FXML
	private GridPane gridPane;

	@FXML
	private Pane pane;

	@FXML
	private Path path;

	@FXML
	private Label scoreShown = new Label("0");

	@FXML
	private Label wordShown = new Label("");

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

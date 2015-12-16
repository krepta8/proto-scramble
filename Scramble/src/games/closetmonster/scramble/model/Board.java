/**
 * 
 */
package games.closetmonster.scramble.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * @author Jonathan Radliff
 *
 */
public class Board {

	private ObservableList<ObservableList<Tile>> board;
	private int columns;
	private int rows;
	private TileFactory tileFactory;

	public Board(int columns, int rows, TileFactory tileFactory) {
		this.columns = columns;
		this.rows = rows;
		this.tileFactory = tileFactory;
		initialize();
	}

	public void addListener(ListChangeListener<Tile> listener) {
		for (ObservableList<Tile> column : board) {
			column.addListener(listener);
		}
	}

	// TODO Temporary method. May delete.
	public void clearTile(int x, int y) {
		// TODO Can use list change listener to do work, or...
		board.get(x).get(y).setCleared(true);
		// TODO ...can do it right here.
		board.get(x).remove(y);
		// TODO Was removed will now fire as true. Insert new tile.
		board.get(x).add(0, tileFactory.makeTile());
	}

	// TODO Temporary method. May delete.
	public Tile getTile(int x, int y) {
		return board.get(x).get(y);
	}

	public void scramble() {
		// TODO Shuffles tiles within a column and then swaps columns around.
		for (int x = 0; x < columns; x++) {
			FXCollections.shuffle(board.get(x));
		}
		FXCollections.shuffle(board);
	}

	// TODO this is perhaps more useful for the GridPane side of things,
	// where movement animations (falls, shuffles, etc.) have to be shown.
	private void boardChanged(ListChangeListener.Change<? extends Tile> change) {
		System.out.println("Detected a change! ");
		int changeNumber = 1;
		while (change.next()) {
			System.out.println("Change number: " + changeNumber);
			System.out.println("Was added: " + change.wasAdded());
			System.out.println("Was removed: " + change.wasRemoved());
			System.out.println("Was replaced: " + change.wasReplaced());
			System.out.println("Was permutated: " + change.wasPermutated());
			System.out.println("Was updated: " + change.wasUpdated());
			changeNumber++;
		}
	}

	private void initialize() {
		board = FXCollections.observableList(new ArrayList<>(columns));
		for (int x = 0; x < columns; x++) {
			board.add(FXCollections.observableList(new ArrayList<>(rows)));
			for (int y = 0; y < rows; y++) {
				// TODO board.get(x).addListener(this::boardChanged);
				board.get(x).add(tileFactory.makeTile());
			}
		}
	}

}

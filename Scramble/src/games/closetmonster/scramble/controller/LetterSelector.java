/**
 * 
 */
package games.closetmonster.scramble.controller;

import java.util.Collection;
import java.util.LinkedList;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * @author Jonathan Radliff
 *
 */
public class LetterSelector {

	private LinkedList<ImageView> selectedLetters = new LinkedList<>();

	public boolean attemptToSelect(ImageView imageView) {
		if (selectedLetters.isEmpty()) {
			selectedLetters.add(imageView);
			return true;
		} else {
			if (hasBeenSelected(imageView)) {
				while (!selectedLetters.peekLast().equals(imageView)) {
					selectedLetters.removeLast();
				}
			} else if (isAdjacent(imageView)) {
				selectedLetters.add(imageView);
				return true;
			}
		}
		return false;
	}

	public void clearSelection() {
		selectedLetters.clear();
	}

	public Collection<ImageView> getSelectedLetters() {
		return selectedLetters;
	}

	public boolean hasBeenSelected(ImageView imageView) {
		return selectedLetters.contains(imageView);
	}

	public boolean isAdjacent(ImageView imageView) {
		int toX = GridPane.getColumnIndex(imageView);
		int toY = GridPane.getRowIndex(imageView);
		int fromX = GridPane.getColumnIndex(selectedLetters.getLast());
		int fromY = GridPane.getRowIndex(selectedLetters.getLast());
		boolean isSameX = toX - fromX == 0;
		boolean isSameY = toY - fromY == 0;
		boolean isLeftOrRight = Math.abs(toX - fromX) == 1;
		boolean isAboveOrBelow = Math.abs(toY - fromY) == 1;
		return ((isSameX && isAboveOrBelow) || (isSameY && isLeftOrRight))
				|| isLeftOrRight && isAboveOrBelow;
	}

}

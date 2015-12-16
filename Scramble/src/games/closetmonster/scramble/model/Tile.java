/**
 * 
 */
package games.closetmonster.scramble.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

/**
 * @author Jonathan Radliff
 *
 */
public interface Tile {

	public BooleanProperty clearedProperty();

	public boolean getCleared();

	public Letter getLetter();

	public int getScoreValue();

	public boolean getSelected();

	public int getX();

	public int getY();

	public ObjectProperty<Letter> letterProperty();

	public IntegerProperty scoreValueProperty();

	public BooleanProperty selectedProperty();

	public void setCleared(boolean cleared);

	public void setLetter(Letter letter);

	public void setScoreValue(int scoreValue);

	public void setSelected(boolean selected);

	public void setX(int x);

	public void setY(int y);

	public IntegerProperty xProperty();

	public IntegerProperty yProperty();

}

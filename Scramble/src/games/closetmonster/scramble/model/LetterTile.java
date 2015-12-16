/**
 * 
 */
package games.closetmonster.scramble.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * @author Jonathan Radliff
 *
 */
public class LetterTile implements Tile {

	private BooleanProperty cleared = new SimpleBooleanProperty(false);
	private ObjectProperty<Letter> letter = new SimpleObjectProperty<>(Letter.A);
	private IntegerProperty scoreValue = new SimpleIntegerProperty(0);
	private BooleanProperty selected = new SimpleBooleanProperty(false);
	private IntegerProperty x = new SimpleIntegerProperty(0);
	private IntegerProperty y = new SimpleIntegerProperty(0);

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#clearedProperty()
	 */
	@Override
	public BooleanProperty clearedProperty() {
		return cleared;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#getCleared()
	 */
	@Override
	public boolean getCleared() {
		return cleared.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#getLetter()
	 */
	@Override
	public Letter getLetter() {
		return letter.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#getScoreValue()
	 */
	@Override
	public int getScoreValue() {
		return scoreValue.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#getSelected()
	 */
	@Override
	public boolean getSelected() {
		return selected.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#getX()
	 */
	@Override
	public int getX() {
		return x.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#getY()
	 */
	@Override
	public int getY() {
		return y.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#letterProperty()
	 */
	@Override
	public ObjectProperty<Letter> letterProperty() {
		return letter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#scoreValueProperty()
	 */
	@Override
	public IntegerProperty scoreValueProperty() {
		return scoreValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#selectedProperty()
	 */
	@Override
	public BooleanProperty selectedProperty() {
		return selected;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#setCleared(boolean)
	 */
	@Override
	public void setCleared(boolean cleared) {
		this.cleared.set(cleared);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#setLetter(application.model.Letter)
	 */
	@Override
	public void setLetter(Letter letter) {
		this.letter.set(letter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#setScoreValue(int)
	 */
	@Override
	public void setScoreValue(int scoreValue) {
		this.scoreValue.set(scoreValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#setSelected(boolean)
	 */
	@Override
	public void setSelected(boolean selected) {
		this.selected.set(selected);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#setX(int)
	 */
	@Override
	public void setX(int x) {
		this.x.set(x);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#setY(int)
	 */
	@Override
	public void setY(int y) {
		this.y.set(y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#xProperty()
	 */
	@Override
	public IntegerProperty xProperty() {
		return x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.Tile#yProperty()
	 */
	@Override
	public IntegerProperty yProperty() {
		return y;
	}

}

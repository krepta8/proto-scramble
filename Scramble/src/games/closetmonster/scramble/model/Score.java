/**
 * 
 */
package games.closetmonster.scramble.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * @author Jonathan Radliff
 *
 */
public class Score {

	private IntegerProperty base = new SimpleIntegerProperty(this, "base", 0);
	private DoubleProperty multiplier = new SimpleDoubleProperty(this,
			"multiplier", 1);
	private IntegerProperty total = new SimpleIntegerProperty(this, "total", 0);
	private ObjectProperty<Word> word = new SimpleObjectProperty<>(this,
			"word", new Word());

	/**
	 * @return the base property of this bean
	 */
	public IntegerProperty baseProperty() {
		return base;
	}

	/**
	 * @return the base
	 */
	public int getBase() {
		return base.get();
	}

	/**
	 * @return the multiplier
	 */
	public double getMultiplier() {
		return multiplier.get();
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total.get();
	}

	/**
	 * @return the word
	 */
	public Word getWord() {
		return word.get();
	}

	/**
	 * @return the multiplier property of this bean
	 */
	public DoubleProperty multiplierProperty() {
		return multiplier;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(int base) {
		this.base.set(base);
	}

	/**
	 * @param multiplier
	 *            the multiplier to set
	 */
	public void setMultiplier(double multiplier) {
		this.multiplier.set(multiplier);
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total.set(total);
	}

	/**
	 * @param word
	 *            the word to set
	 */
	public void setWord(Word word) {
		this.word.set(word);
	}

	/**
	 * @return the total property of this bean
	 */
	public IntegerProperty totalProperty() {
		return total;
	}

	/**
	 * @return the word property of this bean
	 */
	public ObjectProperty<Word> wordProperty() {
		return word;
	}

}

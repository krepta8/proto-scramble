/**
 * 
 */
package games.closetmonster.scramble.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Jonathan Radliff
 *
 */
public class FormedWord {

	private StringProperty word = new SimpleStringProperty(this, "word", "");

	/**
	 * @return the word
	 */
	public String getWord() {
		return word.get();
	}

	/**
	 * @param word
	 *            the word to set
	 */
	public void setWord(String word) {
		this.word.setValue(word);
	}

	/**
	 * @return the word property of this bean
	 */
	public StringProperty wordProperty() {
		return word;
	}

}

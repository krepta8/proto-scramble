/**
 * 
 */
package games.closetmonster.scramble.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author Jonathan Radliff
 *
 */
public class ScoreTotal {

	private IntegerProperty score = new SimpleIntegerProperty(this, "score", 0);

	/**
	 * @return the score
	 */
	public int getScore() {
		return score.get();
	}

	/**
	 * @return the score property of this bean
	 */
	public IntegerProperty scoreProperty() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score.set(score);
	}

	public void add(int score) {
		this.score.set(this.score.get() + score);
	}

}

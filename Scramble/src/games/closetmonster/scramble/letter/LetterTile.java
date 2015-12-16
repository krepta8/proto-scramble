/**
 * 
 */
package games.closetmonster.scramble.letter;

/**
 * @author Jonathan Radliff
 *
 */
public class LetterTile extends Tile {

	private Letter letter;

	public LetterTile(Letter letter) {
		this.letter = letter;
	}

	/**
	 * @return the letter
	 */
	public Letter getLetter() {
		return letter;
	}

}

/**
 * 
 */
package games.closetmonster.scramble.letter;

/**
 * @author Jonathan Radliff
 *
 */
public enum Letter {

	A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, BLANK;

	// TODO Scores should probably be set in a map on a per mode basis.

	private int scoreValue;

	/**
	 * @return the scoreValue
	 */
	public int getScoreValue() {
		return scoreValue;
	}

	/**
	 * @param scoreValue
	 *            the scoreValue to set
	 */
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

}

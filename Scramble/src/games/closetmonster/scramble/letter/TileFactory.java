/**
 * 
 */
package games.closetmonster.scramble.letter;

import java.util.EnumMap;
import java.util.Random;

/**
 * @author Jonathan Radliff
 *
 */
public class TileFactory {

	private enum LetterFrequency {
		E(12.40), T(9.20), A(8.11), O(7.64), I(7.61), N(7.25), S(6.52), R(6.27), H(
				4.88), L(4.12), D(3.84), C(3.38), U(2.76), M(2.53), F(2.29), P(
				2.16), G(1.94), Y(1.69), W(1.67), B(1.45), V(1.06), K(0.60), X(
				0.24), J(0.17), Q(0.12), Z(0.10);

		private double percentChance;

		private LetterFrequency(double percentChance) {
			this.percentChance = percentChance;
		}

		public double getPercentChance() {
			return percentChance;
		}

	}

	private EnumMap<Letter, Tile> tileMap = new EnumMap<>(Letter.class);
	private Random random;

	public TileFactory() {
		createTiles();
	}

	private void createTiles() {
		for (Letter letter : Letter.values()) {
			tileMap.put(letter, new LetterTile(letter));
		}
	}

	public Tile getRandomTile() {
		if (random == null) {
			random = new Random();
		}
		final double randomDouble = random.nextDouble();
		double lowerBound = 0;
		double upperBound = 0;
		for (LetterFrequency letterFrequency : LetterFrequency.values()) {
			upperBound += (letterFrequency.getPercentChance() / 100);
			if (randomDouble >= lowerBound && randomDouble < upperBound) {
				return tileMap.get(Letter.valueOf(letterFrequency.name()));
			}
			lowerBound = upperBound;
		}
		// TODO This should never happen as written. Probabilities should be
		// modified.
		return tileMap.get(Letter.BLANK);
	}

}

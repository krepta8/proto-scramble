/**
 * 
 */
package games.closetmonster.scramble.model;

/**
 * @author Jonathan Radliff
 *
 */
public class LetterTileFactory implements TileFactory {

	private enum LetterInfo {
		E(12.40, 1), T(9.20, 1), A(8.11, 1), O(7.64, 1), I(7.61, 1), N(7.25, 1), S(
				6.52, 1), R(6.27, 1), H(4.88, 4), L(4.12, 1), D(3.84, 2), C(
				3.38, 3), U(2.76, 1), M(2.53, 3), F(2.29, 4), P(2.16, 3), G(
				1.94, 2), Y(1.69, 4), W(1.67, 4), B(1.45, 3), V(1.06, 4), K(
				0.60, 5), X(0.24, 8), J(0.17, 8), Q(0.12, 10), Z(0.10, 10);

		private double percentChance;
		private int scoreValue;

		private LetterInfo(double percentChance, int scoreValue) {
			this.percentChance = percentChance;
			this.scoreValue = scoreValue;
		}

		public double getPercentChance() {
			return percentChance;
		}

		public int getScoreValue() {
			return scoreValue;
		}

	}

	public LetterTileFactory() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.TileFactory#makeTile()
	 */
	@Override
	public Tile makeTile() {
		final double random = Math.random();
		double lowerBound = 0;
		double upperBound = 0;
		for (LetterInfo letterInfo : LetterInfo.values()) {
			upperBound += (letterInfo.getPercentChance() / 100);
			if (random >= lowerBound && random < upperBound) {
				return makeTile(Letter.valueOf(letterInfo.name()));
			}
			lowerBound = upperBound;
		}
		// TODO This should never happen as written.
		return makeTile(Letter.Z);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.model.TileFactory#makeTile(application.model.Letter)
	 */
	@Override
	public Tile makeTile(Letter letter) {
		Tile tile = new LetterTile();
		tile.setLetter(letter);
		tile.setScoreValue(LetterInfo.valueOf(letter.name()).getScoreValue());
		return tile;
	}

}

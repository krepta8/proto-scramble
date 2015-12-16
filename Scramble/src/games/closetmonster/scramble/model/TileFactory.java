/**
 * 
 */
package games.closetmonster.scramble.model;

/**
 * @author Jonathan Radliff
 *
 */
public interface TileFactory {

	public Tile makeTile();

	public Tile makeTile(Letter letter);

}

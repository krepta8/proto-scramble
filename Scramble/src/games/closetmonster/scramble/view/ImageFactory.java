/**
 * 
 */
package games.closetmonster.scramble.view;

import java.util.EnumMap;

import games.closetmonster.scramble.model.Letter;
import javafx.scene.image.Image;

/**
 * @author Jonathan Radliff
 *
 */ 
public class ImageFactory {

	private static EnumMap<Letter, Image> imageMap = new EnumMap<>(Letter.class);
	private static EnumMap<Letter, Image> selectedImageMap = new EnumMap<>(Letter.class);
	private static String dir = "file:images/tiles/";
	private static String ext = ".png";

	public static Image getImage(Letter letter) {
		if (imageMap.isEmpty()) {
			for (Letter key : Letter.values()) {
				imageMap.put(key, new Image(dir + key.name() + "1" + ext));
			}
		}
		return imageMap.get(letter);
	}
	
	public static Image getSelectedImage(Letter letter) {
		if (selectedImageMap.isEmpty()) {
			for (Letter key : Letter.values()) {
				selectedImageMap.put(key, new Image(dir + key.name() + "2" + ext));
			}
		}
		return selectedImageMap.get(letter);
	}

}

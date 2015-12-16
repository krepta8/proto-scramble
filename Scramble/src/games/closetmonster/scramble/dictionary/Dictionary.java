/**
 *
 */
package games.closetmonster.scramble.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jonathan Radliff
 *
 */
public class Dictionary {

	public static boolean isWord(String word) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				new File("src/games/closetmonster/scramble/dictionary/ospd.txt")))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.equalsIgnoreCase(word)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}

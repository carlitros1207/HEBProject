package app;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) throws IOException {
		//path to file
		Path filePath = Paths.get("input.txt");
		//open file
		Scanner scanner = new Scanner(filePath);
		//lists to save words, the count of those words then an object for those words
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> wordCount = new ArrayList<Integer>();
		ArrayList<WordObject> wordObjects = new ArrayList<WordObject>();
		//go through file until it has nothing else to read
		while(scanner.hasNext()) {
			//lowercase everything
			String word = scanner.next().toLowerCase();
			//get rid of periods
			if (word.charAt(word.length() -1) == '.') {
				//get the string withought the period
				String strippedWord = word.substring(0, word.length()-1);
				//update count in wordcount arraylist if the word exists in words arraylist
				if (words.contains(strippedWord)) {
					wordCount.set(words.indexOf(strippedWord), wordCount.get(words.indexOf(strippedWord)) + 1);
				}
				//save the word and add a new count to their respective lists
				else {
					words.add(strippedWord);
					wordCount.add(1);
				}
			}else
				//get rid of commas
				if (word.charAt(word.length()-1) == ',') {
					//get the string without the comma
					String strippedWord = word.substring(0, word.length()-1);
					//update count in wordcount arraylist if the word exists in words arraylist
					if (words.contains(strippedWord)) {
						wordCount.set(words.indexOf(strippedWord), wordCount.get(words.indexOf(strippedWord)) + 1);
					}
					//save the word and add a new count to their respective lists
					else {
						words.add(strippedWord);
						wordCount.add(1);
					}
				}
				//goes here if the word is doesnt have a period or comma at the end of it
				else {
					//update count in wordcount arraylist if the word exists in words arraylist
					if (words.contains(word)) {
						wordCount.set(words.indexOf(word), wordCount.get(words.indexOf(word)) + 1);
					}
					//save the word and add a new count to their respective lists
					else {
						words.add(word);
						wordCount.add(1);
					}
				}
			}
		//go throught all the words and store then in an objext for easy print
		for(String temp: words) {
			WordObject tempObject = new WordObject(temp);
			tempObject.setCount(wordCount.get(words.indexOf(temp)));
			wordObjects.add(tempObject);
		}
		//sort the arraylist by wordcount
		Collections.sort(wordObjects, new Comparator<WordObject>() {
			@Override
			public int compare(WordObject lhs, WordObject rhs) {
				return lhs.getCount() > rhs.getCount() ? -1: (lhs.getCount() < rhs.getCount() ? 1 :0);
			}
		});
		//print the word and its word count
		for(WordObject temp : wordObjects) {
			System.out.print(String.format("%10s", temp.getWord() + " | "));
			for (int i = 0; i < temp.getCount(); i++) {
				System.out.print("=");
			}
			System.out.print(" (" + temp.getCount()+")\n");
			
		}
		
	}
}

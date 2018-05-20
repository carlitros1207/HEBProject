package app;

public class WordObject {


	private String word;
	private int count;
	
	public WordObject() {
		word = null;
		count = 0;
	}
	
	public WordObject(String word) {
		this();
		this.word = word;
		this.count = 0;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}

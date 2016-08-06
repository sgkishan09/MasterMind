import java.util.*;

public abstract class Player {
	String word;

	public Player() {
		word = "";
	}

	public Player(String word) {
		this.word = word;
	}

	abstract public void setWord(int length);

	public int getScore(String inputWord) {
		HashSet<String> myWordSet = new HashSet<>(Arrays.asList(word.split("")));
		HashSet<String> inputWordSet = new HashSet<>(Arrays.asList(inputWord.split("")));
		int count = 0;
		for (String letter : inputWordSet) {
			if (myWordSet.contains(letter)) {
				count++;
				myWordSet.remove(letter);
			}
		}
		return count;
	}

	public String toString() {
		return "[" + word + "]";
	}

	abstract public String guess();
}

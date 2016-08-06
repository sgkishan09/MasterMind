import java.util.*;

public abstract class Player {
	String word;
	int prevScore = Integer.MIN_VALUE;

	public Player() {
		word = "";
	}

	public void setPrevScore(int score) {
		this.prevScore = score;
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
		if (count == inputWord.length() && !word.equals(inputWord))
			return -1;
		return count;
	}

	public String toString() {
		return "[" + word + "]";
	}

	abstract public String guess();
}

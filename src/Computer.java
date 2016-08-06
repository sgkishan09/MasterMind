import java.util.*;
import java.util.function.Predicate;

public class Computer extends Player {
	public ArrayList<String> possibleWords;
	boolean first = true;
	String prevGuess;

	private void populatePossibleWords(int difficulty) {
		possibleWords = new ArrayList<String>();
		try {
			for (String word : Util.readFile("C:\\Projects\\sowpods.txt"))
				if (word.length() == difficulty && isValid(word))
					possibleWords.add(word);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public Computer() {
		super("");
	}

	public Computer(int difficulty) {
		populatePossibleWords(difficulty);
		this.setWord(difficulty);
	}

	public ArrayList<String> combination(char set[], int k) {
		int n = set.length;
		return printAllKLengthRec(set, "", n, k);
	}

	public ArrayList<String> printAllKLengthRec(char set[], String prefix, int n, int k) {
		ArrayList<String> list = new ArrayList<String>();
		if (k == 0) {
			list.add(prefix);
			return list;
		}
		for (int i = 0; i < n; ++i) {
			String newPrefix = prefix + set[i];
			list.addAll(printAllKLengthRec(set, newPrefix, n, k - 1));
		}
		return list;
	}

	public void eliminateWordsFromList(String word) {
		possibleWords.remove(prevGuess);
		if (!first) {
			System.out.println("Trying to eliminate " + word);
			ArrayList<String> removeWords = new ArrayList<String>();
			System.out.println(prevGuess + "\t" + prevScore);
			for (int remove = prevScore + 1; remove < possibleWords.get(0).length(); remove++) {
				ArrayList<String> removeList = combination(word.toCharArray(), remove);
				System.out.println(removeList);
				for (String removePhrase : removeList) {
					if (isValid(removePhrase)) {
						for (String possible : possibleWords) {
							if (possible.contains(removePhrase)) {
								removeWords.add(possible);
							}
						}
					}
				}
			}
			possibleWords.removeAll(removeWords);
			System.out.println(removeWords);
		} else
			first = false;
	}

	public HashSet<String> AnagramCluster = new HashSet<String>();

	private void generateCluster(String word) {
		String hash = sort(word);
		AnagramCluster.add(word);
		for (String iter : possibleWords) {
			if (sort(hash).equals(sort(iter)))
				AnagramCluster.add(iter);
		}
	}

	public String sort(String input) {
		char[] array = input.toCharArray();
		Arrays.sort(array);
		return new String(array);
	}

	@Override
	public String guess() {
		int rand = (int) (Math.random() % possibleWords.size());
		String guess = possibleWords.get(rand);
		if (prevScore == -1) {
			System.out.println("ANAGRAM");
			generateCluster(prevGuess);
		} else {
			if (!first)

				eliminateWordsFromList(prevGuess);
			else
				first = false;
		}
		prevGuess = guess;
		return guess;

	}

	@Override
	public void setWord(int length) {
		int rand = (int) (Math.random() * possibleWords.size());
		this.word = possibleWords.get(rand);

	}

}

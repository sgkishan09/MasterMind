import java.util.HashSet;
import java.util.*;

public class Game {
	final int DEFAULT_DIFFICULTY = 4;
	Player players[] = { new Human(), new Computer() };
	boolean over = false;
	int difficulty;

	public Game() {
		difficulty = DEFAULT_DIFFICULTY;
		players[0] = new Human(DEFAULT_DIFFICULTY);
		players[1] = new Computer(DEFAULT_DIFFICULTY);
	}

	public Game(int difficulty) {
		this.difficulty = difficulty;
		players[0] = new Human(difficulty);
		players[1] = new Computer(difficulty);
	}

	public void run() {
		int turn = 1;
		int count = 0;
		System.out.println(players[0] + "\t" + players[1]);
		while (!over) {
			count++;
			String word = players[turn].guess();
			int score = players[(turn + 1) % 2].getScore(word);
			System.out.println("Word Guessed\t" + word + "\t" + score);
			players[turn].setPrevScore(score);
			if (score == difficulty) {
				over = true;
				System.out.println("Player " + turn + " won!");
			}
			// turn = (turn + 1) % 2;
		}
		System.out.println("No of Moves:" + count);
	}

	public static String[] append(String a, String b[]) {
		for (int i = 0; i < b.length; i++)
			b[i] = a + b[i];
		return b;
	}

	public static void main(String[] args) {
		Game game = new Game(6);
		game.run();
	}
}

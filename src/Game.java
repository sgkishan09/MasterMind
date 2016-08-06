
public class Game {
	final int DEFAULT_DIFFICULTY = 4;
	Player players[];
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
		int turn = 0;
		while (!over) {
			String word = players[turn].guess();
			int score = players[(turn + 1) % 2].getScore(word);
			players[turn].setPrevScore(score);
			if (score == difficulty) {
				over = true;
				System.out.println("Player " + turn + " won!");
			}
			turn = (turn + 1) % 2;
		}
	}

	public static void main(String[] args) {
		// Game game=new Game(new Human(),new Computer(2));
		// game.run();
	}
}


public class Game {
	Player players[];
	boolean over = false;

	public Game() {
	}

	public Game(Player p1, Player p2) {
		players[0] = p1;
		players[1] = p2;
	}

	public static void run() {

	}

	public static void main(String[] args) {
		// Game game=new Game(new Human(),new Computer(2));
		// game.run();
	}
}
